import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed.");
    }
}

public class RoleAccessControl {
    public static void executeMethod(User user, Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(user.getRole())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! Only " + roleAllowed.value() + " can access this method.");
                }
            } else {
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User admin = new User("ADMIN");
        User regularUser = new User("USER");

        SecureService service = new SecureService();

        System.out.println("Admin trying to execute adminTask:");
        executeMethod(admin, service, "adminTask");

        System.out.println("\nUser trying to execute adminTask:");
        executeMethod(regularUser, service, "adminTask");

        System.out.println("\nUser trying to execute userTask:");
        executeMethod(regularUser, service, "userTask");
    }
}
