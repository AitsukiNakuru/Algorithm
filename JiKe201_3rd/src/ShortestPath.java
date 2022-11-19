import java.util.Scanner;

public class ShortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        double[][] map = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 999999999.0;
            }
        }
        for (int i = 0; i < m; i++) {
            map[sc.nextInt()][sc.nextInt()] = sc.nextDouble();
        }
        Graph graph = new Graph(map, n, a);
        graph.dijkstra();
        System.out.printf("%.2f", graph.dist[b]);
    }
}
class Graph {

    int n;
    int start;
    boolean[] isSelected;
    int[] path;
    double[] dist;
    double[][] map;

    public Graph(double[][] map, int n, int start) {
        this.map = map;
        this.dist = new double[n];
        this.path = new int[n];
        this.n = n;
        this.isSelected = new boolean[n];
        this.start = start;
        for (int i = 0; i < n; i++) {
            dist[i] = map[start][i];
            isSelected[i] = false;
        }
        isSelected[start] = true;
    }

    void dijkstra() {
        for (int i = 0; i < n-1; i++) {
            double minDist = 999999999.0;
            int minNode = 0;
            for (int j = 0; j < n; j++) {
                if (minDist > dist[j] && !isSelected[j]) {
                    minDist = dist[j];
                    minNode = j;
                }
            }
            isSelected[minNode] = true;
            for (int j = 0; j < n; j++) {
                if (dist[j] > dist[minNode] + map[minNode][j]) {
                    dist[j] = dist[minNode] + map[minNode][j];
                    path[j] = minNode;
                }
            }
        }
    }
}

