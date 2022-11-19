package second;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfProvinces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] isConnected = new int[n][n];
        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            String[] str = sc.next().split(",");
            for (int j = 0 ; j < n ; j++) {
                isConnected[i][j] = Integer.parseInt(str[j]);
            }
            nodeList.add(new Node(i));
        }
        UnionFind unionFind = new UnionFind(isConnected, nodeList);
        System.out.println(unionFind.count());

    }
}
class Node {
    int index;
    int parent;

    public Node(int index) {
        this.index = index;
        this.parent = index;
    }
}
class UnionFind {
    int[][] isConnected;
    ArrayList<Node> nodeList;
    int count = 0;

    public UnionFind(int[][] isConnected, ArrayList<Node> nodeList) {
        this.isConnected = isConnected;
        this.nodeList = nodeList;
    }

    public void union(int child, int parent) {
        nodeList.get(child).parent = parent;
    }
    public int find(int index) {
        if (nodeList.get(index).parent == nodeList.get(index).index) {
            return nodeList.get(index).index;
        } else {
            nodeList.get(index).parent = find(nodeList.get(index).parent);
            return nodeList.get(index).parent;
        }
    }
    public int count() {
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = i; j < nodeList.size(); j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (Node node : nodeList) {
            if (find(node.index) == node.index) {
                count++;
            }
        }
        return count;
    }
}