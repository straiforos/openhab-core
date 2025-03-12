package org.openhab.core.auth;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Exception thrown when a user does not have the required permissions
 */
public class UserUnauthorizedException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public UserUnauthorizedException() {
        super("User does not have required permissions", Response.Status.FORBIDDEN);
    }

    public UserUnauthorizedException(String message) {
        super(message, Response.Status.FORBIDDEN);
    }
} 