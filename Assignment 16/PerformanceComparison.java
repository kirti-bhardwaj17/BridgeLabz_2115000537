import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilders();
        compareFileReaders("C:\\Users\\Kirti Bhardwaj\\Desktop\\hellokirti.txt");
    }

    public static void compareStringBuilders() {
        String text = "hello";
        int iterations = 1_000_000;

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void compareFileReaders(String filePath) {
        long startTime, endTime, wordCount;

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            startTime = System.nanoTime();
            wordCount = countWords(br);
            endTime = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            startTime = System.nanoTime();
            wordCount = countWords(br);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }

    private static long countWords(BufferedReader br) throws IOException {
        long count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            count += line.split("\\s+").length;
        }
        return count;
    }
}
