/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.kusto.v2020_09_18.implementation;

import com.microsoft.azure.management.kusto.v2020_09_18.LanguageExtensionName;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The language extension object.
 */
public class LanguageExtensionInner {
    /**
     * The language extension name. Possible values include: 'PYTHON', 'R'.
     */
    @JsonProperty(value = "languageExtensionName")
    private LanguageExtensionName languageExtensionName;

    /**
     * Get the language extension name. Possible values include: 'PYTHON', 'R'.
     *
     * @return the languageExtensionName value
     */
    public LanguageExtensionName languageExtensionName() {
        return this.languageExtensionName;
    }

    /**
     * Set the language extension name. Possible values include: 'PYTHON', 'R'.
     *
     * @param languageExtensionName the languageExtensionName value to set
     * @return the LanguageExtensionInner object itself.
     */
    public LanguageExtensionInner withLanguageExtensionName(LanguageExtensionName languageExtensionName) {
        this.languageExtensionName = languageExtensionName;
        return this;
    }

}