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

package io.crate.core.collections;

public class ImmutableRow implements Row {

    private final Object[] values;

    public static ImmutableRow copyOf(Row row) {
        if (row instanceof ImmutableRow) {
            return (ImmutableRow) row;
        }
        Object[] copy = new Object[row.size()];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = row.get(i);
        }
        return new ImmutableRow(copy);
    }

    private ImmutableRow(Object[] values) {
        this.values = values;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public Object get(int index) {
        return values[index];
    }

    @Override
    public ImmutableRow immutableCopy() {
        return this;
    }
}
