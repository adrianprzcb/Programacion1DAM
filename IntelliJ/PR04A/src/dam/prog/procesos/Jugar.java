package dam.prog.procesos;

import dam.prog.beans.CarasDadoPoker;
import dam.prog.beans.Jugador;

import java.util.ArrayList;
import java.util.HashMap;

public class Jugar {
    private static final int PUNTOS_REPOKER = 10;
    private static final int PUNTOS_POKER = 8;
    private static final int PUNTOS_FULL = 4;
    private static final int PUNTOS_TRIO = 2;

    private int numPartidas;
    private ArrayList<Jugador> jugadores;

    public Jugar(int numPartidas, ArrayList<Jugador> jugadores) {
        this.numPartidas = numPartidas;
        this.jugadores = jugadores;
    }

    public void jugar() {
        HashMap<CarasDadoPoker, Integer> jugada;
        for (int i = 0; i < numPartidas; i++) {
            System.out.println("Partida: "+(i+1));
            for (Jugador jugador: jugadores) {
                System.out.println("Jugador: "+jugador.getNombre());
                jugada = jugador.lanzarDados();
                puntuar (jugada, jugador);
                System.out.print(jugador.getUltimaJugada());
                System.out.println(" Puntos totales: "+jugador.getPuntosTotales());
            }
        }
    }

    private void puntuar(HashMap<CarasDadoPoker, Integer> jugada, Jugador jugador) {
        if (isRepoker(jugada)) jugador.incrementaPuntosTotales(Jugar.PUNTOS_REPOKER);
        else
            if (isPoker(jugada)) jugador.incrementaPuntosTotales(Jugar.PUNTOS_POKER);
            else
                if(isFull(jugada)) jugador.incrementaPuntosTotales(Jugar.PUNTOS_FULL);
                else
                    if (isTrio(jugada)) jugador.incrementaPuntosTotales(Jugar.PUNTOS_TRIO);

    }

    private boolean isTrio(HashMap<CarasDadoPoker, Integer> jugada) {
        return jugada.containsValue(3);
    }

    private boolean isFull(HashMap<CarasDadoPoker, Integer> jugada) {
        return jugada.containsValue(3) && jugada.containsValue(2);
    }

    private boolean isPoker(HashMap<CarasDadoPoker, Integer> jugada) {
        return jugada.containsValue(4);
    }

    private boolean isRepoker(HashMap<CarasDadoPoker, Integer> jugada) {
        return jugada.containsValue(5);
    }
}
