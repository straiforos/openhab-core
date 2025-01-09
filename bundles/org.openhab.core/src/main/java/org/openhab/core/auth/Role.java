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

import java.util.List;

import org.openhab.core.common.registry.Identifiable;

/**
 * Interface defining roles which are a collection of privileges.
 * 0, and 1 UID are reserved for Administrator and User roles.
 *
 * @author Kai Kreuzer - Initial contribution
 */
public interface Role extends Identifiable<Integer> {

    /**
     * Role of users with administrative rights
     */
    String ADMIN = "administrator";

    /**
     * Role of a regular user without any exceptional permissions or restrictions
     */
    String USER = "user";

    /**
     * Name of the role typically user or administrator.
     * 
     * @return name of role.
     */
    String getName();

    /**
     * List of privileges a user role has.
     * 
     * @return list of privileges
     */
    List<?> getPrivileges();
}
