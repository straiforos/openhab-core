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

/**
 * Simplest possible implementation of permission.
 *
 * @author Łukasz Dywicki - Initial contribution.
 */
public class NamedPermission implements Permission {
    private final String name;

    public NamedPermission(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * ID to Satisfy registry constraint but uses the Role name string in lowercase for dynamically added roles.
     *
     * @return
     */
    @Override
    public String getUID() {
        return name.toLowerCase();
    }
}
