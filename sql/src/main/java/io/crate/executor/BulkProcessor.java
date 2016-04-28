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

package io.crate.executor;


import io.crate.operation.RowUpstream;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BulkProcessor<TItem, TKey, TGroup extends BulkProcessor.Group<TItem>> {

    private final Function<TItem, TKey> keyFunction;
    private final Supplier<TGroup> groupFactory;
    private final BiConsumer<Set<Map.Entry<TKey, TGroup>>, Runnable> operation;
    private final RowUpstream rowUpstream;
    private final Runnable doneCallback;
    private final int bulkSize;
    private final Map<TKey, TGroup> groups = new HashMap<>();
    private final Runnable resumeOperation;

    private int numItems = 0;
    private AtomicBoolean closed = new AtomicBoolean(false);
    private AtomicInteger runningOperations = new AtomicInteger(0);

    public BulkProcessor(Function<TItem, TKey> keyFunction,
                         Supplier<TGroup> groupFactory,
                         BiConsumer<Set<Map.Entry<TKey, TGroup>>, Runnable> operation,
                         final RowUpstream rowUpstream,
                         Runnable doneCallback,
                         int bulkSize) {
        this.keyFunction = keyFunction;
        this.groupFactory = groupFactory;
        this.operation = operation;
        this.rowUpstream = rowUpstream;
        this.doneCallback = doneCallback;
        this.bulkSize = bulkSize;
        this.resumeOperation = () -> {
            runningOperations.decrementAndGet();
            rowUpstream.resume(false);

            if (closed.get()) {
                doneCallback.run();
            }
        };
    }

    public void add(TItem item) {
        addItemToGroup(item);

        if (numItems % bulkSize == 0) {
            if (runningOperations.get() > 0) {
                rowUpstream.pause();
            } else {
                runningOperations.incrementAndGet();
                operation.accept(groups.entrySet(), resumeOperation);
            }
        }
    }

    private void addItemToGroup(TItem item) {
        numItems++;
        TKey key = keyFunction.apply(item);
        TGroup tGroup = groups.get(key);
        if (tGroup == null) {
            tGroup = groupFactory.get();
            groups.put(key, tGroup);
        }
        tGroup.add(numItems, item);
    }

    public void close() {
        if (closed.compareAndSet(false, true)) {
            if (runningOperations.get() == 0) {
                if (groups.size() == 0) {
                    doneCallback.run();
                } else {
                    operation.accept(groups.entrySet(), doneCallback);
                }
            }
        }
    }

    public interface Group<TItem> {

        void add(int location, TItem item);
    }
}
