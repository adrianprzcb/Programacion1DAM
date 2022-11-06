package beans;


import interfaces.Cantar;
import interfaces.Saludar;

public class Perro implements Saludar, Cantar {

	@Override
	public void canta() {
		System.out.println("Gua Gua Guaaaaau");
		
	}

	@Override
	public void canta(String letra) {
		System.out.println("Guaguauugua (trad: voy a cantar ahora) :"+letra);
	}

	@Override
	public void saludo() {
		System.out.println("Guaua guau");
	}

	@Override
	public void saludo(String saludo, String nombre) {
		System.out.println("Guau "+saludo+" "+nombre);
		
	}

	@Override
	public void saludo(String saludo) {
		System.out.println(saludo+" guau!");
		
	}

	

	
}
