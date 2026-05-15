package com.example.iterator;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private final String codigo;
    private final String nombres;
    private final String direccion;
    private final List<String> telefonos;

    public Student(String codigo, String nombres, String direccion, List<String> telefonos) {
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
    public int compareTo(Student o) {
        return this.codigo.compareTo(o.codigo);
    }

    @Override
    public String toString() {
        return String.format("Student{codigo=%s, nombres=%s, direccion=%s, telefonos=%s}", codigo, nombres, direccion, telefonos);
    }
}
