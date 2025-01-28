public class Football {
    public static void Tallest(int[] heights)
    {
        int tallest = heights[0];
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > tallest)
                tallest = heights[i];
        }
        System.out.println("tallest player is of height " + tallest);

    }
    public static void shortest(int[] heights)
    {
        int shortest = heights[0];
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < shortest)
                shortest = heights[i];
        }
        System.out.println("shortest player is of height " + shortest);

    }

    public static int sum(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        System.out.println("sum of heights " + sum);
        return sum;
    }
    
    public static void mean(int sum) {
        int mean = sum / 11;
        System.out.println("mean of heights " + mean);
        }

    public static void main(String args[]) {
        int heights[] = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int) (Math.random() * 101);
        }
        Tallest(heights);
        shortest(heights);
        sum(heights);
        mean(sum(heights));


    }
}