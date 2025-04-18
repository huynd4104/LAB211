/**
 *
 * @author nguye
 */
import java.util.Arrays;
import java.util.Random;

public class Shell_Sort {

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

    private void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Shell_Sort obj = new Shell_Sort();
        int n = obj.inputSizeOfArray();
        int[] arr = new int[n];
        obj.random(n, arr);
        obj.printArray(arr, "Unsorted array: ");
        obj.shellSort(arr);
        obj.printArray(arr, "Sorted array: ");
    }
}