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

package io.crate.analyze;

import io.crate.analyze.expressions.ExpressionToStringVisitor;
import io.crate.metadata.ColumnIdent;
import io.crate.metadata.FulltextAnalyzerResolver;
import io.crate.metadata.ReferenceInfo;
import io.crate.sql.tree.*;
import io.crate.types.DataTypes;
import org.elasticsearch.common.settings.Settings;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class TableElementsAnalyzer {


    private final static InnerTableElementsAnalyzer analyzer = new InnerTableElementsAnalyzer();

    public static AnalyzedTableElements analyze(List<TableElement> tableElements,
                                                ParameterContext parameterContext,
                                                FulltextAnalyzerResolver fulltextAnalyzerResolver) {
        AnalyzedTableElements analyzedTableElements = new AnalyzedTableElements();
        for (TableElement tableElement : tableElements) {
            ColumnDefinitionContext ctx = new ColumnDefinitionContext(
                    null, parameterContext, fulltextAnalyzerResolver, analyzedTableElements);
            analyzer.process(tableElement, ctx);
            if (ctx.analyzedColumnDefinition.ident() != null) {
                analyzedTableElements.add(ctx.analyzedColumnDefinition);
            }
        }
        return analyzedTableElements;
    }

    public static AnalyzedTableElements analyze(TableElement tableElement,
                                                ParameterContext parameterContext,
                                                FulltextAnalyzerResolver fulltextAnalyzerResolver) {
        return analyze(Arrays.asList(tableElement), parameterContext, fulltextAnalyzerResolver);
    }

    private static class ColumnDefinitionContext {
        final ParameterContext parameterContext;
        final FulltextAnalyzerResolver fulltextAnalyzerResolver;
        AnalyzedColumnDefinition analyzedColumnDefinition;
        final AnalyzedTableElements analyzedTableElements;

        public ColumnDefinitionContext(@Nullable AnalyzedColumnDefinition parent,
                                       ParameterContext parameterContext,
                                       FulltextAnalyzerResolver fulltextAnalyzerResolver,
                                       AnalyzedTableElements analyzedTableElements) {
            this.analyzedColumnDefinition = new AnalyzedColumnDefinition(parent);
            this.parameterContext = parameterContext;
            this.fulltextAnalyzerResolver = fulltextAnalyzerResolver;
            this.analyzedTableElements = analyzedTableElements;
        }
    }

    private static class InnerTableElementsAnalyzer
            extends DefaultTraversalVisitor<Void, ColumnDefinitionContext> {

    }
}
