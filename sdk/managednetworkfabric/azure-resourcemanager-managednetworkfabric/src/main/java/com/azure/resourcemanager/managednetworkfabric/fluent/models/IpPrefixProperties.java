// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.managednetworkfabric.models.AdministrativeState;
import com.azure.resourcemanager.managednetworkfabric.models.AnnotationResource;
import com.azure.resourcemanager.managednetworkfabric.models.ConfigurationState;
import com.azure.resourcemanager.managednetworkfabric.models.IpPrefixRule;
import com.azure.resourcemanager.managednetworkfabric.models.ProvisioningState;
import java.io.IOException;
import java.util.List;

/**
 * IP Prefix Properties defines the properties of the resource.
 */
@Fluent
public final class IpPrefixProperties extends AnnotationResource {
    /*
     * Configuration state of the resource.
     */
    private ConfigurationState configurationState;

    /*
     * Provisioning state of the resource.
     */
    private ProvisioningState provisioningState;

    /*
     * Administrative state of the resource.
     */
    private AdministrativeState administrativeState;

    /*
     * The list of IP Prefix Rules.
     */
    private List<IpPrefixRule> ipPrefixRules;

    /**
     * Creates an instance of IpPrefixProperties class.
     */
    public IpPrefixProperties() {
    }

    /**
     * Get the configurationState property: Configuration state of the resource.
     * 
     * @return the configurationState value.
     */
    public ConfigurationState configurationState() {
        return this.configurationState;
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the administrativeState property: Administrative state of the resource.
     * 
     * @return the administrativeState value.
     */
    public AdministrativeState administrativeState() {
        return this.administrativeState;
    }

    /**
     * Get the ipPrefixRules property: The list of IP Prefix Rules.
     * 
     * @return the ipPrefixRules value.
     */
    public List<IpPrefixRule> ipPrefixRules() {
        return this.ipPrefixRules;
    }

    /**
     * Set the ipPrefixRules property: The list of IP Prefix Rules.
     * 
     * @param ipPrefixRules the ipPrefixRules value to set.
     * @return the IpPrefixProperties object itself.
     */
    public IpPrefixProperties withIpPrefixRules(List<IpPrefixRule> ipPrefixRules) {
        this.ipPrefixRules = ipPrefixRules;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IpPrefixProperties withAnnotation(String annotation) {
        super.withAnnotation(annotation);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (ipPrefixRules() != null) {
            ipPrefixRules().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("annotation", annotation());
        jsonWriter.writeArrayField("ipPrefixRules", this.ipPrefixRules, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IpPrefixProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IpPrefixProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the IpPrefixProperties.
     */
    public static IpPrefixProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IpPrefixProperties deserializedIpPrefixProperties = new IpPrefixProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("annotation".equals(fieldName)) {
                    deserializedIpPrefixProperties.withAnnotation(reader.getString());
                } else if ("configurationState".equals(fieldName)) {
                    deserializedIpPrefixProperties.configurationState
                        = ConfigurationState.fromString(reader.getString());
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedIpPrefixProperties.provisioningState = ProvisioningState.fromString(reader.getString());
                } else if ("administrativeState".equals(fieldName)) {
                    deserializedIpPrefixProperties.administrativeState
                        = AdministrativeState.fromString(reader.getString());
                } else if ("ipPrefixRules".equals(fieldName)) {
                    List<IpPrefixRule> ipPrefixRules = reader.readArray(reader1 -> IpPrefixRule.fromJson(reader1));
                    deserializedIpPrefixProperties.ipPrefixRules = ipPrefixRules;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIpPrefixProperties;
        });
    }
}
