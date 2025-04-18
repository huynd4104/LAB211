
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);
    private static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0|\\d{1,2}$";

    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
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
                String result = sc.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                // Chuyển đổi chuỗi result thành đối tượng Date theo định dạng dd-MM-yyyy.
                Date date = format.parse(result);
                //Phương thức equalsIgnoreCase() so sánh hai chuỗi đưa ra dựa trên nội dung của chuỗi không phân biệt chữ hoa và chữ thường.

                //SimpleDateFormat.parse(result) chỉ kiểm tra xem chuỗi đầu vào có thể được chuyển đổi thành đối tượng Date hay không. 
                //Nó không kiểm tra xem chuỗi đó có định dạng chính xác hay không. format.format(date) sẽ tạo ra một 
                //chuỗi mới từ đối tượng Date theo định dạng "dd-MM-yyyy". 
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (ParseException ex) { //chuyển đổi chuỗi sang đối tượng fail
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputString(String str) {
        System.out.print(str);
        while (true) {
            String result = sc.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.err.println("Not Empty");
            }
        }
    }

    public static int checkInputInt(String str) {
        System.out.print(str);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputTaskTypeId(String str) {
        System.out.print(str);
        while (true) {
            int n = checkIntLimit(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
            }
            return result;
        }
    }

//    public static String checkInputPlan(String str) {
//        System.out.print(str);
//        while (true) {
//            String result = sc.nextLine().trim();
//            if (result.isEmpty()) {
//                System.err.println("Not empty");
//                //Phương thức matches được sử dụng để kiểm tra xem chuỗi result có khớp với biểu thức chính quy PLAN_VALID hay không.
//            } else if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0 && Double.parseDouble(result) <= 17.5) {
//                return result;
//            } else {
//                System.err.println("Re-input.");
//            }
//        }
//    }
    public static double checkInputPlan(String str, double from) {
        System.out.print(str);
        while (true) {
            String result = sc.nextLine().trim();
            //Double.toString(result) <=> String.valueOf(result)
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0 && Double.parseDouble(result) <= 17.5) {
                if (from == 0 || Double.parseDouble(result) > from) {
                    return Double.parseDouble(result);
                } else {
                    System.err.println("re-input");
                }
            } else {
                System.err.println("Re-input.");
            }
        }
    }
    
        public static boolean checkConflict(ArrayList<Task> list, String requirementName, String date, double planFrom, double planTo ) {
        for (Task task : list) {
            if (task.getRequirementName().equalsIgnoreCase(requirementName) && task.getDate().equals(date)) {
                double taskFrom = task.getPlanFrom();
                double taskTo = task.getPlanTo();
                double newFrom = planFrom;
                double newTo = planTo;
                if ((newFrom >= taskFrom && newFrom < taskTo) || (newTo <= taskTo && newTo > taskFrom)) {
                    System.err.println("Can't add task due to time conflict.");
                    return false;
                }
            }
        }
        return true;
    }
}
