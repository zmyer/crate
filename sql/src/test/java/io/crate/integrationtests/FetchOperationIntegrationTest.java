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

import io.crate.action.sql.SQLResponse;
import org.elasticsearch.test.ElasticsearchIntegrationTest;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

@ElasticsearchIntegrationTest.ClusterScope(numDataNodes = 2, numClientNodes = 0)
public class FetchOperationIntegrationTest extends SQLTransportIntegrationTest {

    private void setUpCharacters() {
        execute("create table characters (id int primary key, name string) " +
                "clustered into 2 shards with(number_of_replicas=0)");
        ensureYellow();
        execute("insert into characters (id, name) values (?, ?)",
                new Object[][]{
                        new Object[]{1, "Arthur"},
                        new Object[]{2, "Ford"},
                }
        );
        execute("refresh table characters");
    }

    @Test
    public void testFetchProjection() throws Exception {
        setUpCharacters();
        SQLResponse res = execute("select id, name, substr(name, 2) from characters order by id");
        assertThat(res.rowCount(), is(2L));
        assertThat(res.rows()[0].length, is(3));
        assertThat((Integer) res.rows()[0][0], is(1));
        assertThat((String) res.rows()[0][1], is("Arthur"));
        assertThat((String) res.rows()[0][2], is("rthur"));
        assertThat((Integer) res.rows()[1][0], is(2));
        assertThat((String) res.rows()[1][1], is("Ford"));
        assertThat((String) res.rows()[1][2], is("ord"));
    }
}