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
package org.openhab.core.internal.auth;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.auth.Role;
import org.openhab.core.auth.RoleProvider;
import org.openhab.core.auth.RoleRegistry;
import org.openhab.core.common.registry.AbstractRegistry;
import org.osgi.service.component.annotations.Component;


/**
 * Registry to persist user roles that are configured.
 * @author Stephen Traiforos  (Triforce) - Initial contribution
 */
@NonNullByDefault
@Component(service = RoleRegistry.class, immediate = true)
public class RoleRegistryImpl extends AbstractRegistry<Role, String, RoleProvider> implements RoleRegistry {
    protected RoleRegistryImpl() {
        super(RoleProvider.class);
    }
}
