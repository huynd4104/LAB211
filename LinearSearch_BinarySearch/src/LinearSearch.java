
import java.util.Arrays;
import java.util.Random;

public class LinearSearch {

    public int intputSizeOfArray() {
        validation ob = new validation();
        return ob.checkInputInt("Enter number of array: ");
    }

    public int intputSearch() {
        validation ob2 = new validation();
        return ob2.checkInputInt("Enter search value: ");
    }

    public void random(int arr[]) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(arr.length);
        }
    }

    public void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public int linearSearch(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch obj = new LinearSearch();
        int n = obj.intputSizeOfArray();
        int arr[] = new int[n];
        obj.random(arr);
        obj.printArray(arr, "The array: ");
        int x = obj.intputSearch();

        int index = obj.linearSearch(arr, x);

        if (index == -1) {
            System.out.println("Not found value " + x + " in array");
        } else {
            System.out.println("Found " + x + " at index: " + index);
        }
    }
}
