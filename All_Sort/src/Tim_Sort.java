//(Simulation using Java's built-in Arrays.sort)
/**
 *
 * @author nguye
 */
import java.util.Arrays;
import java.util.Random;

public class Tim_Sort {

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

    private void timSort(int[] arr) {
        Arrays.sort(arr); // Java uses TimSort internally
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Tim_Sort obj = new Tim_Sort();
        int n = obj.inputSizeOfArray();
        int[] arr = new int[n];
        obj.random(arr);
        obj.printArray(arr, "Unsorted array: ");
        obj.timSort(arr);
        obj.printArray(arr, "Sorted array: ");
    }
}