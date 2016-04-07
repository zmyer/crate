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

package io.crate.integrationtests;

import com.carrotsearch.randomizedtesting.annotations.Repeat;
import com.google.common.base.Throwables;
import io.crate.action.sql.SQLRequest;
import io.crate.action.sql.SQLResponse;
import io.crate.analyze.Analysis;
import io.crate.exceptions.Exceptions;
import io.crate.jobs.JobContextService;
import io.crate.jobs.JobExecutionContext;
import io.crate.planner.Plan;
import org.elasticsearch.common.collect.Tuple;
import org.elasticsearch.test.junit.annotations.TestLogging;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.core.Is.is;

public class JobContextIntegrationTest extends SQLTransportIntegrationTest {

    Setup setup = new Setup(sqlExecutor);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAllContextAreClosed() throws Exception {
        // lets create some contexts which must be closed after statement execution

        // group-by query (job collect context with sub-contexts + PageDownstreamContext are created)
        setup.groupBySetup();
        execute("select age, name from characters group by 1, 2");

        // system table query (job collect context without sub-contexts is created)
        execute("select random(), random() from sys.cluster limit 1");

        // information_schema table query (job collect context without sub-contexts is created)
        execute("select table_name from information_schema.tables");

        // multiple upserts (SymbolBasedBulkShardProcessorContext is created)
        execute("create table upserts (id int primary key, d long)");
        ensureYellow();
        execute("insert into upserts (id, d) values (?, ?)", new Object[][] {
                new Object[] { 1, -7L },
                new Object[] { 2, 3L },
        } );
        refresh();

        // upsert-by-id (UpsertByIdContext is created)
        execute("update upserts set d = 5 where id = 1");

        // get by id (ESJobContext is created)
        execute("select * from upserts where id = 1");

        // count (CountContext is created)
        execute("select count(*) from upserts");


        // now check if all contexts are gone
        final Field activeContexts = JobContextService.class.getDeclaredField("activeContexts");
        activeContexts.setAccessible(true);

        assertBusy(new Runnable() {
            @Override
            public void run() {
                for (JobContextService jobContextService : internalCluster().getInstances(JobContextService.class)) {
                    Map<UUID, JobExecutionContext> contextMap = null;
                    try {
                        contextMap = (Map<UUID, JobExecutionContext>) activeContexts.get(jobContextService);
                        assertThat(contextMap.size(), is(0));
                    } catch (Exception e) {
                        fail(e.getMessage());
                    }
                }
            }
        }, 1, TimeUnit.SECONDS);
    }

    @Repeat(iterations = 300)
    @TestLogging("io.crate.jobs:TRACE,io.crate.executor.transport.distributed:TRACE," +
                 "io.crate.operation.collect:TRACE,io.crate.action.sql:TRACE,io.crate.operation.NodeOperation:TRACE," +
                 "io.crate.executor.transport.ExecutionPhasesTask:TRACE")
    @Test
    public void testErrorPropagationOnContextPrepare() throws Throwable {
        // Test that errors on context prepare are propagated correctly.
        // This is provoked by executing a plan after a used index was deleted.

        execute("create table t1 (x int)");
        execute("create table t2 (x int)");
        ensureYellow();
        execute("insert into t1 (x) values (1)");
        execute("insert into t2 (x) values (2)");
        execute("refresh table t1, t2");

        String[] nodes = internalCluster().getNodeNames();
        String handlerNode = nodes[randomInt(nodes.length-1)];

        // create the plan, all indices exists at this point
        SQLRequest request = new SQLRequest("select * from t1, t2 where t1.x = t2.x");
        Tuple<Plan, Analysis> planAndAnalysis = analysisAndPlan(request, handlerNode);

        execute("drop table t2");
        waitForZeroCount("select count(*) from sys.shards where table_name = 't2'");

        System.out.println("\n=============================== EXECUTING JOIN ======================\n");

        expectedException.expectMessage(anyOf(
                containsString("Table 't2' unknown"),
                containsString("Table 'doc.t2' unknown")));

        // execute that plan, now 1 index was deleted
        try {
            execute(planAndAnalysis.v1(), planAndAnalysis.v2(), request, handlerNode).get(20, TimeUnit.SECONDS);
        } catch (Throwable t) {
            clearActiveJobContexts();
            throw Exceptions.unwrap(t);
        }
    }

    private void waitForZeroCount(String stmt) {
        for (int i = 1; i < 10; i++) {
            SQLResponse r = execute(stmt);
            if (((Long) r.rows()[0][0]) == 0L) {
                return;
            }
            try {
                Thread.sleep(i * 100);
            } catch (InterruptedException e) {
                Throwables.propagate(e);
            }
        }
        throw new RuntimeException("waiting for zero result timed out");
    }

}
