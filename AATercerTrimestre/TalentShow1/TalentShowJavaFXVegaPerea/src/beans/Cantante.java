package beans;

import beans.Artista;
    /**
     * 
     * @author Marina y Salvador
     */
public class Cantante extends Artista {
    
    private String tituloCancion;
    /**
     * Crea un artista del tipo cantante 
     * @param localidad Parametro que asigna localidad al artista.
     * @param nombre Parametro que asigna nombre al artista.
     * @param edad Parametro que asigna edad al artista.
     * @param tituloCancion Parametro que asigna un titulo a la cancion.
     */
    public Cantante (String localidad, String nombre, int edad, String tituloCancion) {
        super(localidad,nombre, edad);
        this.tituloCancion = tituloCancion;               
    }
    /**
     * El artista realiza su actuación
     */
    @Override
    public String actuar() {
        return "Voy a cantar la canción "+getTituloCancion();
    }

    /**
     * @return devuelve el titulo de la canción.
     */
    public String getTituloCancion() {
        return tituloCancion;
    }

    /**
     * Establece el titulo de la canción.
     * @param tituloCancion the tituloCancion to set
     */
    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }
    
}
