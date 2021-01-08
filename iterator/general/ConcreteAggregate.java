package main.java.iterator.general;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate<E> implements IAggregate<E> {

    private List<E> list = new ArrayList<>();

    @Override
    public boolean add(E element) {
        return this.list.add(element);
    }

    @Override
    public boolean remove(E elemnet) {
        return this.list.remove(elemnet);
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<E>(this.list);
    }
}
