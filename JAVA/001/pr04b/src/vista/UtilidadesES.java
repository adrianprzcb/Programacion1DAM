package vista;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Proporciona soporte para entrada y salida
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class UtilidadesES {
	/**
	 * Flujo de entrada
	 */
	private BufferedReader flujoEntrada = null;
	/**
	 * Flujo de salida
	 */
	private PrintStream flujoSalida = null;

	private Scanner scanner;

	public UtilidadesES(BufferedReader flujoEntrada, PrintStream flujoSalida) {
		this.flujoEntrada = flujoEntrada;
		this.flujoSalida = flujoSalida;
	}
	/**
	 * Muestra un mensaje por el flujo de salida
	 * @param cadena Mensaje que se mostrar�
	 */
	public void mostrar(String cadena) {
			flujoSalida.print(cadena);
	}
	/**
	 * Muestra un mensaje por el flujo de salida
	 * con salto de l�nea
	 * @param cadena Mensaje que se mostrar�
	 */
	public void mostrarln(String cadena) {
		mostrar(cadena+"\n");
	}
	/**
	 * Muestra un objeto por el flujo de salida
	 * con salto de l�nea
	 */
	public void mostrarln(Object objeto) {
		mostrar(objeto+"\n");
	}	
	/**
	 * Pide una cadena desde el flujo de entrada mostrando previamente
	 * un mensaje.
	 * @param mensaje Mensaje que se muestra
	 * @return Cadena le�da
	 * @throws IOException Error en lectura de datos desde flujo entrada.
	 */
	public String pideCadena(String mensaje) throws IOException{
		String respuesta = null;
		System.out.println(mensaje);
		try {
			respuesta = flujoEntrada.readLine();
		}
		catch(IOException ioe) {
			throw new IOException("Error al leer de teclado en pideCadena()",ioe);
		}
		return respuesta;
	}

	public int pideEntero(String mensaje) {
		System.out.println(mensaje);
		int dato;
		dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return dato;
	}

	/*public ArrayList cargaPalabras(String nombreArchivo) throws FileNotFoundException{
		ArrayList<Palabra> listaPalabras = new ArrayList<>();
		Palabra objetoPalabra;
		String[] tokens;
		String cadena;
		String palabra;
		scanner = new Scanner(new File(nombreArchivo));
		scanner.useDelimiter(":");
		while (scanner.hasNextLine()) {
			cadena = scanner.nextLine();
			tokens = cadena.split(":");
			palabra = tokens[0].trim();

			objetoPalabra = new Palabra(palabra);
			listaPalabras.add(objetoPalabra);
		}

		return listaPalabras;
	}

	public char pideCharSC() {
		char caracter = scanner.next().toLowerCase().charAt(0);
		return caracter;
	}
	*/
}
