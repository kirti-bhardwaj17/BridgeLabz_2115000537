import java.util.regex.*;
import java.util.*;

public class RepeatingWordFinder {
    public List<String> findRepeats(String text) {
        List<String> repeats = new ArrayList<>();
        String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            repeats.add(matcher.group(1));
        }
        return repeats;
    }

    public static void main(String[] args) {
        RepeatingWordFinder finder = new RepeatingWordFinder();
        List<String> repeats = finder.findRepeats("This is is a repeated repeated word test.");
        for (String word : repeats) {
            System.out.println(word);
        }
    }
}
