import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login functionality", assignedTo = "Alice", priority = "HIGH")
    public void login() {
        System.out.println("Login feature development...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        System.out.println("Database optimization...");
    }

    @Todo(task = "Add payment gateway integration", assignedTo = "Charlie", priority = "CRITICAL")
    public void paymentIntegration() {
        System.out.println("Payment integration...");
    }
}

public class TodoTracker {
    public static void main(String[] args) {
        Method[] methods = Project.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("----------------------------");
            }
        }
    }
}
