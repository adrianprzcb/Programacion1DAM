package g1;

import prog.util.es.EntradaSalida;

/**
 * Created by Alumno1 on 18/11/2020.
 */
public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;

    public void ejecutar() {
        EntradaSalida  entradaSalida= new EntradaSalida();
        byte resultado1 = 0;
        byte resultado2 = 0;
        byte puntuacion1 = 0;
        byte puntuacion2 = 0;
        byte numpartidas = 1;
        jugador1 = new Jugador("Pepe");
        jugador2 = new Jugador("Paco");

        do {
            resultado1=jugador1.tirarDado();
            resultado2=jugador2.tirarDado();
            entradaSalida.mostrar("Partida nº"+numpartidas);
            entradaSalida.mostrar(jugador1.getNombre()+" ha sacado un "+resultado1);
            entradaSalida.mostrar(jugador2.getNombre()+" ha sacado un "+resultado2);
            if (resultado1<resultado2){
                puntuacion2++;
            }
            else {
                if (resultado2 < resultado1) {
                    puntuacion1++;
                }
            }
            numpartidas++;
        }while (numpartidas!=11);

        if (puntuacion1<puntuacion2){
            entradaSalida.mostrar(jugador2.getNombre()+" ha ganado más partidas, en total "+puntuacion2);
        }else {
            if (puntuacion2 < puntuacion1) {
                entradaSalida.mostrar(jugador1.getNombre() + " ha ganado más partidas, en total " + puntuacion1);
            }else entradaSalida.mostrar("han empatado");
        }

    }
}
