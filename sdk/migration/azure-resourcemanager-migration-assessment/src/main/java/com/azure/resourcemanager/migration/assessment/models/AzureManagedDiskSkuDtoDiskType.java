// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for AzureManagedDiskSkuDtoDiskType.
 */
public final class AzureManagedDiskSkuDtoDiskType extends ExpandableStringEnum<AzureManagedDiskSkuDtoDiskType> {
    /**
     * Static value Unknown for AzureManagedDiskSkuDtoDiskType.
     */
    public static final AzureManagedDiskSkuDtoDiskType UNKNOWN = fromString("Unknown");

    /**
     * Static value Standard for AzureManagedDiskSkuDtoDiskType.
     */
    public static final AzureManagedDiskSkuDtoDiskType STANDARD = fromString("Standard");

    /**
     * Static value StandardSSD for AzureManagedDiskSkuDtoDiskType.
     */
    public static final AzureManagedDiskSkuDtoDiskType STANDARD_SSD = fromString("StandardSSD");

    /**
     * Static value Premium for AzureManagedDiskSkuDtoDiskType.
     */
    public static final AzureManagedDiskSkuDtoDiskType PREMIUM = fromString("Premium");

    /**
     * Static value StandardOrPremium for AzureManagedDiskSkuDtoDiskType.
     */
    public static final AzureManagedDiskSkuDtoDiskType STANDARD_OR_PREMIUM = fromString("StandardOrPremium");

    /**
     * Static value Ultra for AzureManagedDiskSkuDtoDiskType.
     */
    public static final AzureManagedDiskSkuDtoDiskType ULTRA = fromString("Ultra");

    /**
     * Static value PremiumV2 for AzureManagedDiskSkuDtoDiskType.
     */
    public static final AzureManagedDiskSkuDtoDiskType PREMIUM_V2 = fromString("PremiumV2");

    /**
     * Creates a new instance of AzureManagedDiskSkuDtoDiskType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AzureManagedDiskSkuDtoDiskType() {
    }

    /**
     * Creates or finds a AzureManagedDiskSkuDtoDiskType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AzureManagedDiskSkuDtoDiskType.
     */
    public static AzureManagedDiskSkuDtoDiskType fromString(String name) {
        return fromString(name, AzureManagedDiskSkuDtoDiskType.class);
    }

    /**
     * Gets known AzureManagedDiskSkuDtoDiskType values.
     * 
     * @return known AzureManagedDiskSkuDtoDiskType values.
     */
    public static Collection<AzureManagedDiskSkuDtoDiskType> values() {
        return values(AzureManagedDiskSkuDtoDiskType.class);
    }
}
