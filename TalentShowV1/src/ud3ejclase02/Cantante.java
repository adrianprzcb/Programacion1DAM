package ud3ejclase02;

public class Cantante extends Artista {

    private String tituloCancion;

    
    public Cantante (int numConcursante, String nombre, int edad, String tituloCancion) {
        super(numConcursante,nombre, edad);
        this.tituloCancion = tituloCancion;               
    }
    
    @Override
    public void actuar() {
        System.out.println("Voy a cantar la canción "+getTituloCancion());
    }

    /**
     * @return the tituloCancion
     */
    public String getTituloCancion() {
        return tituloCancion;
    }

  
    
}
