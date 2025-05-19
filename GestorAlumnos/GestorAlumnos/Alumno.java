public class Alumno {
    private String dni;
    private String nombre;
    private int edad;

    public Alumno(String dni, String nombre, int edad) throws EdadNoValidaException {
        if (edad < 0) {
            throw new EdadNoValidaException("La edad no puede ser menor a 0.");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Edad: " + edad;
    }
}
