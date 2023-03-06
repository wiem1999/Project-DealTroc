/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Video
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.video.v1.room;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;


import java.util.Map;


public class RecordingRulesUpdater extends Updater<RecordingRules>{
    private String pathRoomSid;
    private Map<String, Object> rules;

    public RecordingRulesUpdater(final String pathRoomSid){
        this.pathRoomSid = pathRoomSid;
    }

    public RecordingRulesUpdater setRules(final Map<String, Object> rules){
        this.rules = rules;
        return this;
    }

    @Override
    public RecordingRules update(final TwilioRestClient client){
        String path = "/v1/Rooms/{RoomSid}/RecordingRules";

        path = path.replace("{"+"RoomSid"+"}", this.pathRoomSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VIDEO.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("RecordingRules update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return RecordingRules.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (rules != null) {
            request.addPostParam("Rules",  Converter.mapToJson(rules));
    
        }
    }
}