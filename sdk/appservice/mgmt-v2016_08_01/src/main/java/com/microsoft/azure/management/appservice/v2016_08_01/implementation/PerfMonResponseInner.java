/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2016_08_01.implementation;

import com.microsoft.azure.management.appservice.v2016_08_01.PerfMonSet;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Performance monitor API response.
 */
public class PerfMonResponseInner {
    /**
     * The response code.
     */
    @JsonProperty(value = "code")
    private String code;

    /**
     * The message.
     */
    @JsonProperty(value = "message")
    private String message;

    /**
     * The performance monitor counters.
     */
    @JsonProperty(value = "data")
    private PerfMonSet data;

    /**
     * Get the response code.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Set the response code.
     *
     * @param code the code value to set
     * @return the PerfMonResponseInner object itself.
     */
    public PerfMonResponseInner withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message.
     *
     * @param message the message value to set
     * @return the PerfMonResponseInner object itself.
     */
    public PerfMonResponseInner withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the performance monitor counters.
     *
     * @return the data value
     */
    public PerfMonSet data() {
        return this.data;
    }

    /**
     * Set the performance monitor counters.
     *
     * @param data the data value to set
     * @return the PerfMonResponseInner object itself.
     */
    public PerfMonResponseInner withData(PerfMonSet data) {
        this.data = data;
        return this;
    }

}
