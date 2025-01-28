import java.util.Scanner;

public class Sum {
    int sum(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total = total + i;
        }
        return total;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        Sum s = new Sum();
        System.out.println("The sum of n natural numbers is " + s.sum(n));
    }
    
}
