/*
Ưu tiên trong java
 */
public class Precedence{
    public static void main(String[] args){
        int[] a={4,4};
        int b=1;
        a[b]=b=0;
        System.out.println("a[0]: " + a[0] + "\n" + "a[1]: " + a[1]);
    }
}
