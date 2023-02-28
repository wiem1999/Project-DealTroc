/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Wireless
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.wireless.v1.sim;

import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.base.Page;
import java.time.ZonedDateTime;



public class UsageRecordReader extends Reader<UsageRecord> {
    private String pathSimSid;
    private ZonedDateTime end;
    private ZonedDateTime start;
    private UsageRecord.Granularity granularity;
    private Integer pageSize;

    public UsageRecordReader(final String pathSimSid){
        this.pathSimSid = pathSimSid;
    }

    public UsageRecordReader setEnd(final ZonedDateTime end){
        this.end = end;
        return this;
    }
    public UsageRecordReader setStart(final ZonedDateTime start){
        this.start = start;
        return this;
    }
    public UsageRecordReader setGranularity(final UsageRecord.Granularity granularity){
        this.granularity = granularity;
        return this;
    }
    public UsageRecordReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<UsageRecord> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<UsageRecord> firstPage(final TwilioRestClient client) {
        String path = "/v1/Sims/{SimSid}/UsageRecords";
        path = path.replace("{"+"SimSid"+"}", this.pathSimSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.WIRELESS.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<UsageRecord> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("UsageRecord read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "usage_records",
            response.getContent(),
            UsageRecord.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<UsageRecord> previousPage(final Page<UsageRecord> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.WIRELESS.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<UsageRecord> nextPage(final Page<UsageRecord> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.WIRELESS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<UsageRecord> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (end != null) {
            request.addQueryParam("End", end.toInstant().toString());
        }

        if (start != null) {
            request.addQueryParam("Start", start.toInstant().toString());
        }

        if (granularity != null) {
    
            request.addQueryParam("Granularity", granularity.toString());
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if(getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
