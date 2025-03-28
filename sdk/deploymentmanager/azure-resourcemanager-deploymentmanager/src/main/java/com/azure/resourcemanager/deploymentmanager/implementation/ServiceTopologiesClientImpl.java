// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deploymentmanager.implementation;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.resourcemanager.deploymentmanager.fluent.ServiceTopologiesClient;
import com.azure.resourcemanager.deploymentmanager.fluent.models.ServiceTopologyResourceInner;
import java.util.List;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in ServiceTopologiesClient. */
public final class ServiceTopologiesClientImpl implements ServiceTopologiesClient {
    /** The proxy service used to perform REST calls. */
    private final ServiceTopologiesService service;

    /** The service client containing this operation class. */
    private final AzureDeploymentManagerImpl client;

    /**
     * Initializes an instance of ServiceTopologiesClientImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    ServiceTopologiesClientImpl(AzureDeploymentManagerImpl client) {
        this.service
            = RestProxy.create(ServiceTopologiesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for AzureDeploymentManagerServiceTopologies to be used by the proxy
     * service to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "AzureDeploymentManag")
    public interface ServiceTopologiesService {
        @Headers({ "Content-Type: application/json" })
        @Put("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager"
            + "/serviceTopologies/{serviceTopologyName}")
        @ExpectedResponses({ 201 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ServiceTopologyResourceInner>> createOrUpdate(@HostParam("$host") String endpoint,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("serviceTopologyName") String serviceTopologyName, @QueryParam("api-version") String apiVersion,
            @BodyParam("application/json") ServiceTopologyResourceInner serviceTopologyInfo,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager"
            + "/serviceTopologies/{serviceTopologyName}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ServiceTopologyResourceInner>> getByResourceGroup(@HostParam("$host") String endpoint,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("serviceTopologyName") String serviceTopologyName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Delete("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager"
            + "/serviceTopologies/{serviceTopologyName}")
        @ExpectedResponses({ 200, 204 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<Void>> delete(@HostParam("$host") String endpoint,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("serviceTopologyName") String serviceTopologyName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager"
            + "/serviceTopologies")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<List<ServiceTopologyResourceInner>>> list(@HostParam("$host") String endpoint,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Creates or updates a service topology.
     *
     * <p>Synchronously creates a new service topology or updates an existing service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceTopologyInfo Source topology object defines the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource representation of a service topology along with {@link Response} on successful completion of
     *     {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ServiceTopologyResourceInner>> createOrUpdateWithResponseAsync(String resourceGroupName,
        String serviceTopologyName, ServiceTopologyResourceInner serviceTopologyInfo) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serviceTopologyName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null."));
        }
        if (serviceTopologyInfo == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter serviceTopologyInfo is required and cannot be null."));
        } else {
            serviceTopologyInfo.validate();
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.createOrUpdate(this.client.getEndpoint(), this.client.getSubscriptionId(),
                resourceGroupName, serviceTopologyName, this.client.getApiVersion(), serviceTopologyInfo, accept,
                context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Creates or updates a service topology.
     *
     * <p>Synchronously creates a new service topology or updates an existing service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceTopologyInfo Source topology object defines the resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource representation of a service topology along with {@link Response} on successful completion of
     *     {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ServiceTopologyResourceInner>> createOrUpdateWithResponseAsync(String resourceGroupName,
        String serviceTopologyName, ServiceTopologyResourceInner serviceTopologyInfo, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serviceTopologyName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null."));
        }
        if (serviceTopologyInfo == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter serviceTopologyInfo is required and cannot be null."));
        } else {
            serviceTopologyInfo.validate();
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.createOrUpdate(this.client.getEndpoint(), this.client.getSubscriptionId(), resourceGroupName,
            serviceTopologyName, this.client.getApiVersion(), serviceTopologyInfo, accept, context);
    }

    /**
     * Creates or updates a service topology.
     *
     * <p>Synchronously creates a new service topology or updates an existing service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceTopologyInfo Source topology object defines the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource representation of a service topology on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<ServiceTopologyResourceInner> createOrUpdateAsync(String resourceGroupName, String serviceTopologyName,
        ServiceTopologyResourceInner serviceTopologyInfo) {
        return createOrUpdateWithResponseAsync(resourceGroupName, serviceTopologyName, serviceTopologyInfo)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Creates or updates a service topology.
     *
     * <p>Synchronously creates a new service topology or updates an existing service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceTopologyInfo Source topology object defines the resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource representation of a service topology along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ServiceTopologyResourceInner> createOrUpdateWithResponse(String resourceGroupName,
        String serviceTopologyName, ServiceTopologyResourceInner serviceTopologyInfo, Context context) {
        return createOrUpdateWithResponseAsync(resourceGroupName, serviceTopologyName, serviceTopologyInfo, context)
            .block();
    }

    /**
     * Creates or updates a service topology.
     *
     * <p>Synchronously creates a new service topology or updates an existing service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceTopologyInfo Source topology object defines the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource representation of a service topology.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ServiceTopologyResourceInner createOrUpdate(String resourceGroupName, String serviceTopologyName,
        ServiceTopologyResourceInner serviceTopologyInfo) {
        return createOrUpdateWithResponse(resourceGroupName, serviceTopologyName, serviceTopologyInfo, Context.NONE)
            .getValue();
    }

    /**
     * Gets the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the service topology along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ServiceTopologyResourceInner>> getByResourceGroupWithResponseAsync(String resourceGroupName,
        String serviceTopologyName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serviceTopologyName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context -> service.getByResourceGroup(this.client.getEndpoint(), this.client.getSubscriptionId(),
                    resourceGroupName, serviceTopologyName, this.client.getApiVersion(), accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Gets the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the service topology along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ServiceTopologyResourceInner>> getByResourceGroupWithResponseAsync(String resourceGroupName,
        String serviceTopologyName, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serviceTopologyName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.getByResourceGroup(this.client.getEndpoint(), this.client.getSubscriptionId(), resourceGroupName,
            serviceTopologyName, this.client.getApiVersion(), accept, context);
    }

    /**
     * Gets the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the service topology on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<ServiceTopologyResourceInner> getByResourceGroupAsync(String resourceGroupName,
        String serviceTopologyName) {
        return getByResourceGroupWithResponseAsync(resourceGroupName, serviceTopologyName)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Gets the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the service topology along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ServiceTopologyResourceInner> getByResourceGroupWithResponse(String resourceGroupName,
        String serviceTopologyName, Context context) {
        return getByResourceGroupWithResponseAsync(resourceGroupName, serviceTopologyName, context).block();
    }

    /**
     * Gets the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the service topology.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ServiceTopologyResourceInner getByResourceGroup(String resourceGroupName, String serviceTopologyName) {
        return getByResourceGroupWithResponse(resourceGroupName, serviceTopologyName, Context.NONE).getValue();
    }

    /**
     * Deletes the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<Void>> deleteWithResponseAsync(String resourceGroupName, String serviceTopologyName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serviceTopologyName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.delete(this.client.getEndpoint(), this.client.getSubscriptionId(),
                resourceGroupName, serviceTopologyName, this.client.getApiVersion(), accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Deletes the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<Void>> deleteWithResponseAsync(String resourceGroupName, String serviceTopologyName,
        Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serviceTopologyName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.delete(this.client.getEndpoint(), this.client.getSubscriptionId(), resourceGroupName,
            serviceTopologyName, this.client.getApiVersion(), accept, context);
    }

    /**
     * Deletes the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Void> deleteAsync(String resourceGroupName, String serviceTopologyName) {
        return deleteWithResponseAsync(resourceGroupName, serviceTopologyName).flatMap(ignored -> Mono.empty());
    }

    /**
     * Deletes the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteWithResponse(String resourceGroupName, String serviceTopologyName, Context context) {
        return deleteWithResponseAsync(resourceGroupName, serviceTopologyName, context).block();
    }

    /**
     * Deletes the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void delete(String resourceGroupName, String serviceTopologyName) {
        deleteWithResponse(resourceGroupName, serviceTopologyName, Context.NONE);
    }

    /**
     * Lists the service topologies in the resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of service topologies along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<List<ServiceTopologyResourceInner>>> listWithResponseAsync(String resourceGroupName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.list(this.client.getEndpoint(), this.client.getSubscriptionId(),
                resourceGroupName, this.client.getApiVersion(), accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Lists the service topologies in the resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of service topologies along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<List<ServiceTopologyResourceInner>>> listWithResponseAsync(String resourceGroupName,
        Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.list(this.client.getEndpoint(), this.client.getSubscriptionId(), resourceGroupName,
            this.client.getApiVersion(), accept, context);
    }

    /**
     * Lists the service topologies in the resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of service topologies on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<List<ServiceTopologyResourceInner>> listAsync(String resourceGroupName) {
        return listWithResponseAsync(resourceGroupName).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Lists the service topologies in the resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of service topologies along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<List<ServiceTopologyResourceInner>> listWithResponse(String resourceGroupName, Context context) {
        return listWithResponseAsync(resourceGroupName, context).block();
    }

    /**
     * Lists the service topologies in the resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of service topologies.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<ServiceTopologyResourceInner> list(String resourceGroupName) {
        return listWithResponse(resourceGroupName, Context.NONE).getValue();
    }
}
