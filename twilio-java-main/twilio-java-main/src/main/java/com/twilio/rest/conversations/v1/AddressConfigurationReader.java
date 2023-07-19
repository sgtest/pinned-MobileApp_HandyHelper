/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1;

import com.twilio.base.Page;
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

public class AddressConfigurationReader extends Reader<AddressConfiguration> {

    private String type;
    private Integer pageSize;

    public AddressConfigurationReader() {}

    public AddressConfigurationReader setType(final String type) {
        this.type = type;
        return this;
    }

    public AddressConfigurationReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<AddressConfiguration> read(
        final TwilioRestClient client
    ) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<AddressConfiguration> firstPage(final TwilioRestClient client) {
        String path = "/v1/Configuration/Addresses";

        Request request = new Request(
            HttpMethod.GET,
            Domains.CONVERSATIONS.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<AddressConfiguration> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "AddressConfiguration read failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "address_configurations",
            response.getContent(),
            AddressConfiguration.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<AddressConfiguration> previousPage(
        final Page<AddressConfiguration> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.CONVERSATIONS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<AddressConfiguration> nextPage(
        final Page<AddressConfiguration> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.CONVERSATIONS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<AddressConfiguration> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (type != null) {
            request.addQueryParam("Type", type);
        }
        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
