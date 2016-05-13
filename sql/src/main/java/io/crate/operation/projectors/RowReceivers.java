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

package io.crate.operation.projectors;

import io.crate.concurrent.CompletionListener;
import io.crate.concurrent.CompletionMultiListener;
import io.crate.concurrent.CompletionState;

import javax.annotation.ParametersAreNonnullByDefault;

public class RowReceivers {

    public static ListenableRowReceiver listenableRowReceiver(RowReceiver rowReceiver) {
        if (rowReceiver instanceof ListenableRowReceiver) {
            return (ListenableRowReceiver) rowReceiver;
        }
        return new ListenableWrappedRowReceiver(rowReceiver);
    }

    @ParametersAreNonnullByDefault
    private static class ListenableWrappedRowReceiver extends ForwardingRowReceiver implements ListenableRowReceiver {

        private CompletionListener listener = CompletionListener.NO_OP;

        ListenableWrappedRowReceiver(RowReceiver rowReceiver) {
            super(rowReceiver);
        }

        @Override
        public void finish() {
            super.finish();
            listener.onSuccess(CompletionState.EMPTY_STATE);
        }

        @Override
        public void fail(Throwable throwable) {
            super.fail(throwable);
            listener.onFailure(throwable);
        }

        @Override
        public void addListener(CompletionListener listener) {
            this.listener = CompletionMultiListener.merge(this.listener, listener);
        }
    }
}
