/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author bth
 */
public class Poeta extends Artista{
    private String tituloPoema;
    
    public Poeta(String nombre, int edad, String localidad, String tituloPoema) {
        super(nombre, edad, localidad);
        this.tituloPoema=tituloPoema;
    }

    @Override
    public void actuar() {
        System.out.println("El artista "+getNombre()+" esta recitando " +getTituloPoema());
    }
    
    @Override
    public String toString() {
        return "Nombre: "+ getNombre() +"\nLocalidad: " +getLocalidad()+"\nEdad: " +getEdad()+ "\nPuntuacion: " +getPuntuacion();
    }
    /**
     * @return the tituloPoema
     */
    public String getTituloPoema() {
        return tituloPoema;
    }

    /**
     * @param tituloPoema the tituloPoema to set
     */
    public void setTituloPoema(String tituloPoema) {
        this.tituloPoema = tituloPoema;
    }
    
}
