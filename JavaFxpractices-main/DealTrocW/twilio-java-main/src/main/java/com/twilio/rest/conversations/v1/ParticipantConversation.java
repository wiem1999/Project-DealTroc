/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ParticipantConversation extends Resource {
    private static final long serialVersionUID = 210706261724884L;

    public static ParticipantConversationReader reader(){
        return new ParticipantConversationReader();
    }

    /**
    * Converts a JSON String into a ParticipantConversation object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return ParticipantConversation object represented by the provided JSON
    */
    public static ParticipantConversation fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ParticipantConversation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a ParticipantConversation object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return ParticipantConversation object represented by the provided JSON
    */
    public static ParticipantConversation fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ParticipantConversation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum State {
        INACTIVE("inactive"),
        ACTIVE("active"),
        CLOSED("closed");

        private final String value;

        private State(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static State forValue(final String value) {
            return Promoter.enumFromString(value, State.values());
        }
    }

    private final String accountSid;
    private final String chatServiceSid;
    private final String participantSid;
    private final String participantUserSid;
    private final String participantIdentity;
    private final Map<String, Object> participantMessagingBinding;
    private final String conversationSid;
    private final String conversationUniqueName;
    private final String conversationFriendlyName;
    private final String conversationAttributes;
    private final ZonedDateTime conversationDateCreated;
    private final ZonedDateTime conversationDateUpdated;
    private final String conversationCreatedBy;
    private final ParticipantConversation.State conversationState;
    private final Map<String, Object> conversationTimers;
    private final Map<String, String> links;

    @JsonCreator
    private ParticipantConversation(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("chat_service_sid")
        final String chatServiceSid,

        @JsonProperty("participant_sid")
        final String participantSid,

        @JsonProperty("participant_user_sid")
        final String participantUserSid,

        @JsonProperty("participant_identity")
        final String participantIdentity,

        @JsonProperty("participant_messaging_binding")
        final Map<String, Object> participantMessagingBinding,

        @JsonProperty("conversation_sid")
        final String conversationSid,

        @JsonProperty("conversation_unique_name")
        final String conversationUniqueName,

        @JsonProperty("conversation_friendly_name")
        final String conversationFriendlyName,

        @JsonProperty("conversation_attributes")
        final String conversationAttributes,

        @JsonProperty("conversation_date_created")
        final String conversationDateCreated,

        @JsonProperty("conversation_date_updated")
        final String conversationDateUpdated,

        @JsonProperty("conversation_created_by")
        final String conversationCreatedBy,

        @JsonProperty("conversation_state")
        final ParticipantConversation.State conversationState,

        @JsonProperty("conversation_timers")
        final Map<String, Object> conversationTimers,

        @JsonProperty("links")
        final Map<String, String> links
    ) {
        this.accountSid = accountSid;
        this.chatServiceSid = chatServiceSid;
        this.participantSid = participantSid;
        this.participantUserSid = participantUserSid;
        this.participantIdentity = participantIdentity;
        this.participantMessagingBinding = participantMessagingBinding;
        this.conversationSid = conversationSid;
        this.conversationUniqueName = conversationUniqueName;
        this.conversationFriendlyName = conversationFriendlyName;
        this.conversationAttributes = conversationAttributes;
        this.conversationDateCreated = DateConverter.iso8601DateTimeFromString(conversationDateCreated);
        this.conversationDateUpdated = DateConverter.iso8601DateTimeFromString(conversationDateUpdated);
        this.conversationCreatedBy = conversationCreatedBy;
        this.conversationState = conversationState;
        this.conversationTimers = conversationTimers;
        this.links = links;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getChatServiceSid() {
            return this.chatServiceSid;
        }
        public final String getParticipantSid() {
            return this.participantSid;
        }
        public final String getParticipantUserSid() {
            return this.participantUserSid;
        }
        public final String getParticipantIdentity() {
            return this.participantIdentity;
        }
        public final Map<String, Object> getParticipantMessagingBinding() {
            return this.participantMessagingBinding;
        }
        public final String getConversationSid() {
            return this.conversationSid;
        }
        public final String getConversationUniqueName() {
            return this.conversationUniqueName;
        }
        public final String getConversationFriendlyName() {
            return this.conversationFriendlyName;
        }
        public final String getConversationAttributes() {
            return this.conversationAttributes;
        }
        public final ZonedDateTime getConversationDateCreated() {
            return this.conversationDateCreated;
        }
        public final ZonedDateTime getConversationDateUpdated() {
            return this.conversationDateUpdated;
        }
        public final String getConversationCreatedBy() {
            return this.conversationCreatedBy;
        }
        public final ParticipantConversation.State getConversationState() {
            return this.conversationState;
        }
        public final Map<String, Object> getConversationTimers() {
            return this.conversationTimers;
        }
        public final Map<String, String> getLinks() {
            return this.links;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ParticipantConversation other = (ParticipantConversation) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(chatServiceSid, other.chatServiceSid) &&  Objects.equals(participantSid, other.participantSid) &&  Objects.equals(participantUserSid, other.participantUserSid) &&  Objects.equals(participantIdentity, other.participantIdentity) &&  Objects.equals(participantMessagingBinding, other.participantMessagingBinding) &&  Objects.equals(conversationSid, other.conversationSid) &&  Objects.equals(conversationUniqueName, other.conversationUniqueName) &&  Objects.equals(conversationFriendlyName, other.conversationFriendlyName) &&  Objects.equals(conversationAttributes, other.conversationAttributes) &&  Objects.equals(conversationDateCreated, other.conversationDateCreated) &&  Objects.equals(conversationDateUpdated, other.conversationDateUpdated) &&  Objects.equals(conversationCreatedBy, other.conversationCreatedBy) &&  Objects.equals(conversationState, other.conversationState) &&  Objects.equals(conversationTimers, other.conversationTimers) &&  Objects.equals(links, other.links)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, chatServiceSid, participantSid, participantUserSid, participantIdentity, participantMessagingBinding, conversationSid, conversationUniqueName, conversationFriendlyName, conversationAttributes, conversationDateCreated, conversationDateUpdated, conversationCreatedBy, conversationState, conversationTimers, links);
    }

}

