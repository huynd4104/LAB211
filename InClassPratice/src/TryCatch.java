/*
ngoại lệ, nếu chương trình kiểm tra nhập vào ko có trong try 
sẽ thực hiện lệnh ở catch
 */

import java.util.Scanner;

public class TryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");

        try {
            int number = scanner.nextInt();
            if (number < 1) {
                System.out.println("The number is invalid.");
            } else {
                System.out.println("The number is " + number + ".");
            }
        } catch (Exception e) {
            System.out.println("The number is invalid.");
        } finally {
            System.out.println("Hoan thanh!");
        }
    }
}
