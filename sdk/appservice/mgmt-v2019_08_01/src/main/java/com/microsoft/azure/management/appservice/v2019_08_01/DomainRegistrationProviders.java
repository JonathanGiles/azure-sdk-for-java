/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2019_08_01;

import rx.Observable;
import com.microsoft.azure.management.appservice.v2019_08_01.implementation.DomainRegistrationProvidersInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing DomainRegistrationProviders.
 */
public interface DomainRegistrationProviders extends HasInner<DomainRegistrationProvidersInner> {
    /**
     * Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     * Description for Implements Csm operations Api to exposes the list of available Csm Apis under the resource provider.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<CsmOperationDescription> listOperationsAsync();

}