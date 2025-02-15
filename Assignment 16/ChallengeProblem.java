import java.util.Arrays;

public class ChallengeProblem {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int smallest = 1;
        for (int num : nums) {
            if (num == smallest) smallest++;
        }
        return smallest;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;
        System.out.println("First missing positive integer: " + firstMissingPositive(nums));
        Arrays.sort(nums);
        System.out.println("Index of target " + target + ": " + binarySearch(nums, target));
    }
}
