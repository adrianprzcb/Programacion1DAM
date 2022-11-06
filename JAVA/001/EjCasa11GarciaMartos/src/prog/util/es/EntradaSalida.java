/*
 * Copyright (c) Eduardo A. Ponce - IES Punta del Verde - Sevilla
 */

package prog.util.es;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by edu on 31/10/2020.
 * Proporciona soporte para entrada y salida de datos
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class EntradaSalida {

    /**
     * Flujo de entrada
     */
    private BufferedReader flujoEntrada = null;

    /**
     * Flujo de salida
     */
    private PrintStream flujoSalida = null;

    /**
     * Constructor por defecto. Entrada: teclado. Salida: pantalla
     */
    public EntradaSalida() {
        flujoEntrada = new BufferedReader((new InputStreamReader(System.in)));
        flujoSalida = System.out;
    }

    public EntradaSalida(BufferedReader flujoEntrada, PrintStream flujoSalida) {
        this.flujoEntrada = flujoEntrada;
        this.flujoSalida = flujoSalida;
    }

    /**
     * Lee una cadena desde el flujo de entrada.
     * @return Cadena leída
     */
    public String pideCadena() throws IOException {
        String respuesta = null;
            respuesta = flujoEntrada.readLine();
        return respuesta;
    }

    public String pideCadenaMensaje(String mensaje) throws IOException {
        mostrar(mensaje);
        String respuesta = null;
        respuesta = flujoEntrada.readLine();
        return respuesta;
    }

    /**
     * Devuelve un número leído por teclado, o NumberFormartException si
     * no puede convertirse a entero.
     * @return El número leído.
     * @throws NumberFormatException
     */
    public int pideNumero() throws NumberFormatException, IOException{
        String cadena = pideCadena();
        int numero = 0;
        try {
            numero = Integer.parseInt(cadena);
        } catch(NumberFormatException nfe) {
            throw nfe;
        }
        return numero;

    }

    public int pideNumeroMensaje(String mensaje) throws NumberFormatException, IOException{
        mostrar(mensaje);
        String cadena = pideCadena();
        int numero = 0;
        try {
            numero = Integer.parseInt(cadena);
        } catch(NumberFormatException nfe) {
            throw nfe;
        }
        return numero;

    }

    /**
     * Lee un número usando la clase Scanner.
     * @return Número entero leído.
     */
    public int pideNumeroSC() {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        //scanner.nextLine(); // limpia el búfer. Debe usarse si se emplean varios scanner con lectura de cadena después
        // de lectura de números.
        return numero;
    }

    /**
     * Muestra una cadena en pantalla
     * @param cadena LA cadena a mostrar
     */
    public void mostrar(String cadena) {
        flujoSalida.println(cadena);
    }

    public int leeEntero(String mensaje) throws NumberFormatException{
        int numero=0;
            try {
                mostrar(mensaje);
                String cadena = pideCadena();
                if (cadena.isEmpty()) {
                    throw new NumberFormatException();
                }
                numero = Integer.parseInt(cadena);
        } catch (IOException ioe) {
                mostrar("Error.");
            }
        return numero;
    }
}