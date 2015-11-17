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

package io.crate.sql.tree;

import com.google.common.base.MoreObjects;
import jdk.nashorn.internal.ir.Assignment;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InsertFromValues extends Statement {

    private final QualifiedName tableName;
    private final List<List<Expression>> valuesLists;
    @Nullable
    private final List<String> columns;
    @Nullable
    private final List<Assignment> onDuplicateKeyAssignments;
    private final int maxValuesLength;

    public InsertFromValues(QualifiedName tableName,
                            List<List<Expression>> valuesLists,
                            @Nullable List<String> columns,
                            @Nullable List<Assignment> onDuplicateKeyAssignments) {
        super(Optional.empty());
        this.tableName = tableName;
        this.valuesLists = valuesLists;
        this.columns = columns;
        this.onDuplicateKeyAssignments = onDuplicateKeyAssignments;
        int i = 0;
        for (List<Expression> valuesList : valuesLists) {
            i = Math.max(i, valuesList.size());
        }
        maxValuesLength = i;
    }

    public List<List<Expression>> valuesLists() {
        return valuesLists;
    }

    /**
     * returns the length of the longest values List
     */
    public int maxValuesLength() {
        return maxValuesLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsertFromValues that = (InsertFromValues) o;
        return maxValuesLength == that.maxValuesLength &&
               Objects.equals(tableName, that.tableName) &&
               Objects.equals(valuesLists, that.valuesLists) &&
               Objects.equals(columns, that.columns) &&
               Objects.equals(onDuplicateKeyAssignments, that.onDuplicateKeyAssignments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, valuesLists, columns, onDuplicateKeyAssignments, maxValuesLength);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("table", tableName)
                .add("columns", columns)
                .add("values", valuesLists)
                .add("assignments", onDuplicateKeyAssignments)
                .toString();
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitInsertFromValues(this, context);
    }
}
