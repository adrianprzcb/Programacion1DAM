package prog.util.es;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JOptionPane;

/**
 * Proporciona soporte para entrada y salida
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class EntradaSalida {
    /**
     * Flujo de entrada
     */
    private BufferedReader flujoEntrada;
    /**
     * Flujo de salida
     */
    private PrintStream flujoSalida;

    /**
     * Constructor sin parámetros que establece los flujos de entrada y salida al
     * teclado y a la pantlla.
     */
    public EntradaSalida() {
        flujoEntrada = new BufferedReader((new InputStreamReader(System.in)));
        flujoSalida = System.out;
    }
    /**
     * Constructor que recibe los flujos de entrada y salida
     * @param flujoEntrada
     * @param flujoSalida
     */
    public EntradaSalida(BufferedReader flujoEntrada, PrintStream flujoSalida) {
        this.flujoEntrada = flujoEntrada;
        this.flujoSalida = flujoSalida;
    }
    /**
     * Muestra un mensaje por el flujo de salida
     * @param cadena Mensaje que se mostrará
     */
    public void mostrar(String cadena) {
        flujoSalida.print(cadena);
    }
    /**
     * Muestra un mensaje por el flujo de salida
     * con salto de línea
     * @param cadena Mensaje que se mostrará
     */
    public void mostrarln(String cadena) {
        mostrar(cadena+"\n");
    }
    /**
     * Muestra un objeto por el flujo de salida
     * con salto de línea
     * @param objeto Mensaje que se mostrará
     */
    public void mostrarln(Object objeto) {
        mostrar(objeto+"\n");
    }
    /**
     * Pide una cadena desde el flujo de entrada mostrando previamente
     * un mensaje.
     * @param mensaje Mensaje que se muestra
     * @return Cadena leída
     * @throws IOException Error en lectura de datos desde flujo entrada.
     */
    public String pideCadena(String mensaje) throws IOException{
        String respuesta = null;
        mostrar(mensaje);
        respuesta = flujoEntrada.readLine();

        return respuesta;
    }

    /**
     * Solicita un dato a nivel gráfico, y devuelve el dato convertido en entero
     * @param mensaje El mensaje que se visualizará en la ventana de introducción de dato
     * @return Entero con el dato introducido
     * @exception NumberFormatException Excepción en caso de que el dato introducido no
     * pueda convertirse en entero.
     */
    public static int pideEntero(String mensaje) {
        int dato;
        dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return dato;
    }
}
