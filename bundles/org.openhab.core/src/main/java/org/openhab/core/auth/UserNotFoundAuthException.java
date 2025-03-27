/**
 * Copyright (c) 2010-2025 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.core.auth;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Exception thrown when an authenticated user cannot be found in the user registry
 * 
 * @author Stephen Traiforos - Initial Contributor
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
