public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 500;

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.ownerName = "John";
        vehicle1.vehicleType = "Car";
        vehicle1.displayVehicleDetails();

        Vehicle.updateRegistrationFee(600);
        vehicle1.displayVehicleDetails();
    }
}
