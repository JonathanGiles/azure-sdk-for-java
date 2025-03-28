// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Filter Type properties.
 */
public final class FilterType extends ExpandableStringEnum<FilterType> {
    /**
     * Filter type.
     */
    public static final FilterType FILTER = fromString("Filter");

    /**
     * Creates a new instance of FilterType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public FilterType() {
    }

    /**
     * Creates or finds a FilterType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding FilterType.
     */
    public static FilterType fromString(String name) {
        return fromString(name, FilterType.class);
    }

    /**
     * Gets known FilterType values.
     * 
     * @return known FilterType values.
     */
    public static Collection<FilterType> values() {
        return values(FilterType.class);
    }
}
