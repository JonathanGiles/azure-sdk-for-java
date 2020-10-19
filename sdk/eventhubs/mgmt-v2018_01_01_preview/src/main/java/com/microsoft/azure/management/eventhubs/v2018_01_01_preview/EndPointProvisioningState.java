/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventhubs.v2018_01_01_preview;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for EndPointProvisioningState.
 */
public final class EndPointProvisioningState extends ExpandableStringEnum<EndPointProvisioningState> {
    /** Static value Creating for EndPointProvisioningState. */
    public static final EndPointProvisioningState CREATING = fromString("Creating");

    /** Static value Updating for EndPointProvisioningState. */
    public static final EndPointProvisioningState UPDATING = fromString("Updating");

    /** Static value Deleting for EndPointProvisioningState. */
    public static final EndPointProvisioningState DELETING = fromString("Deleting");

    /** Static value Succeeded for EndPointProvisioningState. */
    public static final EndPointProvisioningState SUCCEEDED = fromString("Succeeded");

    /** Static value Canceled for EndPointProvisioningState. */
    public static final EndPointProvisioningState CANCELED = fromString("Canceled");

    /** Static value Failed for EndPointProvisioningState. */
    public static final EndPointProvisioningState FAILED = fromString("Failed");

    /**
     * Creates or finds a EndPointProvisioningState from its string representation.
     * @param name a name to look for
     * @return the corresponding EndPointProvisioningState
     */
    @JsonCreator
    public static EndPointProvisioningState fromString(String name) {
        return fromString(name, EndPointProvisioningState.class);
    }

    /**
     * @return known EndPointProvisioningState values
     */
    public static Collection<EndPointProvisioningState> values() {
        return values(EndPointProvisioningState.class);
    }
}