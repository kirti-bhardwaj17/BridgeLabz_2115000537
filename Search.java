import java.util.*;

public class Search{
    public static boolean searchInArray(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchInHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    public static boolean searchInTreeSet(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {
      
        int[] sizes = {1000, 100000, 1000000};

        for (int size : sizes) {
            
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i; 
            }

            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < size; i++) {
                hashSet.add(i);
                treeSet.add(i);
            }

            
                        int target = size / 2;
            long start = System.nanoTime();
            searchInArray(array, target);
            long arrayTime = System.nanoTime() - start;

      
            start = System.nanoTime();
            searchInHashSet(hashSet, target);
            long hashSetTime = System.nanoTime() - start;

          
            start = System.nanoTime();
            searchInTreeSet(treeSet, target);
            long treeSetTime = System.nanoTime() - start;

  
            System.out.println("Dataset Size: " + size);
            System.out.println("Array Search Time: " + (arrayTime / 1e6) + " ms");
            System.out.println("HashSet Search Time: " + (hashSetTime / 1e6) + " ms");
            System.out.println("TreeSet Search Time: " + (treeSetTime / 1e6) + " ms");
            System.out.println("--------------------------------------");
        }
    }
}
