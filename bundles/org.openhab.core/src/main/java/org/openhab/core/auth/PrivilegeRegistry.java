package org.openhab.core.auth;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.common.registry.Registry;

/**
 * Registry of {@link Permission} in the application, allowing plugins to add/remove more for custom restrictions on
 * {@link Role}.
 * 
 * @author Stephen Traiforos (Triforce) - Initial contribution
 */
@NonNullByDefault
public interface PrivilegeRegistry extends Registry<Permission, String> {

}
