/*
Ép kiểu
 */
public class EpkieuTypecasting {

    public static void main(String[] args) {
        short x, y = 256;
        byte n = 6;
        float c = 35.8f;
        long a = 100000L;
        int b = (int) c + 1;
        x = n;
        n = (byte) y;
          
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(x);
        System.out.println("The first byte of 256 is: " + n);
    }
}


