package beans;

public class Cantante extends Artista {

    private String tituloCancion;

    
    public Cantante ( String nombre, int edad,String localidad, String tituloCancion) {
        super(nombre, edad,localidad);
        this.tituloCancion = tituloCancion;               
    }
    
    @Override
    public String actuar() {
        return("Voy a cantar la canción "+getTituloCancion());
    }

    /**
     * @return the tituloCancion
     */
    public String getTituloCancion() {
        return tituloCancion;
    }

  
    
}
