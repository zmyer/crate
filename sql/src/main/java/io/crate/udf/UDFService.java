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

package io.crate.udf;

import io.crate.DataType;
import io.crate.metadata.DynamicFunctionResolver;
import io.crate.metadata.FunctionIdent;
import io.crate.metadata.FunctionImplementation;
import io.crate.metadata.FunctionInfo;
import io.crate.planner.symbol.Function;
import io.crate.planner.symbol.IntegerLiteral;
import io.crate.planner.symbol.Symbol;
import org.elasticsearch.common.inject.multibindings.MapBinder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UDFService {

    List<UserDefinedFunction<?>> udfs = new ArrayList<>();

    public UDFService() {
       loadPlugins();
    }

    private void loadPlugins() {
        UserDefinedFunction<Function> foo = new UserDefinedFunction<Function>() {
            @Override
            public String name() {
                return "foo";
            }

            @Nullable
            @Override
            public FunctionIdent ident() {
                return new FunctionIdent(name(), Arrays.asList(DataType.INTEGER));
            }

            @Nullable
            @Override
            public DynamicFunctionResolver dynamicFunctionResolver() {
                return null;
            }

            @Override
            public FunctionInfo info() {
                return new FunctionInfo(ident(), DataType.INTEGER);
            }

            @Override
            public Symbol normalizeSymbol(Function symbol) {
                return new IntegerLiteral(1);
            }
        };
    }

    public void registerUDFS(MapBinder<FunctionIdent, FunctionImplementation> functionBinder, MapBinder<String, DynamicFunctionResolver> resolverBinder) {
        for (UserDefinedFunction<?> udf : udfs) {
            FunctionIdent ident = udf.ident();
            if (ident != null) {
                functionBinder.addBinding(ident).toInstance(udf);
            }

            DynamicFunctionResolver dynamicFunctionResolver = udf.dynamicFunctionResolver();
            if (dynamicFunctionResolver != null) {
                resolverBinder.addBinding(udf.name()).toInstance(dynamicFunctionResolver);
            }
        }
    }
}
