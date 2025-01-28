import java.util.Scanner;

public class chocolates {
    public static int[] findchocolates(int chocolates, int students) {
        int each = chocolates / students;
        int remaining = chocolates % students;
        return new int[] { each, remaining };
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter chocolates ");
        int c = sc.nextInt();
        System.out.println("Enter students");
        int s = sc.nextInt();
        int res[] = findchocolates(c, s);
        System.out.println("Chocolates each students gets are "+res[0]+" remaining are  "+res[1]);
    }
    
}
