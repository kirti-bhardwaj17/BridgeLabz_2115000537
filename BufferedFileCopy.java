import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\Kirti Bhardwaj\\Desktop\\largefile.txt";
        String destinationBuffered = "C:\\Users\\Kirti Bhardwaj\\Documents\\python\\buffered_copy.txt";
        String destinationUnbuffered = "C:\\Users\\Kirti Bhardwaj\\Documents\\python\\unbuffered_copy.txt";

        long startBuffered = System.nanoTime();
        copyUsingBufferedStream(sourceFile, destinationBuffered);
        long endBuffered = System.nanoTime();
        System.out.println("Buffered Copy Time: " + (endBuffered - startBuffered) / 1e6 + " ms");

        long startUnbuffered = System.nanoTime();
        copyUsingUnbufferedStream(sourceFile, destinationUnbuffered);
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered Copy Time: " + (endUnbuffered - startUnbuffered) / 1e6 + " ms");
    }

    public static void copyUsingBufferedStream(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered copy completed.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void copyUsingUnbufferedStream(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Unbuffered copy completed.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
