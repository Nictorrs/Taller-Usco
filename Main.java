import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear un alumno
        Alumno alumno1 = new Alumno("Carlos");
        System.out.println("Nombre del alumno: " + alumno1.getNombre());

        // Añadir notas
        System.out.println("Añadiendo notas:");
        System.out.println("Nota 7 añadida: " + alumno1.anadeNota(7));
        System.out.println("Nota 10 añadida: " + alumno1.anadeNota(10));
        System.out.println("Nota 2 añadida: " + alumno1.anadeNota(2));
        System.out.println("Nota 15 añadida (inválida): " + alumno1.anadeNota(15));
        System.out.println("Nota -1 añadida (inválida): " + alumno1.anadeNota(-1));

        // Añadir más notas hasta el límite
        for (int i = 0; i < 8; i++) {
            alumno1.anadeNota(i + 3);
        }
        System.out.println("Intentando añadir una onceava nota: " + alumno1.anadeNota(9));

        // Mostrar notas
        System.out.println("Notas del alumno: " + Arrays.toString(alumno1.getNotas()));
        System.out.println("Número de notas: " + alumno1.numNotas());

        // Calcular y mostrar la nota media
        System.out.println("Nota media: " + alumno1.getNotaMedia());

        // Calcular y mostrar el número de aprobados
        System.out.println("Número de aprobados: " + alumno1.getNumeroAprobados());

        // Borrar las notas
        alumno1.borrarNotas();
        System.out.println("Notas después de borrar: " + Arrays.toString(alumno1.getNotas()));
        System.out.println("Número de notas después de borrar: " + alumno1.numNotas());
    }
}