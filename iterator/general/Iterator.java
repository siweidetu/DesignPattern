package main.java.iterator.general;

/**
 * 迭代器接口类
 * @param <E>
 */
public interface Iterator<E> {
    E next();
    boolean hasNext();
}
