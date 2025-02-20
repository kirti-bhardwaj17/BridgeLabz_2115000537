import java.util.*;

public class ConvertSetToSortedList {
    public static List<Integer> convertToSortedList(HashSet<Integer> set) {
     
        List<Integer> list = new ArrayList<>();
        for (int num : set) {
            list.add(num);
        }


        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) { 
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        List<Integer> sortedList = convertToSortedList(set);
        System.out.println(sortedList);
    }
}
