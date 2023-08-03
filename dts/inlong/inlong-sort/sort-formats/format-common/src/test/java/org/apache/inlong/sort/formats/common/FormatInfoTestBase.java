/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sort.formats.common;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * The base of the unit tests for {@link FormatInfo}.
 */
public abstract class FormatInfoTestBase {

    /**
     * Creates the instances for testing.
     *
     * @return The instances for testing.
     */
    abstract Collection<FormatInfo> createFormatInfos();

    /**
     * Verify that format information can be correctly marshalled and
     * demarshalled.
     */
    @Test
    public void testMarshallAndDemarshall() throws Exception {

        Collection<FormatInfo> formatInfos = createFormatInfos();

        for (FormatInfo formatInfo : formatInfos) {
            String json = FormatUtils.marshall(formatInfo);
            FormatInfo actualFormatInfo = FormatUtils.demarshall(json);
            assertEquals(formatInfo, actualFormatInfo);
        }
    }
}
