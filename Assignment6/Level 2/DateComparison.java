import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter first date (yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(sc.next());

        System.out.println("Enter second date (yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(sc.next());

        if (date1.isBefore(date2)) {
            System.out.println("The first date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("The first date is after the second date.");
        } else {
            System.out.println("Both dates are the same.");
        }
        
        sc.close();
    }
}
