// Mock implementation with QuickSort + HeapSort fallback
/**
 *
 * @author nguye
 */
import java.util.*;

public class Intro_Sort {

    private int inputSizeOfArray() {
        Validate ob = new Validate();
        return ob.checkInputInt("Enter number of array: ");
    }

    private void random(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
    }

    private void introSort(int[] arr, int depthLimit) {
        if (arr.length <= 1) return;
        if (depthLimit == 0) {
            Arrays.sort(arr); // fallback to Java's sort (HeapSort in real IntroSort)
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
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

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Intro_Sort obj = new Intro_Sort();
        int n = obj.inputSizeOfArray();
        int[] arr = new int[n];
        obj.random(arr);
        obj.printArray(arr, "Unsorted array: ");
        obj.introSort(arr, 2 * (int)Math.floor(Math.log(n) / Math.log(2)));
        obj.printArray(arr, "Sorted array: ");
    }
}
