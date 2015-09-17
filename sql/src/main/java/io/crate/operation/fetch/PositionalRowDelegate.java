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

package io.crate.operation.fetch;

import io.crate.core.collections.Row;

public class PositionalRowDelegate implements Row {
    private final int position;
    private final Row row;

    public PositionalRowDelegate(Row delegate, int position) {
        this.row = delegate.immutableCopy();
        this.position = position;
    }

    @Override
    public int size() {
        return row.size();
    }

    @Override
    public Object getCopy(int index) {
        if (index == size()) {
            return position;
        } else if (index < size()) {
            return row.getCopy(index);
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    @Override
    public Object getShared(int index) {
        return getCopy(index);
    }

    @Override
    public Row immutableCopy() {
        return row;
    }
}
