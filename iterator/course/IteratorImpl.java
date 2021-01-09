package main.java.iterator.course;

import main.java.iterator.course.Iterator;

import java.util.List;

public class IteratorImpl<E> implements Iterator<E> {

    private List<E> list;
    private int cursor = 0;
    private E element;

    public IteratorImpl(List<E> list){
        this.list = list;
    }

    @Override
    public E next() {
        System.out.println("当前位置"+cursor+":");
        element = this.list.get(this.cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        return this.cursor<this.list.size();
    }
}
