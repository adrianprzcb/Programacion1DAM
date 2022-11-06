package beans;

import beans.Artista;
    /**
     * 
     * @author Marina y Salvador
     */
public class Malabarista extends Artista {
    
    /**
     * Establece el numero de objetos para el artista.
     * @param numObjetos the numObjetos to set
     */
    public void setNumObjetos(int numObjetos) {
        this.numObjetos = numObjetos;
    }

    /**
     * Establece el nombre del obejeto para el artista.
     * @param nombreObjeto the nombreObjeto to set
     */
    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }
    
    private int numObjetos;

    private String nombreObjeto;
    /**
     * 
     * @param localidad Parametro que asigna localidad al artista.
     * @param nombre Parametro que asigna nombre al artista.
     * @param edad Parametro que asigna edad al artista.
     * @param numObjetos Parametro que asigna el numero de objetos.
     * @param nombreObjeto Parametro que asigna el nombre del objeto.
     */
    
    public Malabarista(String localidad, String nombre, int edad, int numObjetos, String nombreObjeto) {
        super(localidad,nombre, edad);
        this.nombreObjeto = nombreObjeto;
        this.numObjetos = numObjetos;
    }
    
    /**
     * El artista realiza su actuación.
     */
    @Override
    public String actuar() {
        return "Voy a realizar malabares con "+getNumObjetos()+" "+getNombreObjeto();
    }
    
    /**
     * @return devuelve el numero de objetos.
     */
    public int getNumObjetos() {
        return numObjetos;
    }
    
    /**
     * @return devuelve el nombre del objeto.
     */
    public String getNombreObjeto() {
        return nombreObjeto;
    }
}
