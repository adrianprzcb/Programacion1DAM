package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Proporciona soporte para entrada y salidas
 *
 * @author Marina y Salvador
 * @version 1.0
 */
public class UtilidadesES {

    /**
     * Flujo de entrada
     */
    static private BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Flujo de salida
     */
    static private PrintStream flujoSalida = System.out;

    /**
     * Muestra un mensaje por el flujo de salida
     *
     * @param cadena Mensaje que se mostrar�
     */
    static public void mostrar(String cadena) {
        flujoSalida.print(cadena);
    }

    /**
     * Muestra un mensaje por el flujo de salida con salto de l�nea
     *
     * @param cadena Mensaje que se mostrar�
     */
    static public void mostrarln(String cadena) {
        mostrar(cadena + "\n");
    }

    /**
     * Muestra un objeto por el flujo de salida con salto de l�nea
     *
     * @param objeto Mensaje que se mostrar�
     */
    static public void mostrarln(Object objeto) {
        mostrar(objeto + "\n");
    }

    /**
     * Pide una cadena desde el flujo de entrada mostrando previamente un
     * mensaje.
     *
     * @param mensaje Mensaje que se muestra
     * @return Cadena le�da
     * @throws IOException Error en lectura de datos desde flujo entrada.
     */
    static public String pideCadena(String mensaje) throws IOException {
        String respuesta = null;
        mostrar(mensaje);
        try {
            respuesta = flujoEntrada.readLine();
        } catch (IOException ioe) {
            throw new IOException("Error al leer de teclado en pideCadena()", ioe);
        }
        return respuesta;
    }

    /**
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    static public int pideEntero(String mensaje) throws IOException {
        int numero;
        try {
            numero = Integer.parseInt(pideCadena(mensaje));
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Error. El valor introducido no es un número válido.");
        }
        return numero;
    }

    /**
     * Lee una variable String con Scanner
     *
     * @return devuelve el String leido.
     */
    static public String leerString() {
        Scanner sc = new Scanner(System.in);
        String localidad = null;

        localidad = sc.nextLine();

        return localidad;
    }

    /**
     * Lee una variable int con Scanner
     *
     * @return devuelve el int leido.
     */
    static public int leerInt() {
        Scanner sc = new Scanner(System.in);
        int puntuacion = 0;

        puntuacion = sc.nextInt();

        return puntuacion;
    }

}
