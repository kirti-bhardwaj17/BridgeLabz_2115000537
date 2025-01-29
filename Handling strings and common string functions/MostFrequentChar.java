import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentChar {
    public static char findMostFrequentChar(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxCount = 0;
        char mostFrequentChar = ' ';

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            if (freqMap.get(ch) > maxCount) {
                maxCount = freqMap.get(ch);
                mostFrequentChar = ch;
            }
        }
        return mostFrequentChar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        sc.close();

        char result = findMostFrequentChar(input);
        System.out.println("Most Frequent Character: '" + result + "'");
    }
}
