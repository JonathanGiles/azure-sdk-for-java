// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.GoogleAdWordsSource;

public final class GoogleAdWordsSourceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GoogleAdWordsSource model = BinaryData.fromString(
            "{\"type\":\"GoogleAdWordsSource\",\"query\":\"dataxkwrvtlb\",\"queryTimeout\":\"datakbdtmr\",\"additionalColumns\":\"datatuzfhvb\",\"sourceRetryCount\":\"datai\",\"sourceRetryWait\":\"datauluilgmovadn\",\"maxConcurrentConnections\":\"datasmjxgqsbjc\",\"disableMetricsCollection\":\"dataaruvbzcqgtzxtlr\",\"\":{\"pswlepttabrkn\":\"datadznvjgovyqp\",\"keuyxgpcrvvmrdl\":\"datafw\",\"ysdharswhq\":\"datakpznoveabwpaiqik\",\"nndfplksdiehraj\":\"datarpdxnrdvtvtyqlt\"}}")
            .toObject(GoogleAdWordsSource.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GoogleAdWordsSource model = new GoogleAdWordsSource().withSourceRetryCount("datai")
            .withSourceRetryWait("datauluilgmovadn")
            .withMaxConcurrentConnections("datasmjxgqsbjc")
            .withDisableMetricsCollection("dataaruvbzcqgtzxtlr")
            .withQueryTimeout("datakbdtmr")
            .withAdditionalColumns("datatuzfhvb")
            .withQuery("dataxkwrvtlb");
        model = BinaryData.fromObject(model).toObject(GoogleAdWordsSource.class);
    }
}
