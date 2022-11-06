package ejca09ga;

import prog.util.es.EntradaSalida;

/**
 * Created by Javi on 03/04/2021.
 */
public class Malabarista extends Artista{
    private int numObjetos;
    private EntradaSalida entradaSalida;

    public Malabarista(String nombre, int edad, int numConcursante, int numObjetos) {
        super(nombre,edad,numConcursante);
        this.numObjetos=numObjetos;
        entradaSalida = new EntradaSalida();
    }

    @Override
    public void saludar() {
        entradaSalida.mostrar("Me llamo "+getNombre()+", tengo "+getEdad()+" años, soy el concursante nº "+getNumConcursante()+" y soy malabarista");
    }

    @Override
    public void actuar() {
        entradaSalida.mostrar("Voy a hacer malabares con "+numObjetos+" objetos");
    }

    @Override
    public void despedirse() {
        entradaSalida.mostrar("He terminado por lo tanto me voy, gracias");
    }
}
