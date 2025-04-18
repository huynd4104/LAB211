/**
 *
 * @author nguye
 */
import java.util.Arrays;
import java.util.Random;

public class Heap_Sort {

    private int inputSizeOfArray() {
        Validate ob = new Validate();
        return ob.checkInputInt("Enter number of array: ");
    }

    private void random(int n, int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    private void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Heap_Sort obj = new Heap_Sort();
        int n = obj.inputSizeOfArray();
        int[] arr = new int[n];
        obj.random(n, arr);
        obj.printArray(arr, "Unsorted array: ");
        obj.heapSort(arr);
        obj.printArray(arr, "Sorted array: ");
    }
}
