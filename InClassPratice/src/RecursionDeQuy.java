
public class RecursionDeQuy {
        static int phep_cong(int x) {
        if (x != 0)
            return x + phep_cong(x-1);
        else
            return 0;
    }
    public static void main(String[] args) {
        int a = 10, kq;
        kq = phep_cong(a);
        System.out.println(kq); //55
    }
}
