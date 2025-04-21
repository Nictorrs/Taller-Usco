import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestGestionAlumnos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Alumno> alumnos = new ArrayList<>();
        String nombreAlumno;
        int contadorAlumnos = 0;
        final int MAX_ALUMNOS = 30;

        System.out.println("Introduzca datos (fin para terminar):");

        while (contadorAlumnos < MAX_ALUMNOS) {
            System.out.print("Nombre: ");
            nombreAlumno = scanner.nextLine();

            if (nombreAlumno.equalsIgnoreCase("fin")) {
                break;
            }

            Alumno nuevoAlumno = new Alumno(nombreAlumno);
            System.out.println("Notas (separadas por espacio): ");
            System.out.println("--------(Máximo 10 notas por alumno.)--------");
            String lineaNotas = scanner.nextLine();
            String[] notasStr = lineaNotas.split(" ");

            for (String notaStr : notasStr) {
                try {
                    int nota = Integer.parseInt(notaStr);
                    if (!nuevoAlumno.anadeNota(nota)) {
                        if (nota < 0 || nota > 10) {
                            System.out.println("Nota " + nota + " no válida.");
                        } else if (nuevoAlumno.numNotas() >= 10) {
                            System.out.println("Máximo 10 notas para " + nombreAlumno + ".");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("'" + notaStr + "' no es válido.");
                }
            }
            alumnos.add(nuevoAlumno);
            contadorAlumnos++;
        }

        System.out.println("\nListado final:");
        System.out.println("---------------------------------------------");
        System.out.printf("%-8s %-16s %-8s %-8s%n", "Nombre", "Num Notas", "Aprob", "Media");
        System.out.println("-------- ---------------- -------- --------");
        for (Alumno alumno : alumnos) {
            System.out.printf("%-8s %-16d %-8d %-8.1f%n", alumno.getNombre(), alumno.numNotas(), alumno.getNumeroAprobados(), alumno.getNotaMedia());
        }

        scanner.close();
    }
}