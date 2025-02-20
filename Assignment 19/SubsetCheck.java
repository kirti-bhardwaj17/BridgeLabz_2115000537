import java.util.*;

public class SubsetCheck {
    public static boolean isSubset(HashSet<Integer> set1, HashSet<Integer> set2) {
        for (int num : set1) {
            if (!set2.contains(num)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println(isSubset(set1, set2));
    }
}
