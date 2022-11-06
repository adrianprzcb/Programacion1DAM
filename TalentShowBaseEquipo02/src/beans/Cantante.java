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
public class Cantante extends Artista{
    private String tituloMelodia;

    public Cantante(String nombre, int edad, String localidad, String tituloMelodia) {
        super(nombre, edad, localidad);
        this.tituloMelodia=tituloMelodia;
        
    }

    @Override
    public void actuar() {
        System.out.println("El artista "+getNombre()+" esta cantando " +getTituloMelodia());
    }

    /**
     * @return the tituloMelodia
     */
    public String getTituloMelodia() {
        return tituloMelodia;
    }

    /**
     * @param tituloMelodia the tituloMelodia to set
     */
    public void setTituloMelodia(String tituloMelodia) {
        this.tituloMelodia = tituloMelodia;
    }

    @Override
    public String toString() {
        return "Nombre: "+ getNombre() +"\nLocalidad: " +getLocalidad()+"\nEdad: " +getEdad()+ "\nPuntuacion: " +getPuntuacion();
    }
    
}
