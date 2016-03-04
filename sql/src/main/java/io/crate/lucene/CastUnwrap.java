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

package io.crate.lucene;

import io.crate.analyze.symbol.Function;
import io.crate.analyze.symbol.Symbol;
import io.crate.analyze.symbol.SymbolVisitor;
import io.crate.operation.scalar.cast.CastFunctionResolver;

import java.util.ArrayList;
import java.util.List;

public class CastUnwrap {

    private static final Visitor VISITOR = new Visitor();

    public static Symbol unwrapCast(Symbol symbol) {
        return VISITOR.process(symbol, null);
    }

    private static class Visitor extends SymbolVisitor<Void, Symbol> {

        @Override
        protected Symbol visitSymbol(Symbol symbol, Void context) {
            return symbol;
        }

        @Override
        public Symbol visitFunction(Function symbol, Void context) {
            if (CastFunctionResolver.CAST_FUNCTION_NAMES.contains(symbol.info().ident().name())) {
                Symbol arg = symbol.arguments().get(0);
                switch (arg.symbolType()) {
                    case REFERENCE:
                        return arg;
                    case FUNCTION:
                        return unwrapCast(arg);
                }
            }

            boolean hasNewArgs = false;
            List<Symbol> newArgs = new ArrayList<>();
            for (int i = 0; i < symbol.arguments().size(); i++) {
                Symbol arg = symbol.arguments().get(i);
                Symbol newArg = process(arg, null);

                newArgs.add(newArg);
                hasNewArgs = hasNewArgs || arg != newArg;
            }
            if (hasNewArgs) {
                return new Function(symbol.info(), newArgs);
            }
            return symbol;
        }
    }
}
