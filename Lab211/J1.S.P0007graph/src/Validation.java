
import java.util.Scanner;

public class Validation {
    private  final Scanner sc = new Scanner(System.in);

    public  String checkInput(String str, String err) {

        while (true) {
            System.out.print(str);
            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input; // Thoát khỏi vòng lặp khi đầu vào hợp lệ
            } else {
                System.out.println(err);
            }
        }
    }
}

//import java.util.Scanner;
//
//public class Validation {
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static String checkInput(String str, String err) {
//        String input = "";
//        boolean isValid = false;
//
//        while (!isValid) {
//            System.out.print(str);
//            input = scanner.nextLine().trim();
//
//            if (!input.isEmpty()) {
//                isValid = true;
//            } else {
//                System.out.println(err);
//            }
//        }
//
//        return input;
//    }
//}

