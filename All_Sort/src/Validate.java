
import java.util.Scanner;

public class Validate {

     Scanner sc = new Scanner(System.in);

    public int checkInputInt(String str) {
        System.out.println(str);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input an positive number !");
                System.out.print("Enter again: ");
            }
        }
    }
}
