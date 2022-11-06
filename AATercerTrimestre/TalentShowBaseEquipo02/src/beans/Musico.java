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
    private String melodia;
    
    public Musico(String nombre, int edad, String localidad, String instrumento, String melodia) {
        super(nombre, edad, localidad);
        this.instrumento=instrumento;
        this.melodia=melodia;
    }

    @Override
    public void actuar() {
        System.out.println("El artista "+getNombre()+" esta tocando " +getMelodia()+ "con " +getInstrumento());
    }
    
    @Override
    public String toString() {
        return "Nombre: "+ getNombre() +"\nLocalidad: " +getLocalidad()+"\nEdad: " +getEdad()+ "\nPuntuacion: " +getPuntuacion()+"\nInstrumento: " +getInstrumento()+"\nMelodia: "+getMelodia();
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

    /**
     * @return the melodia
     */
    public String getMelodia() {
        return melodia;
    }

    /**
     * @param melodia the melodia to set
     */
    public void setMelodia(String melodia) {
        this.melodia = melodia;
    }
    
}
