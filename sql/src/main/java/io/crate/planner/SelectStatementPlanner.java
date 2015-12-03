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

package io.crate.planner;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.crate.Constants;
import io.crate.analyze.*;
import io.crate.analyze.relations.*;
import io.crate.analyze.symbol.Reference;
import io.crate.analyze.symbol.Symbol;
import io.crate.analyze.symbol.Symbols;
import io.crate.exceptions.ValidationException;
import io.crate.exceptions.VersionInvalidException;
import io.crate.metadata.TableIdent;
import io.crate.metadata.doc.DocTableInfo;
import io.crate.planner.consumer.ConsumerContext;
import io.crate.planner.distribution.UpstreamPhase;
import io.crate.planner.fetch.FetchPushDown;
import io.crate.planner.fetch.MultiSourceFetchPushDown;
import io.crate.planner.node.NoopPlannedAnalyzedRelation;
import io.crate.planner.node.dql.ESGetNode;
import io.crate.planner.node.dql.MergePhase;
import io.crate.planner.node.dql.MergedPlan;
import io.crate.planner.node.dql.QueryThenFetch;
import io.crate.planner.node.fetch.FetchPhase;
import io.crate.planner.node.fetch.FetchSource;
import io.crate.planner.projection.FetchProjection;
import io.crate.planner.projection.Projection;
import io.crate.planner.projection.TopNProjection;
import io.crate.planner.projection.builder.ProjectionBuilder;
import org.elasticsearch.common.inject.Singleton;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Singleton
public class SelectStatementPlanner {

    private final Visitor visitor = new Visitor();

    public Plan plan(SelectAnalyzedStatement statement, Planner.Context context) {
        return visitor.process(statement.relation(), context);
    }

    private static MergePhase mergePhase(Planner.Context context,
                                         Collection<String> executionNodes,
                                         UpstreamPhase upstreamPhase,
                                         @Nullable OrderBy orderBy,
                                         List<Symbol> previousOutputs,
                                         boolean isDistributed) {
        assert !upstreamPhase.executionNodes().isEmpty() : "upstreamPhase must be executed somewhere";
        if (!isDistributed && upstreamPhase.executionNodes().equals(executionNodes)) {
            // if the nested loop is on the same node we don't need a mergePhase to receive requests
            // but can access the RowReceiver of the nestedLoop directly
            return null;
        }

        MergePhase mergePhase;
        if (orderBy != null) {
            mergePhase = MergePhase.sortedMerge(
                    context.jobId(),
                    context.nextExecutionPhaseId(),
                    orderBy,
                    previousOutputs,
                    orderBy.orderBySymbols(),
                    ImmutableList.<Projection>of(),
                    upstreamPhase.executionNodes().size(),
                    Symbols.extractTypes(previousOutputs),
                    executionNodes
            );
        } else {
            mergePhase = MergePhase.localMerge(
                    context.jobId(),
                    context.nextExecutionPhaseId(),
                    ImmutableList.<Projection>of(),
                    upstreamPhase.executionNodes().size(),
                    Symbols.extractTypes(previousOutputs),
                    executionNodes
            );
        }
        return mergePhase;
    }




    private static class Visitor extends AnalyzedRelationVisitor<Planner.Context, Plan> {


        @Override
        public Plan visitMultiSourceSelect(MultiSourceSelect mss, Planner.Context context) {


            if (mss.querySpec().where().noMatch()) {
                return new NoopPlannedAnalyzedRelation(mss, context.jobId()).plan();
            }
            boolean qtf = !mss.canBeFetched().isEmpty();
            MultiSourceFetchPushDown pd = null;
            if (qtf){
                pd = MultiSourceFetchPushDown.pushDown(mss);
            }
            subPlan(mss, context);
            ConsumerContext consumerContext = new ConsumerContext(mss, context);
            PlannedAnalyzedRelation subPlan =  context.consumingPlanner().plan(mss, consumerContext);
            assert subPlan != null;
            // look if this is a noop plan
            if (IsNoopPlan.INSTANCE.apply(subPlan.plan())) {
                return new NoopPlan(context.jobId());
            }

            assert !subPlan.resultIsDistributed();
            FetchProjection fp = null;
            FetchPhase fetchPhase = null;
            if (qtf) {
                Planner.Context.ReaderAllocations readerAllocations = context.buildReaderAllocations();
                ArrayList<Reference> docRefs = new ArrayList<>();
                for (Map.Entry<TableIdent, FetchSource> entry : pd.fetchSources().entrySet()) {
                    docRefs.addAll(entry.getValue().references());
                }
                fetchPhase = new FetchPhase(
                        context.nextExecutionPhaseId(),
                        readerAllocations.nodeReaders().keySet(),
                        readerAllocations.bases(),
                        readerAllocations.tableIndices(),
                        docRefs
                );

                fp = new FetchProjection(
                        fetchPhase.executionPhaseId(),
                        pd.fetchSources(),
                        pd.remainingOutputs(),
                        readerAllocations.nodeReaders(),
                        readerAllocations.indices(),
                        readerAllocations.indicesToIdents());
                subPlan.addProjection(fp);

                return new QueryThenFetch(subPlan.plan(), fetchPhase, null, context.jobId());
            } else {
                return subPlan.plan();
            }
        }

