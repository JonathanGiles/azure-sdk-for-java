/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2020_05_01.implementation;

import com.microsoft.azure.management.mediaservices.v2020_05_01.PrivateLinkResource;
import com.microsoft.azure.arm.model.implementation.IndexableRefreshableWrapperImpl;
import rx.Observable;
import java.util.List;

class PrivateLinkResourceImpl extends IndexableRefreshableWrapperImpl<PrivateLinkResource, PrivateLinkResourceInner> implements PrivateLinkResource {
    private final MediaManager manager;
    private String resourceGroupName;
    private String accountName;
    private String name;

    PrivateLinkResourceImpl(PrivateLinkResourceInner inner,  MediaManager manager) {
        super(null, inner);
        this.manager = manager;
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.accountName = IdParsingUtils.getValueFromIdByName(inner.id(), "mediaservices");
        this.name = IdParsingUtils.getValueFromIdByName(inner.id(), "privateLinkResources");
    }

    @Override
    public MediaManager manager() {
        return this.manager;
    }

    @Override
    protected Observable<PrivateLinkResourceInner> getInnerAsync() {
        PrivateLinkResourcesInner client = this.manager().inner().privateLinkResources();
        return client.getAsync(this.resourceGroupName, this.accountName, this.name);
    }



    @Override
    public String groupId() {
        return this.inner().groupId();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public List<String> requiredMembers() {
        return this.inner().requiredMembers();
    }

    @Override
    public List<String> requiredZoneNames() {
        return this.inner().requiredZoneNames();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}