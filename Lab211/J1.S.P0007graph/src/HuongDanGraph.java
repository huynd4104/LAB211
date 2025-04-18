//1. Giải thích code
import java.util.Scanner;

public class HuongDanGraph {

        private static final Scanner scanner = new Scanner(System.in);
    
    //Phương thức checkInputInt() dùng để đảm bảo rằng người dùng nhập một số nguyên hợp lệ từ bàn phím. 
    //Nếu người dùng nhập không phải số nguyên hoặc số nguyên không nằm trong khoảng từ 1 đến 5, 
    //phương thức sẽ yêu cầu họ nhập lại cho đến khi nhập đúng     
    private static int checkInputInt(){
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                //Đề bài chỉ cho 5 đỉnh,, nên mình giới hạn từ 1 đến 5 luôn
                if (result < 1 || result > 5){
                    throw new NumberFormatException();
                } 
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number in the graph !");
                System.out.print("Enter again: ");
            }
        }
    }
    
    //Biến adjacencyMatrix là một ma trận hai chiều dùng để biểu diễn ma trận kề của đồ thị. 
    //Ma trận kề là một cấu trúc dữ liệu dùng để lưu trữ thông tin về cách các đỉnh trong đồ thị được kết nối với nhau. 
    //Trong trường hợp này, ma trận này được sử dụng để lưu trữ thông tin về việc có cạnh nối giữa các đỉnh của đồ thị hay không. 
    //Nếu có cạnh nối giữa hai đỉnh i và j, thì adjacencyMatrix[i][j] và adjacencyMatrix[j][i] sẽ có giá trị true, ngược lại sẽ là false.
    private boolean adjacencyMatrix[][];
    
    //Biến vertexCount là một số nguyên dùng để lưu trữ số lượng đỉnh trong đồ thị. 
    //Biến này sẽ được sử dụng trong constructor để khởi tạo ma trận kề và trong các phương thức để kiểm tra 
    //tính hợp lệ của các đỉnh trước khi thêm cạnh hoặc kiểm tra cạnh nối.
    private int vertexCount;

    //Phương thức constructor này của lớp Graph được sử dụng để tạo một đối tượng đồ thị mới. 
    //Đối số vertexCount đại diện cho số lượng đỉnh mà đồ thị này sẽ có.
    
    //public Graph(int vertexCount) {: Đây là khai báo của constructor của lớp Graph, 
    //với một tham số đầu vào là vertexCount (số lượng đỉnh trong đồ thị) được truyền vào khi tạo một đối tượng đồ thị mới.
    public HuongDanGraph(int vertexCount) {
        //Dòng này gán giá trị của biến vertexCount truyền vào từ tham số cho biến thành viên (instance variable) 
        //vertexCount của đối tượng đồ thị hiện tại. Điều này cần thiết để lưu trữ thông tin về số lượng đỉnh trong đồ thị.
        this.vertexCount = vertexCount;
        //Dòng này tạo một ma trận hai chiều adjacencyMatrix với kích thước là vertexCount x vertexCount. 
        //Ma trận này sẽ được sử dụng để lưu trữ thông tin về mối quan hệ giữa các đỉnh trong đồ thị. 
        //Ban đầu, khi đối tượng đồ thị mới được tạo, ma trận này sẽ được khởi tạo với tất cả giá trị false, 
        //tức là không có cạnh nào nối giữa các đỉnh. Sau đó, các cạnh sẽ được thêm vào ma trận này thông qua phương thức 
        //addEdge() để biểu diễn đồ thị.
        adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    //Phương thức addEdge(int i, int j) trong lớp Graph được sử dụng để thêm một cạnh nối giữa hai đỉnh i và j vào đồ thị. 
    
    
    public void addEdge(int i, int j) {
        //Đây là một điều kiện kiểm tra để đảm bảo rằng i và j phải là giá trị hợp lệ trong khoảng từ 1 đến vertexCount - 1. 
        //Nếu i và j không thuộc khoảng này, thì cạnh không thể được thêm vào đồ thị.
        if (i > 0 && i < vertexCount && j > 0 && j < vertexCount) {
            //Nếu i và j hợp lệ, thì hai dòng này sẽ đặt giá trị true cho hai phần tử tương ứng trong ma trận kề adjacencyMatrix. 
            
            //Điều này đồng nghĩa với việc thêm một cạnh nối giữa đỉnh i và j cũng như đỉnh j và i vào đồ thị. 
            //Vì đồ thị là vô hướng (undirected), nên cạnh nối giữa hai đỉnh i và j cũng có nghĩa là cạnh nối giữa j và i, 
            //vì vậy cả hai phần tử đều được thiết lập thành true.
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true;
        }
    }
    
    /*
    Phương thức này là trick để sửa code với giáo viên, khi check code bạn không cần cho vào.
    Khi reviews, có thể giáo viên sẽ yêu cầu bạn code 1 phương thức để remove, lúc đó hãy code lại từ pt addEdge.
    public void removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            adjacencyMatrix[i][j] = false;
            adjacencyMatrix[j][i] = false;
        }
    }
    */
    
    //Phương thức isEdge(int i, int j) trong lớp Graph được sử dụng để kiểm tra xem có cạnh nối giữa hai đỉnh i và j trong đồ thị không.
    public boolean isEdge(int i, int j) {
        //Đây là một điều kiện kiểm tra để đảm bảo rằng i và j phải là giá trị hợp lệ trong khoảng từ 1 đến vertexCount - 1. 
        //Nếu i hoặc j không thuộc khoảng này, phương thức sẽ trả về false ngay lập tức, vì không thể có cạnh nối giữa các đỉnh không hợp lệ.
        if (i > 0 && i < vertexCount && j > 0 && j < vertexCount) {
            //Nếu i và j hợp lệ, phương thức này sẽ kiểm tra giá trị trong ma trận kề adjacencyMatrix tại hai vị trí tương ứng 
            //adjacencyMatrix[i][j] và adjacencyMatrix[j][i]. Nếu một trong hai giá trị này bằng true, 
            //có nghĩa là có cạnh nối giữa i và j hoặc giữa j và i, và phương thức sẽ trả về true. 
            return adjacencyMatrix[i][j] || adjacencyMatrix[j][i];
        } else {
            //Ngược lại, nếu cả hai giá trị này đều là false, có nghĩa là không có cạnh nối giữa hai đỉnh này, và phương thức sẽ trả về false.
            return false;
        }
    }

    public static void main(String[] args) {
        
        //một đối tượng đồ thị Graph mới được tạo với 6 đỉnh
        //ở đây có thể hiểu là tạo 6 đỉnh từ 0 đến 5.Chúng ta sử dụng từ 1 đến 5.
        HuongDanGraph graph = new HuongDanGraph(6);
        
        //Thêm 1 số cạnh vào đồ thị bằng cách sử dụng phương thức addEdge()
        //Điều này có nghĩa là có các cạnh nối giữa các đỉnh sau đây: (1, 4), (2, 4), (2, 5), (3, 5), và (4, 5).
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        
        System.out.println("Enter the start point: ");
        int start = checkInputInt();
        
        System.out.println("Enter the end point: ");
        int end = checkInputInt();
        
        //chương trình sử dụng phương thức isEdge() để kiểm tra xem có cạnh nối giữa điểm đầu và điểm cuối không. 
        //Kết quả được in ra màn hình
        //Nếu có cạnh nối giữa start và end, thì câu thông báo sẽ in "This is" sau đó là một dấu cách, 
        //ngược lại nếu không có cạnh nối thì sẽ in " not" sau đó là " an edge". 
        //Kết quả cuối cùng sẽ hiển thị trạng thái của cạnh nối giữa hai điểm mà người dùng đã nhập.
        System.out.println("This is" +(graph.isEdge(start, end) ? " " : " not ") + "an edge");//cho nay su dung toan tu dieu kien 3 ngoi
    }
}

