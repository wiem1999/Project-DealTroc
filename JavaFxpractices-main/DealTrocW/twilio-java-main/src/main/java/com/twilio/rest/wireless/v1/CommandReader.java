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

package com.twilio.rest.wireless.v1;

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



public class CommandReader extends Reader<Command> {
    private String sim;
    private Command.Status status;
    private Command.Direction direction;
    private Command.Transport transport;
    private Integer pageSize;

    public CommandReader(){
    }

    public CommandReader setSim(final String sim){
        this.sim = sim;
        return this;
    }
    public CommandReader setStatus(final Command.Status status){
        this.status = status;
        return this;
    }
    public CommandReader setDirection(final Command.Direction direction){
        this.direction = direction;
        return this;
    }
    public CommandReader setTransport(final Command.Transport transport){
        this.transport = transport;
        return this;
    }
    public CommandReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Command> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Command> firstPage(final TwilioRestClient client) {
        String path = "/v1/Commands";

        Request request = new Request(
            HttpMethod.GET,
            Domains.WIRELESS.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Command> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Command read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "commands",
            response.getContent(),
            Command.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Command> previousPage(final Page<Command> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.WIRELESS.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<Command> nextPage(final Page<Command> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.WIRELESS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Command> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (sim != null) {
    
            request.addQueryParam("Sim", sim);
        }
        if (status != null) {
    
            request.addQueryParam("Status", status.toString());
        }
        if (direction != null) {
    
            request.addQueryParam("Direction", direction.toString());
        }
        if (transport != null) {
    
            request.addQueryParam("Transport", transport.toString());
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if(getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
