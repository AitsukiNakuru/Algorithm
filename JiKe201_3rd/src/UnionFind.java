//import java.util.*;
//
//public class UnionFind {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int q = sc.nextInt();
//        Graph graph = new Graph(n);
//        for (int i = 0; i < m; i++) {
//            int start = sc.nextInt();
//            int end = sc.nextInt();
//            Edge edge = new Edge(start, end);
//            graph.edgeList.add(edge);
//        }
//        graph.run();
//        for (int i = 0; i < q; i++) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            if (graph.find(u) == graph.find(v)) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
//
//
//    }
//
//}
//class Dot {
//    int index;
//    int parent;
//
//    public Dot(int index) {
//        this.index = index;
//        this.parent = index;
//    }
//}
//class Edge {
//    int start;
//    int end;
//
//    public Edge(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//}
//class Graph {
//    public Graph(int n) {
//        for (int i = 0; i <= n; i++) {
//            this.dotList.add(new Dot(i));
//        }
//    }
//
//    ArrayList<Dot> dotList = new ArrayList<>();
//    LinkedList<Edge> edgeList = new LinkedList<>();
//
//    void run() {
//        while (edgeList.size() > 0) {
//            Edge edge = edgeList.poll();
//            union(edge.start, edge.end);
//        }
//    }
//    int find(int dotIndex) {
//        Dot dot = dotList.get(dotIndex);
//        if (dot.parent != dot.index) {
//            dot.parent = find(dot.parent);
//            dotList.set(dot.index, dot);
//        }
//        return dot.parent;
//    }
//
//    void union(int a, int b) {
//        dotList.get(find(dotList.get(b).index)).parent = find(a);
//    }
//}
