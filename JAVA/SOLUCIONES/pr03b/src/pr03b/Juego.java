package pr03b;

import java.util.ArrayList;

/**
 * Created by eduardo on 09/03/2021.
 */
public class Juego {
    private EntradaSalida entradaSalida;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partida> partidas;
    private int numJugadores;
    private int numDados;

    public Juego() {
        this.entradaSalida = new EntradaSalida();
        this.jugadores = new ArrayList<Jugador>();
        this.partidas = new ArrayList<Partida>();
    }
    public void jugar() {
        prepararDatos();
        crearJugadores();
        ejecutarPartidas();
        mostrarResultados();
    }


    private void prepararDatos() {
        numJugadores = pideNumero(4,"Introduzca número jugadores, mínimo 4:");
        numDados = pideNumero(2, "Introduzca el número de dados, mínimo 2:");
    }

    private int pideNumero(int valorMinimo, String mensaje) {
        boolean correcto = false;
        int numero = 0;
        do {
            try {
                entradaSalida.mostrar(mensaje);
                numero = entradaSalida.pideNumero();
                if (numero >= valorMinimo)
                    correcto = true;
                else
                    entradaSalida.mostrar("El número debe ser mayor o igual que "+valorMinimo);
            } catch(NumberFormatException nfe) {
                entradaSalida.mostrar("No ha introducido un número.");
            }
        } while(!correcto);
        return numero;
    }

    private void crearJugadores() {

        for (int i=0; i<numJugadores; i++)
            this.jugadores.add(creaJugador(numDados));
    }

    private Jugador creaJugador(int numDados) {
        String nombreJugador;
        ArrayList<Dado> cubilete = new ArrayList<Dado>();
        entradaSalida.mostrar("Introduzca el nombre del jugador: ");
        nombreJugador = entradaSalida.pideCadena();
        for (int i = 0; i < numDados; i++) {
            cubilete.add(new Dado());
        }
        return new Jugador(nombreJugador,cubilete );
    }

    private Partida ejecutarPartida() {
        int tiradaActual=0;
        String nombreJugadorActual;
        int puntosGanador = 0;
        int puntosPerdedor = 0;
        String nombreGanador = "";
        String nombrePerdedor = "";

        for (int i=0; i<jugadores.size();i++) {
            tiradaActual = jugadores.get(i).lanzarDados();
            nombreJugadorActual = jugadores.get(i).getNombre();
            if (i==0) {
                nombreGanador = nombreJugadorActual;
                nombrePerdedor = nombreGanador;
                puntosGanador = tiradaActual;
                puntosPerdedor = tiradaActual;
            } else {
                if(tiradaActual < puntosPerdedor) {
                    puntosPerdedor = tiradaActual;
                    nombrePerdedor = nombreJugadorActual;
                } else if (tiradaActual > puntosGanador) {
                    puntosGanador = tiradaActual;
                    nombreGanador = nombreJugadorActual;
                }
            }
        }
        if (nombreGanador.equals(nombrePerdedor))
            return null;
        else
            return new Partida(nombreGanador,puntosGanador, nombrePerdedor, puntosPerdedor);
    }
    private void ejecutarPartidas() {
        Partida partida;
        for (int i=0; i<10; i++) {
            partida = ejecutarPartida();
            if (partida != null)
                partidas.add(ejecutarPartida());
        }
    }

    private void mostrarResultados() {

        resultadosPartidas();

        resultadosJugadores();

    }

    private void resultadosJugadores() {
        Jugador jugador;
        Partida partidaActual=null;
        int partidasGanadas;

        for (int i=0; i<jugadores.size();i++) {
            jugador = jugadores.get(i);
            partidasGanadas=0;
            for (int j=0; j<partidas.size();j++) {
                partidaActual = partidas.get(j);
                if (jugador.getNombre().equals(partidaActual.getNombreGanador()))
                    partidasGanadas++;
            }
            entradaSalida.mostrar("El jugador "+jugador.getNombre()+" ha ganado "+partidasGanadas+" partidas.");
        }
    }

    private void resultadosPartidas() {
        int numeroPartida = 1;
        for (Partida partida: partidas) {
            entradaSalida.mostrar("Resultados partida "+numeroPartida);
            entradaSalida.mostrar(partida);
            numeroPartida++;
        }
    }

}
