import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] leftArr = new int[n1], rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    public static int[] generateDataset(int size, int bound) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(bound);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000}; 


        for (int size : sizes) {
            int[] data1 = generateDataset(size, size * 10);
            int[] data2 = Arrays.copyOf(data1, data1.length);
            int[] data3 = Arrays.copyOf(data1, data1.length);

            long start = System.nanoTime();
            bubbleSort(data1);
            long bubbleTime = System.nanoTime() - start;


            start = System.nanoTime();
            mergeSort(data2, 0, data2.length - 1);
            long mergeTime = System.nanoTime() - start;

            
            start = System.nanoTime();
            quickSort(data3, 0, data3.length - 1);
            long quickTime = System.nanoTime() - start;

          
            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort Time: " + (bubbleTime / 1e6) + " ms");
            System.out.println("Merge Sort Time: " + (mergeTime / 1e6) + " ms");
            System.out.println("Quick Sort Time: " + (quickTime / 1e6) + " ms");
            System.out.println("--------------------------------------");
        }
    }
}
