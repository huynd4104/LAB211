
//1. Giải thích code
import java.util.Scanner; //Thư viện dùng để nhập dữ liệu từ bàn phím
import java.util.Random; //Thư viện để tạo số ngẫu nhiên
import java.util.Arrays; //Thư viện để sử lý mảng

public class giaithichcode {
    
//Tạo đối tượng Scanner tên sc để đọc dữ liệu từ bàn phím.
    private static final Scanner sc = new Scanner(System.in);
    /*
    - private: Đảm bảo rằng đối tượng Scanner chỉ có thể được truy cập và sử dụng bên trong lớp hiện tại 
    - static: Cho phép đối tượng Scanner được chia sẻ giữa tất cả các phương thức của lớp.
    Việc này đảm bảo rằng tất cả các phương thức sử dụng cùng một đối tượng Scanner thay vì tạo ra 
    nhiều đối tượng Scanner riêng lẻ.
    - final: ngăn chặn đối tượng Scanner được gán lại, giúp đảm bảo tính nhất quán.
    */
    
/*Đoạn code dưới có tên gọi thuật ngữ là validate. Hầu như mọi bài code lab đều cần có phần này. 
  Đối với những bài dài sử dụng tính kế thừa, đa hình, bạn cần tạo một class validate riêng. 
  Bubble sort rất đơn giản nên có thể để chung trong 1 class. 
  Phương thức checkInputInt dùng để kiểm tra và nhập một số nguyên dương từ bàn phím. 
  Nếu người dùng nhập vào không phải số nguyên dương, 
  chương trình sẽ yêu cầu nhập lại cho đến khi nhập đúng.
*/
    private static int checkInputInt(){
        while (true) {
            //sử dụng try catch để bắt ngoại lệ, nếu bạn quên cách sử dụng, hãy tham khảo đường link video phần tài liệu thao khảo.
            //sử lý ngoại lệ NumberFormatException
            try {
                //sc.nextLine()để nhập vào số dạng string từ bàn phím 
                //trim()để cắt bỏ khoảng trắng thừa đầu đuôi 
                //Integer.parseInt để chuyển kiểu string sang int 
                int result = Integer.parseInt(sc.nextLine().trim());
                /*Đề bài yêu cầu bạn dùng bubble sort sắp sếp 1 mảng random, vì số các phần tử mảng phải > 0
                  Kiểm tra giá trị số nguyên sau khi đó
                  Nếu điều kiện kiểm tra đúng(result <= 0) thì một NumberFormatException sẽ được ném ra để vòng lặp tiếp tục
                  NumberFormatException là một lớp ngoại lệ (exception class) trong Java. 
                  Nó được sử dụng để biểu thị rằng một chuỗi không thể chuyển đổi thành một kiểu số hợp lệ.
                */
                if (result <= 0){
                    throw new NumberFormatException();
                } 
                return result;
            }
            /*
         throw new được dùng để ném ra 1 ngoại lệ NumberFormatException nếu result<=0 đúng
         Khi ngoại lệ được ném ra thì luồng chương trình hiện tại sẽ dừng lại và chuyển quyền điều khiển cho khối catch tương ứng
         Khi một ngoại lệ được ném ra, nó sẽ được bắt bởi khối catch
         Ngoại lệ sẽ được xử lí trong khối catch. Sau khi xử lý ngoại lệ trong khối catch, việc kiểm tra điều kiện vòng lặp 
         while(true) sẽ được thực hiện lại, và vòng lặp sẽ tiếp tục cho đến khi người dùng nhập đúng giá trị số nguyên dương.
            */
            catch (NumberFormatException e) {
                System.out.println("Please input an positive number !");
                System.out.print("Enter again: ");
            }
        }
    }
   
    //Phương thức dùng để nhập số lượng phần tử của mảng từ bàn phím.
    private static int inputSizeOfArray() {          
        System.out.println("Enter number of array: ");
        return checkInputInt();
    }
    
    //Phương thức dùng để sinh ngẫu nhiên các phần tử trong mảng với giá trị từ 1 đến 9.
    //Phương thức không trả về bất kì giá trị nào thì dùng void
    private static void random(int arr[]){
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {   
        arr[i] = rand.nextInt(10)+1;      //rand.nextInt... gán một số nguyên ngẫu nhiên từ 1 đến 9 cho phần tử thứ i của mảng arr.           
        }
    }

