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

package io.crate.jobs;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import io.crate.exceptions.ContextMissingException;
import io.crate.exceptions.Exceptions;
import io.crate.operation.collect.StatsTables;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.util.Callback;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class JobExecutionContext {

    private final ESLogger logger;
    private final UUID jobId;
    private final ConcurrentMap<Integer, ExecutionSubContext> subContexts = new ConcurrentHashMap<>();
    private final AtomicInteger numSubContexts = new AtomicInteger();
    private final List<Integer> orderedContextIds;
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final ArrayList<SubExecutionContextFuture> futures;
    private final ListenableFuture<List<SubExecutionContextFuture.State>> chainedFuture;
    private StatsTables statsTables;
    private volatile Throwable failure;
    private volatile Callback<JobExecutionContext> closeCallback;

    public static class Builder {

        private final UUID jobId;
        private final StatsTables statsTables;
        private final LinkedHashMap<Integer, ExecutionSubContext> subContexts = new LinkedHashMap<>();
        private final ESLogger logger;

        Builder(UUID jobId, StatsTables statsTables, ESLogger logger) {
            this.jobId = jobId;
            this.statsTables = statsTables;
            this.logger = logger;
        }

        public void addAllSubContexts(Iterable<? extends ExecutionSubContext> subContexts) {
            for (ExecutionSubContext subContext : subContexts) {
                addSubContext(subContext);
            }
        }

        public void addSubContext(ExecutionSubContext subContext) {
            ExecutionSubContext existingSubContext = subContexts.put(subContext.id(), subContext);
            if (existingSubContext != null) {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH,
                        "ExecutionSubContext for %d already added", subContext.id()));
            }
        }

        boolean isEmpty() {
            return subContexts.isEmpty();
        }

        public UUID jobId() {
            return jobId;
        }

        public JobExecutionContext build() {
            return new JobExecutionContext(jobId, statsTables, subContexts, logger);
        }
    }


    private JobExecutionContext(UUID jobId,
                                StatsTables statsTables,
                                LinkedHashMap<Integer, ExecutionSubContext> subContexts,
                                ESLogger logger) {
        orderedContextIds = Lists.newArrayList(subContexts.keySet());
        this.jobId = jobId;
        this.statsTables = statsTables;
        this.logger = logger;

        this.futures = new ArrayList<>(subContexts.size());
        for (Map.Entry<Integer, ExecutionSubContext> entry : subContexts.entrySet()) {
            addContext(entry.getKey(), entry.getValue());
        }
        this.chainedFuture = Futures.successfulAsList(this.futures);
    }

    void setCloseCallback(Callback<JobExecutionContext> contextCallback) {
        assert closeCallback == null;
        this.closeCallback = contextCallback;
    }

    private void addContext(int subContextId, ExecutionSubContext subContext) {
        if (subContexts.put(subContextId, subContext) == null) {
            int currentSubContextSize = numSubContexts.incrementAndGet();
            SubExecutionContextFuture future = subContext.future();
            future.addCallback(new RemoveSubContextCallback(subContextId));
            futures.add(future);
            logger.trace("adding subContext {}, now there are {} subContexts", subContextId, currentSubContextSize);
        } else {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "subContext %d is already present", subContextId));
        }
    }

    public UUID jobId() {
        return jobId;
    }

    private void prepare(){
        for (Integer id : orderedContextIds) {
            ExecutionSubContext subContext = subContexts.get(id);
            if (subContext == null || closed.get()) {
                break; // got killed before prepare was called
            }
            statsTables.operationStarted(id, jobId, subContext.name());
            subContext.prepare();
        }
    }

    public void start() throws Throwable {
        prepare();
        if (failure != null){
            throw failure;
        }
        for (Integer id : orderedContextIds) {
            ExecutionSubContext subContext = subContexts.get(id);
            if (subContext == null || closed.get()) {
                break; // got killed before start was called
            }
            subContext.start();
        }
        if (failure != null){
            throw failure;
        }
    }

    @Nullable
    public <T extends ExecutionSubContext> T getSubContextOrNull(int executionNodeId) {
        //noinspection unchecked
        return (T) subContexts.get(executionNodeId);
    }

    public <T extends ExecutionSubContext> T getSubContext(int executionNodeId) throws ContextMissingException {
        T subContext = getSubContextOrNull(executionNodeId);
        if (subContext == null) {
            throw new ContextMissingException(ContextMissingException.ContextType.SUB_CONTEXT, jobId, executionNodeId);
        }
        return subContext;
    }

    public long kill() {
        long numKilled = 0L;
        if (!closed.getAndSet(true)) {
            logger.trace("kill called on JobExecutionContext={}, subContextCount={}", jobId);

            if (numSubContexts.get() == 0) {
                callCloseCallback();
            } else {
                for (ExecutionSubContext executionSubContext : subContexts.values()) {
                    // kill will trigger the ContextCallback onClose too
                    // so it is not necessary to remove the executionSubContext from the map here as it will be done in the callback
                    executionSubContext.kill(null);
                    numKilled++;
                }
            }
        }
        try {
            chainedFuture.get();
            int currentNumSubContexts = numSubContexts.get();
            assert currentNumSubContexts == 0: "unexpected subContexts there: " +  currentNumSubContexts;
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
        return numKilled;
    }

    public void close() {
        if (closed.compareAndSet(false, true)) {
            logger.trace("close called on JobExecutionContext={}", jobId);
            if (numSubContexts.get() == 0) {
                callCloseCallback();
            } else {
                for (ExecutionSubContext executionSubContext : subContexts.values()) {
                    executionSubContext.close();
                }
            }
        }
        try {
            chainedFuture.get();
        } catch (Exception e) {
            Throwables.propagate(e);
        }
    }

    private void callCloseCallback() {
        if (closeCallback == null) {
            return;
        }
        closeCallback.handle(this);
    }

    @Override
    public String toString() {
        return "JobExecutionContext{" +
                "id=" + jobId +
                ", subContexts=" + subContexts.values() +
                ", closed=" + closed +
                '}';
    }

    private class RemoveSubContextCallback implements FutureCallback<SubExecutionContextFuture.State> {

        private final int id;

        private RemoveSubContextCallback(int id) {
            this.id = id;
        }

        private RemoveSubContextPosition remove(){
            ExecutionSubContext removed = subContexts.remove(id);
            assert removed != null;
            if (numSubContexts.decrementAndGet() == 0){
                callCloseCallback();
                return RemoveSubContextPosition.LAST;
            }
            return RemoveSubContextPosition.UNKNOWN;
        }

        @Override
        public void onSuccess(@Nullable SubExecutionContextFuture.State state) {
            assert state != null;
            statsTables.operationFinished(id, jobId, null, state.bytesUsed());
            remove();
        }

        @Override
        public void onFailure(@Nonnull Throwable t) {
            failure = t;
            statsTables.operationFinished(id, jobId, Exceptions.messageOf(t), -1);
            if (remove() == RemoveSubContextPosition.LAST){
                return;
            }
            logger.trace("onFailure killing all other subContexts, subContextCount={}...", subContexts.size());
            for (ExecutionSubContext subContext : subContexts.values()) {
                subContext.kill(t);
            }
        }
    }

    private enum RemoveSubContextPosition {
        UNKNOWN,
        LAST
    }
}
