import java.util.*;
public class Chocolates{
        public static void main(String args[]){
                Scanner sc= new Scanner(System.in);
                int chocolates=sc.nextInt();
                int students = sc.nextInt();
		int chocolatesWithEach = chocolates/students;
		int remaining = chocolates%students;
        System.out.println("The number of chocolates each child gets is "+chocolatesWithEach+" and the number of remaining chocolates are "+remaining);
        }
}
