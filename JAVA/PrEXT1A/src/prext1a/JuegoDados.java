package prext1a;

import prog.util.es.EntradaSalida;

/**
 * Created by edu on 30/11/2020.
 */
public class JuegoDados {
    EntradaSalida entradaSalida;

    public JuegoDados() {
        entradaSalida = new EntradaSalida();
    }
    public void jugador(int numCaras, int numTiradas) {
        Jugador jugador1 = new Jugador("Paco", new Dado(numCaras));
        Jugador jugador2 = new Jugador ( "Jose", new Dado(numCaras));
        int totalJugador1 = 0;
        int totalJugador2 = 0;

        for (int i = 0; i < numTiradas; i++) {
            totalJugador1 += jugador1.tirarDado();
        }
        for (int i = 0; i < numTiradas; i++) {
            totalJugador2 += jugador2.tirarDado();
        }

        entradaSalida.mostrar("Total puntos "+jugador1.getNombre()+" : "+totalJugador1);
        entradaSalida.mostrar("Total puntos "+jugador2.getNombre()+" : "+totalJugador2);

        if (totalJugador1>totalJugador2) {
            entradaSalida.mostrar("Ha ganado "+jugador1.getNombre()+" con "+totalJugador1+" puntos.");
        } else if (totalJugador2>totalJugador1) {
            entradaSalida.mostrar("Ha ganado "+jugador2.getNombre()+" con "+totalJugador2+" puntos.");
        } else {
            entradaSalida.mostrar("Ambos jugadores han empatado.");
        }
    }
}
