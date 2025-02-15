public class FirstLastOccurance {
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, first = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                first = mid; 
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                last = mid; 
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 7, 9};
        int target = 4;
        
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        
        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }
}
