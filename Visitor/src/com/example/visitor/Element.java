package com.example.visitor;

public interface Element {
    void accept(Visitor v);
}
