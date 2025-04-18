import java.util.Arrays;
import java.util.Random;

public class JumpSearch {

    public int jumpSearch(int[] arr, int x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) return -1;
        }

        while (arr[prev] < x) {
            prev++;
            if (prev == Math.min(step, n)) return -1;
        }

        return arr[prev] == x ? prev : -1;
    }

    public static void main(String[] args) {
        validation ob = new validation();
        JumpSearch js = new JumpSearch();
        int n = ob.checkInputInt("Enter number of array: ");
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(100);
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        int x = ob.checkInputInt("Enter search value: ");
        int index = js.jumpSearch(arr, x);
        System.out.println(index == -1 ? "Not found" : "Found at index " + index);
    }
}