        private PlannedAnalyzedRelation subPlan(AnalyzedRelation rel, Planner.Context context) {
            ConsumerContext consumerContext = new ConsumerContext(rel, context);
            PlannedAnalyzedRelation subPlan =  context.planSubRelation(rel, consumerContext);
            assert subPlan != null;
            ValidationException validationException = consumerContext.validationException();
            if (validationException != null) {
                throw validationException;
            }
            return subPlan;
        }

        @Nullable
        private MergePhase localMerge(QuerySpec qsIn, QuerySpec qsOut, Planner.Context context, PlannedAnalyzedRelation plannedSubQuery, FetchProjection fp,
                                      List<Symbol> topNOutPuts) {
            MergePhase localMergePhase = null;
            if (plannedSubQuery.resultIsDistributed()) {
                localMergePhase = mergePhase(context,
                        context.handlerExecutionNodes(),
                        plannedSubQuery.resultPhase(),
                        qsIn.orderBy().orNull(),
                        qsIn.outputs(),
                        true);
                assert localMergePhase != null : "local merge phase must not be null";
                TopNProjection finalTopN = ProjectionBuilder.topNProjection(
                        qsIn.outputs(),
                        qsIn.orderBy().orNull(),
                        qsOut.offset(),
                        qsOut.limit().or(Constants.DEFAULT_SELECT_LIMIT),
                        topNOutPuts
                );
                localMergePhase.addProjection(finalTopN);
                if (fp != null) {
                    localMergePhase.addProjection(fp);
                }
            } else {
                if (fp != null) {
                    plannedSubQuery.addProjection(fp);
                }
            }
            return localMergePhase;
        }

        @Nullable
        private static List<Symbol> outputsWithOrderSymbols(QuerySpec spec) {
            List<Symbol> outputs = null;
            if (spec.orderBy().isPresent()) {
                for (Symbol symbol : spec.orderBy().get().orderBySymbols()) {
                    if (!spec.outputs().contains(symbol)) {
                        if (outputs == null) {
                            outputs = new ArrayList<>(
                                    spec.outputs().size() + spec.orderBy().get().orderBySymbols().size());
                            outputs.addAll(spec.outputs());
                        }
                        outputs.add(symbol);
                    }
                }
            }
            return outputs;
        }

        @Override
        public Plan visitQueriedTable(QueriedTable table, Planner.Context context) {

            // set the default limit
            table.querySpec().limit(table.querySpec().limit().or(Constants.DEFAULT_SELECT_LIMIT));

            List<Symbol> newOutputs = outputsWithOrderSymbols(table.querySpec());
            QueriedTable sub;
            if (newOutputs == null) {
                sub = table;
            } else {
                QuerySpec subSpec = QuerySpec.copyOf(table.querySpec()).outputs(newOutputs);
                sub = new QueriedTable(table.tableRelation(), subSpec);
            }

            PlannedAnalyzedRelation plannedSubQuery = subPlan(table, context);
            // look if this is a noop plan
            if (IsNoopPlan.INSTANCE.apply(plannedSubQuery.plan())) {
                return new NoopPlan(context.jobId());
            }


            MergePhase localMergePhase = localMerge(sub.querySpec(), table.querySpec(), context, plannedSubQuery, null,
                    table.querySpec().outputs());

            if (localMergePhase == null) {
                return plannedSubQuery.plan();
            } else {
                return new MergedPlan(plannedSubQuery.plan(), localMergePhase, context.jobId());
            }
        }

