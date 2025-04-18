
import java.util.StringTokenizer;

/*
Tách chuỗi thành chuỗi con bằng split
 */
public class TachChuoi {

    public static void main(String[] args) {
        String str = "I study hard. So, I pass the examination";
        String[] strs = str.toLowerCase().split("[ ,.]+"); // gặp " ", ",", "." thì tách
        for (String s : strs) {
            char[] strChar = s.toCharArray();
            strChar[0] =  Character.toUpperCase(strChar[0]);
            s = String.valueOf(strChar);
            System.out.print(s +" ");
        }
        
        System.out.println();
        StringTokenizer skt1 = new StringTokenizer(str, "[ ,.]"); // gặp các kí tự này thì ko tính
        System.out.println("Number of substrings: " + skt1.countTokens());
        while (skt1.hasMoreTokens()) {
            System.out.print(skt1.nextToken()+" ");
        }
        
        System.out.println();
        System.out.println();
        StringTokenizer skt2 = new StringTokenizer(str, "[ ,.]", true); // tính cả các kí tự này
        System.out.println("Number of substrings: " + skt2.countTokens());
        while (skt2.hasMoreTokens()) {
            System.out.print(skt2.nextToken());
        }
        System.out.println();
    }
}
