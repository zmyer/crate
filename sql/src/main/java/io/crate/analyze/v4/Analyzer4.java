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

package io.crate.analyze.v4;

import io.crate.analyze.Analysis;
import io.crate.analyze.AnalyzedStatement;
import io.crate.analyze.ParameterContext;
import io.crate.sql.v4.SqlBaseBaseVisitor;
import io.crate.sql.v4.SqlBaseParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class Analyzer4 {

    private final Dispatcher dispatcher;

    public Analyzer4() {
        dispatcher = new Dispatcher();
    }

    public Analysis analyze(ParserRuleContext parserRuleContext, ParameterContext parameterContext) {
        dispatcher.visit(parserRuleContext);
        return null;
    }

    private static class Dispatcher extends SqlBaseBaseVisitor<AnalyzedStatement> {

        @Override
        public AnalyzedStatement visitSingleStatement(SqlBaseParser.SingleStatementContext ctx) {
            return visit(ctx.statement());
        }

        @Override
        public AnalyzedStatement visitQuery(SqlBaseParser.QueryContext ctx) {
            return visit(ctx.queryNoWith());
        }

        @Override
        public AnalyzedStatement visitQueryNoWith(SqlBaseParser.QueryNoWithContext ctx) {
            ctx.queryTerm();
            return super.visitQueryNoWith(ctx);
        }
    }
}
