// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.mediaservices.fluent.models.ContentKeyPolicyInner;
import com.azure.resourcemanager.mediaservices.fluent.models.ContentKeyPolicyPropertiesInner;

/**
 * An instance of this class provides access to all the operations defined in ContentKeyPoliciesClient.
 */
public interface ContentKeyPoliciesClient {
    /**
     * List Content Key Policies
     * 
     * Lists the Content Key Policies in the account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a collection of ContentKeyPolicy items as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ContentKeyPolicyInner> list(String resourceGroupName, String accountName);

    /**
     * List Content Key Policies
     * 
     * Lists the Content Key Policies in the account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param filter Restricts the set of items returned.
     * @param top Specifies a non-negative integer n that limits the number of items returned from a collection. The
     * service returns the number of available items up to but not greater than the specified value n.
     * @param orderby Specifies the key by which the result collection should be ordered.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a collection of ContentKeyPolicy items as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ContentKeyPolicyInner> list(String resourceGroupName, String accountName, String filter, Integer top,
        String orderby, Context context);

    /**
     * Get a Content Key Policy
     * 
     * Get the details of a Content Key Policy in the Media Services account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of a Content Key Policy in the Media Services account along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ContentKeyPolicyInner> getWithResponse(String resourceGroupName, String accountName,
        String contentKeyPolicyName, Context context);

    /**
     * Get a Content Key Policy
     * 
     * Get the details of a Content Key Policy in the Media Services account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of a Content Key Policy in the Media Services account.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ContentKeyPolicyInner get(String resourceGroupName, String accountName, String contentKeyPolicyName);

    /**
     * Create or update an Content Key Policy
     * 
     * Create or update a Content Key Policy in the Media Services account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @param parameters The request parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Content Key Policy resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ContentKeyPolicyInner> createOrUpdateWithResponse(String resourceGroupName, String accountName,
        String contentKeyPolicyName, ContentKeyPolicyInner parameters, Context context);

    /**
     * Create or update an Content Key Policy
     * 
     * Create or update a Content Key Policy in the Media Services account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @param parameters The request parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Content Key Policy resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ContentKeyPolicyInner createOrUpdate(String resourceGroupName, String accountName, String contentKeyPolicyName,
        ContentKeyPolicyInner parameters);

    /**
     * Delete a Content Key Policy
     * 
     * Deletes a Content Key Policy in the Media Services account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String accountName, String contentKeyPolicyName,
        Context context);

    /**
     * Delete a Content Key Policy
     * 
     * Deletes a Content Key Policy in the Media Services account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String accountName, String contentKeyPolicyName);

    /**
     * Update a Content Key Policy
     * 
     * Updates an existing Content Key Policy in the Media Services account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @param parameters The request parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Content Key Policy resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ContentKeyPolicyInner> updateWithResponse(String resourceGroupName, String accountName,
        String contentKeyPolicyName, ContentKeyPolicyInner parameters, Context context);

    /**
     * Update a Content Key Policy
     * 
     * Updates an existing Content Key Policy in the Media Services account.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @param parameters The request parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Content Key Policy resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ContentKeyPolicyInner update(String resourceGroupName, String accountName, String contentKeyPolicyName,
        ContentKeyPolicyInner parameters);

    /**
     * Get a Content Key Policy with secrets
     * 
     * Get a Content Key Policy including secret values.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Content Key Policy including secret values along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ContentKeyPolicyPropertiesInner> getPolicyPropertiesWithSecretsWithResponse(String resourceGroupName,
        String accountName, String contentKeyPolicyName, Context context);

    /**
     * Get a Content Key Policy with secrets
     * 
     * Get a Content Key Policy including secret values.
     * 
     * @param resourceGroupName The name of the resource group within the Azure subscription.
     * @param accountName The Media Services account name.
     * @param contentKeyPolicyName The Content Key Policy name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Content Key Policy including secret values.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ContentKeyPolicyPropertiesInner getPolicyPropertiesWithSecrets(String resourceGroupName, String accountName,
        String contentKeyPolicyName);
}
