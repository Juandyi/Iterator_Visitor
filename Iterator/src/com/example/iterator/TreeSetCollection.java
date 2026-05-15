package com.example.iterator;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetCollection<E extends Comparable<E>> implements IterableCollection<E> {
    private final Set<E> items = new TreeSet<>();

    public void add(E e) { items.add(e); }
    public int size() { return items.size(); }
    public Set<E> getItems() { return items; }

    @Override
    public Iterator<E> createIterator() {
        return new ConcreteIterator<>(items);
    }
}
