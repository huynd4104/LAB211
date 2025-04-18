
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static void addExpense(ArrayList<Expenses> list) {
        String date = Validation.checkInputDate("Enter Date: ");
        double amount = Validation.checkInputDouble("Enter Amount: ");
        String content = Validation.checkInputString("Enter Content: ");

        if (Validation.checkCoincide(list, date, content, amount)) {
            int id;
            if (list.isEmpty()) {
                id = 1;
            } else {
                id = list.get(list.size() - 1).getId() + 1;
            }
            list.add(new Expenses(id, date, amount, content));
        }
    }

    private static void displayExpense(ArrayList<Expenses> list) {
        if (list.isEmpty()) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (Expenses expenses : list) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n",
                    expenses.getId(),
                    expenses.getDate(),
                    expenses.getAmount(),
                    expenses.getContent());
            total += expenses.getAmount();
        }
        System.out.printf("\t\tTotal: %-20.0f\n", total);
    }

    private static void deleteExpense(ArrayList<Expenses> list) {
        if(list.isEmpty()){
            System.out.println("List empty");
            return;
        }
        int idToDelete = Validation.checkInputInt("Enter id: ");
        int findId = -1;

        // Tìm vị trí của expense có id tương ứng trong danh sách
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == idToDelete) {
                findId = i;
                break;
            }
        }

        if (findId != -1) {
            list.remove(findId);
            System.out.println("Deleted success");

            // Cập nhật lại id cho các expense sau expense vừa xóa
            for (int i = findId; i < list.size(); i++) {
                list.get(i).setId(list.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }



    public static void main(String[] args) throws IOException {
            ArrayList<Expenses> list = new ArrayList<>();
            while (true) {
                System.out.println("1. Add an expense");
                System.out.println("2. Display all expenses");
                System.out.println("3. Delete an expense");
                System.out.println("4. Quit");
                System.out.print("Your choice: ");
                int choice = Validation.checkIntLimit(1, 4);
                switch (choice) {
                    case 1:
                        addExpense(list);
                        break;
                    case 2:
                        displayExpense(list);
                        break;
                    case 3:
                        deleteExpense(list);
                        break;
                    case 4:
                        return;
                }
            }
        }
    }
