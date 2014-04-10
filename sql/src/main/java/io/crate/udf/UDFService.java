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

import com.google.common.io.Files;
import io.crate.metadata.DynamicFunctionResolver;
import io.crate.metadata.FunctionIdent;
import io.crate.metadata.FunctionImplementation;
import org.elasticsearch.common.inject.multibindings.MapBinder;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.runtime.Block;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;
import org.python.core.PyJavaType;
import org.python.core.PyObject;
import org.python.core.PyType;

import javax.script.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UDFService {

    protected final ESLogger logger;
    private final Settings settings;
    private final ScriptEngineManager scriptEngineManager;
    private final ThreadContext threadContext;
    List<UserDefinedScalarFunction<?, ?>> scalars = new ArrayList<>();
    List<UserDefinedAggregationFunction<?>> aggregations = new ArrayList<>();
    private MapBinder<FunctionIdent, FunctionImplementation> functionBinder;
    private MapBinder<String, DynamicFunctionResolver> resolverBinder;

    public UDFService(Settings settings,
                      MapBinder<FunctionIdent, FunctionImplementation> functionBinder,
                      MapBinder<String, DynamicFunctionResolver> resolverBinder) {
        this.settings = settings;
        this.functionBinder = functionBinder;
        this.resolverBinder = resolverBinder;
        this.logger = Loggers.getLogger(getClass(), settings);
        scriptEngineManager = new ScriptEngineManager();
        threadContext = Ruby.getGlobalRuntime().getCurrentContext();
        loadPlugins();
    }

    private void loadPlugins() {
        Environment env = new Environment(settings);
        // TODO: make udf path configurable
        File udfFile = new File(env.homeFile(), "udf");
        if (!udfFile.exists()) {
            return;
        }
        File[] files = udfFile.listFiles();
        if (files == null) {
            logger.debug("failed to list udf functions from {}. Check your right access.",
                    udfFile.getAbsolutePath());
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                try {
                    loadUDF(file);
                } catch (IOException | ScriptException e) {
                    logger.warn(e.getMessage(), e);
                }
            }
        }
        this.registerUDFS();
    }

    protected void loadUDF(File udfFile) throws IOException, ScriptException {
        File[] files = udfFile.listFiles();
        if (files == null) {
            logger.trace("Could not list udf files in {}", udfFile);
            return;
        }
        for (File file : files) {
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByExtension(Files.getFileExtension(file.getName()));
            if (scriptEngine == null) {
                continue;
            }
            ScriptContext scriptContext = scriptEngine.getContext();
            scriptEngine.eval(
                    new BufferedReader(new InputStreamReader(new FileInputStream(file))),
                    scriptContext
            );
            for (Integer scope : scriptContext.getScopes()) {
                Bindings bindings = scriptContext.getBindings(scope);
                if (bindings == null) {
                    continue;
                }
                for (Map.Entry<String, Object> entry : bindings.entrySet()) {
                    Object value = entry.getValue();
                    tryLoadClass(value);
                }
            }
        }
    }

    private void tryLoadClass(Object value) {
        if (value instanceof RubyClass) {
            // TODO: check if userDefinedScalar or aggregation
            IRubyObject instance = ((RubyClass) value).newInstance(threadContext, Block.NULL_BLOCK);
            Object o = instance.toJava(UserDefinedScalarFunction.class);
            scalars.add((UserDefinedScalarFunction)o);
        }
        if (value instanceof PyType && !(value instanceof PyJavaType)) {
            if (((PyType) value).isSubType(PyJavaType.fromClass(UserDefinedAggregationFunction.class))) {
                PyObject udf = ((PyType) value).__call__();
                UserDefinedAggregationFunction<?> userDefinedFunction =
                        (UserDefinedAggregationFunction<?>) udf.__tojava__(UserDefinedAggregationFunction.class);
                aggregations.add(userDefinedFunction);
            } else if (((PyType) value).isSubType(PyJavaType.fromClass(UserDefinedScalarFunction.class))) {
                PyObject udf = ((PyType) value).__call__();
                UserDefinedScalarFunction userDefinedFunction =
                        (UserDefinedScalarFunction) udf.__tojava__(UserDefinedScalarFunction.class);
                scalars.add(userDefinedFunction);
            }
        }
    }

    public void registerUDFS() {
        for (UserDefinedScalarFunction<?, ?> udf : scalars) {
            FunctionIdent ident = udf.ident();
            if (ident != null) {
                functionBinder.addBinding(ident).toInstance(udf);
            }
            DynamicFunctionResolver dynamicFunctionResolver = udf.dynamicFunctionResolver();
            if (dynamicFunctionResolver != null) {
                resolverBinder.addBinding(udf.name()).toInstance(dynamicFunctionResolver);
            }
        }

        for (UserDefinedAggregationFunction<?> udf : aggregations) {
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
