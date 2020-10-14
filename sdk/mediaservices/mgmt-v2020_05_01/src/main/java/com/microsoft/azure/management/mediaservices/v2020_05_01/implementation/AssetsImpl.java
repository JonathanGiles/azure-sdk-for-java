/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.mediaservices.v2020_05_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.mediaservices.v2020_05_01.Assets;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.mediaservices.v2020_05_01.AssetContainerSas;
import com.microsoft.azure.management.mediaservices.v2020_05_01.StorageEncryptedAssetDecryptionData;
import com.microsoft.azure.management.mediaservices.v2020_05_01.ListStreamingLocatorsResponse;
import com.microsoft.azure.management.mediaservices.v2020_05_01.ListContainerSasInput;
import com.microsoft.azure.management.mediaservices.v2020_05_01.Asset;

class AssetsImpl extends WrapperImpl<AssetsInner> implements Assets {
    private final MediaManager manager;

    AssetsImpl(MediaManager manager) {
        super(manager.inner().assets());
        this.manager = manager;
    }

    public MediaManager manager() {
        return this.manager;
    }

    @Override
    public AssetImpl define(String name) {
        return wrapModel(name);
    }

    private AssetImpl wrapModel(AssetInner inner) {
        return  new AssetImpl(inner, manager());
    }

    private AssetImpl wrapModel(String name) {
        return new AssetImpl(name, this.manager());
    }

    @Override
    public Observable<AssetContainerSas> listContainerSasAsync(String resourceGroupName, String accountName, String assetName, ListContainerSasInput parameters) {
        AssetsInner client = this.inner();
        return client.listContainerSasAsync(resourceGroupName, accountName, assetName, parameters)
        .map(new Func1<AssetContainerSasInner, AssetContainerSas>() {
            @Override
            public AssetContainerSas call(AssetContainerSasInner inner) {
                return new AssetContainerSasImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<StorageEncryptedAssetDecryptionData> getEncryptionKeyAsync(String resourceGroupName, String accountName, String assetName) {
        AssetsInner client = this.inner();
        return client.getEncryptionKeyAsync(resourceGroupName, accountName, assetName)
        .map(new Func1<StorageEncryptedAssetDecryptionDataInner, StorageEncryptedAssetDecryptionData>() {
            @Override
            public StorageEncryptedAssetDecryptionData call(StorageEncryptedAssetDecryptionDataInner inner) {
                return new StorageEncryptedAssetDecryptionDataImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<ListStreamingLocatorsResponse> listStreamingLocatorsAsync(String resourceGroupName, String accountName, String assetName) {
        AssetsInner client = this.inner();
        return client.listStreamingLocatorsAsync(resourceGroupName, accountName, assetName)
        .map(new Func1<ListStreamingLocatorsResponseInner, ListStreamingLocatorsResponse>() {
            @Override
            public ListStreamingLocatorsResponse call(ListStreamingLocatorsResponseInner inner) {
                return new ListStreamingLocatorsResponseImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<Asset> listAsync(final String resourceGroupName, final String accountName) {
        AssetsInner client = this.inner();
        return client.listAsync(resourceGroupName, accountName)
        .flatMapIterable(new Func1<Page<AssetInner>, Iterable<AssetInner>>() {
            @Override
            public Iterable<AssetInner> call(Page<AssetInner> page) {
                return page.items();
            }
        })
        .map(new Func1<AssetInner, Asset>() {
            @Override
            public Asset call(AssetInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<Asset> getAsync(String resourceGroupName, String accountName, String assetName) {
        AssetsInner client = this.inner();
        return client.getAsync(resourceGroupName, accountName, assetName)
        .flatMap(new Func1<AssetInner, Observable<Asset>>() {
            @Override
            public Observable<Asset> call(AssetInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((Asset)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String accountName, String assetName) {
        AssetsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, accountName, assetName).toCompletable();
    }

}