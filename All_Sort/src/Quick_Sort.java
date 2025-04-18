
import java.util.Random;
import java.util.Arrays;

public class Quick_Sort {

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

    int partition(int arr[], int left, int right) {
        int pivot = arr[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

//từ left -> i-1 : <= pivot
//từ i -> right : >= pivot
    void QuickSort(int arr[], int left, int right) {
        // pi là chỉ mục của chốt, arr[pi] vị trí của chốt
        int i = partition(arr, left, right);
        if (left < i - 1) {
            QuickSort(arr, left, i - 1);
        }
        if (i < right) {
            QuickSort(arr, i, right);
        }
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Quick_Sort obj = new Quick_Sort();
        int n = obj.inputSizeOfArray();
        int arr[] = new int[n];
        obj.random(n, arr);
        obj.printArray(arr, "Unsorted array: ");
        obj.QuickSort(arr, 0, n - 1);
        obj.printArray(arr, "Sorted array: ");
    }
}

