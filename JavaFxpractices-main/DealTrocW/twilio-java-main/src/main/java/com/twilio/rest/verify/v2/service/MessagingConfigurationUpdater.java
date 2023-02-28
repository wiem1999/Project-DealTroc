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

package com.twilio.rest.verify.v2.service;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class MessagingConfigurationUpdater extends Updater<MessagingConfiguration>{
    private String pathServiceSid;
    private String pathCountry;
    private String messagingServiceSid;

    public MessagingConfigurationUpdater(final String pathServiceSid, final String pathCountry, final String messagingServiceSid){
        this.pathServiceSid = pathServiceSid;
        this.pathCountry = pathCountry;
        this.messagingServiceSid = messagingServiceSid;
    }

    public MessagingConfigurationUpdater setMessagingServiceSid(final String messagingServiceSid){
        this.messagingServiceSid = messagingServiceSid;
        return this;
    }

    @Override
    public MessagingConfiguration update(final TwilioRestClient client){
        String path = "/v2/Services/{ServiceSid}/MessagingConfigurations/{Country}";

        path = path.replace("{"+"ServiceSid"+"}", this.pathServiceSid.toString());
        path = path.replace("{"+"Country"+"}", this.pathCountry.toString());
        path = path.replace("{"+"MessagingServiceSid"+"}", this.messagingServiceSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("MessagingConfiguration update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return MessagingConfiguration.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (messagingServiceSid != null) {
            request.addPostParam("MessagingServiceSid", messagingServiceSid);
    
        }
    }
}
