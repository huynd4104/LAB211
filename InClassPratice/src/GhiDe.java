/*Trong ví dụ, phương thức in_thong_tin() hiện diện trong cả lớp cha sinh_vien và lớp con sinh_vien_y. 
Khi phương thức này được gọi, phương thức của lớp con sẽ được gọi thay vì phương thức trong lớp cha.
*/
class sinh_vien {
    public void in_thong_tin() {
        System.out.println("Sinh vien");
    }
}

class sinh_vien_y extends sinh_vien {

    @Override
    public void in_thong_tin() {
        System.out.println("Sinh vien Truong Y");
    }
}

public class GhiDe {
    public static void main(String[] args) {
        sinh_vien_y sv = new sinh_vien_y();
        sv.in_thong_tin();
    }
}
