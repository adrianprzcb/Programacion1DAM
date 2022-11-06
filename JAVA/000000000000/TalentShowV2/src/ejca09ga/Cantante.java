package ejca09ga;

import prog.util.es.EntradaSalida;

/**
 * Created by Javi on 03/04/2021.
 */
public class Cantante extends Artista {
    private String cancion;
    private EntradaSalida entradaSalida;

    public Cantante(String nombre, int edad, int numConcursante, String cancion) {
        super(nombre,edad,numConcursante);
        this.cancion=cancion;
        entradaSalida = new EntradaSalida();
    }

    @Override
    public void saludar() {
        entradaSalida.mostrar("Me llamo "+getNombre()+", tengo "+getEdad()+" años, soy el concursante nº "+getNumConcursante()+" y soy cantante");
    }

    @Override
    public void actuar() {
        entradaSalida.mostrar("Voy a interpretar "+cancion);
    }

    @Override
    public void despedirse() {
        entradaSalida.mostrar("He terminado por lo tanto me voy, gracias");
    }
}
