// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for DeleteRule. */
public final class DeleteRule extends ExpandableStringEnum<DeleteRule> {
    /** Static value NoAction for DeleteRule. */
    public static final DeleteRule NO_ACTION = fromString("NoAction");

    /**
     * Creates or finds a DeleteRule from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding DeleteRule.
     */
    @JsonCreator
    public static DeleteRule fromString(String name) {
        return fromString(name, DeleteRule.class);
    }

    /** @return known DeleteRule values. */
    public static Collection<DeleteRule> values() {
        return values(DeleteRule.class);
    }
}