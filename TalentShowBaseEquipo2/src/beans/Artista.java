package beans;

import java.io.Serializable;

public abstract class Artista implements Comparable<Artista>, Serializable{

    private String nombre;

    private int edad;
   
    private String localidad;
    private Integer puntuacion;

    
    public Artista ( String nombre, int edad, String localidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.localidad = localidad;
        this.puntuacion=0;
        
    }
    
    public Artista(){
        this.puntuacion=0;

    }
    
     public String saludar() {
        return "Hola, me llamo "+this.nombre+", saludos!";
    }
    public String despedirse() {
        return "Y esto ha sido todo, muchas gracias!";
    }

    abstract public String actuar();

   
    public String getLocalidad() {
        return localidad;
    }

   
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
        return "Artista{" + ", nombre=" + nombre + ", edad=" + edad + ", puntuacion=" + puntuacion + '}';
    }
    
    
      @Override
    public int compareTo(Artista t) {
        return puntuacion.compareTo(t.getPuntuacion());
    }
}
