package org.openhab.core.auth;

import org.openhab.core.common.registry.Identifiable;

/**
 * Defines a given access to a specific functionality.
 * <ul>
 * <li>View access</li>
 * <li>CRUD access</li>
 * </ul>
 * 
 * @example View_Roles_and_Privileges, Create_Role, Edit_Role, Delete_Role etc.
 * @author Stephen Traiforos - Triforce
 */
public interface Privilege extends Identifiable<Integer> {
    String getName();
}
