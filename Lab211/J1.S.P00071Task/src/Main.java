
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private void addTask(ArrayList<Task> list) {
        int id;
        if (list.size() == 0) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
        }
        System.out.println("---------Add Task--------");
        String requirementName = Validation.checkInputString("Requirement Name: ");
        String taskTypeId = Validation.checkInputTaskTypeId("Task Type: ");
        String date = Validation.checkInputDate("Date: ");
        double planFrom = Validation.checkInputPlan("From: ", 0);
        double planTo = Validation.checkInputPlan("To: ", planFrom);
        String assign = Validation.checkInputString("Assignee: ");
        String reviewer = Validation.checkInputString("Reviewer: ");

        if (Validation.checkConflict(list, requirementName, date, planFrom, planTo)) {
            list.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
            System.err.println("Add Task Success.");
        }
    }

    private void deleteTask(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        System.out.println("-------Del Task------");
        int idToDelete = Validation.checkInputInt("ID: ");

        int findId = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == idToDelete) {
                findId = i;
                break;
            }
        }

        if (findId != -1) {
            list.remove(findId); //findId khác -1, tức đã tìm thấy => Xóa Task khỏi ArrayList tại chỉ số findId.
            System.err.println("Delete success.");
            for (int i = findId; i < list.size(); i++) {
                list.get(i).setId(list.get(i).getId() - 1);
            }
        } else {
            System.err.println("Not found.");
        }
    }

    private void getDataTasks(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.println("---------------------------------------- Task ------------------------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
//                    list.get(i).getId(),
//                    list.get(i).getRequirementName(),
//                    list.get(i).getTaskTypeId(),
//                    list.get(i).getDate(),
//                    list.get(i).getPlanTo() - list.get(i).getPlanFrom(),
//                    list.get(i).getassign(),
//                    list.get(i).getreviewer()
//            );
//        }

//dùng for-each
        for (Task task : list) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskTypeId(),
                    task.getDate(),
                    task.getPlanTo() - task.getPlanFrom(),
                    task.getassign(),
                    task.getreviewer()
            );
        }
    }

    private void display() {
        ArrayList<Task> list = new ArrayList<>();
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validation.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addTask(list);
                    break;
                case 2:
                    deleteTask(list);
                    break;
                case 3:
                    getDataTasks(list);
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main ob = new Main();
        ob.display();
    }
}
