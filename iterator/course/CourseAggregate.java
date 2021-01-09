package main.java.iterator.course;

import main.java.iterator.course.Iterator;

/**
 * 集合接口类
 * @param
 */
public interface CourseAggregate{
    void add(Course course);
    void remove(Course course);
    Iterator<Course> iterator();
}
