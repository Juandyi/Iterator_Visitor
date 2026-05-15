package com.example.visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClientVisitor {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        if (args != null && args.length > 0 && "demo".equalsIgnoreCase(args[0])) {
            runDemo(elements);
            return;
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Visitor Menu ---");
            System.out.println("1) Agregar Estudiante");
            System.out.println("2) Agregar Docente");
            System.out.println("3) Listar elementos");
            System.out.println("4) Validar (ValidationVisitor)");
            System.out.println("5) Reporte (ReportVisitor)");
            System.out.println("6) Demo rapido");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    elements.add(readStudent(sc));
                    break;
                case "2":
                    elements.add(readTeacher(sc));
                    break;
                case "3":
                    listElements(elements);
                    break;
                case "4":
                    applyVisitor(elements, new ValidationVisitor());
                    break;
                case "5":
                    applyVisitor(elements, new ReportVisitor());
                    break;
                case "6":
                    runDemo(elements);
                    break;
                case "0":
                    System.out.println("Saliendo.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static StudentElement readStudent(Scanner sc) {
        System.out.print("Codigo: ");
        String codigo = sc.nextLine().trim();
        System.out.print("Nombres: ");
        String nombres = sc.nextLine().trim();
        System.out.print("Direccion: ");
        String direccion = sc.nextLine().trim();
        System.out.println("Telefonos (separados por coma) o vacío para ninguno:");
        String telLine = sc.nextLine().trim();
        List<String> telefonos = new ArrayList<>();
        if (!telLine.isEmpty()) {
            telefonos = Arrays.stream(telLine.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        }
        return new StudentElement(codigo, nombres, direccion, telefonos);
    }

    private static TeacherElement readTeacher(Scanner sc) {
        System.out.print("Codigo (max 4 digitos preferible): ");
        String codigo = sc.nextLine().trim();
        System.out.print("Nombres: ");
        String nombres = sc.nextLine().trim();
        System.out.print("Direccion: ");
        String direccion = sc.nextLine().trim();
        System.out.println("Telefonos (separados por coma) o vacío para ninguno:");
        String telLine = sc.nextLine().trim();
        List<String> telefonos = new ArrayList<>();
        if (!telLine.isEmpty()) {
            telefonos = Arrays.stream(telLine.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        }
        return new TeacherElement(codigo, nombres, direccion, telefonos);
    }

    private static void listElements(List<Element> elements) {
        if (elements.isEmpty()) {
            System.out.println("No hay elementos.");
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(i + ") " + elements.get(i));
        }
    }

    private static void applyVisitor(List<Element> elements, Visitor v) {
        if (elements.isEmpty()) {
            System.out.println("No hay elementos para procesar.");
            return;
        }
        for (Element e : elements) {
            e.accept(v);
        }
    }

    private static void runDemo(List<Element> elements) {
        elements.add(new StudentElement("2021001", "Ana Perez", "Calle 1", Arrays.asList("555-1001")));
        elements.add(new StudentElement("2021002", "", "Calle 2", Arrays.asList("555-1002")));
        elements.add(new TeacherElement("123", "Profesor Uno", "Av. 1", Arrays.asList("555-2001")));
        elements.add(new TeacherElement("12345", "Profesor Largo", "Av. 2", Arrays.asList()));

        System.out.println("Demo - Aplicando ValidationVisitor:");
        applyVisitor(elements, new ValidationVisitor());

        System.out.println("\nDemo - Aplicando ReportVisitor:");
        applyVisitor(elements, new ReportVisitor());
    }
}
