package com.example.visitor;

public class ReportVisitor implements Visitor {
    @Override
    public void visit(StudentElement s) {
        System.out.println("--- Student Report ---");
        System.out.println(s);
    }

    @Override
    public void visit(TeacherElement t) {
        System.out.println("--- Teacher Report ---");
        System.out.println(t);
    }
}
