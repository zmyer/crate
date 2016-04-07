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

package io.crate.executor.transport;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.crate.action.job.*;
import io.crate.core.collections.Bucket;
import io.crate.exceptions.Exceptions;
import io.crate.executor.JobTask;
import io.crate.executor.TaskResult;
import io.crate.executor.transport.kill.KillJobsRequest;
import io.crate.executor.transport.kill.KillResponse;
import io.crate.executor.transport.kill.TransportKillJobsNodeAction;
import io.crate.jobs.*;
import io.crate.operation.*;
import io.crate.operation.projectors.RowReceiver;
import io.crate.planner.node.ExecutionPhase;
import io.crate.planner.node.ExecutionPhases;
import io.crate.planner.node.NodeOperationGrouper;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.cluster.ClusterService;
import org.elasticsearch.common.collect.Tuple;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.indices.IndicesService;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


class ExecutionPhasesTask extends JobTask {

    private final ESLogger logger;
    private final TransportJobAction transportJobAction;
    private final List<NodeOperationTree> nodeOperationTrees;
    private final OperationType operationType;
    private final ClusterService clusterService;
    private final ContextPreparer contextPreparer;
    private final JobContextService jobContextService;
    private final IndicesService indicesService;
    private final TransportKillJobsNodeAction transportKillJobsNodeAction;


    private final List<SettableFuture<TaskResult>> results = new ArrayList<>();
    private boolean hasDirectResponse;

    enum OperationType {
        BULK,
        /**
         * UNKNOWN means it will depend on the number of nodeOperationTrees, if > 1 it will use bulk, otherwise QueryResult
         */
        UNKNOWN
    }

    ExecutionPhasesTask(UUID jobId,
                        ESLogger logger,
                        ClusterService clusterService,
                        ContextPreparer contextPreparer,
                        JobContextService jobContextService,
                        IndicesService indicesService,
                        TransportJobAction transportJobAction,
                        TransportKillJobsNodeAction transportKillJobsNodeAction,
                        List<NodeOperationTree> nodeOperationTrees,
                        OperationType operationType) {
        super(jobId);
        this.logger = logger;
        this.clusterService = clusterService;
        this.contextPreparer = contextPreparer;
        this.jobContextService = jobContextService;
        this.indicesService = indicesService;
        this.transportJobAction = transportJobAction;
        this.transportKillJobsNodeAction = transportKillJobsNodeAction;
        this.nodeOperationTrees = nodeOperationTrees;
        this.operationType = operationType;

        for (NodeOperationTree nodeOperationTree : nodeOperationTrees) {
            results.add(SettableFuture.<TaskResult>create());
            for (NodeOperation nodeOperation : nodeOperationTree.nodeOperations()) {
                if (ExecutionPhases.hasDirectResponseDownstream(nodeOperation.downstreamNodes())) {
                    hasDirectResponse = true;
                    break;
                }
            }
        }
    }

    @Override
    public void start() {
        FluentIterable<NodeOperation> nodeOperations = FluentIterable.from(nodeOperationTrees)
                .transformAndConcat(new Function<NodeOperationTree, Iterable<? extends NodeOperation>>() {
                    @Nullable
                    @Override
                    public Iterable<? extends NodeOperation> apply(NodeOperationTree input) {
                        return input.nodeOperations();
                    }
                });

        Map<String, Collection<NodeOperation>> operationByServer = NodeOperationGrouper.groupByServer(nodeOperations);
        List<PageDownstreamContext> pageDownstreamContexts = new ArrayList<>(nodeOperationTrees.size());
        List<Tuple<ExecutionPhase, RowReceiver>> handlerPhases = new ArrayList<>(nodeOperationTrees.size());

        KillOnFailure killOnFailure = new KillOnFailure(jobId(), operationByServer.size(), results,
                transportKillJobsNodeAction, logger);

        if (operationType == OperationType.BULK || nodeOperationTrees.size() > 1) {
            // bulk Operation with rowCountResult
            for (int i = 0; i < nodeOperationTrees.size(); i++) {
                SettableFuture<TaskResult> result = killOnFailure.resultFutures.get(i);
                RowCountResultRowDownstream rowDownstream = new RowCountResultRowDownstream(result);
                handlerPhases.add(new Tuple<ExecutionPhase, RowReceiver>(nodeOperationTrees.get(i).leaf(), rowDownstream));
            }
        } else {
            SettableFuture<TaskResult> result = Iterables.getOnlyElement(killOnFailure.resultFutures);
            QueryResultRowDownstream downstream = new QueryResultRowDownstream(result);
            handlerPhases.add(new Tuple<ExecutionPhase, RowReceiver>(Iterables.getOnlyElement(nodeOperationTrees).leaf(), downstream));
        }

        try {
            setupContext(operationByServer, pageDownstreamContexts, handlerPhases);
        } catch (Throwable throwable) {
            for (SettableFuture<TaskResult> result : results) {
                result.setException(throwable);
            }
        }
        if (operationByServer.isEmpty()) {
            return;
        }
        sendJobRequests(pageDownstreamContexts, operationByServer, killOnFailure);
    }

