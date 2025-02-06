import java.util.ArrayList;

class Course {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Course: " + name);
        for (Student student : students) {
            System.out.println("  Student: " + student.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void displayCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("  Course: " + course.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class School {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            System.out.println("  Student: " + student.getName());
        }
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        school.addStudent(student1);
        school.addStudent(student2);

        Course course1 = new Course("Math");
        Course course2 = new Course("Science");

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        school.displayStudents();
        student1.displayCourses();
        student2.displayCourses();
        course1.displayStudents();
        course2.displayStudents();
    }
}
