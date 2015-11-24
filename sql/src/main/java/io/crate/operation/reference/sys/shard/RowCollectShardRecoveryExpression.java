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

package io.crate.operation.reference.sys.shard;

import io.crate.metadata.ReferenceImplementation;
import io.crate.metadata.RowContextCollectorExpression;
import io.crate.operation.reference.RowCollectNestedObjectExpression;
import org.apache.lucene.util.BytesRef;
import org.elasticsearch.common.lucene.BytesRefs;
import org.elasticsearch.indices.recovery.RecoveryState;

import java.util.Map;

public class RowCollectShardRecoveryExpression<TRow> extends RowCollectNestedObjectExpression<TRow> {

    private RecoveryState recoveryState;

    @Override
    public Map<String, Object> value() {
        return (recoveryState == null) ? null : super.value();
    }

    @Override
    public ReferenceImplementation getChildImplementation(String name) {
        return (recoveryState == null) ? this : super.getChildImplementation(name);
    }

    private void addChildImplementations(final RecoveryState recoveryState) {
        childImplementations.put(ShardRecoveryExpression.TOTAL_TIME, new RowContextCollectorExpression<TRow, Long>() {
            @Override
            public Long value() {
                return recoveryState.getTimer().time();
            }
        });
        childImplementations.put(ShardRecoveryExpression.STAGE, new RowContextCollectorExpression<TRow, BytesRef>() {
            @Override
            public BytesRef value() {
                return BytesRefs.toBytesRef(recoveryState.getStage().name());
            }
        });
        childImplementations.put(ShardRecoveryExpression.TYPE, new RowContextCollectorExpression<TRow, BytesRef>() {
            @Override
            public BytesRef value() {
                return recoveryState != null ? BytesRefs.toBytesRef(recoveryState.getType().name()) : null;
            }
        });
        childImplementations.put(ShardRecoveryExpression.SIZE, new ShardRecoverySizeExpression(recoveryState));
        childImplementations.put(ShardRecoveryExpression.FILES, new ShardRecoveryFilesExpression(recoveryState));
    }

    public void setNextRecoveryState(RecoveryState state) {
        recoveryState = state;
        childImplementations.clear();
        if (state != null) {
            addChildImplementations(state);
        }
    }

}
