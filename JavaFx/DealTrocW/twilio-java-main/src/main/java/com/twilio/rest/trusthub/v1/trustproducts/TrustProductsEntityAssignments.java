/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trusthub
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trusthub.v1.trustproducts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Objects;



@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class TrustProductsEntityAssignments extends Resource {
    private static final long serialVersionUID = 11655766001892L;

    public static TrustProductsEntityAssignmentsCreator creator(final String pathTrustProductSid, final String objectSid){
        return new TrustProductsEntityAssignmentsCreator(pathTrustProductSid, objectSid);
    }

    public static TrustProductsEntityAssignmentsDeleter deleter(final String pathTrustProductSid, final String pathSid){
        return new TrustProductsEntityAssignmentsDeleter(pathTrustProductSid, pathSid);
    }

    public static TrustProductsEntityAssignmentsFetcher fetcher(final String pathTrustProductSid, final String pathSid){
        return new TrustProductsEntityAssignmentsFetcher(pathTrustProductSid, pathSid);
    }

    public static TrustProductsEntityAssignmentsReader reader(final String pathTrustProductSid){
        return new TrustProductsEntityAssignmentsReader(pathTrustProductSid);
    }

    /**
    * Converts a JSON String into a TrustProductsEntityAssignments object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return TrustProductsEntityAssignments object represented by the provided JSON
    */
    public static TrustProductsEntityAssignments fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TrustProductsEntityAssignments.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a TrustProductsEntityAssignments object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return TrustProductsEntityAssignments object represented by the provided JSON
    */
    public static TrustProductsEntityAssignments fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TrustProductsEntityAssignments.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String trustProductSid;
    private final String accountSid;
    private final String objectSid;
    private final ZonedDateTime dateCreated;
    private final URI url;

    @JsonCreator
    private TrustProductsEntityAssignments(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("trust_product_sid")
        final String trustProductSid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("object_sid")
        final String objectSid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("url")
        final URI url
    ) {
        this.sid = sid;
        this.trustProductSid = trustProductSid;
        this.accountSid = accountSid;
        this.objectSid = objectSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.url = url;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getTrustProductSid() {
            return this.trustProductSid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getObjectSid() {
            return this.objectSid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final URI getUrl() {
            return this.url;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TrustProductsEntityAssignments other = (TrustProductsEntityAssignments) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(trustProductSid, other.trustProductSid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(objectSid, other.objectSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, trustProductSid, accountSid, objectSid, dateCreated, url);
    }

}
