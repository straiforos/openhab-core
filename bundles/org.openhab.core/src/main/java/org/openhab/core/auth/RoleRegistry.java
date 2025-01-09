package org.openhab.core.auth;

import org.openhab.core.common.registry.Registry;

/**
 * Role registry allowing plugins and other packages to define new roles besides the default roles of Admin and User.
 * administrator, and user UID are reserved.
 * 
 * @link Role
 * @author Stephen Traiforos - Triforce
 */
public interface RoleRegistry extends Registry<Role, String> {

}
