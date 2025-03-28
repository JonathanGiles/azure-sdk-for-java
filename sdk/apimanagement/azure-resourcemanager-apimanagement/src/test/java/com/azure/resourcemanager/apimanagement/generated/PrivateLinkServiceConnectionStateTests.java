// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.models.PrivateEndpointServiceConnectionStatus;
import com.azure.resourcemanager.apimanagement.models.PrivateLinkServiceConnectionState;
import org.junit.jupiter.api.Assertions;

public final class PrivateLinkServiceConnectionStateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateLinkServiceConnectionState model = BinaryData
            .fromString("{\"status\":\"Rejected\",\"description\":\"jazbbgspftesu\",\"actionsRequired\":\"pvpvd\"}")
            .toObject(PrivateLinkServiceConnectionState.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.REJECTED, model.status());
        Assertions.assertEquals("jazbbgspftesu", model.description());
        Assertions.assertEquals("pvpvd", model.actionsRequired());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateLinkServiceConnectionState model
            = new PrivateLinkServiceConnectionState().withStatus(PrivateEndpointServiceConnectionStatus.REJECTED)
                .withDescription("jazbbgspftesu")
                .withActionsRequired("pvpvd");
        model = BinaryData.fromObject(model).toObject(PrivateLinkServiceConnectionState.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.REJECTED, model.status());
        Assertions.assertEquals("jazbbgspftesu", model.description());
        Assertions.assertEquals("pvpvd", model.actionsRequired());
    }
}
