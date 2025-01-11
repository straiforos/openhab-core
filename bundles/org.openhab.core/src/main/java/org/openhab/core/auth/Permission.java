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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.common.registry.Identifiable;

// TODO implement something similar to opensmarthome to have concrete default permissions for openhab.
// https://github.com/opensmarthouse/opensmarthouse-core/commit/ee3494ce183e379aaa3bdbb00da9496346518670#diff-2ae64de6c0f006865faef94035ee756ceb249a675f8848be9d63ea4ea08d4d2fR20
/**
 * Defines a given access to a specific functionality.
 * <ul>
 * <li>View access</li>
 * <li>CRUD access</li>
 * </ul>
 * 
 * @example View_Roles, View_Permissions, Create_Role, Edit_Role, Delete_Role etc.
 * @author Stephen Traiforos (Triforce) - Initial contribution
 */
@NonNullByDefault
public interface Permission extends Identifiable<String> {
    String getName();
}
