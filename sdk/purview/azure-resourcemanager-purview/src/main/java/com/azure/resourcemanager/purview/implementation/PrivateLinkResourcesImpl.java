// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.purview.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.purview.fluent.PrivateLinkResourcesClient;
import com.azure.resourcemanager.purview.fluent.models.PrivateLinkResourceInner;
import com.azure.resourcemanager.purview.models.PrivateLinkResource;
import com.azure.resourcemanager.purview.models.PrivateLinkResources;

public final class PrivateLinkResourcesImpl implements PrivateLinkResources {
    private static final ClientLogger LOGGER = new ClientLogger(PrivateLinkResourcesImpl.class);

    private final PrivateLinkResourcesClient innerClient;

    private final com.azure.resourcemanager.purview.PurviewManager serviceManager;

    public PrivateLinkResourcesImpl(PrivateLinkResourcesClient innerClient,
        com.azure.resourcemanager.purview.PurviewManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<PrivateLinkResource> listByAccount(String resourceGroupName, String accountName) {
        PagedIterable<PrivateLinkResourceInner> inner
            = this.serviceClient().listByAccount(resourceGroupName, accountName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new PrivateLinkResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<PrivateLinkResource> listByAccount(String resourceGroupName, String accountName,
        Context context) {
        PagedIterable<PrivateLinkResourceInner> inner
            = this.serviceClient().listByAccount(resourceGroupName, accountName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new PrivateLinkResourceImpl(inner1, this.manager()));
    }

    public Response<PrivateLinkResource> getByGroupIdWithResponse(String resourceGroupName, String accountName,
        String groupId, Context context) {
        Response<PrivateLinkResourceInner> inner
            = this.serviceClient().getByGroupIdWithResponse(resourceGroupName, accountName, groupId, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new PrivateLinkResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public PrivateLinkResource getByGroupId(String resourceGroupName, String accountName, String groupId) {
        PrivateLinkResourceInner inner = this.serviceClient().getByGroupId(resourceGroupName, accountName, groupId);
        if (inner != null) {
            return new PrivateLinkResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private PrivateLinkResourcesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.purview.PurviewManager manager() {
        return this.serviceManager;
    }
}
