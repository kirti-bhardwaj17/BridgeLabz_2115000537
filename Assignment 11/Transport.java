class Vehicle{
        String fuelType;
        double maxSpeed;
        Vehicle(String fuelType,double maxSpeed){
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
        }
        void displayDetails(){
        System.out.println("fuelType "+fuelType+" maxSpeed "+maxSpeed);
}       }
class Car extends Vehicle {
    int seatCapacity;


    Car(String fuelType, double maxSpeed, int seatCapacity) {
        super(fuelType, maxSpeed);
        this.seatCapacity = seatCapacity;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Car, seatCapacity: " + seatCapacity);
    }
}
class Truck extends Vehicle {
        String color;
        Truck(String fuelType, double maxSpeed, String color){
        super(fuelType, maxSpeed);
        this.color = color;
}
	void displayDetails(){
	super.displayDetails();
        System.out.println("Vehicle Type: Truck, Color: " + color);
    }
        }

class Motorcycle extends Vehicle { int modelNumber;
       Motorcycle(String fuelType, double maxSpeed,int modelNumber){
        super(fuelType , maxSpeed);
	this.modelNumber = modelNumber;
        }
	void displayDetails() {
        super.displayDetails();
        System.out.println("Vehicle Type: Motorcycle, Model Number: " + modelNumber);
    }
}
public class Transport{
        public static void main(String args[]){
        Vehicle v1 = new Car("petrol",120,7);
        Vehicle v2 = new Truck("deisal",120, "red");
        Vehicle v3 = new Motorcycle("petrol", 60,451);

        v1.displayDetails();
        System.out.println();
        v2.displayDetails();
        System.out.println();
 	v3.displayDetails();
}
}

