/*
 * Copyright (c) Eduardo A. Ponce - IES Punta del Verde - Sevilla
 */

package prog.util.es;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

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

    /**
     * Lee una cadena desde el flujo de entrada.
     * @return Cadena leída
     */
    public String pideCadena() {
        String respuesta = null;
        try {
            respuesta = flujoEntrada.readLine();
        }
        catch(IOException ioe) {
            flujoSalida.println("ERROR: Al leer desde teclado.");
        }
        return respuesta;
    }

    /**
     * Muestra una cadena en pantalla
     * @param cadena LA cadena a mostrar
     */
    public void mostrar(String cadena) {
        flujoSalida.println(cadena);
    }
}
