// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.fluent.models.AlertRuleInner;
import org.junit.jupiter.api.Assertions;

public final class AlertRuleInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AlertRuleInner model = BinaryData.fromString(
            "{\"kind\":\"AlertRule\",\"etag\":\"fpownoizhwlr\",\"id\":\"bqsoqijg\",\"name\":\"dmbpazlobcufpdz\",\"type\":\"rbt\"}")
            .toObject(AlertRuleInner.class);
        Assertions.assertEquals("fpownoizhwlr", model.etag());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AlertRuleInner model = new AlertRuleInner().withEtag("fpownoizhwlr");
        model = BinaryData.fromObject(model).toObject(AlertRuleInner.class);
        Assertions.assertEquals("fpownoizhwlr", model.etag());
    }
}
