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
 * Exception thrown when a user does not have the required permissions
 * 
 * @author Stephen Traiforos - Initial Contributor
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
