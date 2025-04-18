
import java.util.ArrayList;
import java.util.Arrays;

public class Array_Mang {
    public static void main(String[] args) {
 
//1. Trả về chuỗi phần tử của mảng bằng toString. 
//Chuỗi này bao gồm tất cả các phần tử được bao quanh trong []. Tất cả các phần tử được phân tách bằng “,”
System.out.println("VD1:");     
        int[] abc = {12, 21, 42, 68};
        System.out.println(Arrays.toString(abc));
        
//2. Thay đổi tất cả các phần tử của mảng thành 1 giá trị chung bằng fill
System.out.println("VD2:");     
        char[] c = new char[10]; 
        Arrays.fill(c, 'H');  
        System.out.println(Arrays.toString(c)); 
        
        String[] str = { "Java", "Concepts", "basic", "Arrays" };
        Arrays.fill(str, "Huy");  
        System.out.println(Arrays.toString(str));
        
//3. Thay thế phần tử trong mảng bằng set, trích phần tử, xóa phần tử
System.out.println("VD3:");   
        ArrayList<String> list = new ArrayList<>();
        list.add("Nguyễn");
        list.add("Danh");
        list.add("Huy");
        list.set(2,"Tài");
        System.out.println(list); 
        
        //Trích từ phần tử nào đến phần tử nào
        System.out.println(list.subList(1, 3));  
        
        //Xóa phần tử
        list.remove(1);
        System.out.println(list);
        System.out.println(list.remove("danh")); //false, vì đã xóa index 1 = "danh"

//4.Sắp xếp mảng tăng dần bằng Arrays.sort(), đảo mảng      
        System.out.println("VD4:");
        int[] arr = {5, 3, 1, 4, 2, 6, 3}; 
        // copy bằng Arrays.copyOf ; copy từ index nào đến index nào bằng copyOfRange()
        int[] arraycopy = Arrays.copyOf(arr, arr.length);
        
        Arrays.sort(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println();
        // đảo mảng:
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
        
        // chỉ sắp xếp từ index nào đến index nào
        Arrays.sort(arraycopy, 1, 5);
        for (int x : arraycopy) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
