import java.io.*;

public class FileReadingComparison {

    
    public static long readUsingFileReader(String filePath) throws IOException {
        long start = System.nanoTime();
        FileReader fileReader = new FileReader(filePath);
        int ch;
        while ((ch = fileReader.read()) != -1) {
        }
        fileReader.close();
        return System.nanoTime() - start;
    }

    
    public static long readUsingInputStreamReader(String filePath) throws IOException {
        long start = System.nanoTime();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        int ch;
        while ((ch = inputStreamReader.read()) != -1) {
        }
        inputStreamReader.close();
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
       
        String filePath = "C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt";
 

        try {
            long fileReaderTime = readUsingFileReader(filePath);
            System.out.println("FileReader Time: " + (fileReaderTime / 1e6) + " ms");

            long inputStreamReaderTime = readUsingInputStreamReader(filePath);
            System.out.println("InputStreamReader Time: " + (inputStreamReaderTime / 1e6) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
