import java.util.Scanner;

public class HandShakes2 {
    int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("At least 2 students are required for a handshake.");
        } else {
            HandShakes2 obj = new HandShakes2();

            int handshakes = obj.calculateHandshakes(n);
            System.out.println("The maximum number of handshakes among " + n + " students is: " + handshakes);
        }

        sc.close();
    }

}
