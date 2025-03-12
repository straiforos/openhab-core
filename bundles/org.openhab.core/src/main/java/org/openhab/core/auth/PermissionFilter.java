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

import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Stephen Traiforos - Initial contribution
 */
@Component
@Provider
@Priority(Priorities.AUTHORIZATION)
public class PermissionFilter implements ContainerRequestFilter {

    @Context
    SecurityContext securityContext;

    @Reference
    private UserRegistry userRegistry;

    private ResourceInfo resourceInfo;

    @Activate
    public PermissionFilter(final @Reference UserRegistry userRegistry) {
        this.userRegistry = userRegistry;
    }

    @Context
    public void setResourceInfo(ResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    /**
     * Filters users who do not have the appropriate permission(s) supplied in the @RequiresPermission annotation.
     */
    @Override
    public void filter(ContainerRequestContext requestContext)
            throws UnauthenticatedUserException, UserNotFoundAuthException, UserUnauthorizedException {
        // Get the resource method
        Method method = resourceInfo.getResourceMethod();

        // Check for @RequiresPermission annotation
        RequiresPermission permissionAnn = method.getAnnotation(RequiresPermission.class);
        if (permissionAnn == null) {
            return;
        }

        // Get current authentication
        Principal principal = securityContext.getUserPrincipal();
        if (principal == null) {
            throw new UnauthenticatedUserException();
        }

        String username = principal.getName();
        User loggedInUser = userRegistry.get(username);
        if (loggedInUser == null) {
            throw new UserNotFoundAuthException(username);
        }

        // Check if user has required permissions
        Set<Role> roles = loggedInUser.getRoles();
        Set<Permission> userPermissions = roles.stream().flatMap(role -> role.getPermissions().stream())
                .collect(Collectors.toSet());
        boolean hasPermission = Arrays.stream(permissionAnn.value())
                .allMatch(requiredPerm -> userPermissions.stream().anyMatch(p -> p.getName().equals(requiredPerm)));

        if (!hasPermission) {
            throw new UserUnauthorizedException("User '" + username + "' does not have the required permissions: "
                    + Arrays.toString(permissionAnn.value()));
        }
    }
}
