package beans;

import beans.Artista;
/**
 * 
 * @author Marina y Salvador
 */
public class Musico extends Artista {

    private String instrumento;

    /**
     * 
     * @param localidad Parametro que asigna localidad al artista.
     * @param nombre Parametro que asigna nombre al artista.
     * @param edad Parametro que asigna edad al artista.
     * @param instrumento Parametro instrumento que usa el artista.
     */
    public Musico (String localidad, String nombre, int edad, String instrumento) {
        super(localidad,nombre, edad);
        this.instrumento = instrumento;               
    }
    /**
     * El artista realiza su actuación. 
     */
    @Override
    public void actuar() {
        System.out.println("Voy a cantar la canción "+getInstrumento());
    }

    /**
     * @return devuelve el instrumento.
     */
    public String getInstrumento() {
        return instrumento;
    }

    /**
     * Establece el instrumento.
     * @param instrumento the instrumento to set
     */
    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }
    
}
