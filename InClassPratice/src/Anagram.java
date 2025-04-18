
import java.util.*;

public class Anagram {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String string1 = sc.nextLine();
        String string2 = sc.nextLine();

        boolean anagram  = true;
        string2 = string2.replaceAll(" ", "");
        
        // kiểm tra từng kí tự của chuỗi 1 có nằm trong chuỗi 2 không
        for (char c : string1.toCharArray()) {
            if (string2.indexOf(c) == -1) {
                anagram  = false;
                break;
            }
            string2 = string2.replaceFirst(String.valueOf(c), "");
        }

        if (anagram ) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
