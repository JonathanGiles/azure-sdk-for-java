// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.BooleanEnum;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.ProvisioningState;
import java.io.IOException;

/**
 * certificate used for inbound and outbound decryption.
 */
@Fluent
public final class CertificateObject implements JsonSerializable<CertificateObject> {
    /*
     * Resource Id of certificate signer, to be populated only when certificateSelfSigned is false
     */
    private String certificateSignerResourceId;

    /*
     * use certificate self signed
     */
    private BooleanEnum certificateSelfSigned;

    /*
     * comment for this object
     */
    private String auditComment;

    /*
     * user description for this object
     */
    private String description;

    /*
     * read only string representing last create or update
     */
    private String etag;

    /*
     * Provisioning state of the resource.
     */
    private ProvisioningState provisioningState;

    /**
     * Creates an instance of CertificateObject class.
     */
    public CertificateObject() {
    }

    /**
     * Get the certificateSignerResourceId property: Resource Id of certificate signer, to be populated only when
     * certificateSelfSigned is false.
     * 
     * @return the certificateSignerResourceId value.
     */
    public String certificateSignerResourceId() {
        return this.certificateSignerResourceId;
    }

    /**
     * Set the certificateSignerResourceId property: Resource Id of certificate signer, to be populated only when
     * certificateSelfSigned is false.
     * 
     * @param certificateSignerResourceId the certificateSignerResourceId value to set.
     * @return the CertificateObject object itself.
     */
    public CertificateObject withCertificateSignerResourceId(String certificateSignerResourceId) {
        this.certificateSignerResourceId = certificateSignerResourceId;
        return this;
    }

    /**
     * Get the certificateSelfSigned property: use certificate self signed.
     * 
     * @return the certificateSelfSigned value.
     */
    public BooleanEnum certificateSelfSigned() {
        return this.certificateSelfSigned;
    }

    /**
     * Set the certificateSelfSigned property: use certificate self signed.
     * 
     * @param certificateSelfSigned the certificateSelfSigned value to set.
     * @return the CertificateObject object itself.
     */
    public CertificateObject withCertificateSelfSigned(BooleanEnum certificateSelfSigned) {
        this.certificateSelfSigned = certificateSelfSigned;
        return this;
    }

    /**
     * Get the auditComment property: comment for this object.
     * 
     * @return the auditComment value.
     */
    public String auditComment() {
        return this.auditComment;
    }

    /**
     * Set the auditComment property: comment for this object.
     * 
     * @param auditComment the auditComment value to set.
     * @return the CertificateObject object itself.
     */
    public CertificateObject withAuditComment(String auditComment) {
        this.auditComment = auditComment;
        return this;
    }

    /**
     * Get the description property: user description for this object.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: user description for this object.
     * 
     * @param description the description value to set.
     * @return the CertificateObject object itself.
     */
    public CertificateObject withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the etag property: read only string representing last create or update.
     * 
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set the etag property: read only string representing last create or update.
     * 
     * @param etag the etag value to set.
     * @return the CertificateObject object itself.
     */
    public CertificateObject withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (certificateSelfSigned() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property certificateSelfSigned in model CertificateObject"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(CertificateObject.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("certificateSelfSigned",
            this.certificateSelfSigned == null ? null : this.certificateSelfSigned.toString());
        jsonWriter.writeStringField("certificateSignerResourceId", this.certificateSignerResourceId);
        jsonWriter.writeStringField("auditComment", this.auditComment);
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeStringField("etag", this.etag);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CertificateObject from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CertificateObject if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CertificateObject.
     */
    public static CertificateObject fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CertificateObject deserializedCertificateObject = new CertificateObject();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("certificateSelfSigned".equals(fieldName)) {
                    deserializedCertificateObject.certificateSelfSigned = BooleanEnum.fromString(reader.getString());
                } else if ("certificateSignerResourceId".equals(fieldName)) {
                    deserializedCertificateObject.certificateSignerResourceId = reader.getString();
                } else if ("auditComment".equals(fieldName)) {
                    deserializedCertificateObject.auditComment = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedCertificateObject.description = reader.getString();
                } else if ("etag".equals(fieldName)) {
                    deserializedCertificateObject.etag = reader.getString();
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedCertificateObject.provisioningState = ProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCertificateObject;
        });
    }
}
