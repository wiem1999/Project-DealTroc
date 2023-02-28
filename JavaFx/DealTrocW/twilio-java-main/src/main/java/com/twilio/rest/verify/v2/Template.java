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
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Template extends Resource {
    private static final long serialVersionUID = 229000530855919L;

    public static TemplateReader reader(){
        return new TemplateReader();
    }

    /**
    * Converts a JSON String into a Template object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Template object represented by the provided JSON
    */
    public static Template fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Template.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Template object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Template object represented by the provided JSON
    */
    public static Template fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Template.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final List<String> channels;
    private final Map<String, Object> translations;

    @JsonCreator
    private Template(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("channels")
        final List<String> channels,

        @JsonProperty("translations")
        final Map<String, Object> translations
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.channels = channels;
        this.translations = translations;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final List<String> getChannels() {
            return this.channels;
        }
        public final Map<String, Object> getTranslations() {
            return this.translations;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Template other = (Template) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(channels, other.channels) &&  Objects.equals(translations, other.translations)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, friendlyName, channels, translations);
    }

}
