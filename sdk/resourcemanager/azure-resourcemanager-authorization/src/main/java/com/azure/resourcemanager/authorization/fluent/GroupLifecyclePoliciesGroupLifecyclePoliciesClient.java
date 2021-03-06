// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.authorization.fluent.models.Get1ItemsItem;
import com.azure.resourcemanager.authorization.fluent.models.Get2ItemsItem;
import com.azure.resourcemanager.authorization.fluent.models.Get5ItemsItem;
import com.azure.resourcemanager.authorization.fluent.models.Get6ItemsItem;
import com.azure.resourcemanager.authorization.fluent.models.Get7ItemsItem;
import com.azure.resourcemanager.authorization.fluent.models.MicrosoftGraphGroupLifecyclePolicyInner;
import java.util.List;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * GroupLifecyclePoliciesGroupLifecyclePoliciesClient.
 */
public interface GroupLifecyclePoliciesGroupLifecyclePoliciesClient {
    /**
     * Get entities from groupLifecyclePolicies.
     *
     * @param top Show only the first n items.
     * @param skip Skip the first n items.
     * @param search Search items by search phrases.
     * @param filter Filter items by property values.
     * @param count Include count of items.
     * @param orderby Order items by property values.
     * @param select Select properties to be returned.
     * @param expand Expand related entities.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entities from groupLifecyclePolicies.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<MicrosoftGraphGroupLifecyclePolicyInner> listGroupLifecyclePolicyAsync(
        Integer top,
        Integer skip,
        String search,
        String filter,
        Boolean count,
        List<Get5ItemsItem> orderby,
        List<Get6ItemsItem> select,
        List<Get7ItemsItem> expand);

    /**
     * Get entities from groupLifecyclePolicies.
     *
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entities from groupLifecyclePolicies.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<MicrosoftGraphGroupLifecyclePolicyInner> listGroupLifecyclePolicyAsync();

    /**
     * Get entities from groupLifecyclePolicies.
     *
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entities from groupLifecyclePolicies.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MicrosoftGraphGroupLifecyclePolicyInner> listGroupLifecyclePolicy();

    /**
     * Get entities from groupLifecyclePolicies.
     *
     * @param top Show only the first n items.
     * @param skip Skip the first n items.
     * @param search Search items by search phrases.
     * @param filter Filter items by property values.
     * @param count Include count of items.
     * @param orderby Order items by property values.
     * @param select Select properties to be returned.
     * @param expand Expand related entities.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entities from groupLifecyclePolicies.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MicrosoftGraphGroupLifecyclePolicyInner> listGroupLifecyclePolicy(
        Integer top,
        Integer skip,
        String search,
        String filter,
        Boolean count,
        List<Get5ItemsItem> orderby,
        List<Get6ItemsItem> select,
        List<Get7ItemsItem> expand,
        Context context);

    /**
     * Add new entity to groupLifecyclePolicies.
     *
     * @param body New entity.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return groupLifecyclePolicy.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<MicrosoftGraphGroupLifecyclePolicyInner>> createGroupLifecyclePolicyWithResponseAsync(
        MicrosoftGraphGroupLifecyclePolicyInner body);

    /**
     * Add new entity to groupLifecyclePolicies.
     *
     * @param body New entity.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return groupLifecyclePolicy.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<MicrosoftGraphGroupLifecyclePolicyInner> createGroupLifecyclePolicyAsync(
        MicrosoftGraphGroupLifecyclePolicyInner body);

    /**
     * Add new entity to groupLifecyclePolicies.
     *
     * @param body New entity.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return groupLifecyclePolicy.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MicrosoftGraphGroupLifecyclePolicyInner createGroupLifecyclePolicy(MicrosoftGraphGroupLifecyclePolicyInner body);

    /**
     * Add new entity to groupLifecyclePolicies.
     *
     * @param body New entity.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return groupLifecyclePolicy.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<MicrosoftGraphGroupLifecyclePolicyInner> createGroupLifecyclePolicyWithResponse(
        MicrosoftGraphGroupLifecyclePolicyInner body, Context context);

    /**
     * Get entity from groupLifecyclePolicies by key.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param select Select properties to be returned.
     * @param expand Expand related entities.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entity from groupLifecyclePolicies by key.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<MicrosoftGraphGroupLifecyclePolicyInner>> getGroupLifecyclePolicyWithResponseAsync(
        String groupLifecyclePolicyId, List<Get1ItemsItem> select, List<Get2ItemsItem> expand);

    /**
     * Get entity from groupLifecyclePolicies by key.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param select Select properties to be returned.
     * @param expand Expand related entities.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entity from groupLifecyclePolicies by key.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<MicrosoftGraphGroupLifecyclePolicyInner> getGroupLifecyclePolicyAsync(
        String groupLifecyclePolicyId, List<Get1ItemsItem> select, List<Get2ItemsItem> expand);

    /**
     * Get entity from groupLifecyclePolicies by key.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entity from groupLifecyclePolicies by key.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<MicrosoftGraphGroupLifecyclePolicyInner> getGroupLifecyclePolicyAsync(String groupLifecyclePolicyId);

    /**
     * Get entity from groupLifecyclePolicies by key.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entity from groupLifecyclePolicies by key.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MicrosoftGraphGroupLifecyclePolicyInner getGroupLifecyclePolicy(String groupLifecyclePolicyId);

    /**
     * Get entity from groupLifecyclePolicies by key.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param select Select properties to be returned.
     * @param expand Expand related entities.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return entity from groupLifecyclePolicies by key.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<MicrosoftGraphGroupLifecyclePolicyInner> getGroupLifecyclePolicyWithResponse(
        String groupLifecyclePolicyId, List<Get1ItemsItem> select, List<Get2ItemsItem> expand, Context context);

    /**
     * Update entity in groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param body New property values.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> updateGroupLifecyclePolicyWithResponseAsync(
        String groupLifecyclePolicyId, MicrosoftGraphGroupLifecyclePolicyInner body);

    /**
     * Update entity in groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param body New property values.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> updateGroupLifecyclePolicyAsync(
        String groupLifecyclePolicyId, MicrosoftGraphGroupLifecyclePolicyInner body);

    /**
     * Update entity in groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param body New property values.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void updateGroupLifecyclePolicy(String groupLifecyclePolicyId, MicrosoftGraphGroupLifecyclePolicyInner body);

    /**
     * Update entity in groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param body New property values.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> updateGroupLifecyclePolicyWithResponse(
        String groupLifecyclePolicyId, MicrosoftGraphGroupLifecyclePolicyInner body, Context context);

    /**
     * Delete entity from groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param ifMatch ETag.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> deleteGroupLifecyclePolicyWithResponseAsync(String groupLifecyclePolicyId, String ifMatch);

    /**
     * Delete entity from groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param ifMatch ETag.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteGroupLifecyclePolicyAsync(String groupLifecyclePolicyId, String ifMatch);

    /**
     * Delete entity from groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteGroupLifecyclePolicyAsync(String groupLifecyclePolicyId);

    /**
     * Delete entity from groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void deleteGroupLifecyclePolicy(String groupLifecyclePolicyId);

    /**
     * Delete entity from groupLifecyclePolicies.
     *
     * @param groupLifecyclePolicyId key: id of groupLifecyclePolicy.
     * @param ifMatch ETag.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.authorization.fluent.models.OdataErrorMainException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteGroupLifecyclePolicyWithResponse(
        String groupLifecyclePolicyId, String ifMatch, Context context);
}
