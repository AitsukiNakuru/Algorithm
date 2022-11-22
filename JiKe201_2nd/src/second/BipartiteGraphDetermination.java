package second;

import java.util.*;


public class BipartiteGraphDetermination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Dot> dotList = new ArrayList<>();
        for (int i = 0 ; i <= n ; i++) {
            dotList.add(new Dot(i));
        }
        for (int i = 0 ; i < m ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            dotList.get(start).adjoinList.addLast(end);
            dotList.get(end).adjoinList.addLast(start);
        }

        Graph graph = new Graph(dotList);

        for (int i = 1 ; i <= n ; i++) {
            if (!graph.changeFlag(i)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}

class Dot {
    int index;
    int flag = 0;
    LinkedList<Integer> adjoinList;

    public Dot(int index) {
        this.index = index;
        adjoinList = new LinkedList<>();
    }
}
class Graph {
    ArrayList<Dot> dotList;

    public Graph(ArrayList<Dot> dotList) {
        this.dotList = dotList;
    }

    public boolean changeFlag(int index) {
        Dot dot = dotList.get(index);
        if (dot.flag == 0) {
            dotList.get(index).flag = 1;
        }
        for (Integer integer : dot.adjoinList) {
            if (dotList.get(integer).flag == 0) {
                dotList.get(integer).flag = dot.flag * -1;
                changeFlag(integer);
            } else if (dotList.get(integer).flag == dot.flag) {
                return false;
            }
        }
        return true;
    }
}



