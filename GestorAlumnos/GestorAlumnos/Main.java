import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorNotas gestor = new GestorNotas();
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Listar alumnos");
            System.out.println("2. Introducir alumno");
            System.out.println("3. Introducir nueva nota de alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("6. Media de notas por alumno");
            System.out.println("7. Media de cada evaluación");
            System.out.println("8. Mejor nota por evaluación");
            System.out.println("9. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    gestor.listarAlumnos();
                    break;
                case 2:
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    try {
                        Alumno a = new Alumno(dni, nombre, edad);
                        if (gestor.agregarAlumno(a)) {
                            System.out.println("Alumno añadido correctamente.");
                        } else {
                            System.out.println("El DNI ya existe.");
                        }
                    } catch (EdadNoValidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("DNI del alumno: ");
                    String dni3 = sc.nextLine();
                    System.out.print("Nota (0-10): ");
                    int nota = sc.nextInt();
                    sc.nextLine();
                    try {
                        if (gestor.agregarNota(dni3, nota)) {
                            System.out.println("Nota añadida.");
                        } else {
                            System.out.println("No se puede añadir más de 3 notas o el alumno no existe.");
                        }
                    } catch (NotaNoValidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("DNI del alumno a eliminar: ");
                    String dni4 = sc.nextLine();
                    if (gestor.eliminarAlumno(dni4)) {
                        System.out.println("Alumno eliminado.");
                    } else {
                        System.out.println("No existe un alumno con ese DNI.");
                    }
                    break;
                case 6:
                    gestor.mediaNotasPorAlumno();
                    break;
                case 7:
                    gestor.mediaPorEvaluacion();
                    break;
                case 8:
                    gestor.notaMaximaPorEvaluacion();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 9);

        sc.close();
    }
}
