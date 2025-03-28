// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mixedreality.implementation;

import com.azure.resourcemanager.mixedreality.fluent.models.AccountKeysInner;
import com.azure.resourcemanager.mixedreality.models.AccountKeys;

public final class AccountKeysImpl implements AccountKeys {
    private AccountKeysInner innerObject;

    private final com.azure.resourcemanager.mixedreality.MixedRealityManager serviceManager;

    AccountKeysImpl(AccountKeysInner innerObject,
        com.azure.resourcemanager.mixedreality.MixedRealityManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String primaryKey() {
        return this.innerModel().primaryKey();
    }

    public String secondaryKey() {
        return this.innerModel().secondaryKey();
    }

    public AccountKeysInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.mixedreality.MixedRealityManager manager() {
        return this.serviceManager;
    }
}
