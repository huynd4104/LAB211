import java.util.Scanner;

public class BubbleSort {

    // Hàm sắp xếp nổi bọt
    // nếu chỉ ghi: void bubbleSort(int arr[]) thì dưới phải có ob.
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
        }
    }

    // In các phần tử của arr
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("Kích thước mảng:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; ++i){
            arr[i] = sc.nextInt();
        }
        System.out.println();
       
        System.out.println("Mảng ban đầu:");
        ob.printArray(arr);
        bubbleSort(arr);
        System.out.println("Mảng sau khi sắp xếp:");
        ob.printArray(arr);
    }
}