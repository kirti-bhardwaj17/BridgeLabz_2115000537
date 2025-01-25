import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.println("enter number between 6 and 9");
        int number = sc.nextInt();
        int[] res = new int[10];

        for (int i = 1; i <= 10; i++) {
            res[i - 1] = number * i;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(number + " * " + i + " = " + res[i ]);
        }

    }
}
