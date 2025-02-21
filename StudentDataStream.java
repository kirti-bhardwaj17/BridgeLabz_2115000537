import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";

        saveStudentData(filePath, 101, "Alice", 3.8);
        saveStudentData(filePath, 102, "Bob", 3.6);

        System.out.println("\nRetrieving Student Data:");
        loadStudentData(filePath);
    }

    public static void saveStudentData(String filePath, int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Saved: " + rollNumber + ", " + name + ", " + gpa);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void loadStudentData(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
