package dam.prog.modelo.beans;

import dam.prog.modelo.beans.Artista;

/**
 * Created by Administrador on 15/03/2021.
 */
public class Cantante extends Artista {
    private String tituloCancion;

    public Cantante(String nombre, String tituloCancion) {
        super(nombre);
        this.tituloCancion = tituloCancion;
    }
    public Cantante(String nombre, String tituloCancion, int puntuacion) {
        super(nombre);
        this.tituloCancion = tituloCancion;
        this.setPuntuacion(puntuacion);
    }
    @Override
    public String actuar() {
        return "Voy a interpretar la canción "+tituloCancion;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }
}
