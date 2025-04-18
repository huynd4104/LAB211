
import java.util.Scanner;

public class Validation {

    public static Scanner sc = new Scanner(System.in);

    //nhập số nguyên
    public static int getInt(String str, int min, int max) {
        while (true) {
            System.out.print(str);
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (min <= n && n <= max) {
                    return n;
                }
                System.err.println("Out of range, your number must from: " + min + " to " + max);
            } catch (NumberFormatException e) {
                System.out.println("Wrong format, please input an integer");
            }
        }
    }

    //nhập số thực
    public static double getDouble(String str, double min, double max) {
        while (true) {
            System.out.print(str);
            try {
                double n = Double.parseDouble(sc.nextLine().trim());
                if (min <= n && n <= max) {
                    return n;
                }
                System.err.println("Out of range, your number must from: " + min + " to " + max);
            } catch (NumberFormatException e) {
                System.out.println("Wrong format, please input a real number");
            }
        }
    }
    //nhập chuỗi

    public static String getString(String str, String err) {
        while (true) {
            System.out.print(str);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s; //nếu khác rỗng nghĩa là nó là chuỗi hợp lệ, return ra và kết thúc
            }
            System.err.println(err); //err giống out nhưng dùng thông báo lỗi
        }
    }
    //nhập đúng format, vd phải viết hoa,...
    //chữ D bắt đầu và theo sau là 5 ký tự số
    //thì regex gán vào là regex = "D\\d{5}$"
    //hoặc theo sau là 3-5 => regex = "D\\d{3,5}$"

    public static String getStringregex(String str, String regex, String err) {
        while (true) {
            System.out.print(str);
            String s = sc.nextLine();
            if (!s.isEmpty() && s.matches(regex)) {
                return s;
            }
            System.err.print(err);
        }
    }

}
