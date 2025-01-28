import java.util.Scanner;

public class SmallestandLargest {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int largest;
        int smallest;
        if ((number1 > number2) && (number1 > number3)) {
            largest = number1;
        } else if ((number2 > number1) && (number2 > number3)) {
            largest = number2;
        } else {
            largest = number3;
        }
        if ((number1 < number2) && (number1 < number3)) {
            smallest = number1;
        } else if ((number2 < number1) && (number2 < number3)) {
            smallest = number2;
        } else {
            smallest = number3;
        }
        return new int[] { smallest, largest };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter three numbers");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int res[] = findSmallestAndLargest(n1, n2, n3);
        System.out.println("the smallest number is " + res[0] + " the largest number is " + res[1]);
    }
}
