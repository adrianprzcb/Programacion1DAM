package beans;

import java.io.Serializable;

/**
 * 
 * @author Marina y Salvador
 */
public abstract class Artista implements Serializable{

    private String localidad;

    private String nombre;

    private int edad;
    
    private int puntuacion;
    
    public Artista(){
        
    }
    /**
     * 
     * @param localidad Este parametro asigna localidad al artista.
     * @param nombre Este parametro asigna nombre al artista.
     * @param edad Este parametro asigna edad al artista.
     */
    public Artista (String localidad, String nombre, int edad) {
        this.localidad = localidad;
        this.nombre = nombre;
        this.edad = edad;
    }
    /**
     * Metodo que hace que el artista se presente.
     */
    public void saludar() {
        System.out.println("Hola a tod@s soy " + getNombre()+" tengo "+ getEdad() + " años, y vengo de "+ getLocalidad());
    }
    /**
     * Metodo que hace que el artista se despida.
     */
    public void despedirse() {
        System.out.println("Adiós y gracias");
    }
    
    abstract public void actuar();
    /**
     * @return devuelve la localidad del artista.
     */
    public String getLocalidad() {
        return localidad;
    }
    /**
     * @return devuelve el nombre del artista.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @return devuelve la edad del artista.
     */
    public int getEdad() {
        return edad;
    }
    /**
     * @return devuelve la puntuacion del artista.
     */
    public int getPuntuacion() {
        return puntuacion;
    }
    /**
     * @param puntuacion pasa el parametro puntuación para su lectura.
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    /**
     * 
     * @param localidad pasa el parametro localidad para su lectura.
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    /**
     * @param nombre pasa el parametro nombre para su lectura.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @param edad pasa el parametro edad para su lectura.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
