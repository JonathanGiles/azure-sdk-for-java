// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.generated;

/**
 * Samples for VirtualMachineRunCommands ListByVirtualMachine.
 */
public final class VirtualMachineRunCommandsListByVirtualMachineSamples {
    /*
     * x-ms-original-file:
     * specification/compute/resource-manager/Microsoft.Compute/ComputeRP/stable/2024-11-01/examples/runCommandExamples/
     * VirtualMachineRunCommand_List.json
     */
    /**
     * Sample code: List run commands in a Virtual Machine.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void listRunCommandsInAVirtualMachine(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.virtualMachines()
            .manager()
            .serviceClient()
            .getVirtualMachineRunCommands()
            .listByVirtualMachine("myResourceGroup", "myVM", null, com.azure.core.util.Context.NONE);
    }
}
