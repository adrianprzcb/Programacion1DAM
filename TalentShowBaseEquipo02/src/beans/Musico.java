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
public class Musico extends Artista{
    private String instrumento;
    
    public Musico(String nombre, int edad, String localidad, String instrumento) {
        super(nombre, edad, localidad);
        this.instrumento=instrumento;
    }

    @Override
    public void actuar() {
        System.out.println("El artista "+getNombre()+" esta tocando " +getInstrumento());
    }
    
    @Override
    public String toString() {
        return "Nombre: "+ getNombre() +"\nLocalidad: " +getLocalidad()+"\nEdad: " +getEdad()+ "\nPuntuacion: " +getPuntuacion();
    }

    /**
     * @return the instrumento
     */
    public String getInstrumento() {
        return instrumento;
    }

    /**
     * @param instrumento the instrumento to set
     */
    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }
    
}
