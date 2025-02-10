import java.util.*;
abstract class Vehicle{
	private int vehicleNumber;
	private String type;
	private double rentalRate;
	public Vehicle(int vehicleNumber, String type, double rentalRate){
	this.vehicleNumber = vehicleNumber;
	this.type = type;
	this.rentalRate = rentalRate;
	}
	public int getVehicleNumber(){
	return vehicleNumber;
	}
	public String getType(){
	return type;
	}
	public double getRentalRate(){
	return rentalRate;
	}
	public abstract double calculateRentalCost(int days);
}
interface Insurable{
	double calculateInsurance();
	String getInsuranceDetails();
}
class Car extends Vehicle implements Insurable{
	public Car(int vehicleNumber, String type, double rentalRate){
	super(vehicleNumber, type , rentalRate);
	
	}
	public double calculateRentalCost(int days){
	return getRentalRate()*days;
	}
	public double calculateInsurance(){
	return getRentalRate()*0.05;
	}
	public String getInsuranceDetails(){
	return "5% insurance charge applied on car";
	}
}
class Truck extends Vehicle implements Insurable{
        public Truck(int vehicleNumber, String type, double rentalRate){
        super(vehicleNumber, type , rentalRate);
        }
        public double calculateRentalCost(int days){
        return getRentalRate()*days;
        }
        public double calculateInsurance(){
        return getRentalRate()*0.15;
        }
        public String getInsuranceDetails(){
        return "15% insurance charge applied on truck";
        }
}
class Bike extends Vehicle implements Insurable{
        
        public Bike(int vehicleNumber, String type, double rentalRate){
        super(vehicleNumber, type , rentalRate);
        }
        public double calculateRentalCost(int days){
        return getRentalRate()*days;
        }
        public double calculateInsurance(){
        return getRentalRate()*0.10;
        }
        public String getInsuranceDetails(){
        return "10% insurance charge applied on bike";
        }
}
public class VehicleSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car(101, "Sedan", 2000));
        vehicleList.add(new Truck(102, "Heavy Truck", 5000));
        vehicleList.add(new Bike(103, "Sport Bike", 1000));

        int rentalDays = 5;

        for (Vehicle vehicle : vehicleList) {
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = (vehicle instanceof Insurable) ? ((Insurable) vehicle).calculateInsurance() : 0;

            System.out.println("\nVehicle Type: " + vehicle.getType());
            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + rentalCost);
            System.out.println("Insurance Cost: ₹" + insuranceCost);

            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
        }
    }
}
