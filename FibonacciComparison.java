public class FibonacciComparison {

    
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testValues = {10, 30, 50}; 

        for (int n : testValues) {
            System.out.println("Fibonacci Number: " + n);
            long start = System.nanoTime();
            try {
                int recursiveResult = fibonacciRecursive(n);
                long recursiveTime = System.nanoTime() - start;
                System.out.println("Recursive Time: " + (recursiveTime / 1e6) + " ms");
            } catch (StackOverflowError e) {
                System.out.println("Recursive computation is infeasible for n = " + n);
            }


            start = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - start;
            System.out.println("Iterative Time: " + (iterativeTime / 1e6) + " ms");

            System.out.println("--------------------------------------");
        }
    }
}
