package com.example.visitor;

public class ValidationVisitor implements Visitor {
    @Override
    public void visit(StudentElement s) {
        if (s.hasCompleteData()) {
            System.out.println("OK (Student): " + s.getCodigo() + " - " + s.getNombres());
        } else {
            System.out.println("NOTIFICACION (Student): Datos incompletos para " + s.getCodigo() + " -> " + s);
        }
    }

    @Override
    public void visit(TeacherElement t) {
        boolean ok = t.hasCompleteData();
        if (!ok) {
            System.out.println("NOTIFICACION (Teacher): Datos incompletos para " + t.getCodigo() + " -> " + t);
            return;
        }
        // regla adicional: si es docente, codigo max 4 digitos
        if (t.getCodigo().length() > 4) {
            System.out.println("NOTIFICACION (Teacher): Codigo mayor a 4 digitos para " + t.getCodigo());
        } else {
            System.out.println("OK (Teacher): " + t.getCodigo() + " - " + t.getNombres());
        }
    }
}
