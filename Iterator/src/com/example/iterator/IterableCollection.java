package com.example.iterator;

public interface IterableCollection<E> {
    Iterator<E> createIterator();
}
