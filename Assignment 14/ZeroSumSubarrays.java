import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<int[]> subarrays = findZeroSumSubarrays(nums);
        
        for (int[] subarray : subarrays) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}
