package ejclase04;

import prog.util.es.EntradaSalida;

/**
 * Created by eduardo on 18/11/2020.
 */
public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;

    public void ejecutar() {
        EntradaSalida entradaSalida = new EntradaSalida();
        byte resultado = 0;
        jugador1 = new Jugador("Pepe");
        jugador2 = new Jugador("Paco");

        resultado = jugador1.tirarDado();
        entradaSalida.mostrar(jugador1.getNombre()+" ha sacado un "+resultado);
        resultado = jugador2.tirarDado();
        entradaSalida.mostrar(jugador2.getNombre()+" ha sacado un "+resultado);
    }
}
