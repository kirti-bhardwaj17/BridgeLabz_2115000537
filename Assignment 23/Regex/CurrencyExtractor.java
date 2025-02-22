import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {
    public List<String> extract(String text) {
        List<String> values = new ArrayList<>();
        String regex = "\\$\\d+\\.\\d{2}|\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }

    public static void main(String[] args) {
        CurrencyExtractor extractor = new CurrencyExtractor();
        List<String> values = extractor.extract("The price is $45.99, and the discount is 10.50.");
        for (String value : values) {
            System.out.println(value);
        }
    }
}
