/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Serverless
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.serverless.v1.service.environment;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class VariableCreator extends Creator<Variable>{
    private String pathServiceSid;
    private String pathEnvironmentSid;
    private String key;
    private String value;

    public VariableCreator(final String pathServiceSid, final String pathEnvironmentSid, final String key, final String value) {
        this.pathServiceSid = pathServiceSid;
        this.pathEnvironmentSid = pathEnvironmentSid;
        this.key = key;
        this.value = value;
    }

    public VariableCreator setKey(final String key){
        this.key = key;
        return this;
    }
    public VariableCreator setValue(final String value){
        this.value = value;
        return this;
    }

    @Override
    public Variable create(final TwilioRestClient client){
        String path = "/v1/Services/{ServiceSid}/Environments/{EnvironmentSid}/Variables";

        path = path.replace("{"+"ServiceSid"+"}", this.pathServiceSid.toString());
        path = path.replace("{"+"EnvironmentSid"+"}", this.pathEnvironmentSid.toString());
        path = path.replace("{"+"Key"+"}", this.key.toString());
        path = path.replace("{"+"Value"+"}", this.value.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.SERVERLESS.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Variable creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Variable.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (key != null) {
            request.addPostParam("Key", key);
    
        }
        if (value != null) {
            request.addPostParam("Value", value);
    
        }
    }
}