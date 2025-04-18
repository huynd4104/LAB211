
import java.util.*;

public class ChuoiKyTu {
        public static void main(String[] args) {
            
//1. Nối chuỗi bằng concat
System.out.println("VD1:");
            String chuoi1 = "Xin chao ";
            String chuoi2 = chuoi1.concat("Hello");
            String chuoi3 = "World";
            System.out.println(chuoi2);
        
//2. Nối chuỗi bằng dấu cộng
System.out.println("VD2:");
            System.out.println(chuoi1 + chuoi3);
        
//3. So sánh 2 chuỗi bằng equals
System.out.println("VD3:");
            String string1 = "Xin chao";
            String string2 = "Xin chao";
            String string3 = "XIN CHAO";
            boolean kq = string2.equals(string1);
            System.out.println(kq);
            System.out.println(string1.equalsIgnoreCase(string3)); //ko qtam chữ hoa chữ thường
            
 //4. Cắt lấy một đoạn trong chuỗi substring(start,end)
 System.out.println("VD4:");
            String s = "Hello I'm Java";
            System.out.println(s.substring(5));   //I'm Java(lấy từ vtri khe đc chọn đến hết)
            System.out.println(s.substring(0, 2));//He
       
 //5. Thay thế tất cả kí tự trong chuỗi thành kí tự hoặc chuỗi mới bằng replcae  //replace() có thể nhận tham số truyền vào như là ký tự hoặc là chuỗi.
  System.out.println("VD5:");
            String s1 = "nguyen nguyen huy";
            String chuoimoi1 = s1.replace('n', 't');//thay thế 'n' thành 't'  
            String chuoimoi2 = s1.replace("nguyen", "huy");
            System.out.println(chuoimoi1);
            System.out.println(chuoimoi2);
            
            //Thay thế kí tự xuất hiện lần đâu
            String chuoimoi4 = s1.replaceFirst("nguyen", "huy");
            System.out.println(chuoimoi4);
            
            //xóa khoảng trắng bằng replaceAll  //Phương thức replaceAll() nhận tham số vào như một chuỗi.
            String chuoimoi3 = s1.replaceAll(" ", "");
            System.out.println(chuoimoi3);
            
 //6. Trả về gtri Char của chuỗi tại vtri được chọn, tính từ 0 bằng charAt
System.out.println("VD6:");
            String name = "hello java";
            char ch = name.charAt(1);
            System.out.println(ch); //e
 
//7. Trả về vị trí của kí tự hoặc chuỗi con được chọn trong chuỗi, tính từ 0 bằng indexOf, nếu không có thì in ra -1
System.out.println("VD7:");
            String s2 = "this is index of example";
            //Truyền vào chuỗi con
            int index1 = s2.indexOf("is");
            System.out.println(index1);  //2
            //Truyền vào giá trị Char
            int index2 = s2.indexOf('s');
            System.out.println(index2); //3 
       
//8. So sánh 2 chuỗi bằng compareTo(), chuỗi sau lớn hơn thì trả về dương, bé hơn trả về âm, bằng nhau trả về 0
System.out.println("VD8:");
            String test1 = "hello";
            String test2 = "hello";
            String test3 = "meklo";
            String test4 = "hemlo";
            System.out.println(test1.compareTo(test2));
            System.out.println(test1.compareTo(test3));
            System.out.println(test4.compareTo(test1));
       
//9. Loại bỏ khoảng trắng ở đầu và cuối bằng trim
System.out.println("VD9:");
            String space = "  hello string   ";
            System.out.println(space + "java");
            System.out.println(space.trim() + "java");
       
//10. Chuyển đổi chuỗi thành các mảng ký tự bằng toCharArray 
System.out.println("VD10:");
            String chuoi = "hello";
            char[] d = chuoi.toCharArray();
            for (int i = 0; i < d.length; i++) {
                System.out.print(d[i] + " ");
            }
System.out.println();
//11. Chuyển đổi kiểu dữ liệu khác thành chuỗi bằng valueOf  
System.out.println("VD11:");
            int value = 30;
            String taochuoi = String.valueOf(value);
            System.out.println(taochuoi + 10);  //3010
 
//12. Tìm kiếm kí tự có trong chuỗi không bằng contains
System.out.println("VD12:");
            String namex = "tim trong cai chuoi nay nay";
            System.out.println(namex.contains("tim"));     //true
            System.out.println(namex.contains("trong"));  //true
            System.out.println(namex.contains("hello"));  //false
  
//13. Kiểm tra chuỗi kết thúc với gì, bắt đầu với gì
System.out.println("VD13:");
            String namey = "hello java";
            System.out.println(namey.endsWith("v"));       //false
            System.out.println(namey.endsWith("java"));  //true
            System.out.println(namey.startsWith("hello")); //true
            
//13. Nối chuỗi bằng dấu phân tách tùy ý (demiliter)
System.out.println("VD14:");
            String joinString1 = String.join(" ", "welcome", "to", "java");
            System.out.println(joinString1);
            
//14. Sắp xếp mảng bằng Arrays.sort(), đảo mảng
System.out.println("VD15:");
            int[] array = {5, 3, 1, 4, 2, 6, 3};
            int[] arraycopy = Arrays.copyOf(array, array.length);

            Arrays.sort(array);
            for (int x : array) {
                System.out.print(x + " ");
            }
            //System.out.println(Arrays.toString(array));

            System.out.println();
            // đảo mảng:
            for (int i = 0, j = array.length - 1; i < j; i++, j--) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            System.out.println(Arrays.toString(array));
            // chỉ sắp xếp từ index nào đến index nào
            Arrays.sort(arraycopy, 1, 5);
            for (int x : arraycopy) {
                System.out.print(x + " ");
            }
            System.out.println();
          
       }
}
