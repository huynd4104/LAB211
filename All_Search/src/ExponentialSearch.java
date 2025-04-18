import java.util.Arrays;
import java.util.Random;

public class ExponentialSearch {

    public int binarySearch(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public int exponentialSearch(int[] arr, int x) {
        if (arr[0] == x) return 0;
        int i = 1;
        while (i < arr.length && arr[i] <= x) i *= 2;
        return binarySearch(arr, i / 2, Math.min(i, arr.length - 1), x);
    }

    public static void main(String[] args) {
        validation ob = new validation();
        ExponentialSearch es = new ExponentialSearch();
        int n = ob.checkInputInt("Enter number of array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i * 2;
        System.out.println("Array: " + Arrays.toString(arr));
        int x = ob.checkInputInt("Enter search value: ");
        int index = es.exponentialSearch(arr, x);
        System.out.println(index == -1 ? "Not found" : "Found at index " + index);
    }
}
