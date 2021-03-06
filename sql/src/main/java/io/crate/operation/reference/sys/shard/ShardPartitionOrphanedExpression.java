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
package io.crate.operation.reference.sys.shard;

import io.crate.metadata.PartitionName;
import io.crate.metadata.SimpleObjectExpression;
import org.elasticsearch.cluster.ClusterService;
import org.elasticsearch.cluster.metadata.MetaData;
import org.elasticsearch.index.shard.ShardId;

public class ShardPartitionOrphanedExpression extends SimpleObjectExpression<Boolean> {

    private final ClusterService clusterService;
    private final String aliasName;
    private final String templateName;
    private final boolean isPartition;

    public ShardPartitionOrphanedExpression(ShardId shardId, ClusterService clusterService) {
        this.clusterService = clusterService;
        isPartition = PartitionName.isPartition(shardId.getIndex());
        if (isPartition) {
            PartitionName partitionName = PartitionName.fromIndexOrTemplate(shardId.getIndex());
            aliasName = partitionName.tableIdent().indexName();
            templateName = PartitionName.templateName(
                partitionName.tableIdent().schema(),
                partitionName.tableIdent().name());
        } else {
            templateName = null;
            aliasName = null;
        }
    }

    @Override
    public Boolean value() {
        if (!isPartition) {
            return false;
        }
        final MetaData metaData = clusterService.state().metaData();
        return !(metaData.templates().containsKey(templateName) && metaData.hasConcreteIndex(aliasName));
    }
}
