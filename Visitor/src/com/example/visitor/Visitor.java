package com.example.visitor;

public interface Visitor {
    void visit(StudentElement s);
    void visit(TeacherElement t);
}
