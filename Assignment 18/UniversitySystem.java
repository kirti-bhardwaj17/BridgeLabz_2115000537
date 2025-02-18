import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;
    
    public CourseType(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based Course");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based Course");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based Course");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;
    
    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }
    
    public void displayCourse() {
        System.out.println("Course: " + courseName + ", Type: " + courseType.getName());
    }
}

class University {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();
    
    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }
    
    public void displayCourses() {
        for (Course<? extends CourseType> course : courses) {
            course.displayCourse();
        }
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University();
        
        Course<ExamCourse> mathCourse = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> englishCourse = new Course<>("English Literature", new AssignmentCourse());
        Course<ResearchCourse> aiCourse = new Course<>("Artificial Intelligence", new ResearchCourse());
        
        university.addCourse(mathCourse);
        university.addCourse(englishCourse);
        university.addCourse(aiCourse);
        
        System.out.println("\n--- University Courses ---");
        university.displayCourses();
    }
}

