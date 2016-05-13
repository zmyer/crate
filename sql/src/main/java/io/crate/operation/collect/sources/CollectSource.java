package io.crate.operation.collect.sources;

import io.crate.operation.collect.JobCollectContext;
import io.crate.operation.projectors.RowReceiver;
import io.crate.planner.node.dql.CollectPhase;

public interface CollectSource {

    CollectSourceContext getCollectors(CollectPhase collectPhase, RowReceiver downstream, JobCollectContext jobCollectContext);
}
