import java.util.Scanner;
import java.lang.Math;
public class StringDemo{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String origin, replaced, replacement;
        System.out.print("Enter original string:");
        origin = sc.nextLine();
        System.out.print("Enter replaced string:");
        replaced = sc.nextLine();
        System.out.print("Enter replacing string:");
        replacement = sc.nextLine();
        origin = origin.replaceAll(replaced, replacement);
        System.out.println("After replacing:" +origin);
        System.out.println("Uppercase:" +origin.toUpperCase());
        System.out.println("Origin:"+origin);
        System.out.println("Enter the index of extracted character:");
        int index=Integer.parseInt(sc.nextLine());
        System.out.format("The %d(th)character:%c\n", index, origin.charAt(index));
    } 
}