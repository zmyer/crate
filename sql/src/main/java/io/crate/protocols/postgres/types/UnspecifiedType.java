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

package io.crate.protocols.postgres.types;

import io.crate.types.DataTypes;
import org.apache.lucene.util.BytesRef;
import org.jboss.netty.buffer.ChannelBuffer;

import javax.annotation.Nonnull;
import java.nio.charset.StandardCharsets;

public class UnspecifiedType extends PGType {

    private static final int OID = 0;
    private static final int TYPE_LEN = -1;
    private static final int TYPE_MOD = -1;

    UnspecifiedType() {
        super(OID, TYPE_LEN, TYPE_MOD, FormatCode.TEXT);
    }

    @Override
    public int writeValue(ChannelBuffer buffer, @Nonnull Object value) {
        BytesRef val = DataTypes.STRING.value(value);
        buffer.writeInt(val.length);
        buffer.writeBytes(val.bytes, val.offset, val.length);
        return INT32_BYTE_SIZE + val.length;
    }

    @Override
    public Object readBinaryValue(ChannelBuffer buffer, int valueLength) {
        byte[] bytes = new byte[valueLength];
        buffer.readBytes(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @Override
    Object valueFromUTF8Bytes(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
