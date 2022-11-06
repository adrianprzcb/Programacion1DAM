package dam.prog.modelo.beans;

/**
 * Created by Administrador on 15/03/2021.
 */
public abstract class Artista {

    private String nombre;
    private int puntuacion;

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public abstract String actuar();
    public String saludar() {
        return "Hola, me llamo "+this.nombre+", saludos!";
    }
    public String despedirse() {
        return "Y esto ha sido todo, muchas gracias!";
    }

    public String getNombre() {
        return nombre;
    }
    public boolean equals(Object artista) {
        if (this.nombre.equals(((Artista) artista).getNombre())) return true;
        else return false;
    }

    public int hashcode() {
        return this.nombre.hashCode();
    }

    public String toString() {
        return "Nombre: "+this.getNombre()+", puntuación: "+this.getPuntuacion();
    }
}
