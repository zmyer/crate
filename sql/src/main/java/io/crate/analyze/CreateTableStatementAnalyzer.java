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

import io.crate.Constants;
import io.crate.analyze.expressions.ExpressionToNumberVisitor;
import io.crate.analyze.expressions.ExpressionToStringVisitor;
import io.crate.metadata.ColumnIdent;
import io.crate.metadata.FulltextAnalyzerResolver;
import io.crate.metadata.Schemas;
import io.crate.metadata.TableIdent;
import io.crate.sql.tree.*;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Singleton;

import java.util.Locale;

@Singleton
public class CreateTableStatementAnalyzer extends DefaultTraversalVisitor<CreateTableAnalyzedStatement,
        CreateTableStatementAnalyzer.Context> {

    private static final TablePropertiesAnalyzer TABLE_PROPERTIES_ANALYZER = new TablePropertiesAnalyzer();
    private static final String CLUSTERED_BY_IN_PARTITIONED_ERROR = "Cannot use CLUSTERED BY column in PARTITIONED BY clause";
    private final Schemas schemas;
    private final FulltextAnalyzerResolver fulltextAnalyzerResolver;

    static class Context {
        Analysis analysis;
        CreateTableAnalyzedStatement statement;

        public Context(Analysis analysis) {
            this.analysis = analysis;
        }
    }

    public CreateTableAnalyzedStatement analyze(Node node, Analysis analysis) {
        analysis.expectsAffectedRows(true);
        return super.process(node, new Context(analysis));
    }

    @Inject
    public CreateTableStatementAnalyzer(Schemas schemas,
                                        FulltextAnalyzerResolver fulltextAnalyzerResolver) {
        this.schemas = schemas;
        this.fulltextAnalyzerResolver = fulltextAnalyzerResolver;
    }

    @Override
    protected CreateTableAnalyzedStatement visitNode(Node node, Context context) {
        throw new RuntimeException(
                String.format("Encountered node %s but expected a CreateTable node", node));
    }

}
