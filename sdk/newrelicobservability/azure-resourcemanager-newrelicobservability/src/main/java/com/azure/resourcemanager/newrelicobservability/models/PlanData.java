// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.newrelicobservability.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Plan data of NewRelic Monitor resource.
 */
@Fluent
public final class PlanData implements JsonSerializable<PlanData> {
    /*
     * Different usage type like PAYG/COMMITTED. this could be enum
     */
    private UsageType usageType;

    /*
     * Different billing cycles like MONTHLY/WEEKLY. this could be enum
     */
    private BillingCycle billingCycle;

    /*
     * plan id as published by NewRelic
     */
    private String planDetails;

    /*
     * date when plan was applied
     */
    private OffsetDateTime effectiveDate;

    /**
     * Creates an instance of PlanData class.
     */
    public PlanData() {
    }

    /**
     * Get the usageType property: Different usage type like PAYG/COMMITTED. this could be enum.
     * 
     * @return the usageType value.
     */
    public UsageType usageType() {
        return this.usageType;
    }

    /**
     * Set the usageType property: Different usage type like PAYG/COMMITTED. this could be enum.
     * 
     * @param usageType the usageType value to set.
     * @return the PlanData object itself.
     */
    public PlanData withUsageType(UsageType usageType) {
        this.usageType = usageType;
        return this;
    }

    /**
     * Get the billingCycle property: Different billing cycles like MONTHLY/WEEKLY. this could be enum.
     * 
     * @return the billingCycle value.
     */
    public BillingCycle billingCycle() {
        return this.billingCycle;
    }

    /**
     * Set the billingCycle property: Different billing cycles like MONTHLY/WEEKLY. this could be enum.
     * 
     * @param billingCycle the billingCycle value to set.
     * @return the PlanData object itself.
     */
    public PlanData withBillingCycle(BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
        return this;
    }

    /**
     * Get the planDetails property: plan id as published by NewRelic.
     * 
     * @return the planDetails value.
     */
    public String planDetails() {
        return this.planDetails;
    }

    /**
     * Set the planDetails property: plan id as published by NewRelic.
     * 
     * @param planDetails the planDetails value to set.
     * @return the PlanData object itself.
     */
    public PlanData withPlanDetails(String planDetails) {
        this.planDetails = planDetails;
        return this;
    }

    /**
     * Get the effectiveDate property: date when plan was applied.
     * 
     * @return the effectiveDate value.
     */
    public OffsetDateTime effectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Set the effectiveDate property: date when plan was applied.
     * 
     * @param effectiveDate the effectiveDate value to set.
     * @return the PlanData object itself.
     */
    public PlanData withEffectiveDate(OffsetDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("usageType", this.usageType == null ? null : this.usageType.toString());
        jsonWriter.writeStringField("billingCycle", this.billingCycle == null ? null : this.billingCycle.toString());
        jsonWriter.writeStringField("planDetails", this.planDetails);
        jsonWriter.writeStringField("effectiveDate",
            this.effectiveDate == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.effectiveDate));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PlanData from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PlanData if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the PlanData.
     */
    public static PlanData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PlanData deserializedPlanData = new PlanData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("usageType".equals(fieldName)) {
                    deserializedPlanData.usageType = UsageType.fromString(reader.getString());
                } else if ("billingCycle".equals(fieldName)) {
                    deserializedPlanData.billingCycle = BillingCycle.fromString(reader.getString());
                } else if ("planDetails".equals(fieldName)) {
                    deserializedPlanData.planDetails = reader.getString();
                } else if ("effectiveDate".equals(fieldName)) {
                    deserializedPlanData.effectiveDate = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPlanData;
        });
    }
}
