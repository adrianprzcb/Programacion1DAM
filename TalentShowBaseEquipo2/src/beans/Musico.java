/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author alumno
 */
public class Musico extends Artista {

    private String instrumento;
    
    public Musico(String nombre, int edad, String localidad, String instrumento) {
        super(nombre, edad, localidad);
        this.instrumento = instrumento;
    }

    @Override
    public String actuar() {
        return("Voy a tocar mi "+getInstrumento());
    }

    /**
     * @return the instrumento
     */
    public String getInstrumento() {
        return instrumento;
    }
    
}
