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

import io.crate.metadata.DynamicFunctionResolver;
import io.crate.metadata.FunctionIdent;
import io.crate.metadata.FunctionImplementation;
import org.elasticsearch.common.inject.multibindings.MapBinder;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.python.core.PyJavaType;
import org.python.core.PyObject;
import org.python.core.PyStringMap;
import org.python.core.PyType;
import org.python.util.PythonInterpreter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UDFService {

    protected final ESLogger logger;
    private final Settings settings;
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
        loadPlugins();
    }

    private void loadPlugins() {
        Environment env = new Environment(settings);
        File udfFile = new File(env.homeFile(), "udf");

        if (!udfFile.exists()) {
            return;
        }

        File[] pluginsFiles = udfFile.listFiles();
        if (pluginsFiles != null) {
            for (File pluginFile : pluginsFiles) {
                if (pluginFile.isDirectory()) {
                    loadPlugin(pluginFile);
                }
            }
        } else {
            logger.debug("failed to list udf functions from {}. Check your right access.", udfFile.getAbsolutePath());
        }
        this.registerUDFS();
    }

    protected void loadPlugin(File pluginFile) {
        if (logger.isTraceEnabled()) {
            logger.trace("--- adding udf function [" + pluginFile.getAbsolutePath() + "]");
        }
        try {
            // add the root
            PythonInterpreter python = new PythonInterpreter();
            File[] pythonFiles = pluginFile.listFiles();
            if (pythonFiles == null) {
                logger.trace("Could not list udf files in {}", pluginFile);
                return;
            }

            for (File pythonFile : pythonFiles) {
                python.execfile(pythonFile.getPath());
                PyStringMap locals = (PyStringMap)python.getLocals();
                for (PyObject item : locals.itervalues().asIterable()) {
                    if (item instanceof PyType) {
                        PyObject base = ((PyType) item).getBase();
                        if (base instanceof PyJavaType) {
                            for (PyObject super_base: ((PyJavaType) base).getBases().asIterable()) {
                                if (super_base instanceof PyJavaType) {
                                    String className = ((PyJavaType) super_base).getName();
                                    if (className.endsWith("UserDefinedScalarFunction")) {
                                        PyObject udf = item.__call__();
                                        UserDefinedScalarFunction userDefinedFunction =
                                                (UserDefinedScalarFunction) udf.__tojava__(UserDefinedScalarFunction.class);
                                        scalars.add(userDefinedFunction);
                                    } else if (className.endsWith("UserDefinedAggregationFunction")) {
                                        PyObject udf = item.__call__();
                                        UserDefinedAggregationFunction<?> userDefinedFunction =
                                                (UserDefinedAggregationFunction<?>) udf.__tojava__(UserDefinedAggregationFunction.class);
                                        aggregations.add(userDefinedFunction);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            logger.warn("failed to add plugin [" + pluginFile + "]", e);
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
