package interfaces;

import beans.Gato;
import beans.Perro;
import beans.Persona;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Perro perro=new Perro();
		Persona persona=new Persona();
		Gato gato = new Gato();
                
		perro.canta();
		perro.canta("canta perrito esta letrita");
		perro.saludo();
		perro.saludo("soy un perro");
		perro.saludo("Hola, soy", "pinki");

		gato.canta();
		gato.canta("canta gatito esta letrita");
		gato.saludo();
		gato.saludo("soy un gato");
		gato.saludo("Hola, soy", "pumuki");

		persona.canta();
		persona.canta("esta letra tan bonita");
		persona.saludo();
		persona.saludo("hola soy una persona");
		persona.saludo("ehhhhhh", "¿cómo vas?");
	}

}

