import java.io.*;

public class UpperToLowerCase {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";
        String destinationFile = "C:\\Users\\Kirti Bhardwaj\\Documents\\python\\hello.txt";

        convertUppercaseToLowercase(sourceFile, destinationFile);
    }

    public static void convertUppercaseToLowercase(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toLowerCase(character));
            }
            System.out.println("Conversion completed. Check the output file.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
