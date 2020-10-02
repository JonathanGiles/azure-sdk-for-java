// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The SuppressCondition model. */
@Fluent
public final class SuppressCondition {
    /*
     * min point number, value range : [1, +∞)
     */
    @JsonProperty(value = "minNumber", required = true)
    private int minNumber;

    /*
     * min point ratio, value range : (0, 100]
     */
    @JsonProperty(value = "minRatio", required = true)
    private double minRatio;

    /**
     * Get the minNumber property: min point number, value range : [1, +∞).
     *
     * @return the minNumber value.
     */
    public int getMinNumber() {
        return this.minNumber;
    }

    /**
     * Set the minNumber property: min point number, value range : [1, +∞).
     *
     * @param minNumber the minNumber value to set.
     * @return the SuppressCondition object itself.
     */
    public SuppressCondition setMinNumber(int minNumber) {
        this.minNumber = minNumber;
        return this;
    }

    /**
     * Get the minRatio property: min point ratio, value range : (0, 100].
     *
     * @return the minRatio value.
     */
    public double getMinRatio() {
        return this.minRatio;
    }

    /**
     * Set the minRatio property: min point ratio, value range : (0, 100].
     *
     * @param minRatio the minRatio value to set.
     * @return the SuppressCondition object itself.
     */
    public SuppressCondition setMinRatio(double minRatio) {
        this.minRatio = minRatio;
        return this;
    }
}