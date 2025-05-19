import java.util.*;

public class GestorNotas {
    private Map<String, Alumno> alumnos = new HashMap<>();
    private Map<String, List<Integer>> notas = new HashMap<>();

    public boolean agregarAlumno(Alumno alumno) {
        if (alumnos.containsKey(alumno.getDni())) {
            return false;
        }
        alumnos.put(alumno.getDni(), alumno);
        notas.put(alumno.getDni(), new ArrayList<>());
        return true;
    }

    public boolean eliminarAlumno(String dni) {
        if (!alumnos.containsKey(dni)) return false;
        alumnos.remove(dni);
        notas.remove(dni);
        return true;
    }

    public boolean agregarNota(String dni, int nota) throws NotaNoValidaException {
        if (nota < 0 || nota > 10) {
            throw new NotaNoValidaException("La nota debe estar entre 0 y 10.");
        }
        List<Integer> listaNotas = notas.get(dni);
        if (listaNotas == null || listaNotas.size() >= 3) {
            return false;
        }
        listaNotas.add(nota);
        return true;
    }

    public void listarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        for (String dni : alumnos.keySet()) {
            System.out.println(alumnos.get(dni));
            List<Integer> n = notas.get(dni);
            System.out.println("Notas: " + (n.isEmpty() ? "Sin notas" : n));
        }
    }

    public void mediaNotasPorAlumno() {
        for (String dni : alumnos.keySet()) {
            List<Integer> n = notas.get(dni);
            double media = n.isEmpty() ? 0 : n.stream().mapToInt(i -> i).average().orElse(0);
            System.out.println("Alumno " + alumnos.get(dni).getNombre() + " (DNI: " + dni + ") - Media: " + media);
        }
    }

    public void mediaPorEvaluacion() {
        for (int i = 0; i < 3; i++) {
            int count = 0;
            int suma = 0;
            for (List<Integer> lista : notas.values()) {
                if (lista.size() > i) {
                    suma += lista.get(i);
                    count++;
                }
            }
            double media = count > 0 ? (double) suma / count : 0;
            System.out.println("Evaluación " + (i + 1) + " - Media: " + media);
        }
    }

    public void notaMaximaPorEvaluacion() {
        Map<String, Integer[]> mejoresNotas = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : notas.entrySet()) {
            String dni = entry.getKey();
            List<Integer> lista = entry.getValue();
            Integer[] max = new Integer[3];
            for (int i = 0; i < lista.size(); i++) {
                max[i] = lista.get(i);
            }
            mejoresNotas.put(dni, max);
        }

        for (int i = 0; i < 3; i++) {
            String mejorDni = null;
            int mejorNota = -1;
            for (Map.Entry<String, Integer[]> entry : mejoresNotas.entrySet()) {
                Integer[] notasEv = entry.getValue();
                if (notasEv[i] != null && notasEv[i] > mejorNota) {
                    mejorNota = notasEv[i];
                    mejorDni = entry.getKey();
                }
            }
            if (mejorDni != null) {
                System.out.println("Evaluación " + (i + 1) + ": Mejor nota " + mejorNota + " (DNI: " + mejorDni + ")");
            } else {
                System.out.println("Evaluación " + (i + 1) + ": Sin notas registradas.");
            }
        }
    }
}
