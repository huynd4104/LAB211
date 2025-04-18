

import java.util.Scanner;

public class ScanningData {

    public static void main(String args[]) {
        String S = "Anh hùng khó qua mỹ nhân quan";
        Scanner sc1 = new Scanner(S);
        while (sc1.hasNext()) {
            System.out.print(sc1.next() + " ");
        }
        System.out.println();
        String S2 = "abc 123 556.78";
        Scanner sc2 = new Scanner(S2);
        System.out.println(sc2.next());
        System.out.println(sc2.nextInt());
        System.out.println(sc2.nextDouble());
        System.out.println();
        String S3 = "  How are     you!   ";
        String delim = "[au\\a]+";      
        /*  Đây là biểu thức chính quy (regular expression) 
        được sử dụng làm delimiter (dấu phân cách) cho đối tượng Scanner.
    */
        Scanner sc3 = new Scanner(S3);
        sc3.useDelimiter(delim);
        /*
        Đặt delimiter cho đối tượng Scanner sc3 với biểu thức chính quy được định nghĩa ở biến delim. 
        Điều này có nghĩa là Scanner sẽ sử dụng biểu thức chính quy này để xác định cách phân tách (delimit) 
        các phần từ trong chuỗi khi thực hiện các phương thức quét như next().
    */
        while (sc3.hasNext()) {
            System.out.println(sc3.next());
        }
    }
}
