import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (result.indexOf(String.valueOf(str.charAt(i))) == -1) {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        sc.close();

        String modifiedString = removeDuplicates(str);
        System.out.println("String after removing duplicates: " + modifiedString);
    }
}
