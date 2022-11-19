package StableMatching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Man> manList = new ArrayList<>();
        ArrayList<Women> womenList = new ArrayList<>();
        LinkedList<Integer> freeManList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Man man = new Man(n, i);
            for (int j = 0; j < n; j++) {
                man.likeList[j] = sc.nextInt();
            }
            manList.add(i, man);
            freeManList.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            Women women = new Women(n, i);
            for (int j = 0; j < n; j++) {
                women.likeList[sc.nextInt()] = n - j;
            }
            womenList.add(i, women);
        }
        while (freeManList.size() != 0) {
            int freeManIndex = freeManList.getFirst();
            Man freeMan = manList.get(freeManIndex);
            for ( ; freeMan.likeIndex < n; ) {
                Women women = womenList.get(freeMan.likeList[freeMan.likeIndex]);
                if (women.marriageIndex == -1) {
                    freeMan.marriageIndex = women.index;
                    freeManList.removeFirst();
                    freeMan.likeIndex+=1;
                    manList.set(freeManIndex, freeMan);
                    women.marriageIndex = freeManIndex;
                    break;
                } else {
                    if (women.likeList[women.marriageIndex] < women.likeList[freeManIndex]) {
                        freeManList.addLast(women.marriageIndex);
                        women.marriageIndex = freeManIndex;
                        freeMan.marriageIndex = women.index;
                        freeMan.likeIndex++;
                        manList.set(freeManIndex, freeMan);
                        freeManList.removeFirst();
                    } else {
                        freeMan.likeIndex++;
                    }
                }
            }
        }

        System.out.println(manList.get(k).marriageIndex);
    }

}
class Man {
    int index;
    int[] likeList;
    int likeIndex;

    int marriageIndex;

    public Man(int n, int i) {
        this.likeList = new int[n];
        this.index = i;
        this.likeIndex = 0;
    }
}
class Women {
    int index;
    int[] likeList;
    int marriageIndex;

    public Women(int n, int i) {
        this.likeList = new int[n];
        this.index = i;
        this.marriageIndex = -1;
    }
}