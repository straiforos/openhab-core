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
package org.openhab.core.io.rest.sse.internal;

import java.util.List;
import java.util.function.Predicate;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.io.rest.sse.internal.util.SseUtil;
import org.openhab.core.auth.Permission;
import org.openhab.core.auth.Permissions;

/**
 * The specific information we need to hold for a SSE sink which subscribes to event topics.
 *
 * @author Markus Rathgeb - Initial contribution
 */
@NonNullByDefault
public class SseSinkTopicInfo {

    private final List<String> regexFilters;
    private List<Permission> userPermissions;

    public SseSinkTopicInfo(String topicFilter) {
        this.regexFilters = SseUtil.convertToRegex(topicFilter);
    }

    public static Predicate<SseSinkTopicInfo> matchesTopic(final String topic) {
        return info -> info.regexFilters.stream().anyMatch(topic::matches);
    }

    public boolean canAccessTopic(String topic) {
        // Check if user has permission for this topic
        return regexFilters.stream().anyMatch(topic::matches) && 
               hasPermissionForTopic(topic);
    }
    
    private boolean hasPermissionForTopic(String topic) {
        // Implement topic-specific permission logic
        if (topic.startsWith("openhab/items/")) {
            return userPermissions.stream()
                .anyMatch(p -> p.getName().equals(Permissions.READ));
        }
        // Add other topic permission checks
        return false;
    }
}
