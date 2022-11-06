package beans;

public class Poeta extends Artista {

    private String tituloPoema;
    
    public Poeta( String nombre, int edad, String localidad, String tituloPoema){
        super(nombre, edad, localidad);
        this.tituloPoema = tituloPoema;
    }
    @Override
    public String actuar() {
        return("Voy a recitar el poema "+getTituloPoema());
    }

    /**
     * @return the tituloPoema
     */
    public String getTituloPoema() {
        return tituloPoema;
    }

  
}
