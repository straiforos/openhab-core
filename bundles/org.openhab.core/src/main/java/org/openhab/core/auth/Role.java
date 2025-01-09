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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.common.registry.Identifiable;

/**
 * Interface defining roles which are a collection of privileges.
 * administrator, and user UID are reserved.
 *
 * @author Kai Kreuzer - Initial contribution
 * @author Stephen Traiforos - Dynamic Roles and Privileges for RBAC Git issue 3305.
 */
@NonNullByDefault
public interface Role extends Identifiable<String> {

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
