/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Chat
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.chat.v1.service.channel;

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class InviteCreator extends Creator<Invite> {

    private String pathServiceSid;
    private String pathChannelSid;
    private String identity;
    private String roleSid;

    public InviteCreator(
        final String pathServiceSid,
        final String pathChannelSid,
        final String identity
    ) {
        this.pathServiceSid = pathServiceSid;
        this.pathChannelSid = pathChannelSid;
        this.identity = identity;
    }

    public InviteCreator setIdentity(final String identity) {
        this.identity = identity;
        return this;
    }

    public InviteCreator setRoleSid(final String roleSid) {
        this.roleSid = roleSid;
        return this;
    }

    @Override
    public Invite create(final TwilioRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Channels/{ChannelSid}/Invites";

        path =
            path.replace(
                "{" + "ServiceSid" + "}",
                this.pathServiceSid.toString()
            );
        path =
            path.replace(
                "{" + "ChannelSid" + "}",
                this.pathChannelSid.toString()
            );
        path = path.replace("{" + "Identity" + "}", this.identity.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.CHAT.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "Invite creation failed: Unable to connect to server"
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

        return Invite.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
        }
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
        }
    }
}
