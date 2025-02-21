import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";
        readFileAndFilterErrors(filePath);
    }

    public static void readFileAndFilterErrors(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
