# RBAC Development Guide

## API Overview

### Core Interfaces

```java
public interface User {
    String getName();
    String getUID();
    Set<Role> getRoles();
}

public interface Role {
    String getName();
    List<Permission> getPermissions();
    void setPermissions(List<Permission> permissions);
}

public interface Permission {
    String getName();
    String getDescription();
}

public interface RoleRegistry {
    void add(Role role);
    void remove(Role role);
    Role get(String name);
    List<Role> getAll();
}
```

### Security Context

```java
public interface SecurityContext {
    User getUser();
    boolean hasPermission(Permission permission);
    boolean hasRole(String roleName);
    Set<Permission> getPermissions();
    Set<Role> getRoles();
}
```

## Testing Guidelines

### Unit Testing

```java
public class RBACTest {
    @Test
    public void testPermissionCheck() {
        // Create test user with permission
        User user = createTestUser(Permissions.READ.getPermission());
        SecurityContext context = new SecurityContext(user);

        // Test permission check
        assertTrue(context.hasPermission(Permissions.READ.getPermission()));
        assertFalse(context.hasPermission(Permissions.COMMAND.getPermission()));
    }

    @Test
    public void testRoleAssignment() {
        // Create test role with permission
        Role role = createTestRole("testRole", 
            Collections.singletonList(Permissions.READ.getPermission()));
        
        // Test role operations
        assertTrue(roleRegistry.add(role));
        assertEquals(1, role.getPermissions().size());
    }
}
```

### Integration Testing

```java
public class RBACIntegrationTest {
    @Test
    public void testServiceAccess() {
        // Create test user with required permissions
        User user = createTestUser(
            Permissions.READ.getPermission(),
            Permissions.STATE.getPermission()
        );
        
        // Test service access
        ItemService service = new ItemService();
        SecurityContext context = new SecurityContext(user);
        
        // Should succeed
        service.readItemState();
        service.readItemStateWithHistory();
        
        // Remove one permission
        user.getRoles().iterator().next().getPermissions()
            .remove(Permissions.STATE.getPermission());
        
        // Should fail
        assertThrows(SecurityException.class, () -> service.readItemStateWithHistory());
    }
}
```

## Migration Guide

### From Previous Versions

1. Update Permission Usage
```java
// Old way
@RequiresPermission("read")
public void oldMethod() {
    // Implementation
}

// New way
@RequiresPermission(Permissions.READ)
public void newMethod() {
    // Implementation
}
```

2. Update Role Creation
```java
// Old way
Role role = new Role("customRole", Arrays.asList("read"));

// New way
Role role = new RoleImpl("customRole", 
    Collections.singletonList(Permissions.READ.getPermission()));
```

3. Update Permission Checking
```java
// Old way
if (hasPermission("read")) {
    // Implementation
}

// New way
if (securityContext.hasPermission(Permissions.READ.getPermission())) {
    // Implementation
}
```

## Best Practices

### Permission Implementation

1. Naming Conventions
   - Use standard permission names
   - Follow permission hierarchy
   - Use descriptive combinations

2. Documentation
   - Document permission usage
   - Include usage examples
   - Specify dependencies

3. Testing
   - Unit test permissions
   - Integration test access
   - Security test validation

### Role Management

1. Role Creation
   - Use meaningful names
   - Group related permissions
   - Document purpose

2. Role Assignment
   - Follow least privilege
   - Regular review
   - Monitor usage

3. Security
   - Validate inputs
   - Handle errors
   - Log changes

## Common Patterns

### Permission Checking

```java
public class PermissionChecker {
    public static void checkPermission(SecurityContext context, Permission permission) {
        if (!context.hasPermission(permission)) {
            throw new SecurityException(
                String.format("User %s does not have permission %s",
                    context.getUser().getName(),
                    permission.getName()
                )
            );
        }
    }
}
```

### Role Validation

```java
public class RoleValidator {
    public static void validateRole(Role role) {
        if (role.getName() == null || role.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Role name cannot be empty");
        }
        
        if (role.getName().equals("administrator") || 
            role.getName().equals("user")) {
            throw new IllegalArgumentException("Cannot use reserved role name");
        }
        
        if (role.getPermissions() == null || role.getPermissions().isEmpty()) {
            throw new IllegalArgumentException("Role must have at least one permission");
        }
    }
}
```

### Security Context Management

```java
public class SecurityContextManager {
    private static final ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<>();
    
    public static void setContext(SecurityContext context) {
        contextHolder.set(context);
    }
    
    public static SecurityContext getContext() {
        return contextHolder.get();
    }
    
    public static void clearContext() {
        contextHolder.remove();
    }
}
``` 