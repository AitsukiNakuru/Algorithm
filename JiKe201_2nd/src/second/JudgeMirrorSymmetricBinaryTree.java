package second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class JudgeMirrorSymmetricBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        ArrayList<Integer> array = new ArrayList<>();
        for (String s : str) {
            array.add(Integer.parseInt(s));
        }
        Tree tree = new Tree(array);
        if (tree.judge()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
class Tree {
    ArrayList<Integer> tree;

    int depth = 1;
    int n = 1;

    public Tree(ArrayList<Integer> tree) {
        this.tree = tree;
    }
    public boolean judge() {
        while (n < tree.size()) {
            LinkedList<Integer> list = new LinkedList<>();
            int end = (int) Math.pow(2, depth);
            if (n + end > tree.size()) {
                return false;
            }
            for (int i = 0 ; i < end/2 ; i++) {
                list.addFirst(tree.get(i+n));
            }
            for (int i = end/2 ; i< end ; i++) {
                if (!Objects.equals(list.pollFirst(), tree.get(i + n))) {
                    return false;
                }
            }
            n += end;
            depth += 1;
        }
        return true;
    }
}
