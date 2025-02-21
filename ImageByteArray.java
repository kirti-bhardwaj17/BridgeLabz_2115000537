import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        String sourceImage = "C:\\Users\\Kirti Bhardwaj\\Pictures\\Screenshots\\IMG_20210429_163149.jpg";
        String destinationImage = "C:\\Users\\Kirti Bhardwaj\\Pictures\\Screenshots\\Screenshot 2024-05-19 231254.png";

        byte[] imageData = convertImageToByteArray(sourceImage);
        if (imageData != null) {
            writeByteArrayToImage(imageData, destinationImage);
            System.out.println("Image copied successfully.");
        }
    }

    public static byte[] convertImageToByteArray(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static void writeByteArrayToImage(byte[] imageData, String filePath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
