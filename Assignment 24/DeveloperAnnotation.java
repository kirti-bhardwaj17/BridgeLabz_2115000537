import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Developer {
    String name();
}

@Developer(name = "Kirti Bhardwaj")
class SoftwareProject {
    public void showProject() {
        System.out.println("Software Project details.");
    }
}

public class DeveloperAnnotation {
    public static void main(String[] args) {
        Class<SoftwareProject> obj = SoftwareProject.class;

        if (obj.isAnnotationPresent(Developer.class)) {
            Developer dev = obj.getAnnotation(Developer.class);
            System.out.println("Developer: " + dev.name());
        } else {
            System.out.println("No Developer annotation found.");
        }
    }
}