    /*
    Phương thức này thực hiện sắp xếp mảng số nguyên đầu vào bằng phương pháp Bubble Sort(nổi bọt). 
    Đây sẽ là đoạn code quan trọng nhất của bài này, giáo viên sẽ tập trung hỏi bạn cách vận hành của nó.
    Vì vậy bạn nên hiểu thật kĩ đoạn code sau đó mới check và reviews.
    */
    //Kiểu trả về là một mảng số nguyên nên phải dùng int[]
    private static int[] sortArrayByBubbleSort(int[] arr) {
        /*
        Cách vận hành như sau:
        Phương pháp Bubble Sort hoạt động bằng cách so sánh từng cặp phần tử liền kề của mảng, 
        nếu phần tử sau nhỏ hơn phần tử trước thì hoán đổi chúng cho nhau. 
        * Sau một lần lặp, ta sẽ tìm được 1 phần tử lớn nhất để đưa nó về cuối mảng.
        Lần lặp tiếp theo i về 0, còn j sẽ giảm đi 1 đơn vị, điều này giúp tiết kiệm tài nguyên và tăng hiệu suất.
        (với mỗi lần tăng giá trị của i, giá trị lớn nhất của j sẽ giảm đi 1 đơn vị)
        Tiếp tục thực hiện quá trình này cho đến khi mảng được sắp xếp hoàn chỉnh.
        */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    
    //Phương thức này được sử dụng để in ra màn hình các phần tử của mảng theo format[x1, x2, x3,...].
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    
    public static void main(String[] args) {
    int n = inputSizeOfArray(); //Yêu cầu người dùng nhập số lượng phần tử của mảng bằng cách gọi hàm
    int arr[] = new int[n]; //Khởi tạo một mảng arr với kích thước đã nhập từ bàn phím.
        random(arr); //Gọi hàm random để sinh ngẫu nhiên các phần tử trong mảng arr.
        System.out.print("Unsorted array: "); //In ra màn hình mảng chưa sắp xếp.
        printArray(arr);
    int[] sortedArr = sortArrayByBubbleSort(arr); //Gọi hàm sortArrayByBubbleSort để sắp xếp mảng arr và lưu kết quả vào một mảng mới sortedArr.
        System.out.print("Sorted array: "); //In ra màn hình mảng đã sắp xếp.
        printArray(sortedArr);
        //Chương trình sau đó sẽ kết thúc và đóng đối tượng Scanner để giải phóng tài nguyên.
        sc.close();
}
}

//2. Tài liệu tham khảo
//Sử dụng try catch: https://www.youtube.com/watch?v=nQXE89sy8QQ
//Cách hoạt động của thuận toán bubble sort: https://www.youtube.com/watch?v=KsbdeXLau08

//3. Lưu ý
//*Để xử đẹp bài này, bạn cầm làm theo trình tự như sau:
//-Đảm bảo rằng bạn đã hiểu kĩ đề bài.
//-Hãy bắt đầu mỗi bài code bằng mục lưu ý, sau đó đến tài liệu tham khảo, cuối cùng mới đến giải thích code.
//-Bubble sort nên là bài được kiểm tra đầu tiên. Hãy đề nghị giáo viên check code cho bạn trước(tùy gv mà họ sẽ có những thay đổi khác nhau),
//sau đó mới nộp bài để review với 100% sự chuẩn bị.
//-Đối với những bài đơn giản 20 loc, thầy cô thường sẽ không yêu cầu sửa code. Tuy nhiên họ sẽ hỏi những câu hỏi liên quan đến bất kì dòng code nào.
//-Một số câu hỏi minh họa:
//+tại sao cần có validate?
//+throw trong phương thức checkInputInt có tác dụng gì?
//+tại sao result cần lớn hơn 0?
//+Integer.parseInt để làm gì?
//+sc.nextLine() là kiểu dữ liệu nào?
//+rand.nextInt(10) có nghĩa là gì?
//+Trình bày cách code của bạn sort mảng bằng bubble sort?
//+Phương thức printArray để làm gì?
//+sc.close() để làm gì?
