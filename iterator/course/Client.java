package main.java.iterator.course;

public class Client {
    public static void main(String[] args) {
        Course java = new Course("面向对象编程");
        Course ai = new Course("人工智能");

        CourseAggregate courseAggregate = new CourseAggregateImpl();
        courseAggregate.add(java);
        courseAggregate.add(ai);
        System.out.println("课程列表");
        printCourses(courseAggregate);
    }

    public static void printCourses(CourseAggregate courseAggregate){
        Iterator<Course> iterator = courseAggregate.iterator();
        while (iterator.hasNext()){
            Course course = iterator.next();
            System.out.println("《" + course.getName() + "》");
        }

    }
}
