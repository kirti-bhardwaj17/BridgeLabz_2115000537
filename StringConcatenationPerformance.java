public class StringConcatenationPerformance {

    
    public static long testStringConcat(int iterations) {
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a"; 
        }
        return System.nanoTime() - start;
    }

    
    public static long testStringBuilderConcat(int iterations) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        return System.nanoTime() - start;
    }

    
    public static long testStringBufferConcat(int iterations) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; 

        for (int size : sizes) {
            System.out.println("Operations Count: " + size);

            long stringTime = testStringConcat(size);
            System.out.println("String Time: " + (stringTime / 1e6) + " ms");

            long stringBuilderTime = testStringBuilderConcat(size);
            System.out.println("StringBuilder Time: " + (stringBuilderTime / 1e6) + " ms");

            long stringBufferTime = testStringBufferConcat(size);
            System.out.println("StringBuffer Time: " + (stringBufferTime / 1e6) + " ms");

            System.out.println("--------------------------------------");
        }
    }
}
