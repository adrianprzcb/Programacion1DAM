package dam.prog.modelo.beans;

import dam.prog.modelo.beans.Artista;

/**
 * Created by Administrador on 15/03/2021.
 */
public class Poeta extends Artista {
    private String tituloPoema;

    public Poeta(String nombre, String tituloPoema) {
        super(nombre);
        this.setTituloPoema(tituloPoema);
    }
    public Poeta(String nombre, String tituloPoema, int puntuacion) {
        super(nombre);
        this.setTituloPoema(tituloPoema);
        setPuntuacion(puntuacion);
    }
    @Override
    public String actuar() {
        return "Voy a recitar el poema "+ getTituloPoema();
    }

    public String getTituloPoema() {
        return tituloPoema;
    }

    public void setTituloPoema(String tituloPoema) {
        this.tituloPoema = tituloPoema;
    }
}
