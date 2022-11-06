package ejca09ga;

import prog.util.es.EntradaSalida;

/**
 * Created by Javi on 03/04/2021.
 */
public abstract class Artista {
    private String nombre;
    private int edad;
    private int numConcursante;

    public Artista(String nombre,int edad,int numConcursante) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setNumConcursante(numConcursante);
    }
    public abstract void saludar();

    public abstract void actuar();

    public abstract void despedirse();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumConcursante() {
        return numConcursante;
    }

    public void setNumConcursante(int numConcursante) {
        this.numConcursante = numConcursante;
    }
}
