
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public void random(int arr[]) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(arr.length);
        }
    }

    public void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public int binarySearch(int arr[], int x, int left, int right) {
        while(left<=right){
            int mid = (left + right)/2;
            if(arr[mid] == x){
                return mid;
            }
            if(x < arr[mid]){
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }
        return -1;
    }
    
    //dùng đệ quy
    public int binarySearchRecursion(int arr[], int x, int left, int right) {
        while(left<=right){
            int mid = (left + right)/2;
            if(arr[mid] == x){
                return mid;
            }
            if(x < arr[mid]){
                return binarySearchRecursion(arr, x, left, mid - 1);
            }
            return binarySearchRecursion(arr, x, mid +1, right);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        validation ob = new validation();
        int n = ob.checkInputInt("Enter number of array: ");
        int arr[] = new int[n];
        obj.random(arr);
        Arrays.sort(arr);
        obj.printArray(arr, "Sorted array: ");
        int x = ob.checkInputInt("Enter search value: ");
        
        int index = obj.binarySearch(arr, x, 0 , n - 1);
        
        if (index == -1) {
            System.out.println("Not found value " + x + " in array");
        } else {
            System.out.println("Found " + x + " at index: " + index);
        }
    }
}
