package ud3ejclase02;

public class Poeta extends Artista {

    private String tituloPoema;
    
    public Poeta(int numConcursante, String nombre, int edad, String tituloPoema){
        super(numConcursante,nombre, edad);
        this.tituloPoema = tituloPoema;
    }
    @Override
    public void actuar() {
        System.out.println("Voy a recitar el poema "+getTituloPoema());
    }

    /**
     * @return the tituloPoema
     */
    public String getTituloPoema() {
        return tituloPoema;
    }

  
}
