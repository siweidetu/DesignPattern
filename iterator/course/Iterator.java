package main.java.iterator.course;

/**
 * 迭代器接口类
 * @param <E>
 */
public interface Iterator<E> {
    E next();
    boolean hasNext();
}
