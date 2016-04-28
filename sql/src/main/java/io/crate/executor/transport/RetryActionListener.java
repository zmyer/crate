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

package io.crate.executor.transport;

import io.crate.exceptions.Exceptions;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.util.concurrent.EsRejectedExecutionException;
import org.elasticsearch.threadpool.ThreadPool;

import java.util.Iterator;
import java.util.function.BiConsumer;

public class RetryActionListener<TRequest, TResponse> implements ActionListener<TResponse> {

    private final ThreadPool threadPool;
    private final Runnable command;
    private final ActionListener<TResponse> listener;
    private final Iterator<TimeValue> backOffIt;

    public RetryActionListener(ThreadPool threadPool,
                               TRequest request,
                               BiConsumer<TRequest, ActionListener<TResponse>> command,
                               BackoffPolicy backoffPolicy,
                               ActionListener<TResponse> listener) {
        this.threadPool = threadPool;
        backOffIt = backoffPolicy.iterator();
        this.listener = listener;
        this.command = () -> command.accept(request, RetryActionListener.this);
    }

    @Override
    public void onResponse(TResponse tResponse) {
        listener.onResponse(tResponse);
    }

    @Override
    public void onFailure(Throwable e) {
        Throwable t = Exceptions.unwrap(e);
        if (t instanceof EsRejectedExecutionException) {
            if (backOffIt.hasNext()) {
                TimeValue delay = backOffIt.next();
                threadPool.schedule(delay, ThreadPool.Names.GENERIC, command);
                return;
            }
        }
        listener.onFailure(t);
    }
}
