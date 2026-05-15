package com.example.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCollection<E> implements IterableCollection<E> {
    private final List<E> items = new ArrayList<>();

    public void add(E e) { items.add(e); }
    public int size() { return items.size(); }
    public List<E> getItems() { return items; }

    @Override
    public Iterator<E> createIterator() {
        return new ConcreteIterator<>(items);
    }
}
