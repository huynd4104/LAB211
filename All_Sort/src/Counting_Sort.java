/**
 *
 * @author nguye
 */
import java.util.Arrays;
import java.util.Random;

public class Counting_Sort {

    private int inputSizeOfArray() {
        Validate ob = new Validate();
        return ob.checkInputInt("Enter number of array: ");
    }

    private void random(int n, int[] arr, int maxValue) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(maxValue + 1);
        }
    }

    private int[] countingSort(int[] arr, int maxValue) {
        int[] count = new int[maxValue + 1];
        int[] output = new int[arr.length];

        for (int num : arr) {
            count[num]++;
        }

        for (int i = 1; i <= maxValue; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Counting_Sort obj = new Counting_Sort();
        int n = obj.inputSizeOfArray();
        int[] arr = new int[n];
        int maxValue = 100; // Adjust as needed
        obj.random(n, arr, maxValue);
        obj.printArray(arr, "Unsorted array: ");
        int[] sorted = obj.countingSort(arr, maxValue);
        obj.printArray(sorted, "Sorted array: ");
    }
}

