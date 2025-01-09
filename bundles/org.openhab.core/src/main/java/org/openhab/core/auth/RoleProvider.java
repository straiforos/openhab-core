package org.openhab.core.auth;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.common.registry.Provider;

/**
 * Role provider
 * @author Stephen Traiforos - Initial contribution
 */
@NonNullByDefault
public interface RoleProvider extends Provider<Role> {
}