        @Override
        public Plan visitQueriedDocTable(QueriedDocTable table, Planner.Context context) {

            final QuerySpec querySpec = table.querySpec();

            querySpec.limit(querySpec.limit().or(Constants.DEFAULT_SELECT_LIMIT));


            FetchPushDown fetchPushDown = null;
            QueriedDocTable subRelation = null;
            if (!querySpec.hasAggregates() && !querySpec.groupBy().isPresent()) {
                if (querySpec.where().docKeys().isPresent() && !table.tableRelation().tableInfo().isAlias()) {
                    // plan get directly, since it is currently not usable as subplan
                    return planESGet(table, context);
                } else {
                    fetchPushDown = new FetchPushDown(querySpec, table.tableRelation());
                    subRelation = fetchPushDown.pushDown();
                }
            }
            boolean qtf;
            if (subRelation == null) {

                List<Symbol> newOutputs = outputsWithOrderSymbols(table.querySpec());
                if (newOutputs == null) {
                    subRelation = table;
                } else {
                    QuerySpec subSpec = QuerySpec.copyOf(table.querySpec()).outputs(newOutputs);
                    subRelation = new QueriedDocTable(table.tableRelation(), subSpec);
                }
                qtf = false;
            } else {
                qtf = true;
            }


//            if (querySpec.where().hasVersions()) {
//                context.validationException(new VersionInvalidException());
//                return null;
//            }

            //Planner.Context plannerContext = context.plannerContext();

            //table.tableRelation().validateOrderBy(querySpec.orderBy());

//            FetchPushDown fetchPushDown = new FetchPushDown(querySpec, table.tableRelation());
//            QueriedDocTable subRelation = fetchPushDown.pushDown();
//            if (subRelation == null) {
//                return null;
//            }
            PlannedAnalyzedRelation plannedSubQuery = subPlan(subRelation, context);

            // look if this is a noop plan
            if (IsNoopPlan.INSTANCE.apply(plannedSubQuery.plan())) {
                return new NoopPlan(context.jobId());
            }
            // TODO: set the limit on the query spec
//            if (collectPhase.nodePageSizeHint() == null) {
//                collectPhase.nodePageSizeHint(Constants.DEFAULT_SELECT_LIMIT + querySpec.offset());
//            }


            FetchProjection fp = null;
            FetchPhase fetchPhase = null;
            List<Symbol> topNOutputs;
            if (qtf) {
                Planner.Context.ReaderAllocations readerAllocations = context.buildReaderAllocations();
                fetchPhase = new FetchPhase(
                        context.nextExecutionPhaseId(),
                        readerAllocations.nodeReaders().keySet(),
                        readerAllocations.bases(),
                        readerAllocations.tableIndices(),
                        fetchPushDown.fetchRefs()
                );

                Map<TableIdent, FetchSource> fetchSources = ImmutableMap.of(table.tableRelation().tableInfo().ident(),
                        new FetchSource(table.tableRelation().tableInfo().partitionedByColumns(),
                                ImmutableList.of(fetchPushDown.docIdCol()),
                                fetchPushDown.fetchRefs()));

                fp = new FetchProjection(
                        fetchPhase.executionPhaseId(),
                        fetchSources,
                        querySpec.outputs(),
                        readerAllocations.nodeReaders(),
                        readerAllocations.indices(),
                        readerAllocations.indicesToIdents());
                topNOutputs = subRelation.querySpec().outputs();
            } else {
                topNOutputs = table.querySpec().outputs();
            }
            MergePhase localMergePhase = localMerge(subRelation.querySpec(), table.querySpec(), context, plannedSubQuery, fp, topNOutputs);
            // TODO: we should not need this?
//            if (consumerContext.requiredPageSize() != null) {
//                collectPhase.pageSizeHint(consumerContext.requiredPageSize());
//            }

            // TODO: check what is needed here
//            SimpleSelect.enablePagingIfApplicable(
//                    collectPhase, localMergePhase, querySpec.limit().orNull(), querySpec.offset(),
//                    context.clusterService().localNode().id());

            if (qtf) {
                return new QueryThenFetch(plannedSubQuery.plan(), fetchPhase, localMergePhase, context.jobId());
            } else {
                if (localMergePhase == null) {
                    return plannedSubQuery.plan();
                } else {
                    return new MergedPlan(plannedSubQuery.plan(), localMergePhase, context.jobId());
                }
            }
        }

        private Plan planESGet(QueriedDocTable table, Planner.Context context) {
            assert !table.querySpec().hasAggregates() && !table.querySpec().groupBy().isPresent();
            DocTableInfo tableInfo = table.tableRelation().tableInfo();
            if (tableInfo.isAlias()) {
                return null;
            }

            if (table.querySpec().where().docKeys().get().withVersions()) {
                throw new VersionInvalidException();
            }
            Optional<Integer> limit = table.querySpec().limit();
            if (limit.isPresent() && limit.get() == 0) {
                return new NoopPlan(context.jobId());
            }
            table.tableRelation().validateOrderBy(table.querySpec().orderBy());
            return new ESGetNode(context.nextExecutionPhaseId(), tableInfo, table.querySpec(), context.jobId()).plan();
        }
    }
}
