package ahorcado.juego;

import prog.util.es.*;
import java.util.ArrayList;
import java.lang.*;

public class PedirJugadores {

    private ArrayList<String> jugadores;
    private EntradaSalida entradaSalida;

    public PedirJugadores(){
        setJugadores(new ArrayList<String>());
        entradaSalida = new EntradaSalida();
    }

    public void crearJugadores(){
        entradaSalida.mostrar("Por favor, introduzca el numero de jugadores:");
        String num = entradaSalida.pideCadena();
        int numeroJug = Integer.parseInt(num);

        for(int i=0; i<numeroJug;i++){
            entradaSalida.mostrar("Por favor, introduzca el nombre del jugador" + (i+1));
            String jugador = entradaSalida.pideCadena();
            getJugadores().add(jugador);
        }
        for(int i=0; i<numeroJug;i++) {
            entradaSalida.mostrar(getJugadores().get(i));
        }
    }


    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<String> jugadores) {
        this.jugadores = jugadores;
    }
}
