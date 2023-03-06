/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Insights
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.insights.v1.room;

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
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.List;
import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Participant extends Resource {
    private static final long serialVersionUID = 21473393957377L;

    public static ParticipantFetcher fetcher(final String pathRoomSid, final String pathParticipantSid){
        return new ParticipantFetcher(pathRoomSid, pathParticipantSid);
    }

    public static ParticipantReader reader(final String pathRoomSid){
        return new ParticipantReader(pathRoomSid);
    }

    /**
    * Converts a JSON String into a Participant object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Participant object represented by the provided JSON
    */
    public static Participant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Participant object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Participant object represented by the provided JSON
    */
    public static Participant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Codec {
        VP8("VP8"),
        H264("H264"),
        VP9("VP9");

        private final String value;

        private Codec(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Codec forValue(final String value) {
            return Promoter.enumFromString(value, Codec.values());
        }
    }
    public enum EdgeLocation {
        ASHBURN("ashburn"),
        DUBLIN("dublin"),
        FRANKFURT("frankfurt"),
        SINGAPORE("singapore"),
        SYDNEY("sydney"),
        SAO_PAULO("sao_paulo"),
        ROAMING("roaming"),
        UMATILLA("umatilla"),
        TOKYO("tokyo");

        private final String value;

        private EdgeLocation(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static EdgeLocation forValue(final String value) {
            return Promoter.enumFromString(value, EdgeLocation.values());
        }
    }
    public enum RoomStatus {
        IN_PROGRESS("in_progress"),
        COMPLETED("completed");

        private final String value;

        private RoomStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static RoomStatus forValue(final String value) {
            return Promoter.enumFromString(value, RoomStatus.values());
        }
    }
    public enum TwilioRealm {
        US1("us1"),
        US2("us2"),
        AU1("au1"),
        BR1("br1"),
        IE1("ie1"),
        JP1("jp1"),
        SG1("sg1"),
        IN1("in1"),
        DE1("de1"),
        GLL("gll");

        private final String value;

        private TwilioRealm(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static TwilioRealm forValue(final String value) {
            return Promoter.enumFromString(value, TwilioRealm.values());
        }
    }

    private final String participantSid;
    private final String participantIdentity;
    private final ZonedDateTime joinTime;
    private final ZonedDateTime leaveTime;
    private final Long durationSec;
    private final String accountSid;
    private final String roomSid;
    private final Participant.RoomStatus status;
    private final List<Participant.Codec> codecs;
    private final String endReason;
    private final Integer errorCode;
    private final String errorCodeUrl;
    private final Participant.TwilioRealm mediaRegion;
    private final Map<String, Object> properties;
    private final Participant.EdgeLocation edgeLocation;
    private final Map<String, Object> publisherInfo;
    private final URI url;

    @JsonCreator
    private Participant(
        @JsonProperty("participant_sid")
        final String participantSid,

        @JsonProperty("participant_identity")
        final String participantIdentity,

        @JsonProperty("join_time")
        final String joinTime,

        @JsonProperty("leave_time")
        final String leaveTime,

        @JsonProperty("duration_sec")
        final Long durationSec,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("room_sid")
        final String roomSid,

        @JsonProperty("status")
        final Participant.RoomStatus status,

        @JsonProperty("codecs")
        final List<Participant.Codec> codecs,

        @JsonProperty("end_reason")
        final String endReason,

        @JsonProperty("error_code")
        final Integer errorCode,

        @JsonProperty("error_code_url")
        final String errorCodeUrl,

        @JsonProperty("media_region")
        final Participant.TwilioRealm mediaRegion,

        @JsonProperty("properties")
        final Map<String, Object> properties,

        @JsonProperty("edge_location")
        final Participant.EdgeLocation edgeLocation,

        @JsonProperty("publisher_info")
        final Map<String, Object> publisherInfo,

        @JsonProperty("url")
        final URI url
    ) {
        this.participantSid = participantSid;
        this.participantIdentity = participantIdentity;
        this.joinTime = DateConverter.iso8601DateTimeFromString(joinTime);
        this.leaveTime = DateConverter.iso8601DateTimeFromString(leaveTime);
        this.durationSec = durationSec;
        this.accountSid = accountSid;
        this.roomSid = roomSid;
        this.status = status;
        this.codecs = codecs;
        this.endReason = endReason;
        this.errorCode = errorCode;
        this.errorCodeUrl = errorCodeUrl;
        this.mediaRegion = mediaRegion;
        this.properties = properties;
        this.edgeLocation = edgeLocation;
        this.publisherInfo = publisherInfo;
        this.url = url;
    }

        public final String getParticipantSid() {
            return this.participantSid;
        }
        public final String getParticipantIdentity() {
            return this.participantIdentity;
        }
        public final ZonedDateTime getJoinTime() {
            return this.joinTime;
        }
        public final ZonedDateTime getLeaveTime() {
            return this.leaveTime;
        }
        public final Long getDurationSec() {
            return this.durationSec;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getRoomSid() {
            return this.roomSid;
        }
        public final Participant.RoomStatus getStatus() {
            return this.status;
        }
        public final List<Participant.Codec> getCodecs() {
            return this.codecs;
        }
        public final String getEndReason() {
            return this.endReason;
        }
        public final Integer getErrorCode() {
            return this.errorCode;
        }
        public final String getErrorCodeUrl() {
            return this.errorCodeUrl;
        }
        public final Participant.TwilioRealm getMediaRegion() {
            return this.mediaRegion;
        }
        public final Map<String, Object> getProperties() {
            return this.properties;
        }
        public final Participant.EdgeLocation getEdgeLocation() {
            return this.edgeLocation;
        }
        public final Map<String, Object> getPublisherInfo() {
            return this.publisherInfo;
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

        Participant other = (Participant) o;

        return Objects.equals(participantSid, other.participantSid) &&  Objects.equals(participantIdentity, other.participantIdentity) &&  Objects.equals(joinTime, other.joinTime) &&  Objects.equals(leaveTime, other.leaveTime) &&  Objects.equals(durationSec, other.durationSec) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(roomSid, other.roomSid) &&  Objects.equals(status, other.status) &&  Objects.equals(codecs, other.codecs) &&  Objects.equals(endReason, other.endReason) &&  Objects.equals(errorCode, other.errorCode) &&  Objects.equals(errorCodeUrl, other.errorCodeUrl) &&  Objects.equals(mediaRegion, other.mediaRegion) &&  Objects.equals(properties, other.properties) &&  Objects.equals(edgeLocation, other.edgeLocation) &&  Objects.equals(publisherInfo, other.publisherInfo) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantSid, participantIdentity, joinTime, leaveTime, durationSec, accountSid, roomSid, status, codecs, endReason, errorCode, errorCodeUrl, mediaRegion, properties, edgeLocation, publisherInfo, url);
    }

}
