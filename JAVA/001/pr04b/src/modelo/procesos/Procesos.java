package modelo.procesos;

import modelo.beans.Jugador;
import vista.UtilidadesES;

import java.io.*;
import java.util.*;

/**
 * Created by alumno2 on 30/04/2021.
 */
public class Procesos {
    private UtilidadesES utilidadesES;
    private ArrayList<Jugador> listaJugadores;
    private boolean datosIntroducidos;
    private boolean juegoTerminado;
    private Jugador jugador;
    private File archivo;

    public Procesos(UtilidadesES utilidadesES) {
        this.utilidadesES = utilidadesES;
        listaJugadores = new ArrayList<>();
        datosIntroducidos = false;
        juegoTerminado = false;
        archivo = new File("jugadores.txt");
    }

    public void ejecutarOpc(int opc) {
        switch (opc) {
            case 1: ejecutarOpcIntroducirDatosJugador();break;
            case 2: ejecutarOpcJugar(); break;
            case 3: ejecutarOpcMejorPeor(); break;
            case 4: ejecutarOpcPeorMejor(); break;
            case 5: ejecutarOpcGuardarArchivo(); break;
            case 0: ejecutarOpcSalir();break;
            default: ejecutarNada();
        }
    }

    private void ejecutarOpcGuardarArchivo() {
        PrintWriter pw;
        String cadena;
        if (juegoTerminado){
            try{
                if (archivo.exists()) {
                    if (archivo.canWrite()) {
                        pw = new PrintWriter(new FileWriter(archivo));
                        for (Jugador jugador : listaJugadores) {
                            cadena = jugador.toString();
                            pw.println(cadena);
                        }
                        pw.close();
                    }
                } else {
                    archivo.createNewFile();
                    System.out.println("No existías el archivo para guardar, porfavor vuelva a seleccionar esta acción");
                }
            } catch (IOException ioe){
                System.out.println("Se ha producido un error en la escritura del archivo");
            }
        } else {
            System.out.println("Se debe jugar primero para realizar esta opción");
        }
    }

    private void ejecutarOpcPeorMejor() {
        if (juegoTerminado){
            Collections.sort(listaJugadores, new CompararPeorJugador());
            for (Jugador jugador :listaJugadores) {
                System.out.println(jugador.toString());
            }
        } else {
            System.out.println("Se debe jugar primero para realizar esta opción");
        }
    }

    private void ejecutarOpcMejorPeor() {
        if (juegoTerminado){
            Collections.sort(listaJugadores, new CompararMejorJugador());
            for (Jugador jugador : listaJugadores) {
                System.out.println(jugador.toString());
            }
        } else {
            System.out.println("Se debe jugar primero para realizar esta opción");
        }
    }

    private void ordenaMejor() {

    }

    private void ejecutarOpcJugar() {
        if (datosIntroducidos){
            int[] listaPuntuaje = new int[6];
            for (Jugador jugador : listaJugadores) {
                for (int i = 0; i < 6; i++) {
                    jugador.setValorTirada1(jugador.getDado1().lanzarDados());
                    jugador.setValorTirada2(jugador.getDado2().lanzarDados());
                    jugador.setValorTirada3(jugador.getDado3().lanzarDados());
                    jugador.setValorTiradaPartida(jugador.getValorTirada1()+jugador.getValorTirada2()+jugador.getValorTirada3());
                    listaPuntuaje[i] = jugador.getValorTiradaPartida();
                }
                jugador.setValorTotal(listaPuntuaje[0]+listaPuntuaje[1]+listaPuntuaje[2]+listaPuntuaje[3]+listaPuntuaje[4]+listaPuntuaje[5]);
                listaPuntuaje = new int[6];
                juegoTerminado = true;
            }
        } else{
            System.out.println("Para poder jugar primero deben introducirse los nombres de los Jugadores");
        }
    }

    private void ejecutarOpcSalir() {
        System.out.println("Se procede a la salida de la aplicación");
        System.out.println("-----------------------------------------------------");
    }
    private void ejecutarNada() {
        utilidadesES.mostrarln("La opción introducida no tiene un proceso asociado.");
    }

    private void ejecutarOpcIntroducirDatosJugador() {
        try{
            int contador = 0;
            listaJugadores.clear();
            do {
                Jugador jugador = new Jugador(utilidadesES.pideCadena("Porfavor introduzca el nombre del Jugador"));
                if (jugador.getNombre().equals("")){
                    System.out.println("No se puede poner el nombre de Jugador como cadena vacia");
                } else if (jugador.getNombre().equals(null)){
                    System.out.println("No se puede poner a null el nombre del Jugador");
                } else {
                    listaJugadores.add(jugador);
                    contador++;
                }
            } while (contador != 5);
            datosIntroducidos = true;
        } catch (IOException ioe){
            System.out.println("Se ha producido una IOEception en la toma de los nombres de los Jugadores.");
        }
    }
}
