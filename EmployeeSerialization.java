import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary);
    }
}

public class EmployeeSerialization {
    private static final String FILE_PATH = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 60000));
        employees.add(new Employee(103, "Charlie", "Finance", 55000));

        saveEmployees(employees);
        List<Employee> retrievedEmployees = loadEmployees();

        if (retrievedEmployees != null) {
            System.out.println("Employees retrieved from file:");
            for (Employee emp : retrievedEmployees) {
                emp.display();
            }
        }
    }

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static List<Employee> loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return (ArrayList<Employee>) ois.readObject();

            return null;
        }
    }
}
