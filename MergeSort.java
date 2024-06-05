
import java.util.Random;
import java.util.Arrays;

public class MergeSort {

    private void random(int n, int arr[]) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(arr.length);
        }
    }

    // Merge hai mảng con của arr[].
    // Mảng con thứ nhất là arr[left ... mid]
    // Mảng con thứ hai là arr[mid+1 ... right]
    private void merge(int[] arr, int left, int mid, int right) {
        // Kích thước của 2 mảng con 
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //Tạo mảng tạm
        int arrL[] = new int[n1];
        int arrR[] = new int[n2];

        //copy dữ liệu vào mảng
        for (int i = 0; i < n1; ++i) {
            arrL[i] = arr[left + i];
        }

        for (int i = 0; i < n2; ++i) {
            arrR[i] = arr[mid + 1 + i];
        }

        //chỉ mục hiện tại của phần tử mảng trái và phải
        int i = 0;
        int j = 0;
        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int result = left;
        while (i < n1 && j < n2) {
            if (arrL[i] <= arrR[j]) {
                arr[result++] = arrL[i++];
            } else {
                arr[result++] = arrR[j++];
            }
        }
        // Sao chép các phần tử còn lại của arrL[] nếu có
        while (i < n1) {
            arr[result++] = arrL[i++];
        }
        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[result++] = arrR[j++];
        }
    }

    private void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            //tìm vị trí ở giữa
            int mid = (left + right) / 2;
            //dùng đệ quy để sort từng phần bên trái và phải
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            //gộp 2 phần lại
            merge(arr, left, mid, right);
        }
    }

    private void printArray(int[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        Validate ob = new Validate();
        int n = ob.checkInputInt("Enter number of array: ");
        int arr[] = new int[n];
        obj.random(n, arr);
        obj.printArray(arr, "Unsorted array: ");
        obj.mergeSort(arr, 0, n - 1);
        obj.printArray(arr, "Sorted array: ");
    }
}
