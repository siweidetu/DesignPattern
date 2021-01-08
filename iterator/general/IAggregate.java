package main.java.iterator.general;

/**
 * 集合接口类
 * @param <E>
 */
public interface IAggregate<E>{
    boolean add(E element);
    boolean remove(E elemnet);
    Iterator<E> iterator();
}
