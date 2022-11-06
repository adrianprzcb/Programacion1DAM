package ahorcado.juego;

import prog.util.es.EntradaSalida;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class Juego {


    private ArrayList<String> palabras;
    private ArrayList<String> jugadores;

    public Juego(){
        this.palabras = new ArrayList<String>();
        this.jugadores = new ArrayList<String>();
    }


    public void jugar() {

        if(!palabras.isEmpty()){
            System.out.println("Cargando palabras...");
            System.out.println("Cargados correctamente.");
        }else{
            System.out.println( "No hay palabras. Añade las palabras antes de ejecutar el juego. Opción 1");
        }
        if(!jugadores.isEmpty()){
            System.out.println("Cargando jugadores...");
            System.out.println("Cargandos correctamente.");

        }else{
            System.out.println( "No hay jugadores. Añade los jugadores antes de ejecutar el juego. Opción 2");
        }



        for (int in = 0; in < jugadores.size(); in++) {

            System.out.println("Turno de " + jugadores.get(in));
            int rnd = new Random().nextInt(palabras.size());
            String palabra = palabras.get(rnd);
            palabras.remove(rnd);
            char[] palabraGuiones = getGuionesFromPalabra(palabra);

            boolean juegoTerminado = false;
            Scanner lector = new Scanner(System.in);
            int vidas = 7;
            do {
                System.out.println("Te quedan " + vidas + " vidas.");
                System.out.println(palabraGuiones);
                System.out.println("Introduce una letra");
                char letra = lector.next().charAt(0);
                boolean algunaLetraAcertada = false;
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra) {
                        palabraGuiones[i] = letra;
                        algunaLetraAcertada = true;
                    }
                }
                if (!algunaLetraAcertada) {
                    System.out.println("No has acertado ninguna letra");
                    --vidas;
                    if (vidas == 0) {
                        System.out.println("Has perdido, te quedaste sin vidas");
                        juegoTerminado = true;
                    }
                } else {
                    boolean juegoGanado = !hayGuiones(palabraGuiones);
                    if (juegoGanado) {
                        System.out.println("Enhorabuena "+jugadores.get(in) +". Has acertado tu palabra");
                        juegoTerminado = true;
                    }

                }
            } while (!juegoTerminado);

        }


    }




    private char[] getGuionesFromPalabra(String palabra) {
        int nLetrasPalabraSecreta = palabra.length();

        char[] palabraGuiones = new char[nLetrasPalabraSecreta];

        for (int i = 0; i < palabraGuiones.length; i++) {
            palabraGuiones[i] = '_';
        }
        return palabraGuiones;
    }

    private boolean hayGuiones(char[] array){
        for(char l:array){
            if(l=='_')return true;
        }
        return false;
    }



    public void setPalabras(ArrayList<String> palabras) {
        for(int i =0;i<palabras.size(); i++){
            this.palabras.add(palabras.get(i));
        }
    }

    public void setJugadores(ArrayList<String> jugadores) {
        for(int i =0;i<jugadores.size(); i++){
            this.jugadores.add(jugadores.get(i));
        }
        System.out.println(this.jugadores.size());
    }
}