    private void setupContext(Map<String, Collection<NodeOperation>> operationByServer,
                              List<PageDownstreamContext> pageDownstreamContexts,
                              List<Tuple<ExecutionPhase, RowReceiver>> handlerPhases) throws Throwable {
        boolean noNodeOperations = false;
        if (operationByServer.isEmpty()) {
            // this should never happen, instead we should use a NOOP plan instead
            // which immediately results in an empty result
            noNodeOperations = true;
        }
        List<ExecutionSubContext> localContextAndStartOperation = createLocalContextAndStartOperation(operationByServer, handlerPhases);
        if (noNodeOperations) {
            for (ExecutionSubContext executionSubContext : localContextAndStartOperation) {
                executionSubContext.close();
            }
            return;
        }
        if (hasDirectResponse) {
            for (ExecutionSubContext executionSubContext : localContextAndStartOperation) {
                assert executionSubContext != null && executionSubContext instanceof DownstreamExecutionSubContext
                        : "Need DownstreamExecutionSubContext for DIRECT_RESPONSE remote jobs. Got " +
                          executionSubContext;
                pageDownstreamContexts.add(((DownstreamExecutionSubContext) executionSubContext).pageDownstreamContext((byte) 0));
            }
        }
    }

    private void sendJobRequests(List<PageDownstreamContext> pageDownstreamContexts,
                                 Map<String, Collection<NodeOperation>> operationsByServer,
                                 KillOnFailure killOnFailure) {
        logger.trace("operationsByServer={}", operationsByServer);
        int idx = 0;
        for (Map.Entry<String, Collection<NodeOperation>> entry : operationsByServer.entrySet()) {
            String serverNodeId = entry.getKey();
            Collection<NodeOperation> nodeOperations = entry.getValue();

            JobRequest request = new JobRequest(jobId(), nodeOperations);
            if (hasDirectResponse) {
                transportJobAction.execute(serverNodeId, request, new DirectResponseListener(idx, pageDownstreamContexts, killOnFailure, logger));
            } else {
                transportJobAction.execute(serverNodeId, request,
                        new FailureOnlyResponseListener(logger, killOnFailure, idx));
            }
            idx++;
        }
    }

    /**
     * removes the localNodeId entry from the nodesByServer map and initializes the context and starts the operation.
     * <p>
     * This is done in order to be able to create the JobExecutionContext with the localMerge PageDownstreamContext
     */
    private List<ExecutionSubContext> createLocalContextAndStartOperation(Map<String, Collection<NodeOperation>> operationsByServer,
                                                                          List<Tuple<ExecutionPhase, RowReceiver>> handlerPhases) throws Throwable {
        String localNodeId = clusterService.localNode().id();
        JobExecutionContext.Builder builder = jobContextService.newBuilder(jobId());
        Collection<NodeOperation> localNodeOperations = null;
        SharedShardContexts sharedShardContexts = null;
        if (!hasDirectResponse) {
            localNodeOperations = operationsByServer.remove(localNodeId);
        }
        if (localNodeOperations == null) {
            localNodeOperations = ImmutableList.of();
        } else {
            sharedShardContexts = new SharedShardContexts(indicesService);
        }

        List<ExecutionSubContext> executionSubContexts = contextPreparer.prepareOnHandler(
                jobId(),
                localNodeOperations,
                builder,
                handlerPhases,
                sharedShardContexts
        );

        if (!hasDirectResponse) {
            JobExecutionContext context = jobContextService.createContext(builder);
            context.start();
        } else {
            for (ExecutionSubContext executionSubContext : executionSubContexts) {
                executionSubContext.prepare();
                executionSubContext.start();
            }
        }
        return executionSubContexts;
    }

    @Override
    public List<? extends ListenableFuture<TaskResult>> result() {
        return results;
    }

    @Override
    public void upstreamResult(List<? extends ListenableFuture<TaskResult>> result) {
        throw new UnsupportedOperationException("ExecutionNodesTask doesn't support upstreamResult");
    }

    private static class DirectResponseListener implements ActionListener<JobResponse> {

        private final int bucketIdx;
        private final List<PageDownstreamContext> pageDownstreamContexts;
        private final KillOnFailure killOnFailure;
        private final ESLogger logger;

        DirectResponseListener(int bucketIdx, List<PageDownstreamContext> pageDownstreamContexts, KillOnFailure killOnFailure, ESLogger logger) {
            this.bucketIdx = bucketIdx;
            this.pageDownstreamContexts = pageDownstreamContexts;
            this.killOnFailure = killOnFailure;
            this.logger = logger;
        }

