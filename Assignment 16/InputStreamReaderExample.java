import java.io.*;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt"; 

        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
