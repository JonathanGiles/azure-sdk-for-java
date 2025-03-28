// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hybridconnectivity.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.hybridconnectivity.fluent.GenerateAwsTemplatesClient;
import com.azure.resourcemanager.hybridconnectivity.fluent.models.PostResponseInner;
import com.azure.resourcemanager.hybridconnectivity.models.GenerateAwsTemplateRequest;
import com.azure.resourcemanager.hybridconnectivity.models.GenerateAwsTemplates;
import com.azure.resourcemanager.hybridconnectivity.models.PostResponse;

public final class GenerateAwsTemplatesImpl implements GenerateAwsTemplates {
    private static final ClientLogger LOGGER = new ClientLogger(GenerateAwsTemplatesImpl.class);

    private final GenerateAwsTemplatesClient innerClient;

    private final com.azure.resourcemanager.hybridconnectivity.HybridConnectivityManager serviceManager;

    public GenerateAwsTemplatesImpl(GenerateAwsTemplatesClient innerClient,
        com.azure.resourcemanager.hybridconnectivity.HybridConnectivityManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<PostResponse> postWithResponse(GenerateAwsTemplateRequest generateAwsTemplateRequest,
        Context context) {
        Response<PostResponseInner> inner = this.serviceClient().postWithResponse(generateAwsTemplateRequest, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new PostResponseImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public PostResponse post(GenerateAwsTemplateRequest generateAwsTemplateRequest) {
        PostResponseInner inner = this.serviceClient().post(generateAwsTemplateRequest);
        if (inner != null) {
            return new PostResponseImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private GenerateAwsTemplatesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.hybridconnectivity.HybridConnectivityManager manager() {
        return this.serviceManager;
    }
}
