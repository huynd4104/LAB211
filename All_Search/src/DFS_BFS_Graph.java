import java.util.*;

public class DFS_BFS_Graph {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public DFS_BFS_Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // undirected graph
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        System.out.print("BFS traversal starting from vertex " + start + ": ");

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int neighbor : adjList[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS traversal starting from vertex " + start + ": ");
        DFSUtil(start, visited);
        System.out.println();
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        validation ob = new validation();
        int v = ob.checkInputInt("Enter number of vertices: ");
        DFS_BFS_Graph g = new DFS_BFS_Graph(v);

        int e = ob.checkInputInt("Enter number of edges: ");
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < e; i++) {
            System.out.println("Edge " + (i + 1) + ":");
            System.out.print("From: ");
            int from = Integer.parseInt(sc.nextLine());
            System.out.print("To: ");
            int to = Integer.parseInt(sc.nextLine());
            g.addEdge(from, to);
        }

        int start = ob.checkInputInt("Enter start vertex for DFS/BFS: ");
        g.BFS(start);
        g.DFS(start);
    }
}
