// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.resourcemanager.security.models.ExpandEnum;

/**
 * Samples for Assessments Get.
 */
public final class AssessmentsGetSamples {
    /*
     * x-ms-original-file:
     * specification/security/resource-manager/Microsoft.Security/stable/2021-06-01/examples/Assessments/
     * GetAssessmentWithExpand_example.json
     */
    /**
     * Sample code: Get security recommendation task from security data location with expand parameter.
     * 
     * @param manager Entry point to SecurityManager.
     */
    public static void getSecurityRecommendationTaskFromSecurityDataLocationWithExpandParameter(
        com.azure.resourcemanager.security.SecurityManager manager) {
        manager.assessments()
            .getWithResponse(
                "subscriptions/20ff7fc3-e762-44dd-bd96-b71116dcdc23/resourceGroups/myRg/providers/Microsoft.Compute/virtualMachineScaleSets/vmss2",
                "21300918-b2e3-0346-785f-c77ff57d243b", ExpandEnum.LINKS, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/security/resource-manager/Microsoft.Security/stable/2021-06-01/examples/Assessments/
     * GetAssessment_example.json
     */
    /**
     * Sample code: Get security recommendation task from security data location.
     * 
     * @param manager Entry point to SecurityManager.
     */
    public static void getSecurityRecommendationTaskFromSecurityDataLocation(
        com.azure.resourcemanager.security.SecurityManager manager) {
        manager.assessments()
            .getWithResponse(
                "subscriptions/20ff7fc3-e762-44dd-bd96-b71116dcdc23/resourceGroups/myRg/providers/Microsoft.Compute/virtualMachineScaleSets/vmss2",
                "21300918-b2e3-0346-785f-c77ff57d243b", null, com.azure.core.util.Context.NONE);
    }
}
