package com.example.iterator;

import java.util.Collection;

public class ConcreteIterator<E> implements Iterator<E> {
    private final java.util.Iterator<E> internal;

    public ConcreteIterator(Collection<E> collection) {
        this.internal = collection.iterator();
    }

    @Override
    public boolean hasMore() {
        return internal.hasNext();
    }

    @Override
    public E getNext() {
        return internal.next();
    }
}
