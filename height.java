import java.util.*;
public class height {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int heightinCm = sc.nextInt();
        double heightInInches = heightinCm/2.54;
        double heightInFeet= heightInInches/12;
        
        System.out.println("Your Height in cm is "+heightinCm+" while in feet is "+heightInFeet+ " and inches is "+heightInInches);
    }
}
