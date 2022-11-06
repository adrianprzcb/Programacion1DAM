package modelo.procesos;

import modelo.beans.Jugador;

import java.util.Comparator;
/**
 * Created by legion on 05/05/2021.
 */
public class CompararMejorJugador implements Comparator<Jugador> {
    @Override
    public int compare(Jugador jugador1, Jugador jugador2) {
        if(jugador1.getValorTotal()> jugador2.getValorTotal()){
            return -1;
        }else if(jugador1.getValorTotal() > jugador2.getValorTotal()){
            return 0;
        }else{
            return 1;
        }
    }
}
