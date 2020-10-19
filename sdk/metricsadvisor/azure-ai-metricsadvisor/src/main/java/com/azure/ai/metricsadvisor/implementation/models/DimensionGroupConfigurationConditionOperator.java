// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for DimensionGroupConfigurationConditionOperator. */
public final class DimensionGroupConfigurationConditionOperator
        extends ExpandableStringEnum<DimensionGroupConfigurationConditionOperator> {
    /** Static value AND for DimensionGroupConfigurationConditionOperator. */
    public static final DimensionGroupConfigurationConditionOperator AND = fromString("AND");

    /** Static value OR for DimensionGroupConfigurationConditionOperator. */
    public static final DimensionGroupConfigurationConditionOperator OR = fromString("OR");

    /**
     * Creates or finds a DimensionGroupConfigurationConditionOperator from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding DimensionGroupConfigurationConditionOperator.
     */
    @JsonCreator
    public static DimensionGroupConfigurationConditionOperator fromString(String name) {
        return fromString(name, DimensionGroupConfigurationConditionOperator.class);
    }

    /** @return known DimensionGroupConfigurationConditionOperator values. */
    public static Collection<DimensionGroupConfigurationConditionOperator> values() {
        return values(DimensionGroupConfigurationConditionOperator.class);
    }
}