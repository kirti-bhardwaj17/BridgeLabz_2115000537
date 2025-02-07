class Employee{
	String name;
	int id;
	double salary;
	Employee(String name, int id,double salary){
	this.name = name;
	this.id = id;
	this.salary = salary;
	}
	void displayDetails(){
	System.out.println("id "+ id + "name "+name+"salary "+salary);
}	}
class Manager extends Employee {
    int teamSize;

    
    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager, Team Size: " + teamSize);
    }
}
class Developer extends Employee {
	String ProgrammingLanguage;
	Developer(String name, int id, double salary, String ProgrammingLanguage){
	super(name, id , salary);
	this.ProgrammingLanguage = ProgrammingLanguage;
}	}
class Intern extends Employee {
	Intern(String name, int id, double salary){
	super(name , id, salary);
	}
}
public class Employees{
	public static void main(String args[]){
	Employee emp1 = new Manager("Alice",101,90000,10);
	Employee emp2 = new Developer("Bob",102, 80000, "java");
	Employee emp3 = new Intern("Charlie", 103,45000);

	emp1.displayDetails();
        System.out.println(); 
        emp2.displayDetails();
        System.out.println();
        emp3.displayDetails();
}
}
