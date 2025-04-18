//getMessage(): Trả về một message cụ thể về exception đã xảy ra. 
public class NgoaiLe {
        public static void main(String[] args) {
        try {
            int mang[] = new int[5];
            mang[6] = 27 / 0;
        }
        catch (ArithmeticException a) {
            System.out.println(a.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException a) {
            System.out.println(a.getMessage());
        }
    }
}


//Trong ví dụ này, có thể xảy ra hai trường hợp ngoại lệ:
//
//ArithmeticException vì chúng ta đang cố gắng chia một số cho 0.
//ArrayIndexOutOfBoundsException vì chúng ta đã khai báo một mảng số nguyên mới với giới hạn mảng từ 0 đến 4 
//và chúng ta đang cố gắng truy cập vào phần tử thứ 7 là mang[6].
