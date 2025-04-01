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

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @author Stephen Traiforos - Initial Contribution
 */
@NonNullByDefault
public class RoleImpl implements Role {

    public RoleImpl(@NotNull String name) {
        this(name, new ArrayList<>());
    }

    public RoleImpl(@NotNull String name, @NotNull List<Permission> permissions) {
        this.setName(name);
        this.setPermissions(permissions);
    }

    private String name = USER;

    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    private List<Permission> permissions = new ArrayList<>();

    @Override
    public List<Permission> getPermissions() {
        return permissions;
    }

    protected void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    // TODO Validation to prevent special characters will be needed on the model.
    /**
     * ID to Satisfy registry constraint but uses the Role name string in lowercase for dynamically added roles.
     * 
     * @return
     */
    @Override
    public String getUID() {
        return name.toLowerCase();
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof RoleImpl)) {
            return false;
        }

        RoleImpl role = (RoleImpl) o;

        return role.toString().equals(this.toString());
    }
}
