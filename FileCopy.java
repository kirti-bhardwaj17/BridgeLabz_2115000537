import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";
        String destinationFile = "C:\\Users\\Kirti Bhardwaj\\Documents\\python\\hello.txt";
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch (IOException e) {
            System.out.println("Error reading or writing file.");
        }
    }
}
