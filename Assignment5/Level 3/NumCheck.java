public class NumCheck {

    public static int countDigits(int number) {
        return Integer.toString(number).length();
    }

    public static int[] getDigitsArray(int number) {
        String numStr = Integer.toString(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static int sumOfDigits(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static double sumOfSquaresOfDigits(int number) {
        int[] digits = getDigitsArray(number);
        double sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        int sum = sumOfDigits(number);
        return number % sum == 0;
    }

    public static int[][] frequencyOfDigits(int number) {
        int[] digits = getDigitsArray(number);
        int[][] frequency = new int[10][2]; // Digits 0-9, and frequency
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]][0] = digits[i]; // Store digit
            frequency[digits[i]][1]++; // Increment frequency
        }
        return frequency;
    }

    public static void main(String[] args) {
        int[] testNumbers = {21, 123, 56, 411, 555};

        for (int number : testNumbers) {
            System.out.println("Number: " + number);

            System.out.println("Count of Digits: " + countDigits(number));
            System.out.print("Digits Array: ");
            int[] digits = getDigitsArray(number);
            for (int digit : digits) {
                System.out.print(digit + " ");
            }
            System.out.println();

            System.out.println("Sum of Digits: " + sumOfDigits(number));
            System.out.println("Sum of Squares of Digits: " + sumOfSquaresOfDigits(number));
            System.out.println("Is Harshad Number: " + isHarshadNumber(number));

            System.out.println("Frequency of Digits:");
            int[][] freq = frequencyOfDigits(number);
            for (int i = 0; i < 10; i++) {
                if (freq[i][1] > 0) {
                    System.out.println("Digit: " + freq[i][0] + " Frequency: " + freq[i][1]);
                }
            }

            System.out.println("-------------------");
        }
    }
}
