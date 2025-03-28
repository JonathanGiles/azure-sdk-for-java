// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

/**
 * Samples for DeviceSecurityGroups Get.
 */
public final class DeviceSecurityGroupsGetSamples {
    /*
     * x-ms-original-file:
     * specification/security/resource-manager/Microsoft.Security/stable/2019-08-01/examples/DeviceSecurityGroups/
     * GetDeviceSecurityGroups_example.json
     */
    /**
     * Sample code: Get a device security group for the specified IoT Hub resource.
     * 
     * @param manager Entry point to SecurityManager.
     */
    public static void getADeviceSecurityGroupForTheSpecifiedIoTHubResource(
        com.azure.resourcemanager.security.SecurityManager manager) {
        manager.deviceSecurityGroups()
            .getWithResponse(
                "subscriptions/20ff7fc3-e762-44dd-bd96-b71116dcdc23/resourceGroups/SampleRG/providers/Microsoft.Devices/iotHubs/sampleiothub",
                "samplesecuritygroup", com.azure.core.util.Context.NONE);
    }
}
