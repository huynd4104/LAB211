/*
Các cách nhập input và in output
 */

import java.util.Scanner;

public class InputOutput {

    public static void main(String[] args) {
        int a[];
        int n, i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        n = Integer.parseInt(sc.nextLine());
        // nhập n là 1 chuỗi và nó sẽ được chuyển thành số nguyên
        a = new int[n]; // tạo mảng a[n]
        for (i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + "/" + n + " element: ");
            a[i] = sc.nextInt();
            // hoặc: a[i]=Integer.parseInt(sc.nextLine());
        }
        System.out.print("Entered values: ");
        for (i = 0; i < n; i++) {
            System.out.format("%5d", a[i]);   //giống printf() trong C
        }
        int S = 0;
        for (int x : a) {
            S += x;
        }
        System.out.println("\nSum of values: " + S);
    }
}
