import java.util.Scanner;

public class SpringSeason {
    Boolean Season(int m, int d) {
        if (((m==3) &&(d>=20) && (d<=31))||
            ((m==4)&&(d>=1) && (d<=31))||
            ((m==5)&&(d>=1)&&(d<=31))||
                ((m == 6) && (d <= 20))) {
            return true;
            }
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month");
        int m = sc.nextInt();
        System.out.println("Enter the date");
        int d = sc.nextInt();
        SpringSeason s = new SpringSeason();
        if (s.Season(m, d) == true)
            System.out.println("Spring Season");
        else {
            System.out.println("Not spring season");
        }
    }
}