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

package io.crate.operation.collect.sources;

import io.crate.concurrent.CompletionListenable;
import io.crate.concurrent.Killable;
import io.crate.operation.collect.CrateCollector;
import io.crate.operation.projectors.RowReceiver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectSourceContext {

    private final Collection<CrateCollector> collectors;
    private final List<Killable> killables;
    private final List<CompletionListenable> completionListenables;

    public CollectSourceContext(Collection<CrateCollector> collectors, List<RowReceiver> rowReceivers) {
        this.collectors = collectors;
        killables = new ArrayList<>(collectors.size());
        killables.addAll(collectors);
        completionListenables = new ArrayList<>(collectors.size());
        completionListenables.addAll(collectors);

        for (RowReceiver rowReceiver : rowReceivers) {
            if (rowReceiver instanceof Killable) {
                killables.add((Killable) rowReceiver);
            }
            if (rowReceiver instanceof CompletionListenable) {
                completionListenables.add((CompletionListenable) rowReceiver);
            }
        }
    }

    public Collection<CrateCollector> collectors() {
        return collectors;
    }

    public List<Killable> killables() {
        return killables;
    }

    public List<CompletionListenable> completionListenables() {
        return completionListenables;
    }
}
