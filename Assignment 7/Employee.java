import java.util.*;
public class Employee{
        String name;
        int id;
        int salary;

public Employee(String name,int id, int salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
}
public void displayDetails(){
        System.out.println("Employee Name: "+ name);
        System.out.println("id: "+id);
        System.out.println("salary: "+salary);
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Employee Salary: ");
        int salary = sc.nextInt();
        sc.close();

        Employee emp = new Employee(name, id, salary);
        emp.displayDetails();
    }
}
