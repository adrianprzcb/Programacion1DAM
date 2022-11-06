package ejentradasalida;

import prog.util.es.EntradaSalida;

/**
 * Created by eduardo on 13/11/2020.
 */
public class EjEntradaSalida {
    public void ejecutar() {
        EntradaSalida entradaSalida = new EntradaSalida();
        String cadena;

        entradaSalida.mostrar("Introduzca una palabra: ");
        cadena = entradaSalida.pideCadena();
        System.out.println("Cadena leída: "+cadena);
    }
}
