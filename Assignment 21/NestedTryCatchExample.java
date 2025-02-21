import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50}; // Example array

        try {
            System.out.print("Enter an index: ");
            int index = scanner.nextInt();

            try {
                int value = numbers[index];

                System.out.print("Enter a divisor: ");
                int divisor = scanner.nextInt();

                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
