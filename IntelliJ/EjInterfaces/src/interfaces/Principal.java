package interfaces;

import prjinterfaces.beans.Perro;
import prjinterfaces.beans.Persona;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Perro perro=new Perro();
                Persona persona=new Persona();
                
		perro.canta();
		perro.canta("canta perrito esta letritas");
		perro.saludo();
		perro.saludo("soy un perro");
		perro.saludo("Hola, soy", "pinki");

		persona.canta();
		persona.canta("esta letra tan bonita");
		persona.saludo();
		persona.saludo("hola soy una persona");
		persona.saludo("ehhhhhh", "¿cómo vas?");
	}

}

