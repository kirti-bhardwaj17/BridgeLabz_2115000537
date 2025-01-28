import java.util.Scanner;

public class Trignometry {

    public double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the angle in degrees:");
        double angle = sc.nextDouble();

        Trignometry trig = new Trignometry();
        double[] results = trig.calculateTrigonometricFunctions(angle);

        System.out.println("Sine of " + angle + results[0]);
        System.out.println("Cosine of " + angle  + results[1]);
        System.out.println("Tangent of " + angle  + results[2]);

        sc.close();
    }
}
