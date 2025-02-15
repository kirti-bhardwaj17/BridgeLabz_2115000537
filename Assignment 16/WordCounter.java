import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        String filePath =  "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";

        String targetWord = "hello";  
        int count = 0;  

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); 
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { 
                        count++;
                    }
                }
            }

            System.out.println("The word '" + targetWord + "' appears " + count + " times.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
