import java.util.Scanner;
public class Rounds {
    int CalculateRounds(int s1, int s2, int s3) {
        int perimeter = s1 + s2 + s3;
        int rounds = perimeter / 5;
        return rounds;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Eneter side 1");
        int s1 = sc.nextInt();
        System.out.println("Enter side 2 ");
        int s2 = sc.nextInt();
        System.out.println("Enter side 3");
        int s3 = sc.nextInt();
        Rounds r = new Rounds();
        System.out.println("Total rounds are " + r.CalculateRounds(s1, s2, s3));
    }
}
