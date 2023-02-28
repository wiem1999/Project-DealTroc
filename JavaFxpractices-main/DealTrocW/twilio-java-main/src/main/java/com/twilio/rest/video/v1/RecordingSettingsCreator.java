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

package com.twilio.rest.video.v1;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.net.URI;



import java.net.URI;

public class RecordingSettingsCreator extends Creator<RecordingSettings>{
    private String friendlyName;
    private String awsCredentialsSid;
    private String encryptionKeySid;
    private URI awsS3Url;
    private Boolean awsStorageEnabled;
    private Boolean encryptionEnabled;

    public RecordingSettingsCreator(final String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public RecordingSettingsCreator setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public RecordingSettingsCreator setAwsCredentialsSid(final String awsCredentialsSid){
        this.awsCredentialsSid = awsCredentialsSid;
        return this;
    }
    public RecordingSettingsCreator setEncryptionKeySid(final String encryptionKeySid){
        this.encryptionKeySid = encryptionKeySid;
        return this;
    }
    public RecordingSettingsCreator setAwsS3Url(final URI awsS3Url){
        this.awsS3Url = awsS3Url;
        return this;
    }

    public RecordingSettingsCreator setAwsS3Url(final String awsS3Url){
        return setAwsS3Url(Promoter.uriFromString(awsS3Url));
    }
    public RecordingSettingsCreator setAwsStorageEnabled(final Boolean awsStorageEnabled){
        this.awsStorageEnabled = awsStorageEnabled;
        return this;
    }
    public RecordingSettingsCreator setEncryptionEnabled(final Boolean encryptionEnabled){
        this.encryptionEnabled = encryptionEnabled;
        return this;
    }

    @Override
    public RecordingSettings create(final TwilioRestClient client){
        String path = "/v1/RecordingSettings/Default";

        path = path.replace("{"+"FriendlyName"+"}", this.friendlyName.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VIDEO.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("RecordingSettings creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return RecordingSettings.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (awsCredentialsSid != null) {
            request.addPostParam("AwsCredentialsSid", awsCredentialsSid);
    
        }
        if (encryptionKeySid != null) {
            request.addPostParam("EncryptionKeySid", encryptionKeySid);
    
        }
        if (awsS3Url != null) {
            request.addPostParam("AwsS3Url", awsS3Url.toString());
    
        }
        if (awsStorageEnabled != null) {
            request.addPostParam("AwsStorageEnabled", awsStorageEnabled.toString());
    
        }
        if (encryptionEnabled != null) {
            request.addPostParam("EncryptionEnabled", encryptionEnabled.toString());
    
        }
    }
}
