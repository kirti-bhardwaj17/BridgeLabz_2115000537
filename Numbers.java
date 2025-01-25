import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double arr[] = new double[10];
        double total = 0.0;
        int i = 0;

        while (true) {
            double n = sc.nextDouble();
            if (n <= 0 || i == 10) {
                break;
            }
            arr[i++] = n;
        }

        for (int j = 0; j < i; j++) {
            System.out.print(arr[j] + " ");
            total += arr[j];
        }

        System.out.println( total);
        sc.close();
    }
}

	
