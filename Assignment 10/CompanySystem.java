import java.util.ArrayList;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void displayEmployee() {
        System.out.println("  Employee: " + name);
    }
}

class Department {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void displayDepartment() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}

class Company {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName) {
        for (Department dept : departments) {
            if (deptName.equals(deptName)) {
                dept.addEmployee(empName);
                return;
            }
        }
        System.out.println("Department not found!");
    }

    public void displayCompany() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }
}

public class CompanySystem {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");
        company.addDepartment("IT");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("IT", "Alice");
        company.addEmployeeToDepartment("IT", "Bob");
        company.addEmployeeToDepartment("HR", "Charlie");

        company.displayCompany();
    }
}
