/*
 * Licensed to Crate under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Crate licenses this file
 * to you under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial
 * agreement.
 */

package io.crate.operation.projectors;

import com.carrotsearch.hppc.cursors.IntCursor;
import io.crate.analyze.symbol.Symbol;
import io.crate.core.collections.Row;
import io.crate.core.collections.Row1;
import io.crate.exceptions.Exceptions;
import io.crate.executor.BulkProcessor;
import io.crate.executor.transport.RetryActionListener;
import io.crate.executor.transport.ShardResponse;
import io.crate.executor.transport.ShardUpsertRequest;
import io.crate.executor.transport.TransportActionProvider;
import io.crate.metadata.PartitionName;
import io.crate.metadata.settings.CrateSettings;
import io.crate.operation.collect.CollectExpression;
import org.apache.lucene.util.BytesRef;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkRequestExecutor;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.IndexNotFoundException;
import org.elasticsearch.index.mapper.Uid;
import org.elasticsearch.index.shard.ShardId;
import org.elasticsearch.threadpool.ThreadPool;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class UpdateProjectorNew extends AbstractProjector {


    private final ThreadPool threadPool;
    private final Symbol[] assignments;
    @Nullable
    private final Long requiredVersion;
    private final CollectExpression<Row, ?> collectUidExpression;
    private final BulkProcessor<ShardUpsertRequest.Item, ShardId, ShardUpsertRequest> bulkProcessor;
    private final BulkRequestExecutor<ShardUpsertRequest> transportAction;
    private final boolean isPartition;
    private AtomicReference<Throwable> throwable = new AtomicReference<>(null);
    private boolean receiveRows = true;
    private final Object responsesLock = new Object();
    private final BitSet responses = new BitSet();

    public UpdateProjectorNew(final Settings settings,
                              ThreadPool threadPool,
                              final UUID jobId,
                              final ShardId shardId,
                              Symbol[] assignments,
                              final String[] assignmentColumns,
                              TransportActionProvider transportActionProvider,
                              @Nullable Long requiredVersion,
                              CollectExpression<Row, ?> collectUidExpression) {
        this.threadPool = threadPool;
        this.assignments = assignments;
        this.requiredVersion = requiredVersion;
        this.collectUidExpression = collectUidExpression;
        isPartition = PartitionName.isPartition(shardId.getIndex());
        transportAction = transportActionProvider.transportShardUpsertActionDelegate();
        Supplier<ShardUpsertRequest> groupFactory = () -> new ShardUpsertRequest(
            shardId,
            assignmentColumns,
            null,
            null,
            jobId)
            .timeout(CrateSettings.BULK_REQUEST_TIMEOUT.extractTimeValue(settings))
            .continueOnError(false)
            .overwriteDuplicates(false)
            .validateGeneratedColumns(true);


        bulkProcessor = new BulkProcessor<>(
            (x) -> shardId,
            groupFactory,
            this::sendRequests,
            this,
            this::doneCallback,
            1000
        );
    }

    private void doneCallback() {
        Throwable t = this.throwable.get();
        if (t == null) {
            downstream.setNextRow(new Row1((long)responses.cardinality()));
            downstream.finish();
        } else {
            downstream.fail(t);
        }
    }

    private void processResponse(ShardResponse response) {
        Throwable failure = response.failure();
        if (failure != null) {
            throwable.compareAndSet(null, failure);
            return;
        }

        for (IntCursor intCursor : response.itemIndices()) {
            ShardResponse.Failure itemFailure = response.failures().get(intCursor.index);

            synchronized (responsesLock) {
                responses.set(intCursor.value, itemFailure == null);
            }
        }
    }

    private void processResponse(ShardUpsertRequest request, Throwable t) {
        t = Exceptions.unwrap(t);

        // index missing exception on a partition should never bubble, mark all items as failed instead
        if (isPartition && t instanceof IndexNotFoundException) {
            for (IntCursor intCursor : request.itemIndices()) {
                synchronized (responsesLock) {
                    responses.set(intCursor.value, false);
                }
            }
            return;
        }

        receiveRows = false;
        throwable.compareAndSet(null, t);
    }

    private void sendRequests(Set<Map.Entry<ShardId, ShardUpsertRequest>> requests, Runnable callback) {
        final AtomicInteger pendingRequests = new AtomicInteger(requests.size());
        for (Iterator<Map.Entry<ShardId, ShardUpsertRequest>> it = requests.iterator(); it.hasNext(); ) {
            Map.Entry<ShardId, ShardUpsertRequest> entry = it.next();

            ShardUpsertRequest request = entry.getValue();
            ActionListener<ShardResponse> listener = new ActionListener<ShardResponse>() {
                @Override
                public void onResponse(ShardResponse shardResponse) {
                    processResponse(shardResponse);
                    countdown();
                }

                @Override
                public void onFailure(Throwable e) {
                    processResponse(request, e);
                    countdown();
                }

                private void countdown() {
                    if (pendingRequests.decrementAndGet() == 0) {
                        callback.run();
                    }
                }
            };

            RetryActionListener<ShardUpsertRequest, ShardResponse> retryListener = new RetryActionListener<>(
                threadPool,
                request,
                transportAction::execute,
                BackoffPolicy.exponentialBackoff(),
                listener
            );
            transportAction.execute(request, retryListener);
            it.remove();
        }

    }

    @Override
    public boolean setNextRow(Row row) {
        collectUidExpression.setNextRow(row);
        Uid uid = Uid.createUid(((BytesRef)collectUidExpression.value()).utf8ToString());

        ShardUpsertRequest.Item item = new ShardUpsertRequest.Item(uid.id(), assignments, null, requiredVersion);
        bulkProcessor.add(item);
        return receiveRows;
    }


    @Override
    public void finish() {
        bulkProcessor.close();
    }

    @Override
    public void fail(Throwable throwable) {
        this.throwable.compareAndSet(null, throwable);
        bulkProcessor.close();
    }

    @Override
    public void kill(Throwable throwable) {
        this.throwable.compareAndSet(null, throwable);
        bulkProcessor.close();
    }
}
