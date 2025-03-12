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

// TODO split into ItemPermissions since only items have state, command etc
// TODO make named permissions PermissionImpl so we do not have reference to anothe project.
/**
 * Common permission definitions.
 *
 * @author Łukasz Dywicki - Initial contribution
 * @author Stephen Traiforos - Brought from Łukasz's contributions.
 */
public interface Permissions {
    Permission ALL = new PermissionImpl("*");
    Permission READ = new PermissionImpl("read");
    Permission STATE = new PermissionImpl("state");
    Permission COMMAND = new PermissionImpl("command");
    Permission MANAGE = new PermissionImpl("manage");
    Permission PERSISTENCE = new PermissionImpl("persistence");
}
