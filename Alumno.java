import java.util.Arrays;

public class Alumno implements IAlumno {
    private String nombre;
    private int[] notas;
    private int numNotasActuales;
    private static final int MAX_NOTAS = 10;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.notas = new int[MAX_NOTAS];
        this.numNotasActuales = 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int[] getNotas() {
        return Arrays.copyOf(notas, numNotasActuales); // Devuelve una copia para evitar modificaciones externas
    }

    @Override
    public boolean anadeNota(int nota) {
        if (numNotasActuales < MAX_NOTAS && nota >= 0 && nota <= 10) {
            notas[numNotasActuales++] = nota;
            return true;
        }
        return false;
    }

    @Override
    public int numNotas() {
        return numNotasActuales;
    }

    @Override
    public double getNotaMedia() {
        if (numNotasActuales == 0) {
            return 0.0;
        }
        int suma = 0;
        for (int i = 0; i < numNotasActuales; i++) {
            suma += notas[i];
        }
        return (double) suma / numNotasActuales;
    }

    @Override
    public int getNumeroAprobados() {
        int aprobados = 0;
        for (int i = 0; i < numNotasActuales; i++) {
            if (notas[i] >= 5) {
                aprobados++;
            }
        }
        return aprobados;
    }

    @Override
    public void borrarNotas() {
        this.notas = new int[MAX_NOTAS];
        this.numNotasActuales = 0;
    }
}