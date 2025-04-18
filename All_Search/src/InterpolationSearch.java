import java.util.Arrays;
import java.util.Random;

public class InterpolationSearch {

    public int interpolationSearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;

        while (low <= high && x >= arr[low] && x <= arr[high]) {
            int pos = low + ((x - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (arr[pos] == x) return pos;
            if (arr[pos] < x) low = pos + 1;
            else high = pos - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        validation ob = new validation();
        InterpolationSearch is = new InterpolationSearch();
        int n = ob.checkInputInt("Enter number of array: ");
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) arr[i] = i * 3; // uniform distribution
        System.out.println("Array: " + Arrays.toString(arr));
        int x = ob.checkInputInt("Enter search value: ");
        int index = is.interpolationSearch(arr, x);
        System.out.println(index == -1 ? "Not found" : "Found at index " + index);
    }
}
