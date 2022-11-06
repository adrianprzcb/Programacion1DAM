package ud3ejclase02;

public abstract class Artista implements Comparable<Artista>{

    private int numConcursante;

    private String nombre;

    private int edad;
    
    Integer puntuacion;
    
    public Artista (int numConcursante, String nombre, int edad) {
        this.numConcursante = numConcursante;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void saludar() {
        System.out.println("Hola a tod@s");
    }

    public void despedirse() {
        System.out.println("Adiós y gracias");
    }

    abstract public void actuar();

    /**
     * @return the numConcursante
     */
    public int getNumConcursante() {
        return numConcursante;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @return the puntuacion
     */
    public Integer getPuntuacion() {
        return puntuacion;
    }

    /**
     * @param puntuacion the puntuacion to set
     */
    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Artista{" + "numConcursante=" + numConcursante + ", nombre=" + nombre + ", edad=" + edad + ", puntuacion=" + puntuacion + '}';
    }
    
    
      @Override
    public int compareTo(Artista t) {
        return puntuacion.compareTo(t.getPuntuacion());
    }
}
