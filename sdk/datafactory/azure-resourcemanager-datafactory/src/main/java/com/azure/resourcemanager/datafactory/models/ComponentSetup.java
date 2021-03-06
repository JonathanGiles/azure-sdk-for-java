// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** The custom setup of installing 3rd party components. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("ComponentSetup")
@JsonFlatten
@Fluent
public class ComponentSetup extends CustomSetupBase {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ComponentSetup.class);

    /*
     * The name of the 3rd party component.
     */
    @JsonProperty(value = "typeProperties.componentName", required = true)
    private String componentName;

    /*
     * The license key to activate the component.
     */
    @JsonProperty(value = "typeProperties.licenseKey")
    private SecretBase licenseKey;

    /**
     * Get the componentName property: The name of the 3rd party component.
     *
     * @return the componentName value.
     */
    public String componentName() {
        return this.componentName;
    }

    /**
     * Set the componentName property: The name of the 3rd party component.
     *
     * @param componentName the componentName value to set.
     * @return the ComponentSetup object itself.
     */
    public ComponentSetup withComponentName(String componentName) {
        this.componentName = componentName;
        return this;
    }

    /**
     * Get the licenseKey property: The license key to activate the component.
     *
     * @return the licenseKey value.
     */
    public SecretBase licenseKey() {
        return this.licenseKey;
    }

    /**
     * Set the licenseKey property: The license key to activate the component.
     *
     * @param licenseKey the licenseKey value to set.
     * @return the ComponentSetup object itself.
     */
    public ComponentSetup withLicenseKey(SecretBase licenseKey) {
        this.licenseKey = licenseKey;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (componentName() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property componentName in model ComponentSetup"));
        }
        if (licenseKey() != null) {
            licenseKey().validate();
        }
    }
}
