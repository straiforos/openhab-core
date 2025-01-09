package org.openhab.core.auth;

import org.openhab.core.common.registry.Registry;

/**
 * Registry of {@link Privilege} in the application, allowing plugins to add/remove more for custom restrictions on
 * {@link Role}.
 * 
 * @author Stephen Traiforos - Triforce
 */
public interface PrivilegeRegistry extends Registry<Privilege, Integer> {

}
