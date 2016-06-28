/*
 * Licensed to CRATE Technology GmbH ("Crate") under one or more contributor
 * license agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.  Crate licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
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

package io.crate.testing;

import com.google.common.base.MoreObjects;
import com.google.common.base.Throwables;
import io.crate.action.sql.*;
import io.crate.protocols.postgres.types.PGTypes;
import io.crate.types.DataType;
import org.elasticsearch.ElasticsearchTimeoutException;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.common.Priority;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.unit.TimeValue;
import org.hamcrest.Matchers;

import javax.annotation.Nullable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SQLTransportExecutor {

    private static final String SQL_REQUEST_TIMEOUT = "CRATE_TESTS_SQL_REQUEST_TIMEOUT";

    public static final TimeValue REQUEST_TIMEOUT = new TimeValue(Long.parseLong(
            MoreObjects.firstNonNull(System.getenv(SQL_REQUEST_TIMEOUT), "5")), TimeUnit.SECONDS);

    private static final ESLogger LOGGER = Loggers.getLogger(SQLTransportExecutor.class);
    private final ClientProvider clientProvider;
    private final Random random;

    public SQLTransportExecutor(ClientProvider clientProvider, Random random) {
        this.clientProvider = clientProvider;
        this.random = random;
    }

    public SQLResponse exec(String statement) {
        return exec(new SQLRequest(statement));
    }

    public SQLResponse exec(String statement, Object... params) {
        return exec(new SQLRequest(statement, params));
    }

    public SQLResponse exec(String statement, Object[] params, TimeValue timeout) {
        return exec(new SQLRequest(statement, params), timeout);
    }

    public SQLBulkResponse execBulk(String statement, Object[][] bulkArgs) {
        return exec(new SQLBulkRequest(statement, bulkArgs), REQUEST_TIMEOUT);
    }

    public SQLBulkResponse execBulk(String statement, Object[][] bulkArgs, TimeValue timeout) {
        return exec(new SQLBulkRequest(statement, bulkArgs), timeout);
    }

    public SQLResponse exec(SQLRequest request) {
        return exec(request, REQUEST_TIMEOUT);
    }

    public SQLResponse exec(SQLRequest request, TimeValue timeout) {
        String pgUrl = clientProvider.pgUrl();
        if (pgUrl != null ) { // && random.nextInt() % 10 == 0) {
            return executeWithPg(request, pgUrl);
        }
        try {
            return execute(request).actionGet(timeout);
        } catch (ElasticsearchTimeoutException e) {
            LOGGER.error("Timeout on SQL statement: {}", e, request.stmt());
            throw e;
        }
    }

    private SQLResponse executeWithPg(SQLRequest request, String pgUrl) {
        try {
            try (Connection conn = DriverManager.getConnection(pgUrl)) {
                conn.setAutoCommit(true);
                PreparedStatement preparedStatement = conn.prepareStatement(request.stmt());
                Object[] args = request.args();
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
                return toSqlResponse(preparedStatement);
            }
        } catch (SQLException e) {
            throw Throwables.propagate(e);
        }
    }

    private SQLResponse toSqlResponse(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement.execute()) {
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Object[]> rows = new ArrayList<>();
            List<String> columnNames = new ArrayList<>(metaData.getColumnCount());
            DataType[] dataTypes = new DataType[metaData.getColumnCount()];
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                columnNames.add(metaData.getColumnName(i + 1));

                // TODO: get dataType
            }
            while (resultSet.next()) {
                Object[] row = new Object[metaData.getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                rows.add(row);
            }
            return new SQLResponse(
                columnNames.toArray(new String[0]),
                rows.toArray(new Object[0][]),
                dataTypes,
                rows.size(),
                1,
                true
            );
        } else {
            int updateCount = preparedStatement.getUpdateCount();
            return new SQLResponse(
                new String[0],
                new Object[0][],
                new DataType[0],
                updateCount,
                1,
                true
            );
        }
    }

    public SQLBulkResponse exec(SQLBulkRequest request) {
        return exec(request, REQUEST_TIMEOUT);
    }

    public SQLBulkResponse exec(SQLBulkRequest request, TimeValue timeout) {
        try {
            return execute(request).actionGet(timeout);
        } catch (ElasticsearchTimeoutException e) {
            LOGGER.error("Timeout on SQL statement: {}", e, request.stmt());
            throw e;
        }
    }

    private ActionFuture<SQLResponse> execute(SQLRequest request) {
        return clientProvider.client().execute(SQLAction.INSTANCE, request);
    }

    private ActionFuture<SQLBulkResponse> execute(SQLBulkRequest request) {
        return clientProvider.client().execute(SQLBulkAction.INSTANCE, request);
    }

    public ClusterHealthStatus ensureGreen() {
        return ensureState(ClusterHealthStatus.GREEN);
    }

    public ClusterHealthStatus ensureYellowOrGreen() {
        return ensureState(ClusterHealthStatus.YELLOW);
    }

    private ClusterHealthStatus ensureState(ClusterHealthStatus state) {
        ClusterHealthResponse actionGet = client().admin().cluster().health(
                Requests.clusterHealthRequest()
                        .waitForStatus(state)
                        .waitForEvents(Priority.LANGUID).waitForRelocatingShards(0)
        ).actionGet();

        if (actionGet.isTimedOut()) {
            LOGGER.info("ensure state timed out, cluster state:\n{}\n{}", client().admin().cluster().prepareState().get().getState().prettyPrint(), client().admin().cluster().preparePendingClusterTasks().get().prettyPrint());
            assertThat("timed out waiting for state", actionGet.isTimedOut(), equalTo(false));
        }
        if (state == ClusterHealthStatus.YELLOW) {
            assertThat(actionGet.getStatus(), Matchers.anyOf(equalTo(state), equalTo(ClusterHealthStatus.GREEN)));
        } else {
            assertThat(actionGet.getStatus(), equalTo(state));
        }
        return actionGet.getStatus();
    }

    public Client client() {
        return clientProvider.client();
    }

    public interface ClientProvider {
        Client client();

        @Nullable
        String pgUrl();
    }
}
