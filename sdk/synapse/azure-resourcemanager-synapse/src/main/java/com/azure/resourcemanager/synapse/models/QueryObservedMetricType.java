// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Defines values for QueryObservedMetricType. */
public enum QueryObservedMetricType {
    /** Enum value cpu. */
    CPU("cpu"),

    /** Enum value io. */
    IO("io"),

    /** Enum value logio. */
    LOGIO("logio"),

    /** Enum value duration. */
    DURATION("duration"),

    /** Enum value executionCount. */
    EXECUTION_COUNT("executionCount");

    /** The actual serialized value for a QueryObservedMetricType instance. */
    private final String value;

    QueryObservedMetricType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a QueryObservedMetricType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed QueryObservedMetricType object, or null if unable to parse.
     */
    @JsonCreator
    public static QueryObservedMetricType fromString(String value) {
        QueryObservedMetricType[] items = QueryObservedMetricType.values();
        for (QueryObservedMetricType item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
