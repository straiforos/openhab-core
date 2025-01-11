package org.openhab.core.auth;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.common.registry.Identifiable;

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
