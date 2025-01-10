package org.openhab.core.internal.auth;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.auth.Role;
import org.openhab.core.auth.RoleProvider;
import org.openhab.core.auth.RoleRegistry;
import org.openhab.core.common.registry.AbstractRegistry;
import org.osgi.service.component.annotations.Component;

@NonNullByDefault
@Component(service = RoleRegistry.class, immediate = true)
public class RoleRegistryImpl extends AbstractRegistry<Role, String, RoleProvider> implements RoleRegistry {
    protected RoleRegistryImpl() {
        super(RoleProvider.class);
    }
}
