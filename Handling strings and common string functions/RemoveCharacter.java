import java.util.Scanner;

public class RemoveCharacter {
    public static String removeChar(String str, char ch) {
        return str.replace(String.valueOf(ch), "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("Enter the character to remove: ");
        char ch = sc.next().charAt(0);
        sc.close();

        String result = removeChar(input, ch);
        System.out.println("Modified String: " + result);
    }
}
