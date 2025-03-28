// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob.options;

import com.azure.core.annotation.Fluent;
import com.azure.storage.blob.models.AppendBlobRequestConditions;
import com.azure.storage.blob.models.BlobRequestConditions;

/**
 * Extended options that may be passed when sealing an Append Blob.
 */
@Fluent
public class AppendBlobSealOptions {
    private AppendBlobRequestConditions requestConditions;

    /**
     * Creates a new instance of {@link AppendBlobSealOptions}.
     */
    public AppendBlobSealOptions() {
    }

    /**
     * Gets the {@link AppendBlobRequestConditions}.
     *
     * @return {@link AppendBlobRequestConditions}
     */
    public AppendBlobRequestConditions getRequestConditions() {
        return requestConditions;
    }

    /**
     * Sets the {@link AppendBlobRequestConditions}.
     *
     * @param requestConditions {@link BlobRequestConditions}
     * @return The updated options.
     */
    public AppendBlobSealOptions setRequestConditions(AppendBlobRequestConditions requestConditions) {
        this.requestConditions = requestConditions;
        return this;
    }
}
