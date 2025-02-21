import java.util.Scanner;

public class ExceptionPropagationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter principal amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter interest rate (%): ");
            double rate = scanner.nextDouble();

            System.out.print("Enter number of years: ");
            int years = scanner.nextInt();

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Total interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter valid numbers.");
        } finally {
            scanner.close();
        }
    }

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive.");
        }
        return (amount * rate * years) / 100;
    }
}
