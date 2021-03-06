// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callingserver.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The response payload of the join call operation. */
@Fluent
public final class JoinCallResultInternal {
    /*
     * The call connection id.
     */
    @JsonProperty(value = "callConnectionId")
    private String callConnectionId;

    /**
     * Get the callConnectionId property: The call connection id.
     *
     * @return the callConnectionId value.
     */
    public String getCallConnectionId() {
        return this.callConnectionId;
    }

    /**
     * Set the callConnectionId property: The call connection id.
     *
     * @param callConnectionId the callConnectionId value to set.
     * @return the JoinCallResultInternal object itself.
     */
    public JoinCallResultInternal setCallConnectionId(String callConnectionId) {
        this.callConnectionId = callConnectionId;
        return this;
    }
}
