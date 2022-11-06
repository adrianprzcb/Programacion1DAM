package ejca09ga;

import prog.util.es.EntradaSalida;

/**
 * Created by Javi on 03/04/2021.
 */
public class Poeta extends Artista {
    private String poema;
    EntradaSalida entradaSalida;

    public Poeta(String nombre, int edad, int numConcursante, String poema) {
        super(nombre,edad,numConcursante);
        this.poema=poema;
        entradaSalida = new EntradaSalida();
    }

    @Override
    public void saludar() {
        entradaSalida.mostrar("Me llamo "+getNombre()+", tengo "+getEdad()+" años, soy el concursante nº "+getNumConcursante()+" y soy poeta");
    }

    @Override
    public void actuar() {
        entradaSalida.mostrar("Voy a recitar "+poema);
    }

    @Override
    public void despedirse() {
        entradaSalida.mostrar("He terminado por lo tanto me voy, gracias");
    }
}
