/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Ip_messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.ipmessaging.v2;

import com.twilio.base.Updater;
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

import java.util.List;


public class ServiceUpdater extends Updater<Service>{
    private String pathSid;
    private String friendlyName;
    private String defaultServiceRoleSid;
    private String defaultChannelRoleSid;
    private String defaultChannelCreatorRoleSid;
    private Boolean readStatusEnabled;
    private Boolean reachabilityEnabled;
    private Integer typingIndicatorTimeout;
    private Integer consumptionReportInterval;
    private Boolean notificationsNewMessageEnabled;
    private String notificationsNewMessageTemplate;
    private String notificationsNewMessageSound;
    private Boolean notificationsNewMessageBadgeCountEnabled;
    private Boolean notificationsAddedToChannelEnabled;
    private String notificationsAddedToChannelTemplate;
    private String notificationsAddedToChannelSound;
    private Boolean notificationsRemovedFromChannelEnabled;
    private String notificationsRemovedFromChannelTemplate;
    private String notificationsRemovedFromChannelSound;
    private Boolean notificationsInvitedToChannelEnabled;
    private String notificationsInvitedToChannelTemplate;
    private String notificationsInvitedToChannelSound;
    private URI preWebhookUrl;
    private URI postWebhookUrl;
    private HttpMethod webhookMethod;
    private List<String> webhookFilters;
    private Integer limitsChannelMembers;
    private Integer limitsUserChannels;
    private String mediaCompatibilityMessage;
    private Integer preWebhookRetryCount;
    private Integer postWebhookRetryCount;
    private Boolean notificationsLogEnabled;

    public ServiceUpdater(final String pathSid){
        this.pathSid = pathSid;
    }

    public ServiceUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public ServiceUpdater setDefaultServiceRoleSid(final String defaultServiceRoleSid){
        this.defaultServiceRoleSid = defaultServiceRoleSid;
        return this;
    }
    public ServiceUpdater setDefaultChannelRoleSid(final String defaultChannelRoleSid){
        this.defaultChannelRoleSid = defaultChannelRoleSid;
        return this;
    }
    public ServiceUpdater setDefaultChannelCreatorRoleSid(final String defaultChannelCreatorRoleSid){
        this.defaultChannelCreatorRoleSid = defaultChannelCreatorRoleSid;
        return this;
    }
    public ServiceUpdater setReadStatusEnabled(final Boolean readStatusEnabled){
        this.readStatusEnabled = readStatusEnabled;
        return this;
    }
    public ServiceUpdater setReachabilityEnabled(final Boolean reachabilityEnabled){
        this.reachabilityEnabled = reachabilityEnabled;
        return this;
    }
    public ServiceUpdater setTypingIndicatorTimeout(final Integer typingIndicatorTimeout){
        this.typingIndicatorTimeout = typingIndicatorTimeout;
        return this;
    }
    public ServiceUpdater setConsumptionReportInterval(final Integer consumptionReportInterval){
        this.consumptionReportInterval = consumptionReportInterval;
        return this;
    }
    public ServiceUpdater setNotificationsNewMessageEnabled(final Boolean notificationsNewMessageEnabled){
        this.notificationsNewMessageEnabled = notificationsNewMessageEnabled;
        return this;
    }
    public ServiceUpdater setNotificationsNewMessageTemplate(final String notificationsNewMessageTemplate){
        this.notificationsNewMessageTemplate = notificationsNewMessageTemplate;
        return this;
    }
    public ServiceUpdater setNotificationsNewMessageSound(final String notificationsNewMessageSound){
        this.notificationsNewMessageSound = notificationsNewMessageSound;
        return this;
    }
    public ServiceUpdater setNotificationsNewMessageBadgeCountEnabled(final Boolean notificationsNewMessageBadgeCountEnabled){
        this.notificationsNewMessageBadgeCountEnabled = notificationsNewMessageBadgeCountEnabled;
        return this;
    }
    public ServiceUpdater setNotificationsAddedToChannelEnabled(final Boolean notificationsAddedToChannelEnabled){
        this.notificationsAddedToChannelEnabled = notificationsAddedToChannelEnabled;
        return this;
    }
    public ServiceUpdater setNotificationsAddedToChannelTemplate(final String notificationsAddedToChannelTemplate){
        this.notificationsAddedToChannelTemplate = notificationsAddedToChannelTemplate;
        return this;
    }
    public ServiceUpdater setNotificationsAddedToChannelSound(final String notificationsAddedToChannelSound){
        this.notificationsAddedToChannelSound = notificationsAddedToChannelSound;
        return this;
    }
    public ServiceUpdater setNotificationsRemovedFromChannelEnabled(final Boolean notificationsRemovedFromChannelEnabled){
        this.notificationsRemovedFromChannelEnabled = notificationsRemovedFromChannelEnabled;
        return this;
    }
    public ServiceUpdater setNotificationsRemovedFromChannelTemplate(final String notificationsRemovedFromChannelTemplate){
        this.notificationsRemovedFromChannelTemplate = notificationsRemovedFromChannelTemplate;
        return this;
    }
    public ServiceUpdater setNotificationsRemovedFromChannelSound(final String notificationsRemovedFromChannelSound){
        this.notificationsRemovedFromChannelSound = notificationsRemovedFromChannelSound;
        return this;
    }
    public ServiceUpdater setNotificationsInvitedToChannelEnabled(final Boolean notificationsInvitedToChannelEnabled){
        this.notificationsInvitedToChannelEnabled = notificationsInvitedToChannelEnabled;
        return this;
    }
    public ServiceUpdater setNotificationsInvitedToChannelTemplate(final String notificationsInvitedToChannelTemplate){
        this.notificationsInvitedToChannelTemplate = notificationsInvitedToChannelTemplate;
        return this;
    }
    public ServiceUpdater setNotificationsInvitedToChannelSound(final String notificationsInvitedToChannelSound){
        this.notificationsInvitedToChannelSound = notificationsInvitedToChannelSound;
        return this;
    }
    public ServiceUpdater setPreWebhookUrl(final URI preWebhookUrl){
        this.preWebhookUrl = preWebhookUrl;
        return this;
    }

