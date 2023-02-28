/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

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
public class WorkerChannel extends Resource {
    private static final long serialVersionUID = 38376318052081L;

    public static WorkerChannelFetcher fetcher(final String pathWorkspaceSid, final String pathWorkerSid, final String pathSid){
        return new WorkerChannelFetcher(pathWorkspaceSid, pathWorkerSid, pathSid);
    }

    public static WorkerChannelReader reader(final String pathWorkspaceSid, final String pathWorkerSid){
        return new WorkerChannelReader(pathWorkspaceSid, pathWorkerSid);
    }

    public static WorkerChannelUpdater updater(final String pathWorkspaceSid, final String pathWorkerSid, final String pathSid){
        return new WorkerChannelUpdater(pathWorkspaceSid, pathWorkerSid, pathSid);
    }

    /**
    * Converts a JSON String into a WorkerChannel object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return WorkerChannel object represented by the provided JSON
    */
    public static WorkerChannel fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkerChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a WorkerChannel object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return WorkerChannel object represented by the provided JSON
    */
    public static WorkerChannel fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkerChannel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Integer assignedTasks;
    private final Boolean available;
    private final Integer availableCapacityPercentage;
    private final Integer configuredCapacity;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String sid;
    private final String taskChannelSid;
    private final String taskChannelUniqueName;
    private final String workerSid;
    private final String workspaceSid;
    private final URI url;

    @JsonCreator
    private WorkerChannel(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("assigned_tasks")
        final Integer assignedTasks,

        @JsonProperty("available")
        final Boolean available,

        @JsonProperty("available_capacity_percentage")
        final Integer availableCapacityPercentage,

        @JsonProperty("configured_capacity")
        final Integer configuredCapacity,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("task_channel_sid")
        final String taskChannelSid,

        @JsonProperty("task_channel_unique_name")
        final String taskChannelUniqueName,

        @JsonProperty("worker_sid")
        final String workerSid,

        @JsonProperty("workspace_sid")
        final String workspaceSid,

        @JsonProperty("url")
        final URI url
    ) {
        this.accountSid = accountSid;
        this.assignedTasks = assignedTasks;
        this.available = available;
        this.availableCapacityPercentage = availableCapacityPercentage;
        this.configuredCapacity = configuredCapacity;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.sid = sid;
        this.taskChannelSid = taskChannelSid;
        this.taskChannelUniqueName = taskChannelUniqueName;
        this.workerSid = workerSid;
        this.workspaceSid = workspaceSid;
        this.url = url;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final Integer getAssignedTasks() {
            return this.assignedTasks;
        }
        public final Boolean getAvailable() {
            return this.available;
        }
        public final Integer getAvailableCapacityPercentage() {
            return this.availableCapacityPercentage;
        }
        public final Integer getConfiguredCapacity() {
            return this.configuredCapacity;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final String getSid() {
            return this.sid;
        }
        public final String getTaskChannelSid() {
            return this.taskChannelSid;
        }
        public final String getTaskChannelUniqueName() {
            return this.taskChannelUniqueName;
        }
        public final String getWorkerSid() {
            return this.workerSid;
        }
        public final String getWorkspaceSid() {
            return this.workspaceSid;
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

        WorkerChannel other = (WorkerChannel) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(assignedTasks, other.assignedTasks) &&  Objects.equals(available, other.available) &&  Objects.equals(availableCapacityPercentage, other.availableCapacityPercentage) &&  Objects.equals(configuredCapacity, other.configuredCapacity) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(sid, other.sid) &&  Objects.equals(taskChannelSid, other.taskChannelSid) &&  Objects.equals(taskChannelUniqueName, other.taskChannelUniqueName) &&  Objects.equals(workerSid, other.workerSid) &&  Objects.equals(workspaceSid, other.workspaceSid) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, assignedTasks, available, availableCapacityPercentage, configuredCapacity, dateCreated, dateUpdated, sid, taskChannelSid, taskChannelUniqueName, workerSid, workspaceSid, url);
    }

}
