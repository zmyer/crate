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

package io.crate.disruption;

import com.google.common.collect.Sets;
import io.crate.Constants;
import io.crate.plugin.SQLPlugin;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.discovery.DiscoverySettings;
import org.elasticsearch.discovery.zen.elect.ElectMasterService;
import org.elasticsearch.discovery.zen.fd.FaultDetection;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.test.ESIntegTestCase;
import org.elasticsearch.test.disruption.NetworkDisconnectPartition;
import org.elasticsearch.test.disruption.NetworkPartition;
import org.elasticsearch.test.transport.MockTransportService;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

@ESIntegTestCase.ClusterScope(scope = ESIntegTestCase.Scope.TEST, numDataNodes = 0)
@ESIntegTestCase.SuppressLocalMode
public class VersionConsistencyITest extends ESIntegTestCase {

    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        final HashSet<Class<? extends Plugin>> classes = new HashSet<>(super.nodePlugins());
        classes.add(MockTransportService.TestPlugin.class);
        classes.add(SQLPlugin.class);
        return classes;
    }

    /**
     * Start 5 nodes, 5 reading and 5 writing threads whereas each read/write thread connects to one of the 5 nodes.
     * While concurrently writing and reading 10 documents for a concrete time, simulate a network partition.
     * Afterwards validate that each read documents version will never have different values.
     * (Document with version X must always hold the same value for all concurrent reads).
     */
    @Test
    public void testVersionIsUniqueForEachWriteOnNetworkPartition() throws Throwable {
        long runTimeInSeconds = 360;
        final long runUntil = System.currentTimeMillis() + (runTimeInSeconds * 1000);

        logger.info("--> start 5 nodes");

        final Settings sharedSettings = Settings.builder()
            .put(FaultDetection.SETTING_PING_TIMEOUT, "1s") // for hitting simulated network failures quickly
            .put(FaultDetection.SETTING_PING_RETRIES, "1") // for hitting simulated network failures quickly
            .put("discovery.zen.join_timeout", "10s")  // still long to induce failures but to long so test won't time out
            .put(DiscoverySettings.PUBLISH_TIMEOUT, "1s") // <-- for hitting simulated network failures quickly
            .put(ElectMasterService.DISCOVERY_ZEN_MINIMUM_MASTER_NODES, 3)
            .build();

        final List<String> nodes = internalCluster().startNodesAsync(5, sharedSettings).get();

        logger.info("--> wait for all nodes to join the cluster");
        ensureStableCluster(5);

        client().admin().indices().prepareCreate("registers")
            .addMapping(Constants.DEFAULT_MAPPING_TYPE, "value", "type=integer")
            .setSettings(IndexMetaData.SETTING_AUTO_EXPAND_REPLICAS, "0-all")
            .get();
        ensureYellow();

        final Map<Integer, Map<Long, Set<Integer>>> results = new ConcurrentHashMap<>(10);
        for (int i = 0; i < 10; i++) {
            results.put(i, new ConcurrentHashMap<Long, Set<Integer>>());
        }

        final CyclicBarrier barrier = new CyclicBarrier(11);

        // create and start all read and write threads
        List<Thread> allThreads = createAndRunReadWriteThreads(barrier, results, nodes, runUntil, 5);

        barrier.await();

        // simulate a ~200ms network partition, heal back to normal. repeat this after 10sec
        NetworkPartition partition = new NetworkDisconnectPartition(Sets.newHashSet(nodes.subList(0, 3)), Sets.newHashSet(nodes.subList(3, 5)), random());
        internalCluster().setDisruptionScheme(partition);

        while (System.currentTimeMillis() < runUntil) {
            logger.info("--> disrupting network");
            partition.startDisrupting();
            sleep(200);

            logger.info("--> healing network");
            partition.stopDisrupting();
            //logger.info("--> waiting to heal");
            //ensureStableCluster(5);
            sleep(10_000);
        }

        // finish all threads
        for (Thread thread : allThreads) {
            thread.join();
        }

        // validate that at least 1 version exist of each document
        assertDocumentsAreWritten(results);

        // filter out all versions which are pointing to the same value
        filterResults(results);

        // validate that there are no results left where one version points to multiple different values
        assertThat(results.size(), is(0));
    }

    private List<Thread> createAndRunReadWriteThreads(final CyclicBarrier barrier,
                                                      final Map<Integer, Map<Long, Set<Integer>>> results,
                                                      final List<String> nodes,
                                                      final long runUntil,
                                                      int numConcurrentReadWritePairs) {
        List<Thread> allThreads = new ArrayList<>();
        for (int i = 0; i < numConcurrentReadWritePairs; i++) {
            final int nodeIdx = i;
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (!waitOnBarrier(barrier)) {
                        return;
                    }

                    int val = 1;
                    while (System.currentTimeMillis() <= runUntil) {
                        for (Integer i = 0; i < results.size(); i++) {
                            try {
                                client(nodes.get(nodeIdx)).prepareIndex("registers", Constants.DEFAULT_MAPPING_TYPE, i.toString())
                                    .setSource("value", val++)
                                    .get();
                            } catch (Throwable t) {
                                //logger.error("[{}] exception on write id={}", t, nodeIdx, i);
                            }
                        }
                    }
                }
            });
            writeThread.setName("writeThread-"+i);
            writeThread.start();
            allThreads.add(writeThread);

            Thread readThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (!waitOnBarrier(barrier)) {
                        return;
                    }

                    while (System.currentTimeMillis() <= runUntil) {
                        for (Integer i = 0; i < results.size(); i++) {
                            GetResponse response;
                            try {
                                response = client().prepareGet("registers", Constants.DEFAULT_MAPPING_TYPE, i.toString())
                                    .setFields("value", "_version").get();
                            } catch (Throwable t) {
                                //logger.error("[{}] exception on read id={}", t, nodeIdx, i);
                                continue;
                            }
                            if (!response.isExists()) {
                                logger.warn("[{}] read id={}, document not found", nodeIdx, i);
                                continue;
                            }

                            // collect version and value
                            Map<Long, Set<Integer>> result = results.get(i);
                            Integer value = (Integer) response.getField("value").getValue();
                            Long version = response.getVersion();
                            if (result.get(version) == null) {
                                Set<Integer> set = Sets.newConcurrentHashSet();
                                set.add(value);
                                result.put(version, set);
                            } else {
                                result.get(version).add(value);
                            }
                        }
                    }
                }
            });
            readThread.setName("readThread-"+i);
            readThread.start();
            allThreads.add(readThread);
        }

        return allThreads;
    }

    private boolean waitOnBarrier(CyclicBarrier barrier) {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            logger.warn("Barrier interrupted", e);
            return false;
        } catch (BrokenBarrierException e) {
            logger.warn("Broken barrier", e);
            return false;
        }
        return true;
    }

    private void filterResults(Map<Integer, Map<Long, Set<Integer>>> results) {
        Iterator<Map<Long, Set<Integer>>> mapIterator = results.values().iterator();
        while (mapIterator.hasNext()) {
            Map<Long, Set<Integer>> entry = mapIterator.next();
            Iterator<Set<Integer>> it = entry.values().iterator();
            while (it.hasNext()) {
                if (it.next().size() == 1) {
                    it.remove();
                }
            }
            if (entry.size() == 0) {
                mapIterator.remove();
            }
        }
    }

    private void assertDocumentsAreWritten(Map<Integer, Map<Long, Set<Integer>>> results) {
        for (Map<Long, Set<Integer>> entry : results.values()) {
            assertThat(entry.values().size(), greaterThan(0));
        }
    }
}
