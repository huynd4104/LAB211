import java.util.Random;
import java.util.Arrays;

public class selection_sort {
    
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

    private int[] sortArrayBySelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            // Gán chỉ mục đầu mảng là nhỏ nhất
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        selection_sort obj = new selection_sort();
        int n = obj.inputSizeOfArray();
        int arr[] = new int[n];
        obj.random(n, arr);
        obj.printArray(arr, "Unsorted array: ");
        int[] sortedArr = obj.sortArrayBySelectionSort(arr);
        obj.printArray(sortedArr, "Sorted array: ");
    }
}