 //Gọi một phương thức

public class Phuong_Thuc {

    public float trung_binh_cong(float a, float b) {
        float tb = (a + b) / 2;
        return tb;
    }

    public static void in_gia_tri() {
        System.out.println("Khong co tham so nao de in ra!\n");
    }

    public static void in_gia_tri2(int a) {
        System.out.println("Gia tri la: " + a + "\n");
    }

    public static void main(String[] args) {
        float a = 4.1f;
        float b = 5.6f;
        Phuong_Thuc c = new Phuong_Thuc();
        float kq = c.trung_binh_cong(a, b);
        System.out.println(kq+"\n");
        in_gia_tri();
        in_gia_tri2(23);
    }
}
