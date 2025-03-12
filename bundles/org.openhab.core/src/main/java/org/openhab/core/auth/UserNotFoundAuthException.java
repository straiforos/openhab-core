package org.openhab.core.auth;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Exception thrown when an authenticated user cannot be found in the user registry
 */
public class UserNotFoundAuthException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundAuthException() {
        super("Authenticated user not found in registry", Response.Status.NOT_FOUND);
    }

    public UserNotFoundAuthException(String username) {
        super("Authenticated user '" + username + "' not found in registry", Response.Status.NOT_FOUND);
    }
} 