/**
 *
 * @author nguye
 */
import java.util.Arrays;
import java.util.Random;

public class Radix_Sort {

    private int inputSizeOfArray() {
        Validate ob = new Validate();
        return ob.checkInputInt("Enter number of array: ");
    }

    private void random(int n, int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }
    }

    private void countingSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];

        for (int value : arr)
            count[(value / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    private void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortByDigit(arr, exp);
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Radix_Sort obj = new Radix_Sort();
        int n = obj.inputSizeOfArray();
        int[] arr = new int[n];
        obj.random(n, arr);
        obj.printArray(arr, "Unsorted array: ");
        obj.radixSort(arr);
        obj.printArray(arr, "Sorted array: ");
    }
}

