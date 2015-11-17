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
import io.crate.analyze.Analyzer;
import io.crate.analyze.ParameterContext;
import io.crate.analyze.V3Analyzer;
import io.crate.sql.tree.Node;
import io.crate.sql.tree.Statement;
import io.crate.sql.v4.AstBuilder;
import io.crate.sql.v4.SqlParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Singleton;

@Singleton
public class V4Analyzer implements Analyzer {

    private final V3Analyzer v3Analyzer;
    private final SqlParser parser;
    private final AstBuilder builder;

    @Inject
    public V4Analyzer(V3Analyzer v3Analyzer) {
        this.v3Analyzer = v3Analyzer;
        this.parser = new SqlParser();
        this.builder = new AstBuilder();
    }

    @Override
    public Analysis analyze(String statement, ParameterContext parameterContext) throws Exception {
        try {
            ParseTree tree = parser.parse(statement);
            Node node = builder.visit(tree);
            return v3Analyzer.analyze((Statement) node, parameterContext);
        } catch (Throwable t) {
            return v3Analyzer.analyze(statement, parameterContext);
        }
    }
}
