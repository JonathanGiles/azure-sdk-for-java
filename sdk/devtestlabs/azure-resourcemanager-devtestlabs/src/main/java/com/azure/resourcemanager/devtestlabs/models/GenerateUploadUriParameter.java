// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Properties for generating an upload URI. */
@Fluent
public final class GenerateUploadUriParameter {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(GenerateUploadUriParameter.class);

    /*
     * The blob name of the upload URI.
     */
    @JsonProperty(value = "blobName")
    private String blobName;

    /**
     * Get the blobName property: The blob name of the upload URI.
     *
     * @return the blobName value.
     */
    public String blobName() {
        return this.blobName;
    }

    /**
     * Set the blobName property: The blob name of the upload URI.
     *
     * @param blobName the blobName value to set.
     * @return the GenerateUploadUriParameter object itself.
     */
    public GenerateUploadUriParameter withBlobName(String blobName) {
        this.blobName = blobName;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
