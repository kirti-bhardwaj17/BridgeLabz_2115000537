import java.util.Scanner;

public class Division {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int q = number / divisor;
        int r = number % divisor;
        return new int[] { q, r };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number ");
        int n = sc.nextInt();
        System.out.println("Enter divisor");
        int d = sc.nextInt();
        int res[] = findRemainderAndQuotient(n, d);
        System.out.println("quotient is "+res[0]+" remainder is "+res[1]);
    }
    
}
