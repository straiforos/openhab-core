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
 *
 * @author Łukasz Dywicki - Initial contribution
 * @author Stephen Traiforos - Brought from Łukasz's contributions.
 */
public interface PermissionEvaluator<T> {
    /**
     * Allows checking if a class has permissions available to be authorized for.
     * 
     * @param type
     * @param permission
     * @return
     */
    boolean supports(Class<?> type, Permission permission);

    /**
     * Decide if given value is accessible in given authentication context or not.
     *
     * @param permission Permission to be evaluated.
     * @param authentication Authentication to verify.
     * @param value Entity or resource to check.
     * @return True if user can access given object.
     */
    boolean hasPermission(Permission permission, Authentication authentication, T value);

    boolean hasPermission(Permission permission, Authentication authentication, Class<?> type, String id);
}
