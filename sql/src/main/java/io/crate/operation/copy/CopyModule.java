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

package io.crate.operation.copy;

import io.crate.operation.collect.files.FileInput;
import io.crate.operation.collect.files.FileInputFactory;
import io.crate.operation.collect.files.LocalFsFileInput;
import io.crate.operation.projectors.writer.Output;
import io.crate.operation.projectors.writer.OutputFactory;
import io.crate.operation.projectors.writer.OutputFile;
import io.crate.planner.projection.WriterProjection;
import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.inject.multibindings.MapBinder;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutorService;

public class CopyModule extends AbstractModule {

    private MapBinder<String, OutputFactory> outputBindings;
    private MapBinder<String, FileInputFactory> fileInputBindings;

    @Override
    protected void configure() {
        outputBindings = MapBinder.newMapBinder(binder(), String.class, OutputFactory.class);
        outputBindings.addBinding(OutputFile.SCHEMA_NAME).toInstance(new OutputFactory() {
            @Override
            public Output create(ExecutorService executorService, URI uri, WriterProjection.CompressionType compressionType) {
                return new OutputFile(uri, compressionType);
            }
        });
        fileInputBindings = MapBinder.newMapBinder(binder(), String.class, FileInputFactory.class);
        fileInputBindings.addBinding("file").toInstance(new FileInputFactory() {
            @Override
            public FileInput create() throws IOException {
                return new LocalFsFileInput();
            }
        });
    }
}
