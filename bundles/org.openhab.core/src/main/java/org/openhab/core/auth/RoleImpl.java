package org.openhab.core.auth;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.eclipse.jdt.annotation.NonNullByDefault;

/**
 * @author Stephen Traiforos - Initial Contribution
 */
@NonNullByDefault
public class RoleImpl implements Role {

    public RoleImpl(@NotNull String name) {
        this(name, new ArrayList<>());
    }

    public RoleImpl(@NotNull String name, @NotNull List<Permission> permissions) {
        this.setName(name);
        this.setPermissions(permissions);
    }

    private String name = USER;

    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    private List<Permission> permissions = new ArrayList<>();

    @Override
    public List<Permission> getPermissions() {
        return permissions;
    }

    protected void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    // TODO Validation to prevent special characters will be needed on the model.
    /**
     * ID to Satisfy registry constraint but uses the Role name string in lowercase for dynamically added roles.
     * @return
     */
    @Override
    public String getUID() {
        return name.toLowerCase();
    }
}
