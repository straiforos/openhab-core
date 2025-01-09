package org.openhab.core.auth;

import org.openhab.core.common.registry.Registry;

/**
 * Role registry allowing plugins and other packages to define new roles besides the default roles of Admin and User.
 * 0, and 1 UID's are reserved for Administrator and User roles.
 * 
 * @link Role
 * @author Stephen Traiforos - Triforce
 */
public interface RoleRegistry extends Registry<Role, Integer> {

}
