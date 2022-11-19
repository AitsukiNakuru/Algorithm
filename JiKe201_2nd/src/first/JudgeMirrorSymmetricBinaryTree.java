package first;

import java.util.*;

public class JudgeMirrorSymmetricBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int depth = 1;
        ArrayList<Integer> num = new ArrayList<>();

        String s=sc.nextLine();
        String[] temp =s.split(" ");//分割字符串，去除空白符
        for (String s1 : temp) {
            num.add(Integer.parseInt(s1)); //String转化为int类型
        }

        int n = 1;
        while (n < num.size()) {
            int end = (int) Math.pow(2, depth);
            if (n+end > num.size()) {
                System.out.println("NO");
                return;
            }
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < end/2; i++) {
                list.addFirst(num.get(i+n));
            }
            for (int i = end/2; i < end ; i++) {
                if (!Objects.equals(list.poll(), num.get(i + n))) {
                    System.out.println("NO");
                    return;
                }
            }
            n+=end;
            depth++;
        }
        System.out.println("YES");
    }
}
