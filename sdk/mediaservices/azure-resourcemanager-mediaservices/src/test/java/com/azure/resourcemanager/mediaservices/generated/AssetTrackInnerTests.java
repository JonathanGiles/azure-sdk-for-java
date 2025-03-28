// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mediaservices.fluent.models.AssetTrackInner;
import com.azure.resourcemanager.mediaservices.models.TrackBase;

public final class AssetTrackInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AssetTrackInner model = BinaryData.fromString(
            "{\"properties\":{\"track\":{\"@odata.type\":\"TrackBase\"},\"provisioningState\":\"InProgress\"},\"id\":\"z\",\"name\":\"nsikvmkqzeqqkdl\",\"type\":\"fzxmhhvhgureodkw\"}")
            .toObject(AssetTrackInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AssetTrackInner model = new AssetTrackInner().withTrack(new TrackBase());
        model = BinaryData.fromObject(model).toObject(AssetTrackInner.class);
    }
}
