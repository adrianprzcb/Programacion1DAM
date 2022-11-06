package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

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
	 * @throws IOException
	 */
	public String pideCadena() throws IOException{
		String respuesta = null;

		respuesta = flujoEntrada.readLine();

		return respuesta;
	}

	/**
	 * Devuelve un número leído por teclado, o NumberFormartException si
	 * no puede convertirse a entero.
	 * @return El número leído.
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public int pideNumero() throws NumberFormatException, IOException{
		String cadena;
		int numero = 0;
		cadena = pideCadena();
		numero = Integer.parseInt(cadena);
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


}

