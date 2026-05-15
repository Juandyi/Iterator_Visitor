package com.example.iterator;

public interface Iterator<E> {
    boolean hasMore();
    E getNext();
}
