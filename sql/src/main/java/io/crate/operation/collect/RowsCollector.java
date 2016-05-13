/*
 * Licensed to Crate.IO GmbH ("Crate") under one or more contributor
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

import com.google.common.collect.ImmutableList;
import io.crate.concurrent.CompletionListener;
import io.crate.concurrent.CompletionMultiListener;
import io.crate.concurrent.CompletionState;
import io.crate.core.collections.Row;
import io.crate.operation.projectors.IterableRowEmitter;
import io.crate.operation.projectors.RowReceiver;

import javax.annotation.Nullable;

public class RowsCollector implements CrateCollector {

    private final IterableRowEmitter emitter;
    private boolean killed = false;
    private CompletionListener listener = CompletionListener.NO_OP;

    public static RowsCollector empty(RowReceiver rowDownstream) {
        return new RowsCollector(rowDownstream, ImmutableList.<Row>of());
    }

    public static RowsCollector single(Row row, RowReceiver rowDownstream) {
        return new RowsCollector(rowDownstream, ImmutableList.of(row));
    }

    public RowsCollector(RowReceiver rowDownstream, Iterable<Row> rows) {
        this.emitter = new IterableRowEmitter(rowDownstream, rows);
    }

    @Override
    public void doCollect() {
        emitter.run();
        if (!killed) {
            listener.onSuccess(CompletionState.EMPTY_STATE);
        }
    }

    @Override
    public void kill(@Nullable Throwable throwable) {
        killed = true;
        emitter.kill(throwable);
        listener.onFailure(throwable);
    }

    @Override
    public void addListener(CompletionListener listener) {
        this.listener = CompletionMultiListener.merge(this.listener, listener);
    }
}
