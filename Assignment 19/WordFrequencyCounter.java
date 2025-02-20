import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kirti Bhardwaj\\Documents\\python\\hello.txt"));
        Map<String, Integer> wordCount = new HashMap<>();
        String line;
        
        while ((line = br.readLine()) != null) {
            for (String word : line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+")) {
                if (!word.isEmpty()) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        br.close();

        System.out.println(wordCount);
    }
}

