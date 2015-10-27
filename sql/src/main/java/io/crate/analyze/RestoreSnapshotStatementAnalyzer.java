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

package io.crate.analyze;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.crate.exceptions.PartitionAlreadyExistsException;
import io.crate.exceptions.SchemaUnknownException;
import io.crate.exceptions.TableAlreadyExistsException;
import io.crate.exceptions.TableUnknownException;
import io.crate.metadata.PartitionName;
import io.crate.metadata.Schemas;
import io.crate.metadata.TableIdent;
import io.crate.metadata.doc.DocTableInfo;
import io.crate.metadata.table.TableInfo;
import io.crate.sql.tree.Expression;
import io.crate.sql.tree.RestoreSnapshot;
import io.crate.sql.tree.Table;
import org.elasticsearch.cluster.ClusterService;
import org.elasticsearch.common.Preconditions;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Singleton;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;

import java.util.*;

import static io.crate.analyze.SnapshotSettings.*;

@Singleton
public class RestoreSnapshotStatementAnalyzer extends AbstractRepositoryDDLAnalyzer<RestoreSnapshotAnalyzedStatement, RestoreSnapshot> {

    private static final ESLogger LOGGER = Loggers.getLogger(RestoreSnapshotStatementAnalyzer.class);
    private static final ImmutableMap<String, SettingsApplier> SETTINGS = ImmutableMap.<String, SettingsApplier>builder()
            .put(PARTIAL.name(), new SettingsAppliers.BooleanSettingsApplier(PARTIAL))
            .put(IGNORE_UNAVAILABLE.name(), new SettingsAppliers.BooleanSettingsApplier(IGNORE_UNAVAILABLE))
            .put(WAIT_FOR_COMPLETION.name(), new SettingsAppliers.BooleanSettingsApplier(WAIT_FOR_COMPLETION))
            .build();

    private final Schemas schemas;

    @Inject
    public RestoreSnapshotStatementAnalyzer(ClusterService clusterService,
                                            Schemas schemas) {
        super(clusterService);
        this.schemas = schemas;
    }

    @Override
    public RestoreSnapshotAnalyzedStatement visitRestoreSnapshot(RestoreSnapshot node, Analysis analysis) {
        List<String> nameParts = node.name().getParts();
        Preconditions.checkArgument(nameParts.size() == 2, "Snapshot name not supported, only <repository>.<snapshot> works.");
        String repositoryName = nameParts.get(0);
        failIfRepositoryDoesNotExist(repositoryName);

        // validate and extract settings
        ImmutableSettings.Builder builder = ImmutableSettings.builder();

        // apply defaults
        for (Map.Entry<String, SettingsApplier> entry : SETTINGS.entrySet()) {
            builder.put(entry.getValue().getDefault());
        }
        if (node.properties().isPresent()) {
            // apply given config
            for (Map.Entry<String, Expression> entry : node.properties().get().properties().entrySet()) {
                SettingsApplier settingsApplier = SETTINGS.get(entry.getKey());
                settingsApplier.apply(builder, analysis.parameterContext().parameters(), entry.getValue());
            }
        }
        Settings settings = builder.build();

        if (node.tableList().isPresent()) {
            List<Table> tableList = node.tableList().get();
            Set<String> restorePartitions = new HashSet<>(tableList.size());
            Set<String> restoreIndices = new HashSet<>(tableList.size());
            for (Table table : tableList) {
                TableInfo tableInfo;
                TableIdent tableIdent = TableIdent.of(table, analysis.parameterContext().defaultSchema());
                try {
                    tableInfo = schemas.getTableInfo(tableIdent);

                    if (!(tableInfo instanceof DocTableInfo)) {
                        throw new IllegalArgumentException(
                                String.format(Locale.ENGLISH, "Cannot restore snapshot of tables in schema '%s'", tableInfo.ident().schema()));
                    }
                    DocTableInfo docTableInfo = (DocTableInfo)tableInfo;
                    if (table.partitionProperties().isEmpty()) {
                        throw new TableAlreadyExistsException(tableIdent);
                    } else {
                        PartitionName partitionName = PartitionPropertiesAnalyzer.toPartitionName(
                                docTableInfo,
                                table.partitionProperties(),
                                analysis.parameterContext().parameters()
                        );
                        if (docTableInfo.partitions().contains(partitionName)) {
                            throw new PartitionAlreadyExistsException(partitionName);
                        } else {
                            restorePartitions.add(partitionName.asIndexName());
                        }
                    }
                } catch (SchemaUnknownException | TableUnknownException e) {
                    if (!table.partitionProperties().isEmpty()) {
                        // restore a partition without surrounding partitioned table
                        throw new TableUnknownException(tableIdent);
                    }

                    // add indexname
                    restoreIndices.add(tableIdent.indexName());
                    // also add a partitions wildcard
                    // to match all partitions if a partitioned table was meant
                    restoreIndices.add(PartitionName.templateName(tableIdent.schema(), tableIdent.name()) + "*");
                }
            }

            return RestoreSnapshotAnalyzedStatement.forTables(
                    nameParts.get(1),
                    repositoryName,
                    settings,
                    ImmutableList.copyOf(restoreIndices),
                    ImmutableList.copyOf(restorePartitions));
        } else {
            return RestoreSnapshotAnalyzedStatement.all(nameParts.get(1), repositoryName, settings);
        }
    }
}
