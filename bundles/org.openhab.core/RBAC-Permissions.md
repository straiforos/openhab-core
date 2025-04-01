# RBAC Permissions System

## Overview

The permissions system in openHAB Core provides a standardized way to control access to system resources. The system is built around the `Permissions` enum which defines the standard set of permissions available in the system.

## Standard Permissions

```mermaid
classDiagram
    class Permissions {
        <<enumeration>>
        ALL
        READ
        STATE
        COMMAND
        MANAGE
        PERSISTENCE
        +getPermission() Permission
    }
    
    class Permission {
        +String name
        +String description
        +getName() String
        +getDescription() String
    }
    
    Permissions "1" *-- "1" Permission : creates
```

### Permission Types

1. `ALL` ("*")
   - Grants complete access to all resources
   - Used for administrative roles
   - Implies all other permissions
   - Cannot be overridden by other permissions

2. `READ` ("read")
   - Allows reading resource values
   - Basic access for viewing items
   - Required for most operations
   - Base permission for viewing system state

3. `STATE` ("state")
   - Controls access to item states
   - Allows reading and writing states
   - Required for item updates
   - Implies READ permission
   - Used for monitoring and state changes

4. `COMMAND` ("command")
   - Permits sending commands to items
   - Required for item control
   - Implies READ permission
   - Default permission for standard users
   - Can be disabled for read-only access

5. `MANAGE` ("manage")
   - Allows system configuration
   - Required for administrative tasks
   - Implies COMMAND permission
   - Restricted to administrator role
   - Controls system-wide changes

6. `PERSISTENCE` ("persistence")
   - Controls data persistence access
   - Required for historical data
   - Implies READ permission
   - Used for data storage operations
   - Independent of COMMAND permission

## Permission Hierarchy

```mermaid
graph TD
    A[ALL] --> B[MANAGE]
    B --> C[COMMAND]
    C --> D[STATE]
    D --> E[READ]
    F[PERSISTENCE] --> E
```

## Usage Examples

### Method-Level Permissions

```java
@RequiresPermission(Permissions.READ)
public Item getItem(String name) {
    // Implementation
}

@RequiresPermission({ Permissions.READ, Permissions.STATE })
public void updateItemState(String name, State state) {
    // Implementation
}

@RequiresPermission(Permissions.COMMAND)
public void sendCommand(Command command) {
    // Implementation
}
```

### Role Creation

```java
// Standard user role with command access
Role userRole = new RoleImpl("user", Arrays.asList(
    Permissions.READ.getPermission(),
    Permissions.STATE.getPermission(),
    Permissions.COMMAND.getPermission()
));

// Read-only user role
Role readOnlyRole = new RoleImpl("readonly", Arrays.asList(
    Permissions.READ.getPermission(),
    Permissions.STATE.getPermission()
));
```

### Permission Checking

```java
SecurityContext context = SecurityContextHolder.getContext();
if (context.hasPermission(Permissions.READ.getPermission())) {
    // Perform read operation
}

// Check for command access
if (context.hasPermission(Permissions.COMMAND.getPermission())) {
    // Allow command operations
}
```

## Best Practices

1. Permission Usage
   - Use standard permissions
   - Follow permission hierarchy
   - Use descriptive combinations
   - Consider permission implications

2. Security
   - Principle of least privilege
   - Regular permission review
   - Audit access patterns
   - Validate permission sets

3. Documentation
   - Document permission usage
   - Include usage examples
   - Specify dependencies
   - Explain permission implications

## Related Documentation

- [RBAC Overview](RBAC-Overview.md)
- [Roles and Users](RBAC-Roles.md)
- [Security Implementation](RBAC-Security.md)
- [Development Guide](RBAC-Development.md) 