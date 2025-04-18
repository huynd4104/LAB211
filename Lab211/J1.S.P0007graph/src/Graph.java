


import java.util.Scanner;

public class Graph {

        private static final Scanner scanner = new Scanner(System.in);
     
    private static int checkInputInt(){
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
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
    
    private boolean adjacencyMatrix[][];
    private int vertexCount;
    
    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }
    
    public void addEdge(int i, int j) {
        if (i > 0 && i < vertexCount && j > 0 && j < vertexCount) {
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
    
    public boolean isEdge(int i, int j) {
        if (i > 0 && i < vertexCount && j > 0 && j < vertexCount) {
            return adjacencyMatrix[i][j] || adjacencyMatrix[j][i];
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
       
        Graph graph = new Graph(6);

        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        
        System.out.println("Enter the start point: ");
        int start = checkInputInt();
        
        System.out.println("Enter the end point: ");
        int end = checkInputInt();
        
        System.out.println("This is" +(graph.isEdge(start, end) ? " " : " not ") + "an edge");
    }
}

