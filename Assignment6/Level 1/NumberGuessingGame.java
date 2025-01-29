import java.util.*;

public class NumberGuessingGame {
    public static int generateGuess(int low, int high) {
        return (low + high) / 2;
    }

    public static void getFeedback(String feedback) {
        if (feedback.equals("high")) {
            System.out.println("The guess is too high.");
        } else if (feedback.equals("low")) {
            System.out.println("The guess is too low.");
        } else {
            System.out.println("The guess is correct!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100, guess;
        String feedback;
        
        System.out.println("Think of a number between 1 and 100, and I will try to guess it.");
        
        while (true) {
            guess = generateGuess(low, high);
            System.out.println("Is the number " + guess + "? (Enter high/low/correct): ");
            feedback = sc.nextLine();
            
            if (feedback.equals("correct")) {
                getFeedback(feedback);
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }

    }
}
