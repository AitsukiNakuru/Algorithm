package first;

import java.util.*;

public class CourseSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int relationshipCount = sc.nextInt();
        LinkedList<Integer> noPreviousCourseList = new LinkedList<>();

        List<Course> courseList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            courseList.add(new Course(i));
            noPreviousCourseList.addLast(i);
        }
        for (int i = 0; i < relationshipCount; i++) {
            String[] str = sc.next().split(",");
            courseList.get(Integer.parseInt(str[0])).previousCourseMap.put(Integer.parseInt(str[1]), Integer.parseInt(str[1]));
            noPreviousCourseList.remove((Object) Integer.parseInt(str[0]));
        }
        while (noPreviousCourseList.size() > 0 && courseList.size() > 0) {
            Integer noPreviousCourse = noPreviousCourseList.poll();
            courseList.removeIf(course -> course.courseIndex == noPreviousCourse);
            for (Course course : courseList) {
                course.previousCourseMap.remove(noPreviousCourse);
                if (course.previousCourseMap.size() == 0) {
                    noPreviousCourseList.addLast(course.courseIndex);
                }
            }
        }
        if (courseList.size() == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

}

class Course {
    int courseIndex;
    Map<Integer, Integer> previousCourseMap = new HashMap<>();

    public Course(int courseIndex) {
        this.courseIndex = courseIndex;
    }
}
