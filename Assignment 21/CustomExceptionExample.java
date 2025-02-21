import java.util.Scanner;

// Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Access granted!");
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }
}
