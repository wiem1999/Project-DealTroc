/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.verify.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.Objects;


import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class VerificationAttemptsSummary extends Resource {
    private static final long serialVersionUID = 224637081616234L;

    public static VerificationAttemptsSummaryFetcher fetcher(){
        return new VerificationAttemptsSummaryFetcher();
    }

    /**
    * Converts a JSON String into a VerificationAttemptsSummary object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return VerificationAttemptsSummary object represented by the provided JSON
    */
    public static VerificationAttemptsSummary fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, VerificationAttemptsSummary.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a VerificationAttemptsSummary object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return VerificationAttemptsSummary object represented by the provided JSON
    */
    public static VerificationAttemptsSummary fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, VerificationAttemptsSummary.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Channels {
        SMS("sms"),
        CALL("call"),
        EMAIL("email"),
        WHATSAPP("whatsapp");

        private final String value;

        private Channels(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Channels forValue(final String value) {
            return Promoter.enumFromString(value, Channels.values());
        }
    }

    private final Integer totalAttempts;
    private final Integer totalConverted;
    private final Integer totalUnconverted;
    private final BigDecimal conversionRatePercentage;
    private final URI url;

    @JsonCreator
    private VerificationAttemptsSummary(
        @JsonProperty("total_attempts")
        final Integer totalAttempts,

        @JsonProperty("total_converted")
        final Integer totalConverted,

        @JsonProperty("total_unconverted")
        final Integer totalUnconverted,

        @JsonProperty("conversion_rate_percentage")
        final BigDecimal conversionRatePercentage,

        @JsonProperty("url")
        final URI url
    ) {
        this.totalAttempts = totalAttempts;
        this.totalConverted = totalConverted;
        this.totalUnconverted = totalUnconverted;
        this.conversionRatePercentage = conversionRatePercentage;
        this.url = url;
    }

        public final Integer getTotalAttempts() {
            return this.totalAttempts;
        }
        public final Integer getTotalConverted() {
            return this.totalConverted;
        }
        public final Integer getTotalUnconverted() {
            return this.totalUnconverted;
        }
        public final BigDecimal getConversionRatePercentage() {
            return this.conversionRatePercentage;
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

        VerificationAttemptsSummary other = (VerificationAttemptsSummary) o;

        return Objects.equals(totalAttempts, other.totalAttempts) &&  Objects.equals(totalConverted, other.totalConverted) &&  Objects.equals(totalUnconverted, other.totalUnconverted) &&  Objects.equals(conversionRatePercentage, other.conversionRatePercentage) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalAttempts, totalConverted, totalUnconverted, conversionRatePercentage, url);
    }

}
