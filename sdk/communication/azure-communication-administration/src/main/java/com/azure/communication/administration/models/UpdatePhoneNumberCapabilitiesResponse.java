// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.administration.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

/** The UpdatePhoneNumberCapabilitiesResponse model. */
@Fluent
public final class UpdatePhoneNumberCapabilitiesResponse {
    /*
     * The id of the phone number capabilties update
     */
    @JsonProperty(value = "capabilitiesUpdateId")
    private String capabilitiesUpdateId;

    /*
     * The time the capabilities update was created
     */
    @JsonProperty(value = "createdAt")
    private OffsetDateTime createdAt;

    /*
     * Status of the capabilities update.
     */
    @JsonProperty(value = "capabilitiesUpdateStatus")
    private CapabilitiesUpdateStatus capabilitiesUpdateStatus;

    /*
     * The capabilities update for each of a set of phone numbers.
     */
    @JsonProperty(value = "phoneNumberCapabilitiesUpdates")
    private Map<String, NumberUpdateCapabilities> phoneNumberCapabilitiesUpdates;

    /**
     * Get the capabilitiesUpdateId property: The id of the phone number capabilties update.
     *
     * @return the capabilitiesUpdateId value.
     */
    public String getCapabilitiesUpdateId() {
        return this.capabilitiesUpdateId;
    }

    /**
     * Set the capabilitiesUpdateId property: The id of the phone number capabilties update.
     *
     * @param capabilitiesUpdateId the capabilitiesUpdateId value to set.
     * @return the UpdatePhoneNumberCapabilitiesResponse object itself.
     */
    public UpdatePhoneNumberCapabilitiesResponse setCapabilitiesUpdateId(String capabilitiesUpdateId) {
        this.capabilitiesUpdateId = capabilitiesUpdateId;
        return this;
    }

    /**
     * Get the createdAt property: The time the capabilities update was created.
     *
     * @return the createdAt value.
     */
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Set the createdAt property: The time the capabilities update was created.
     *
     * @param createdAt the createdAt value to set.
     * @return the UpdatePhoneNumberCapabilitiesResponse object itself.
     */
    public UpdatePhoneNumberCapabilitiesResponse setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get the capabilitiesUpdateStatus property: Status of the capabilities update.
     *
     * @return the capabilitiesUpdateStatus value.
     */
    public CapabilitiesUpdateStatus getCapabilitiesUpdateStatus() {
        return this.capabilitiesUpdateStatus;
    }

    /**
     * Set the capabilitiesUpdateStatus property: Status of the capabilities update.
     *
     * @param capabilitiesUpdateStatus the capabilitiesUpdateStatus value to set.
     * @return the UpdatePhoneNumberCapabilitiesResponse object itself.
     */
    public UpdatePhoneNumberCapabilitiesResponse setCapabilitiesUpdateStatus(
            CapabilitiesUpdateStatus capabilitiesUpdateStatus) {
        this.capabilitiesUpdateStatus = capabilitiesUpdateStatus;
        return this;
    }

    /**
     * Get the phoneNumberCapabilitiesUpdates property: The capabilities update for each of a set of phone numbers.
     *
     * @return the phoneNumberCapabilitiesUpdates value.
     */
    public Map<String, NumberUpdateCapabilities> getPhoneNumberCapabilitiesUpdates() {
        return this.phoneNumberCapabilitiesUpdates;
    }

    /**
     * Set the phoneNumberCapabilitiesUpdates property: The capabilities update for each of a set of phone numbers.
     *
     * @param phoneNumberCapabilitiesUpdates the phoneNumberCapabilitiesUpdates value to set.
     * @return the UpdatePhoneNumberCapabilitiesResponse object itself.
     */
    public UpdatePhoneNumberCapabilitiesResponse setPhoneNumberCapabilitiesUpdates(
            Map<String, NumberUpdateCapabilities> phoneNumberCapabilitiesUpdates) {
        this.phoneNumberCapabilitiesUpdates = phoneNumberCapabilitiesUpdates;
        return this;
    }
}