    public ServiceUpdater setPreWebhookUrl(final String preWebhookUrl){
        return setPreWebhookUrl(Promoter.uriFromString(preWebhookUrl));
    }
    public ServiceUpdater setPostWebhookUrl(final URI postWebhookUrl){
        this.postWebhookUrl = postWebhookUrl;
        return this;
    }

    public ServiceUpdater setPostWebhookUrl(final String postWebhookUrl){
        return setPostWebhookUrl(Promoter.uriFromString(postWebhookUrl));
    }
    public ServiceUpdater setWebhookMethod(final HttpMethod webhookMethod){
        this.webhookMethod = webhookMethod;
        return this;
    }
    public ServiceUpdater setWebhookFilters(final List<String> webhookFilters){
        this.webhookFilters = webhookFilters;
        return this;
    }
    public ServiceUpdater setWebhookFilters(final String webhookFilters){
        return setWebhookFilters(Promoter.listOfOne(webhookFilters));
    }
    public ServiceUpdater setLimitsChannelMembers(final Integer limitsChannelMembers){
        this.limitsChannelMembers = limitsChannelMembers;
        return this;
    }
    public ServiceUpdater setLimitsUserChannels(final Integer limitsUserChannels){
        this.limitsUserChannels = limitsUserChannels;
        return this;
    }
    public ServiceUpdater setMediaCompatibilityMessage(final String mediaCompatibilityMessage){
        this.mediaCompatibilityMessage = mediaCompatibilityMessage;
        return this;
    }
    public ServiceUpdater setPreWebhookRetryCount(final Integer preWebhookRetryCount){
        this.preWebhookRetryCount = preWebhookRetryCount;
        return this;
    }
    public ServiceUpdater setPostWebhookRetryCount(final Integer postWebhookRetryCount){
        this.postWebhookRetryCount = postWebhookRetryCount;
        return this;
    }
    public ServiceUpdater setNotificationsLogEnabled(final Boolean notificationsLogEnabled){
        this.notificationsLogEnabled = notificationsLogEnabled;
        return this;
    }

