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
 * An enumeration of standard permissions used throughout the openHAB system for authorization.
 * Each enum constant represents a specific permission type with its associated {@link Permission} object.
 * These permissions are used to control access to various system functionalities and resources.
 * 
 * <p>Each enum value contains a {@link Permission} instance that defines the specific access rights
 * it grants. These permissions can be assigned to roles and users to implement fine-grained
 * access control.</p>
 * 
 * <p>The available permission types are:</p>
 * <ul>
 *   <li>{@code ALL} - Grants complete access to all functionalities ("*")</li>
 *   <li>{@code READ} - Allows reading item states and metadata</li>
 *   <li>{@code STATE} - Permits access to item state information</li>
 *   <li>{@code COMMAND} - Enables sending commands to items</li>
 *   <li>{@code MANAGE} - Grants administrative capabilities like creating/updating items</li>
 *   <li>{@code PERSISTENCE} - Controls access to persistence services</li>
 * </ul>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * @RequiresPermission(Permissions.READ.permission)
 * public void readItemState() {
 *     // Method implementation
 * }
 * }
 * </pre>
 *
 * @author Stephen Traiforos - Initial Contribution
 */
public enum Permissions {
    /** Grants complete access to all functionalities (represented by "*") */
    ALL("*"),
    
    /** Allows reading item states and metadata */
    READ("read"),
    
    /** Permits access to item state information */
    STATE("state"),
    
    /** Enables sending commands to items */
    COMMAND("command"),
    
    /** Grants administrative capabilities like creating/updating items */
    MANAGE("manage"),
    
    /** Controls access to persistence services */
    PERSISTENCE("persistence");

    protected Permission permission;

    public Permission getPermission() {
        return this.permission;
    }

    private Permissions(String permissionName) {
        this.permission = new PermissionImpl(permissionName);
    }
}