//2. Tài liệu tham khảo
//-Tham khảo các tài liệu liên quan đến mảng 2 chiều, ma trận kề, đồ thị trong java.

//3. Lưu ý
//-Đọc thật kĩ file đề, đảm bảo rằng bạn đã hiểu nó.
//-Bắt đầu mỗi bài bằng mục lưu ý --> tài liệu tham khảo --> giải thích code --> Câu hỏi minh họa
//-Đây là bài tập yêu cầu độ khéo léo trong khâu reviews. Vì vậy bạn nên ôn tập kĩ ở nhà trước khi submit.
//-Giáo viên dễ tính sẽ không yêu cầu sửa code. Tuy nhiên bạn vẫn cần chuẩn bị cho phần này.

//4. Câu hỏi minh họa:
//+Giải thích cách bạn code bài này?
//+Đồ thị và ma trận kề có liên quan gì đến nhau?
//+Tại sao trong câu lệnh này lại nhập 6 trong khi bài chỉ có 5 đỉnh: HuongDanGraph graph = new HuongDanGraph(6)?
//+Toán tử điều kiện 3 ngôi trong main là gì? giải thích cách hoạt động?
//+giả sử ma trận kề của bạn là dạng 1 chiều. Điều này ảnh hưởng gì đến code của bạn?
//+Thêm phương thức code để xóa phần tử.
//+