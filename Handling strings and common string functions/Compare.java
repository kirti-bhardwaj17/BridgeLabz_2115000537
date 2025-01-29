import java.util.Scanner;

public class Compare {
    public static int compareStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return -1; // str1 comes before str2
            } else if (str1.charAt(i) > str2.charAt(i)) {
                return 1; // str1 comes after str2
            }
        }

        // If all characters are the same, compare lengths
        if (len1 < len2) return -1;
        if (len1 > len2) return 1;
        return 0; // Both strings are equal
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        sc.close();

        int result = compareStrings(str1, str2);

        if (result < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
        } else if (result > 0) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order.");
        } else {
            System.out.println("Both strings are equal.");
        }
    }
}
