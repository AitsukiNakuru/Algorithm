package second;

import java.util.*;

public class CourseStudy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Course> courseList = new ArrayList<>();
        LinkedList<Integer> freeCourseList = new LinkedList<>();
        for (int i = 0 ; i < n ; i++ ) {
            courseList.add(new Course(i));
            freeCourseList.add(i);
        }
        for (int i = 0 ; i < m ; i++) {
            String[] str = sc.next().split(",");
            int courseA = Integer.parseInt(str[0]);
            int courseB = Integer.parseInt(str[1]);
            courseList.get(courseA).previousCourseMap.put(courseB, courseB);
            freeCourseList.remove((Object) courseA);
        }
        while (freeCourseList.size() > 0) {
            int freeCourseIndex = freeCourseList.pollFirst();
            for (Course course : courseList) {
                course.previousCourseMap.remove(freeCourseIndex);
                if (course.previousCourseMap.size() == 0) {
                    freeCourseList.addLast(course.index);
                }
            }
            courseList.removeIf(course -> course.index == freeCourseIndex);
        }

        if (courseList.size() == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
class Course {
    int index;
    Map<Integer, Integer> previousCourseMap = new HashMap<>();

    public Course(int index) {
        this.index = index;
    }
}
