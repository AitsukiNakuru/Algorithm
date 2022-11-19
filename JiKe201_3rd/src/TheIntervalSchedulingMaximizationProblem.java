import java.util.*;

public class TheIntervalSchedulingMaximizationProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Task> taskList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Task task = new Task(sc.nextInt(), sc.nextInt());
            taskList.add(task);
        }
        taskList.sort(new Comparator<Task>() {
            // o1 - o2 降序
            // o2 - o1 升序
            @Override
            public int compare(Task o1, Task o2) {
                return o1.endTime - o2.endTime;
            }
        });
        int nowTime = 0;
        int taskCount = 0;
        for (Task task : taskList) {
            if (nowTime <= task.startTime) {
                nowTime = task.endTime;
                taskCount++;
            }

        }
        System.out.println(taskCount);
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
