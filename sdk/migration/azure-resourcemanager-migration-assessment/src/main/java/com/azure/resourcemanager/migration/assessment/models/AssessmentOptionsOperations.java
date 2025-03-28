// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of AssessmentOptionsOperations.
 */
public interface AssessmentOptionsOperations {
    /**
     * List AssessmentOptions resources by AssessmentProject.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a AssessmentOptions list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<AssessmentOptions> listByAssessmentProject(String resourceGroupName, String projectName);

    /**
     * List AssessmentOptions resources by AssessmentProject.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a AssessmentOptions list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<AssessmentOptions> listByAssessmentProject(String resourceGroupName, String projectName,
        Context context);

    /**
     * Get a AssessmentOptions.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param assessmentOptionsName assessment options ARM name. Accepted value is 'default'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a AssessmentOptions along with {@link Response}.
     */
    Response<AssessmentOptions> getWithResponse(String resourceGroupName, String projectName,
        String assessmentOptionsName, Context context);

    /**
     * Get a AssessmentOptions.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param assessmentOptionsName assessment options ARM name. Accepted value is 'default'.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a AssessmentOptions.
     */
    AssessmentOptions get(String resourceGroupName, String projectName, String assessmentOptionsName);
}
