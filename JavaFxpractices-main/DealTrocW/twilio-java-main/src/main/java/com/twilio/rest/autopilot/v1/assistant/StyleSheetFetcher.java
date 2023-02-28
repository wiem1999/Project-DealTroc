/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Autopilot
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.autopilot.v1.assistant;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class StyleSheetFetcher extends Fetcher<StyleSheet> {
    private String pathAssistantSid;

    public StyleSheetFetcher(final String pathAssistantSid){
        this.pathAssistantSid = pathAssistantSid;
    }


    @Override
    public StyleSheet fetch(final TwilioRestClient client) {
        String path = "/v1/Assistants/{AssistantSid}/StyleSheet";

        path = path.replace("{"+"AssistantSid"+"}", this.pathAssistantSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.AUTOPILOT.toString(),
            path
        );
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("StyleSheet fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return StyleSheet.fromJson(response.getStream(), client.getObjectMapper());
    }
}
