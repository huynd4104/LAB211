/*
Nhập mảng ma trận
*/
import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("m[%d][%d]=", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix inputted:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " "); // khoảng trắng thì "\t"
            }
            System.out.println();
        }

        //sum and average
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j];
            }
        }
        double average = (double) sum / (rows * columns);

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        sc.close();
    }
}

