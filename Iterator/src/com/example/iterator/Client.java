package com.example.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        if (args != null && args.length > 0 && "demo".equalsIgnoreCase(args[0])) {
            runDemo();
            return;
        }

        Scanner sc = new Scanner(System.in);
        ConcreteCollection<Student> list = new ConcreteCollection<>();
        TreeSetCollection<Student> tree = new TreeSetCollection<>();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1) Agregar estudiante a ArrayList");
            System.out.println("2) Agregar estudiante a TreeSet");
            System.out.println("3) Mostrar y validar ArrayList");
            System.out.println("4) Mostrar y validar TreeSet");
            System.out.println("5) Ejecutar demo rápido");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    list.add(readStudentFromConsole(sc));
                    break;
                case "2":
                    tree.add(readStudentFromConsole(sc));
                    break;
                case "3":
                    System.out.println("\nRecorrido ArrayList:");
                    iterateAndValidate(list.createIterator());
                    break;
                case "4":
                    System.out.println("\nRecorrido TreeSet:");
                    iterateAndValidate(tree.createIterator());
                    break;
                case "5":
                    runDemo();
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

    private static Student readStudentFromConsole(Scanner sc) {
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

        return new Student(codigo, nombres, direccion, telefonos);
    }

    private static void iterateAndValidate(Iterator<Student> it) {
        while (it.hasMore()) {
            Student s = it.getNext();
            validateAndNotify(s);
        }
    }

    private static void validateAndNotify(Student s) {
        if (s.hasCompleteData()) {
            System.out.println("OK: " + s.getCodigo() + " - " + s.getNombres());
        } else {
            System.out.println("NOTIFICACION: Datos incompletos para " + s.getCodigo() + " -> " + s);
        }
    }

    private static void runDemo() {
        ConcreteCollection<Student> list = new ConcreteCollection<>();
        list.add(new Student("2021001", "Ana Perez", "Calle 1", Arrays.asList("555-1001")));
        list.add(new Student("2021002", "", "Calle 2", Arrays.asList("555-1002")));

        TreeSetCollection<Student> tree = new TreeSetCollection<>();
        tree.add(new Student("2021003", "Luis Gomez", "Calle 3", Arrays.asList("555-1003")));
        tree.add(new Student("2021000", "Maria Ruiz", "", Arrays.asList()));

        System.out.println("Demo - Recorrido ArrayList:");
        iterateAndValidate(list.createIterator());

        System.out.println("\nDemo - Recorrido TreeSet:");
        iterateAndValidate(tree.createIterator());
    }
}
