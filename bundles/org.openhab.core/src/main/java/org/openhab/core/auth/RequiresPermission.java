/**
 * Annotation to specify required permissions for accessing a resource or method
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RequiresPermission {
    String[] value();
} 