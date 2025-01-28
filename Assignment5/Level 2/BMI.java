import java.util.*;
public class BMI {
    public static void calculate(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][2] = arr[i][1] / ((arr[i][0]) * arr[i][0]);
        }

    }

    public static void status(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][2] >= 40)
                System.out.println((i+1) + " person is obese");
            else if (arr[i][2] <= 39 && arr[i][2] >= 25)
                System.out.println((i+1) + " person is overweight");
            else if (arr[i][2] <= 24 && arr[i][2] >= 18.5)
                System.out.println((i+1) + " person is normal");
            else
                System.out.println((i+1) + " person is underweight");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double arr[][] = new double[10][3];
    for (int i = 0; i < 10; i++) {
            System.out.println("Enter height (in meters) and weight (in kg) for person " + (i + 1) + ":");
            arr[i][0] = sc.nextDouble(); // Height
            arr[i][1] = sc.nextDouble(); // Weight
        }

        calculate(arr);
        status(arr);
    }
}