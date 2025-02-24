import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Fix null pointer exception")
    @BugReport(description = "Optimize loop performance")
    public void process() {
        System.out.println("Processing...");
    }
}

public class BugTracker {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("process");
        BugReports bugReports = method.getAnnotation(BugReports.class);
        
        if (bugReports != null) {
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug: " + bug.description());
            }
        }
    }
}
