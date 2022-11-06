package dam.prog;

import dam.prog.beans.Jugador;
import dam.prog.procesos.Jugar;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        Jugador jugador = new Jugador("Eduardo", 5);
        jugador.lanzarDados();
        */
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Bubu",5));
        jugadores.add(new Jugador("Momo",5));
        jugadores.add(new Jugador("Pepe",5));
        Jugar jugar = new Jugar(6,jugadores);
        jugar.jugar();
    }
}
