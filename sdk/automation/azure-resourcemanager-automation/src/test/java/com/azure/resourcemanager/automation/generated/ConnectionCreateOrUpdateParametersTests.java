// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.automation.models.ConnectionCreateOrUpdateParameters;
import com.azure.resourcemanager.automation.models.ConnectionTypeAssociationProperty;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ConnectionCreateOrUpdateParametersTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ConnectionCreateOrUpdateParameters model = BinaryData.fromString(
            "{\"name\":\"rmaequ\",\"properties\":{\"description\":\"hxicslfaoqz\",\"connectionType\":{\"name\":\"yylhalnswhccsp\"},\"fieldDefinitionValues\":{\"oluhczbwemh\":\"ivwitqscywugg\",\"sbrgz\":\"i\",\"ggicccnxqhue\":\"wmsweypqwd\"}}}")
            .toObject(ConnectionCreateOrUpdateParameters.class);
        Assertions.assertEquals("rmaequ", model.name());
        Assertions.assertEquals("hxicslfaoqz", model.description());
        Assertions.assertEquals("yylhalnswhccsp", model.connectionType().name());
        Assertions.assertEquals("ivwitqscywugg", model.fieldDefinitionValues().get("oluhczbwemh"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ConnectionCreateOrUpdateParameters model = new ConnectionCreateOrUpdateParameters().withName("rmaequ")
            .withDescription("hxicslfaoqz")
            .withConnectionType(new ConnectionTypeAssociationProperty().withName("yylhalnswhccsp"))
            .withFieldDefinitionValues(
                mapOf("oluhczbwemh", "ivwitqscywugg", "sbrgz", "i", "ggicccnxqhue", "wmsweypqwd"));
        model = BinaryData.fromObject(model).toObject(ConnectionCreateOrUpdateParameters.class);
        Assertions.assertEquals("rmaequ", model.name());
        Assertions.assertEquals("hxicslfaoqz", model.description());
        Assertions.assertEquals("yylhalnswhccsp", model.connectionType().name());
        Assertions.assertEquals("ivwitqscywugg", model.fieldDefinitionValues().get("oluhczbwemh"));
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
