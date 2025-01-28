public class Number1 {

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

    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseDigitsArray(digits);
        return areArraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int number) {
        int[] digits = getDigitsArray(number);
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true; // Duck numbers cannot start with 0
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testNumbers = {12321, 120, 101, 567, 8008};

        for (int number : testNumbers) {
            System.out.println("Number: " + number);
            System.out.println("Count of Digits: " + countDigits(number));
            System.out.print("Digits Array: ");
            int[] digits = getDigitsArray(number);
            for (int digit : digits) {
                System.out.print(digit + " ");
            }
            System.out.println();
            System.out.print("Reversed Digits Array: ");
            int[] reversed = reverseDigitsArray(digits);
            for (int digit : reversed) {
                System.out.print(digit + " ");
            }
            System.out.println();
            System.out.println("Is Palindrome: " + isPalindrome(number));
            System.out.println("Is Duck Number: " + isDuckNumber(number));
            System.out.println("-------------------");
        }
    }
}
