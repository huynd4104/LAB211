import java.util.Random;
import java.util.Arrays;

public class Insertion_sort {
    
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


    private  int[] sortArrayByInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length ; ++i) {
            int key = arr[i];
            int pos = i - 1; //xem là chỉ mục tạm thời mà mình sẽ chọn để gán key

            /*So sánh key với mỗi phần tử ở bên trái của nó cho đến khi phần tử nhỏ hơn 
        nó được tìm thấy. Để có thứ tự giảm dần, hãy đổi key<array[j] thành key>array[j]. */
            while (pos >= 0 && key < arr[pos]) {    //j>=0 để ko duyệt ra bên ngoài mảng 
                arr[pos + 1] = arr[pos];
                pos = pos - 1;  //--pos;
            }
            arr[pos + 1] = key;
        }
        return arr;
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Insertion_sort obj = new Insertion_sort();
        int n = obj.inputSizeOfArray();
        int arr[] = new int[n];
        obj.random(n, arr);
        obj.printArray(arr, "Unsorted array: ");
        int[] sortedArr = obj.sortArrayByInsertionSort(arr);
        obj.printArray(sortedArr, "Sorted array: ");
    }
}
