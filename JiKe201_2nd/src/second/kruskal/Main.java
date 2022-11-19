package second.kruskal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Edge> edgeList = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0 ; i < m ; i++) {
            edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        for (int i = 0 ; i <= n ; i++) {
            nodeList.add(new Node(i));
        }
        Graph graph = new Graph(edgeList, nodeList);
        int cost = graph.kruskal();
        if (cost == -1) {
            System.out.println("Imp");
        } else {
            System.out.println(cost);
        }
    }
}
class Node {
    int index;
    int parent;

    public Node(int index) {
        this.index = index;
        this.parent = index;
    }

    public boolean isParent() {
        return index == parent;
    }
}
class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
class Graph {
    PriorityQueue<Edge> edgeList;
    ArrayList<Node> nodeList;


    public Graph(PriorityQueue<Edge> edgeList, ArrayList<Node> nodeList) {
        this.edgeList = edgeList;
        this.nodeList = nodeList;
    }

    public void union(int child, int parent) {
        nodeList.get(child).parent = parent;
    }
    public void union(Edge edge) {
        nodeList.get(edge.start).parent = edge.end;
    }
    public int find(int index) {
        if (nodeList.get(index).isParent()) {
            return index;
        } else {
            nodeList.get(index).parent = find(nodeList.get(index).parent);
            return nodeList.get(index).parent;
        }
    }
    public boolean judge(Edge edge) {
        return find(edge.start) == find(edge.end);
    }
    public int kruskal() {
        int count = 0;
        int cost = 0;
        for (Edge edge : edgeList) {
            if (!judge(edge)) {
                union(edge);
                count += 1;
                cost += edge.weight;
            }
        }
        if (count < nodeList.size() - 2) {
            return -1;
        } else {
            return cost;
        }
    }
}
