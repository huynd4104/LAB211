
public class StringBufferr {

    public static void main(String args[]) {
 //Nối thêm tham số vào cuối chuỗi bằng append()
 System.out.println("VD1:");
        StringBuffer sb1 = new StringBuffer("Hello ");
        sb1.append("Java");
        System.out.println(sb1);           //Hello Java (khe 0 là trước chữ H)
        
 //Chèn chuỗi vào chuỗi khác từ vị trí khe được chọn bằng insert()
 System.out.println("VD2:");
        StringBuffer sb2 = new StringBuffer("Hello ");
        sb2.insert(1, "Java");   //bắt đầu từ giữa 2 chữ đầu là vtri khe 1
        System.out.println(sb2);           // HJavaello 
        
 //Thay một đoạn từ vtri khe bắt đầu đến khe kết thúc của chuỗi bằng chuỗi khác bằng replace()
 System.out.println("VD3:");
        StringBuffer sb3 = new StringBuffer("Hello");
        sb3.replace(1, 2, "Java");
        System.out.println(sb3);        // HJavalo (thay el bằng java)
        
//Xóa một đoạn từ vtri khe bắt đầu đến khe kết thúc của chuỗi được chọn bằng replace()
 System.out.println("VD4:");
        StringBuffer sb4 = new StringBuffer("Hello");
        sb4.delete(1, 3); //xóa el
        System.out.println(sb4);           // Hlo 
        
//Đảo chuỗi hiện tại
 System.out.println("VD5:");
        StringBuffer sb5 = new StringBuffer("Hello");
        sb5.reverse();
        System.out.println(sb5);//olleH  
        
    }
}
