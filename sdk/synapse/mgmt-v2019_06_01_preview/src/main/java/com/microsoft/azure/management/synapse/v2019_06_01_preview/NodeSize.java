/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.synapse.v2019_06_01_preview;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for NodeSize.
 */
public final class NodeSize extends ExpandableStringEnum<NodeSize> {
    /** Static value None for NodeSize. */
    public static final NodeSize NONE = fromString("None");

    /** Static value Small for NodeSize. */
    public static final NodeSize SMALL = fromString("Small");

    /** Static value Medium for NodeSize. */
    public static final NodeSize MEDIUM = fromString("Medium");

    /** Static value Large for NodeSize. */
    public static final NodeSize LARGE = fromString("Large");

    /** Static value XLarge for NodeSize. */
    public static final NodeSize XLARGE = fromString("XLarge");

    /** Static value XXLarge for NodeSize. */
    public static final NodeSize XXLARGE = fromString("XXLarge");

    /** Static value XXXLarge for NodeSize. */
    public static final NodeSize XXXLARGE = fromString("XXXLarge");

    /**
     * Creates or finds a NodeSize from its string representation.
     * @param name a name to look for
     * @return the corresponding NodeSize
     */
    @JsonCreator
    public static NodeSize fromString(String name) {
        return fromString(name, NodeSize.class);
    }

    /**
     * @return known NodeSize values
     */
    public static Collection<NodeSize> values() {
        return values(NodeSize.class);
    }
}