        @Override
        public void onResponse(JobResponse jobResponse) {
            for (int i = 0; i < pageDownstreamContexts.size(); i++) {
                PageDownstreamContext pageDownstreamContext = pageDownstreamContexts.get(i);
                jobResponse.streamers(pageDownstreamContext.streamer());
                Bucket bucket = jobResponse.directResponse().get(i);
                if (bucket == null) {
                    pageDownstreamContext.failure(bucketIdx, new IllegalStateException("expected directResponse but didn't get one"));
                }
                pageDownstreamContext.setBucket(bucketIdx, bucket, true, new PageResultListener() {
                    @Override
                    public void needMore(boolean needMore) {
                        if (needMore) {
                            logger.warn("requested more data but directResponse doesn't support paging");
                        }
                    }

                    @Override
                    public int buckedIdx() {
                        return bucketIdx;
                    }
                });
            }
            killOnFailure.processNodeResponse(null);
        }

        @Override
        public void onFailure(Throwable e) {
            for (PageDownstreamContext pageDownstreamContext : pageDownstreamContexts) {
                pageDownstreamContext.failure(bucketIdx, e);
            }
            killOnFailure.processNodeResponse(e);
        }
    }

    private static class FailureOnlyResponseListener implements ActionListener<JobResponse> {

        private final KillOnFailure killOnFailure;
        private final ESLogger logger;
        private final int nodeIdx;

        FailureOnlyResponseListener(ESLogger logger, KillOnFailure killOnFailure, int nodeIdx) {
            this.logger = logger;
            this.killOnFailure = killOnFailure;
            this.nodeIdx = nodeIdx;
        }

        @Override
        public void onResponse(JobResponse jobResponse) {
            Throwable throwable = null;
            if (jobResponse.directResponse().size() > 0) {
                throwable = new IllegalStateException("Got a directResponse but didn't expect one");
            }
            killOnFailure.processNodeResponse(throwable);
        }

        @Override
        public void onFailure(Throwable e) {
            logger.warn(e.getMessage(), e);
            killOnFailure.processNodeResponse(e);
        }
    }

    private static class KillOnFailure {

        private final UUID jobId;
        private final AtomicInteger nodesResponded;
        private final List<SettableFuture<TaskResult>> resultFutures;
        private final List<TaskResult> results;
        private final List<SettableFuture<TaskResult>> finalResults;
        private final AtomicInteger killResponses;
        private final TransportKillJobsNodeAction transportKillJobsNodeAction;
        private final ESLogger logger;

        private Throwable rootCause;

        KillOnFailure(UUID jobId,
                      int nodesCnt,
                      List<SettableFuture<TaskResult>> finalResults,
                      TransportKillJobsNodeAction transportKillJobsNodeAction,
                      ESLogger logger) {
            this.jobId = jobId;
            this.transportKillJobsNodeAction = transportKillJobsNodeAction;
            this.logger = logger;
            this.finalResults = finalResults;
            results = new ArrayList<>(finalResults.size());
            resultFutures = new ArrayList<>(finalResults.size());
            for (int i = 0; i < finalResults.size(); i++) {
                SettableFuture<TaskResult> future = SettableFuture.create();
                resultFutures.add(future);
            }
            logger.trace("killOnFailure initialized with number_of_nodes={}", nodesCnt);
            nodesResponded = new AtomicInteger(nodesCnt);
            killResponses = new AtomicInteger(nodesCnt);
        }

        void processNodeResponse(@Nullable Throwable throwable) {
            if (throwable != null) {
                throwable = Exceptions.unwrap(throwable);
                if (rootCause == null) {
                    rootCause = throwable;
                }
            }
            //logger.trace("Got node response from job init request (nodesResponded={}) with failure={}", nodesResponded.get(), throwable);

            if (nodesResponded.decrementAndGet() == 0) {
                if (rootCause != null) {
                    // all nodes responded, kill the job
                    logger.trace("All nodes responded, lets kill the job..");
                    kill();
                } else {
                    logger.trace("All nodes responded successfully");
                    finish();
                }
            }
        }

        private void kill() {
            transportKillJobsNodeAction.executeKillOnAllNodes(
                    new KillJobsRequest(Collections.singletonList(jobId)), new ActionListener<KillResponse>() {
                        @Override
                        public void onResponse(KillResponse killResponse) {
                            logger.debug("Killed {} jobs", killResponse.numKilled());
                            finishAfterKill();

                        }

                        @Override
                        public void onFailure(Throwable e) {
                            logger.warn("Failed to kill job", e);
                            finishAfterKill();
                        }
                    }
            );
        }

        private void finishAfterKill() {
            if (killResponses.decrementAndGet() <= 0) {
                logger.trace("Killed job, will set result exception now", rootCause);
                finish();
            }

        }

        private void finish() {
            for (int i = 0; i < resultFutures.size(); i++) {
                SettableFuture<TaskResult> finalResult = finalResults.get(i);
                if (rootCause != null) {
                    finalResult.setException(rootCause);
                } else {
                    try {
                        finalResult.set(resultFutures.get(i).get());
                    } catch (Exception e) {
                        finalResult.setException(e);
                    }
                }
            }
        }
    }

}
