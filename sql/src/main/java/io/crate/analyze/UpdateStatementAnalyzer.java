/*
 * Licensed to CRATE Technology GmbH ("Crate") under one or more contributor
 * license agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.  Crate licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
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

package io.crate.analyze;

import com.google.common.base.Predicate;
import io.crate.analyze.relations.RelationAnalyzer;
import io.crate.analyze.symbol.Literal;
import io.crate.analyze.symbol.Symbol;
import io.crate.core.collections.StringObjectMaps;
import io.crate.exceptions.UnsupportedFeatureException;
import io.crate.metadata.ColumnIdent;
import io.crate.metadata.ReferenceInfo;
import io.crate.metadata.doc.DocTableInfo;
import io.crate.metadata.table.TableInfo;
import io.crate.sql.tree.DefaultTraversalVisitor;
import io.crate.sql.tree.Node;
import io.crate.types.ArrayType;
import io.crate.types.DataTypes;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Singleton;

import javax.annotation.Nullable;
import java.util.Map;


@Singleton
public class UpdateStatementAnalyzer extends DefaultTraversalVisitor<AnalyzedStatement, Analysis> {

    public static final String VERSION_SEARCH_EX_MSG =
            "_version is not allowed in update queries without specifying a primary key";
    private static final UnsupportedFeatureException VERSION_SEARCH_EX = new UnsupportedFeatureException(
            VERSION_SEARCH_EX_MSG);


    private static final Predicate<ReferenceInfo> IS_OBJECT_ARRAY = new Predicate<ReferenceInfo>() {
        @Override
        public boolean apply(@Nullable ReferenceInfo input) {
            return input != null
                    && input.type().id() == ArrayType.ID
                    && ((ArrayType)input.type()).innerType().equals(DataTypes.OBJECT);
        }
    };


    private final AnalysisMetaData analysisMetaData;
    private final RelationAnalyzer relationAnalyzer;


    @Inject
    public UpdateStatementAnalyzer(AnalysisMetaData analysisMetaData,
                                   RelationAnalyzer relationAnalyzer) {
        this.analysisMetaData = analysisMetaData;
        this.relationAnalyzer = relationAnalyzer;
    }

    public AnalyzedStatement analyze(Node node, Analysis analysis) {
        analysis.expectsAffectedRows(true);
        return process(node, analysis);
    }

    public static void ensureUpdateIsAllowed(DocTableInfo tableInfo, ColumnIdent column, Symbol value) {
        if (tableInfo.clusteredBy() != null) {
            ensureNotUpdated(column, value, tableInfo.clusteredBy(),
                    "Updating a clustered-by column is not supported");
        }
        for (ColumnIdent pkIdent : tableInfo.primaryKey()) {
            ensureNotUpdated(column, value, pkIdent, "Updating a primary key is not supported");
        }
        for (ColumnIdent partitionIdent : tableInfo.partitionedBy()) {
            ensureNotUpdated(column, value, partitionIdent, "Updating a partitioned-by column is not supported");
        }
    }

    private static void ensureNotUpdated(ColumnIdent columnUpdated,
                                         Symbol newValue,
                                         ColumnIdent protectedColumnIdent,
                                         String errorMessage) {
        if (columnUpdated.equals(protectedColumnIdent)) {
            throw new UnsupportedOperationException(errorMessage);
        }
        if (protectedColumnIdent.isChildOf(columnUpdated)) {
            if (newValue.valueType().equals(DataTypes.OBJECT)
                    && newValue.symbolType().isValueSymbol()
                    && StringObjectMaps.fromMapByPath((Map) ((Literal) newValue).value(), protectedColumnIdent.path()) == null) {
                return;
            }
            throw new UnsupportedOperationException(errorMessage);
        }
    }

    private boolean hasMatchingParent(TableInfo tableInfo, ReferenceInfo info, Predicate<ReferenceInfo> parentMatchPredicate) {
        ColumnIdent parent = info.ident().columnIdent().getParent();
        while (parent != null) {
            ReferenceInfo parentInfo = tableInfo.getReferenceInfo(parent);
            if (parentMatchPredicate.apply(parentInfo)) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

}