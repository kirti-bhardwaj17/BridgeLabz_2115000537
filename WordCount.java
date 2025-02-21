import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";
        countWords(filePath);
    }

    public static void countWords(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
            sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("Total unique words: " + wordCountMap.size());
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                System.out.println(sortedWords.get(i).getKey() + " - " + sortedWords.get(i).getValue());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

