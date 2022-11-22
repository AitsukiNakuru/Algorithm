package second.intervalScheduling;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class intervalScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Task> taskList = new PriorityQueue<>((o1, o2) -> {
            return o1.endTime - o2.endTime;
        });
        int n = sc.nextInt();
        for (int i = 0 ; i < n ; i++) {
            taskList.add(new Task(sc.nextInt(), sc.nextInt()));
        }
        int nowTime = 0;
        int count = 0;
        for (Task task : taskList) {
            if (nowTime <= task.startTime) {
                count+=1;
                nowTime = task.endTime;
            }
        }
        System.out.println(count);
    }
}
class Task {
    int startTime;

    int endTime;

    public Task(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
