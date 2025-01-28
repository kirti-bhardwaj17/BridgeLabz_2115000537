import java.util.*;
public class SimpleInterest
{
    int Interest(int p, int r, int t) {
        int si = (p * r * t) / 100;
        return si;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int r = sc.nextInt();
        int t = sc.nextInt();
        SimpleInterest obj = new SimpleInterest();
        System.out.println("The Simple Interest is "+ obj.Interest(p, r, t) + " for Principal " + p + ", Rate of Interest "
                + r + " and Time " + t);
    }
}