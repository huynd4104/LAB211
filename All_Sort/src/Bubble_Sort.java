import java.util.Random;
import java.util.Arrays;

public class Bubble_Sort {
    
    private int inputSizeOfArray() {
        Validate ob = new Validate();
        return ob.checkInputInt("Enter number of array: ");
    }

    private void random(int n, int arr[]) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(arr.length);
        }
    }

    private int[] sortArrayByBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Bubble_Sort obj = new Bubble_Sort();
        int n = obj.inputSizeOfArray();
        int arr[] = new int[n];
        obj.random(n, arr);
        obj.printArray(arr, "Unsorted array: ");
        int[] sortedArr = obj.sortArrayByBubbleSort(arr);
        obj.printArray(sortedArr, "Sorted array: ");
    }
}
