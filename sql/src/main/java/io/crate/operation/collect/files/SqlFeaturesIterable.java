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

package io.crate.operation.collect.files;

import com.google.common.base.Splitter;
import io.crate.sql.tree.Except;
import org.elasticsearch.common.inject.Inject;

import javax.annotation.Nullable;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SqlFeaturesIterable implements Iterable<SqlFeatureContext> {

    private static final Splitter TAB_SPLITTER = Splitter.on("\t");

    @Inject
    public SqlFeaturesIterable() {
    }

    @Override
    public SqlFeaturesIterator iterator() {
        return new SqlFeaturesIterator();
    }

    private class SqlFeaturesIterator implements Iterator<SqlFeatureContext> {

        private final BufferedReader reader;
        private String nextLine;

        SqlFeaturesIterator() {
            InputStreamReader SQL_FEATURES = new InputStreamReader(
                    SqlFeaturesIterator.class.getResourceAsStream("/sql_features.tsv"));
            reader = new BufferedReader(SQL_FEATURES);
            if (reader != null) {
                readNextLine();
            }
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = nextLine != null;
            if (!hasNext) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            return hasNext;
        }

        @Override
        public SqlFeatureContext next() {
            String next = nextLine();
            SqlFeatureContext ctx = null;
            if (next != null) {
                List<String> parts = TAB_SPLITTER.splitToList(next);
                ctx = SqlFeatureContext.builder()
                    .featureId(parts.get(0))
                    .featureName(parts.get(1))
                    .subFeatureId(parts.get(2))
                    .subFeatureName(parts.get(3))
                    .isSupported(parts.get(4).equals("YES"))
                    .isVerifiedBy(parts.get(5).isEmpty() ? null : parts.get(5))
                    .comments(parts.get(6).isEmpty() ? null : parts.get(6))
                    .build();
            }
            return ctx;
        }

        @Nullable
        private String nextLine() {
            String line = nextLine;
            readNextLine();
            if (line == null) {
                throw new NoSuchElementException();
            }
            return line;
        }

        private void readNextLine() {
            try {
                nextLine = reader.readLine();
            } catch (IOException e) {
                nextLine = null;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
