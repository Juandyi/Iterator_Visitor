package com.example.visitor;

import java.util.ArrayList;
import java.util.List;

public class TeacherElement implements Element {
    private final String codigo;
    private final String nombres;
    private final String direccion;
    private final List<String> telefonos;

    public TeacherElement(String codigo, String nombres, String direccion, List<String> telefonos) {
        this.codigo = codigo == null ? "" : codigo.trim();
        this.nombres = nombres == null ? "" : nombres.trim();
        this.direccion = direccion == null ? "" : direccion.trim();
        this.telefonos = telefonos == null ? new ArrayList<>() : telefonos;
    }

    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getDireccion() { return direccion; }
    public List<String> getTelefonos() { return telefonos; }

    public boolean hasCompleteData() {
        return !codigo.isEmpty() && !nombres.isEmpty() && !direccion.isEmpty() && !telefonos.isEmpty();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return String.format("Teacher{codigo=%s, nombres=%s, direccion=%s, telefonos=%s}", codigo, nombres, direccion, telefonos);
    }
}
