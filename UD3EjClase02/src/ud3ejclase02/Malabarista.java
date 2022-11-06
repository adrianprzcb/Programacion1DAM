package ud3ejclase02;

public class Malabarista extends Artista {

    private int numObjetos;

    private String nombreObjeto;

    public Malabarista(int numConcursante, String nombre, int edad, int numObjetos, String nombreObjeto) {
        super(numConcursante,nombre, edad);
        this.nombreObjeto = nombreObjeto;
        this.numObjetos = numObjetos;
    }
    @Override
    public void actuar() {
        System.out.println("Voy a realizar malabares con "+getNumObjetos()+" "+getNombreObjeto());
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
