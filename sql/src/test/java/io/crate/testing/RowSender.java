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

package io.crate.testing;

import com.google.common.util.concurrent.MoreExecutors;
import io.crate.core.collections.Bucket;
import io.crate.core.collections.CollectionBucket;
import io.crate.core.collections.Row;
import io.crate.operation.RowUpstream;
import io.crate.operation.collect.collectors.TopRowUpstream;
import io.crate.operation.projectors.RowReceiver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class RowSender implements Runnable, RowUpstream {

    private final RowReceiver downstream;
    private final TopRowUpstream topRowUpstream;

    private volatile int numPauses = 0;
    private volatile int numResumes = 0;
    private Iterator<? extends Row> iterator;
    private Row currentRow;

    public RowSender(final Iterable<? extends Row> rows, RowReceiver rowReceiver, Executor executor) {
        downstream = rowReceiver;
        topRowUpstream = new TopRowUpstream(executor, new Runnable() {
            @Override
            public void run() {
                numResumes++;
                RowSender.this.run();
            }
        }, new Runnable() {
            @Override
            public void run() {
                iterator = rows.iterator();
                RowSender.this.run();
            }
        });
        rowReceiver.setUpstream(this);
        iterator = rows.iterator();
    }

    @Override
    public void run() {
        while (iterator.hasNext()) {
            currentRow = iterator.next();
            final boolean wantsMore = downstream.setNextRow(currentRow);
            if (!wantsMore) {
                break;
            }
            if (processPause()) return;
        }
        downstream.finish();
   }

    private boolean processPause() {
        if (topRowUpstream.shouldPause()) {
            numPauses++;
            topRowUpstream.pauseProcessed();
            return true;
        }
        return false;
    }

    @Override
    public void pause() {
        topRowUpstream.pause();
    }

    @Override
    public void resume(boolean async) {
        topRowUpstream.resume(async);
    }

    @Override
    public void repeat() {
        topRowUpstream.repeat();
    }

    public int numPauses() {
        return numPauses;
    }

    public int numResumes() {
        return numResumes;
    }

    public static Bucket bucketFromRange(int from, int to) {
        List<Object[]> rows = new ArrayList<>(Math.abs(to - from));
        if (from < to) {
            for (int i = from; i < to; i++) {
                rows.add(new Object[] {i});
            }
        } else {
            for (int i = from; i > to; i--) {
                rows.add(new Object[] {i});
            }
        }
        return new CollectionBucket(rows);
    }

    public static RowSender run(Iterable<? extends Row> rows, RowReceiver rowReceiver) {
        RowSender rowSender = new RowSender(rows, rowReceiver, MoreExecutors.directExecutor());
        rowSender.run();
        return rowSender;
    }

    /**
     * Generates N rows where each row will just have 1 integer column, the current range iteration value.
     * N is defined by the given <p>start</p> and <p>end</p> arguments.
     *
     * @param start         range start for generating rows (inclusive)
     * @param end           range end for generating rows (exclusive)
     * @param reverse       if true, list of rows will be reversed before emitting
     * @param rowReceiver   rows will be emitted on that RowReceiver
     * @return              the last emitted integer value
     */
    public static int generateRowsInRangeAndEmit(int start, int end, boolean reverse, RowReceiver rowReceiver) {
        if (reverse) {
            return (int) run(bucketFromRange(end, start), rowReceiver).currentRow.get(0);
        }
        return ((int) run(bucketFromRange(start, end), rowReceiver).currentRow.get(0));
    }
}
