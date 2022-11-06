package beans;

public class Malabarista extends Artista {

    private int numObjetos;

    private String nombreObjeto;

    public Malabarista(String nombre, int edad,String localidad, int numObjetos, String nombreObjeto) {
        super(nombre, edad,localidad);
        this.nombreObjeto = nombreObjeto;
        this.numObjetos = numObjetos;
    }
    @Override
    public String actuar() {
        return("Voy a realizar malabares con "+getNumObjetos()+" "+getNombreObjeto());
    }

    /**
     * @return the numObjetos
     */
    public int getNumObjetos() {
        return numObjetos;
    }

    /**
     * @return the nombreObjeto
     */
    public String getNombreObjeto() {
        return nombreObjeto;
    }

}
