package prjinterfaces.beans;

import prjinterfaces.interfaces.Cantar;
import prjinterfaces.interfaces.Saludar;

public class Persona implements Saludar, Cantar {

	@Override
	public void canta() {
		System.out.println("tralara tralara");
		
	}

	@Override
	public void canta(String letra) {
		System.out.println("Voy a cantar esta letra :"+letra);
	}

	@Override
	public void saludo() {
		System.out.println("Hola señor/a ¿cómo está?");
	}

	@Override
	public void saludo(String saludo, String nombre) {
		System.out.println(saludo+" "+nombre);
		
	}

	@Override
	public void saludo(String saludo) {
		System.out.println(saludo+" señor/a");
		
	}

}

