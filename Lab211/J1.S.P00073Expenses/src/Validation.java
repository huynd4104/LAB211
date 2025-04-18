
import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Validation {

    private static final Scanner scanner = new Scanner(System.in);

    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputDate(String str) {
        System.out.print(str);
        while (true) {
            try {
                String result = scanner.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputString(String str) {
        System.out.print(str);
        while (true) {
            String result = scanner.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public static int checkInputInt(String str) {
        System.out.print(str);
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static double checkInputDouble(String str) {
        System.out.print(str);
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }
    
    public static boolean checkCoincide(ArrayList<Expenses> list, String date, String content, double amount){
        for(Expenses expense : list){
            if(expense.getDate().equals(date) && expense.getContent().equalsIgnoreCase(content)){
                expense.setAmount(expense.getAmount() + amount);
                System.out.println("amount updated");
                return false;
            }
        }
        return true;
    }
}
