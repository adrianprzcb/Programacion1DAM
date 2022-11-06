package modelo.beans;

public class Jugador {

	private String nombre;

	private int puntosCerebro;

	private Cubilete cubilete;

	public Jugador(String nombre, Cubilete cubilete) {
		this.nombre = nombre;
		this.cubilete = cubilete;
	}

	public void setPuntosCerebro(int puntosCerebro) {
		this.puntosCerebro = puntosCerebro;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntosCerebro() {
		return puntosCerebro;
	}

	public Cubilete getCubilete() {
		return cubilete;
	}

	public void setCubilete(Cubilete cubilete) {
		this.cubilete = cubilete;
	}

	public String toString() {
		String cadena = "";

		cadena = nombre+" --> "+ puntosCerebro+"\n";
		return cadena;
	}

}
