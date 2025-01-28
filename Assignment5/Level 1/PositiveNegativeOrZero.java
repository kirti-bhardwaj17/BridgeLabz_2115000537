import java.util.Scanner;

public class PositiveNegativeOrZero {
    int Check(int n) {
        if (n < 0)
            return -1;
        else if (n > 0)
            return 1;
        else 
            return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PositiveNegativeOrZero obj = new PositiveNegativeOrZero();
        System.out.println("Enter a number");
        int n = sc.nextInt();
        System.out.println(obj.Check(n));        
    }
}
