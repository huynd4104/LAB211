class sinh_vien {
    private int ID_sv = 2;
    public void in_thong_tin() {
        System.out.println(ID_sv);
    }
}

public class Class_Object {
        public static void main(String[] args) {
        sinh_vien object1 = new sinh_vien(); //object chứa các phương thức của lớp sinh_vien
        object1.in_thong_tin();
    }
}