    @Override
    public Service update(final TwilioRestClient client){
        String path = "/v2/Services/{Sid}";

        path = path.replace("{"+"Sid"+"}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Service update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Service.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (defaultServiceRoleSid != null) {
            request.addPostParam("DefaultServiceRoleSid", defaultServiceRoleSid);
    
        }
        if (defaultChannelRoleSid != null) {
            request.addPostParam("DefaultChannelRoleSid", defaultChannelRoleSid);
    
        }
        if (defaultChannelCreatorRoleSid != null) {
            request.addPostParam("DefaultChannelCreatorRoleSid", defaultChannelCreatorRoleSid);
    
        }
        if (readStatusEnabled != null) {
            request.addPostParam("ReadStatusEnabled", readStatusEnabled.toString());
    
        }
        if (reachabilityEnabled != null) {
            request.addPostParam("ReachabilityEnabled", reachabilityEnabled.toString());
    
        }
        if (typingIndicatorTimeout != null) {
            request.addPostParam("TypingIndicatorTimeout", typingIndicatorTimeout.toString());
    
        }
        if (consumptionReportInterval != null) {
            request.addPostParam("ConsumptionReportInterval", consumptionReportInterval.toString());
    
        }
        if (notificationsNewMessageEnabled != null) {
            request.addPostParam("Notifications.NewMessage.Enabled", notificationsNewMessageEnabled.toString());
    
        }
        if (notificationsNewMessageTemplate != null) {
            request.addPostParam("Notifications.NewMessage.Template", notificationsNewMessageTemplate);
    
        }
        if (notificationsNewMessageSound != null) {
            request.addPostParam("Notifications.NewMessage.Sound", notificationsNewMessageSound);
    
        }
        if (notificationsNewMessageBadgeCountEnabled != null) {
            request.addPostParam("Notifications.NewMessage.BadgeCountEnabled", notificationsNewMessageBadgeCountEnabled.toString());
    
        }
        if (notificationsAddedToChannelEnabled != null) {
            request.addPostParam("Notifications.AddedToChannel.Enabled", notificationsAddedToChannelEnabled.toString());
    
        }
        if (notificationsAddedToChannelTemplate != null) {
            request.addPostParam("Notifications.AddedToChannel.Template", notificationsAddedToChannelTemplate);
    
        }
        if (notificationsAddedToChannelSound != null) {
            request.addPostParam("Notifications.AddedToChannel.Sound", notificationsAddedToChannelSound);
    
        }
        if (notificationsRemovedFromChannelEnabled != null) {
            request.addPostParam("Notifications.RemovedFromChannel.Enabled", notificationsRemovedFromChannelEnabled.toString());
    
        }
        if (notificationsRemovedFromChannelTemplate != null) {
            request.addPostParam("Notifications.RemovedFromChannel.Template", notificationsRemovedFromChannelTemplate);
    
        }
        if (notificationsRemovedFromChannelSound != null) {
            request.addPostParam("Notifications.RemovedFromChannel.Sound", notificationsRemovedFromChannelSound);
    
        }
        if (notificationsInvitedToChannelEnabled != null) {
            request.addPostParam("Notifications.InvitedToChannel.Enabled", notificationsInvitedToChannelEnabled.toString());
    
        }
        if (notificationsInvitedToChannelTemplate != null) {
            request.addPostParam("Notifications.InvitedToChannel.Template", notificationsInvitedToChannelTemplate);
    
        }
        if (notificationsInvitedToChannelSound != null) {
            request.addPostParam("Notifications.InvitedToChannel.Sound", notificationsInvitedToChannelSound);
    
        }
        if (preWebhookUrl != null) {
            request.addPostParam("PreWebhookUrl", preWebhookUrl.toString());
    
        }
        if (postWebhookUrl != null) {
            request.addPostParam("PostWebhookUrl", postWebhookUrl.toString());
    
        }
        if (webhookMethod != null) {
            request.addPostParam("WebhookMethod", webhookMethod.toString());
    
        }
        if (webhookFilters != null) {
            for (String prop : webhookFilters) {
                request.addPostParam("WebhookFilters", prop);
            }
    
        }
        if (limitsChannelMembers != null) {
            request.addPostParam("Limits.ChannelMembers", limitsChannelMembers.toString());
    
        }
        if (limitsUserChannels != null) {
            request.addPostParam("Limits.UserChannels", limitsUserChannels.toString());
    
        }
        if (mediaCompatibilityMessage != null) {
            request.addPostParam("Media.CompatibilityMessage", mediaCompatibilityMessage);
    
        }
        if (preWebhookRetryCount != null) {
            request.addPostParam("PreWebhookRetryCount", preWebhookRetryCount.toString());
    
        }
        if (postWebhookRetryCount != null) {
            request.addPostParam("PostWebhookRetryCount", postWebhookRetryCount.toString());
    
        }
        if (notificationsLogEnabled != null) {
            request.addPostParam("Notifications.LogEnabled", notificationsLogEnabled.toString());
    
        }
    }
}
