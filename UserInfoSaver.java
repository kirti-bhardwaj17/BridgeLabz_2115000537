import java.io.*;

public class UserInfoSaver {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filePath)) {
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            System.out.println("Information saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
