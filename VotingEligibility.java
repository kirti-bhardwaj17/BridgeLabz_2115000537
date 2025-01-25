import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        int[] studentAges = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            if (studentAges[i] < 0) {
                System.out.println("Invalid age.");
            } else if (studentAges[i] >= 18) {
                System.out.println("The student with age " + studentAges[i] + " can vote.");
            } else {
                System.out.println("The student with age " + studentAges[i] + " cannot vote.");
            }
        }

        scanner.close();
    }
}
