public interface IAlumno {
    /**
     * Método que devuelve el nombre del alumno
     * @return Devuelve el nombre del alumno
     */
    public String getNombre();
    /**
     * Método que devuelve el array de notas del alumno
     * @return
     */
    public int[] getNotas();
    /**
     * Añade una nota al alumno
     * @param nota que se le añade al alumno
     * @return true si se puede añadir una nota más, false en caso contrario, ya sea porque no
     * caben más notas o porque la nota no es válida (nota >=0 y <=10)
     */
    public boolean anadeNota(int nota);
    /**
     * Método que devuelve el numero de notas que tiene el alumno
     * @return numero de notas
     */
    public int numNotas();
    /**
     * @return nota media
     */
    public double getNotaMedia();
    /**
     * @return numero de aprobados
     */
    public int getNumeroAprobados();
    /**
     * Método que borra todas las notas del alumno
     */
    public void borrarNotas();
}

//Nicolas Torres B.
