package beans;

import beans.Artista;
/**
 * 
 * @author Marina y Salvador
 */
public class Poeta extends Artista {
   
    private String tituloPoema;
    /**
     * 
     * @param localidad Parametro que asigna localidad al artista.
     * @param nombre Parametro que asigna nombre al artista.
     * @param edad Parametro que asigna edad al artista.
     * @param tituloPoema Parametro que asigna un titulo al poema.
     */
    public Poeta(String localidad, String nombre, int edad, String tituloPoema){
        super(localidad,nombre, edad);
        this.tituloPoema = tituloPoema;
    }
    /**
     * El artista realiza su actuación. 
     */
    @Override
    public String actuar() {
        return "Voy a recitar el poema "+getTituloPoema();
    }

    /**
     * @return devuelve el titulo del poema.
     */
    public String getTituloPoema() {
        return tituloPoema;
    }
    
     /**
      * Establece el titulo poema para el artista.
     * @param tituloPoema the tituloPoema to set
     */
    public void setTituloPoema(String tituloPoema) {
        this.tituloPoema = tituloPoema;
    }
}
