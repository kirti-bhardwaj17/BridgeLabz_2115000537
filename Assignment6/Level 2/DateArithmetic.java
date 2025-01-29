import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a date (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();
        
        LocalDate date = LocalDate.parse(inputDate);
        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        LocalDate finalDate = updatedDate.minusWeeks(3);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Final date after operations: " + finalDate.format(formatter));

        sc.close();
    }
}
