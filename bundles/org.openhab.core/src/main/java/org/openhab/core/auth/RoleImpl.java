package org.openhab.core.auth;

import org.eclipse.jdt.annotation.NonNullByDefault;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Stephen Traiforos -  Initial Contribution
 */
@NonNullByDefault
public class RoleImpl implements Role {

    public RoleImpl(@NotNull String name) {
        this(name, null);
    }
    public RoleImpl(@NotNull String name, List<Privilege> privileges) {
        this.setName(name);
        this.setUID(this.getName().toLowerCase());
        this.setPrivileges(privileges);
    }
    private String name;
    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    private List<Privilege> privileges;
    @Override
    public List<Privilege> getPrivileges() {
        return privileges;
    }

    protected void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    private String id;
    @Override
    public String getUID() {
        return id;
    }

    protected void setUID(String id) {
        this.id = id;
    }
}
