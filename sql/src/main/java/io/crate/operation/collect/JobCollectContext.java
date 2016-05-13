/*
 * Licensed to CRATE Technology GmbH ("Crate") under one or more contributor
 * license agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.  Crate licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial agreement.
 */

package io.crate.operation.collect;

import com.carrotsearch.hppc.IntObjectHashMap;
import com.carrotsearch.hppc.cursors.ObjectCursor;
import com.google.common.annotations.VisibleForTesting;
import io.crate.action.job.SharedShardContexts;
import io.crate.action.sql.query.CrateSearchContext;
import io.crate.breaker.RamAccountingContext;
import io.crate.concurrent.CompletionListener;
import io.crate.concurrent.CompletionState;
import io.crate.concurrent.ExecutionComponent;
import io.crate.jobs.AbstractExecutionSubContext;
import io.crate.metadata.RowGranularity;
import io.crate.operation.collect.sources.CollectSourceContext;
import io.crate.operation.projectors.RowReceiver;
import io.crate.planner.node.dql.CollectPhase;
import io.crate.planner.node.dql.RoutedCollectPhase;
import org.elasticsearch.common.StopWatch;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.util.concurrent.ConcurrentCollections;
import org.elasticsearch.threadpool.ThreadPool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class JobCollectContext extends AbstractExecutionSubContext {

    private static final ESLogger LOGGER = Loggers.getLogger(JobCollectContext.class);

    private final CollectPhase collectPhase;
    private final MapSideDataCollectOperation collectOperation;
    private final RamAccountingContext queryPhaseRamAccountingContext;
    private final RowReceiver rowReceiver;
    private final SharedShardContexts sharedShardContexts;

    private final IntObjectHashMap<CrateSearchContext> searchContexts = new IntObjectHashMap<>();
    private final Object subContextLock = new Object();
    private final String threadPoolName;
    private final AtomicReference<Throwable> failure = new AtomicReference<>();

    private Collection<CrateCollector> collectors;
    private Set<ExecutionComponent> executionComponents;
    private AtomicInteger executionComponentsCount;

    public JobCollectContext(final CollectPhase collectPhase,
                             MapSideDataCollectOperation collectOperation,
                             String localNodeId,
                             RamAccountingContext queryPhaseRamAccountingContext,
                             final RowReceiver rowReceiver,
                             SharedShardContexts sharedShardContexts) {
        super(collectPhase.executionPhaseId(), LOGGER);
        this.collectPhase = collectPhase;
        this.collectOperation = collectOperation;
        this.queryPhaseRamAccountingContext = queryPhaseRamAccountingContext;
        this.sharedShardContexts = sharedShardContexts;
        this.rowReceiver = rowReceiver;
        this.threadPoolName = threadPoolName(collectPhase, localNodeId);
    }

    void addSearchContext(int jobSearchContextId, CrateSearchContext searchContext) {
        if (future.closed()) {
            // if this is closed and addContext is called this means the context got killed.
            searchContext.close();
            return;
        }

        synchronized (subContextLock) {
            CrateSearchContext replacedContext = searchContexts.put(jobSearchContextId, searchContext);
            if (replacedContext != null) {
                replacedContext.close();
                searchContext.close();
                throw new IllegalArgumentException(String.format(Locale.ENGLISH,
                        "ShardCollectContext for %d already added", jobSearchContextId));
            }
        }
    }

    public void closeDueToFailure(Throwable throwable) {
        close(throwable);
    }

    @Override
    protected void cleanup() {
        closeSearchContexts();
        queryPhaseRamAccountingContext.close();
    }

    @Override
    protected void innerClose(@Nullable Throwable throwable) {
        future.bytesUsed(queryPhaseRamAccountingContext.totalBytes());
    }

    private void closeSearchContexts() {
        synchronized (subContextLock) {
            for (ObjectCursor<CrateSearchContext> cursor : searchContexts.values()) {
                cursor.value.close();
            }
            searchContexts.clear();
        }
    }

    @Override
    public void innerKill(@Nonnull Throwable throwable) {
        failure.compareAndSet(null, throwable);
        killComponents(throwable);
        future.bytesUsed(queryPhaseRamAccountingContext.totalBytes());
    }

    private void killComponents(@Nonnull Throwable throwable) {
        if (executionComponents != null) {
            for (ExecutionComponent executionComponent : executionComponents) {
                executionComponent.kill(throwable);
            }
        }
    }

    @Override
    public String name() {
        return collectPhase.name();
    }


    @Override
    public String toString() {
        return "JobCollectContext{" +
               "id=" + id +
               ", sharedContexts=" + sharedShardContexts +
               ", rowReceiver=" + rowReceiver +
               ", searchContexts=" + Arrays.toString(searchContexts.keys) +
               ", closed=" + future.closed() +
               '}';
    }

    @Override
    protected void innerPrepare() {
        CollectSourceContext collectSourceContext = collectOperation.createCollectors(collectPhase, rowReceiver, this);
        collectors = collectSourceContext.collectors();
        executionComponents = ConcurrentCollections.newConcurrentSet();
        if (collectors.isEmpty()) {
            // only add rowReceiver known by this context as execution component (projectors are skipped if collectors are empty)
            executionComponents.add(rowReceiver);
        } else {
            executionComponents.addAll(collectSourceContext.executionComponents());
        }
        executionComponentsCount = new AtomicInteger(executionComponents.size());
        for (ExecutionComponent component : executionComponents) {
            if (logger.isTraceEnabled()) {
                logger.trace("[{}] Registering completion listener to component={}", collectPhase.jobId(), component);
            }
            component.addListener(new ComponentCompletionListener(component));
        }
    }

    private void countdown() {
        // TODO: seems like due to existing failure propagation, counter can go negative. check/fix this after removed failure propagation.
        if (executionComponentsCount.decrementAndGet() <= 0) {
            if (logger.isTraceEnabled()) {
                logger.trace("[{}] [{}] All components finished, will close context",
                    collectPhase.jobId(), collectPhase.executionPhaseId());
            }
            close(failure.get());
        }
    }

    @Override
    protected void innerStart() {
        if (collectors.isEmpty()) {
            rowReceiver.finish();
        } else {
            if (logger.isTraceEnabled()) {
                measureCollectTime();
            }
            collectOperation.launchCollectors(collectors, threadPoolName);
        }
    }

    private void measureCollectTime() {
        final StopWatch stopWatch = new StopWatch(collectPhase.executionPhaseId() + ": " + collectPhase.name());
        stopWatch.start("starting collectors");
        rowReceiver.addListener(new CompletionListener() {

            private void stop() {
                // stopWatch is not thread-safe and so it could be still marked as non-runnning
                // TODO: use a thread-safe implementation
                if (stopWatch.isRunning()) {
                    stopWatch.stop();
                }
                logger.trace("Collectors finished: {}", stopWatch.shortSummary());
            }

            @Override
            public void onSuccess(@Nullable CompletionState result) {
                stop();
            }

            @Override
            public void onFailure(@Nonnull Throwable t) {
                stop();
            }
        });
    }

    public RamAccountingContext queryPhaseRamAccountingContext() {
        return queryPhaseRamAccountingContext;
    }

    public SharedShardContexts sharedShardContexts() {
        return sharedShardContexts;
    }

    @VisibleForTesting
    static String threadPoolName(CollectPhase phase, String localNodeId) {
        if (phase instanceof RoutedCollectPhase) {
            RoutedCollectPhase collectPhase = (RoutedCollectPhase) phase;
            if (collectPhase.maxRowGranularity() == RowGranularity.DOC
                && collectPhase.routing().containsShards(localNodeId)) {
                // DOC table collectors
                return ThreadPool.Names.SEARCH;
            } else if (collectPhase.maxRowGranularity() == RowGranularity.NODE
                       || collectPhase.maxRowGranularity() == RowGranularity.SHARD) {
                // Node or Shard system table collector
                return ThreadPool.Names.MANAGEMENT;
            }
        }

        // Anything else like INFORMATION_SCHEMA tables or sys.cluster table collector
        return ThreadPool.Names.PERCOLATE;
    }

    private class ComponentCompletionListener implements CompletionListener {

        ExecutionComponent component;

        ComponentCompletionListener(ExecutionComponent component) {
            this.component = component;
        }

        @Override
        public void onSuccess(@Nullable CompletionState result) {
            if (logger.isTraceEnabled()) {
                logger.trace("[{}] onSuccess called by component={}, remainingComponents={}",
                    collectPhase.jobId(), component, executionComponentsCount.get());
            }
            executionComponents.remove(component);
            countdown();
        }

        @Override
        public void onFailure(@Nonnull Throwable t) {
            if (logger.isTraceEnabled()) {
                logger.trace("[{}] onFailure called by component={}, remainingComponents={}",
                    t, collectPhase.jobId(), component, executionComponentsCount.get());
            }
            boolean isFirstFailure = failure.compareAndSet(null, t);
            executionComponents.remove(component);
            countdown();

            if (isFirstFailure) {
                // TODO: is this the right place for doing that?
                kill(failure.get());
            }
        }
    }
}
