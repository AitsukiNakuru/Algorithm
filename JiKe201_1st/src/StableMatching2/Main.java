package StableMatching2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<People> manList = new ArrayList<>();
        ArrayList<People> womenList = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            int[] likeList = new int[n];
            for (int j = 0 ; j < n ; j++) {
                likeList[j] = sc.nextInt();
            }
            People man = new People(i, likeList);
            manList.add(man);
        }
        for (int i = 0 ; i < n ; i++) {
            int[] likeList = new int[n];
            for (int j = 0 ; j < n ; j++) {
                likeList[sc.nextInt()] = n - j;
            }
            People women = new People(i, likeList);
            womenList.add(women);
        }
        StableMatching stableMatching = new StableMatching(manList, womenList, n);
        stableMatching.match();
        System.out.println(stableMatching.manList.get(k).likeList[manList.get(k).likeIndex]);
    }
}
class StableMatching {
    ArrayList<People> manList;
    ArrayList<People> womenList;
    LinkedList<Integer> freeManList;
    int n;
    public StableMatching(ArrayList<People> manList, ArrayList<People> womenList, int n) {
        this.manList = manList;
        this.womenList = womenList;
        this.n = n;
        freeManList = new LinkedList<>();
        for (int i = 0 ; i < n ; i++) {
            freeManList.add(i);
        }
    }
    public void match() {
        while (freeManList.size() > 0) {
            int freeManIndex = freeManList.pollFirst();
            People freeMan = manList.get(freeManIndex);

            while (freeMan.likeIndex < n) {
                freeMan.likeIndex+=1;
                People women = womenList.get(freeMan.likeList[freeMan.likeIndex]);
                if (women.likeIndex == -1) {
                    women.likeIndex = freeManIndex;
                    womenList.set(women.index, women);
                    break;
                } else {
                    if (women.likeList[women.likeIndex] < women.likeList[freeManIndex]) {
                        freeManList.addLast(women.likeIndex);
                        women.likeIndex = freeManIndex;
                        womenList.set(women.index, women);
                        break;
                    }
                }
            }
            manList.set(freeManIndex, freeMan);
        }
    }
}
class People {
    public People(int index, int[] likeList) {
        this.index = index;
        this.likeList = likeList;
        this.likeIndex = -1;
    }
    int index;
    int[] likeList;
    int likeIndex;
}
