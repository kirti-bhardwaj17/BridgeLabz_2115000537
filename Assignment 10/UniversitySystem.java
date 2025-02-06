import java.util.ArrayList;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    private String name;
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void displayDepartment() {
        System.out.println("Department: " + name);
        for (Faculty faculty : faculties) {
            faculty.displayFaculty();
        }
    }
}

class University {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void assignFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department dept : departments) {
            if (deptName.equals(deptName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found!");
    }

    public void displayUniversity() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
        System.out.println("Independent Faculty Members:");
        for (Faculty faculty : faculties) {
            faculty.displayFaculty();
        }
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("Tech University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        Faculty faculty1 = new Faculty("Dr. Alice");
        Faculty faculty2 = new Faculty("Dr. Bob");
        Faculty faculty3 = new Faculty("Dr. Charlie");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addFaculty(faculty3);

        university.assignFacultyToDepartment("Computer Science", faculty1);
        university.assignFacultyToDepartment("Mechanical Engineering", faculty2);

        university.displayUniversity();
    }
}

