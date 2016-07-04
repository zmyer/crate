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

import com.google.common.base.Optional;
import io.crate.core.collections.Row;

import java.util.Iterator;
import java.util.concurrent.Executor;

public class IterableRowEmitter implements Runnable, Resumeable {

    private final RowReceiver rowReceiver;
    private Iterator<? extends Row> rowsIt;

    public IterableRowEmitter(RowReceiver rowReceiver,
                              final Iterable<? extends Row> rows,
                              Optional<Executor> executor) {
        this.rowReceiver = rowReceiver;
        this.rowsIt = rows.iterator();
    }

    public IterableRowEmitter(RowReceiver rowReceiver, Iterable<? extends Row> rows) {
        this(rowReceiver, rows, Optional.<Executor>absent());
    }

    public void kill(Throwable t) {
        rowReceiver.kill(t);
    }

    @Override
    public void run() {
        try {
            loop:
            while (rowsIt.hasNext()) {
                switch (rowReceiver.nextRow(rowsIt.next())) {
                    case CONTINUE:
                        break;
                    case PAUSE:
                        rowReceiver.pauseProcessed(this);
                        return;
                    case STOP:
                        break loop;
                }
            }
            rowReceiver.finish();
        } catch (Throwable t) {
            rowReceiver.fail(t);
        }
    }

    @Override
    public void resume(boolean async) {
        run();
    }
}
