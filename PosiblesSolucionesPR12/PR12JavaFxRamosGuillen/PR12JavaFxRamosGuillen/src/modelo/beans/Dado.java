package modelo.beans;

public  class Dado {

	protected int cerebros;
	
	protected int disparo;
	
	protected int huellas;
	
	
	
	public final int verde=1;
	
	public final int amarillo=2;
	
	public final int rojo=3;
	
	
public Dado() {
		
		
		
	}

	public Dado(int cerebros, int disparo, int huellas ) {
		
		this.cerebros = cerebros;
		this.disparo = disparo;
		this.huellas = huellas;
		
	}

	public int getCerebros() {
		return cerebros;
	}

	public void setCerebros(int cerebros) {
		this.cerebros = cerebros;
	}

	public int getDisparo() {
		return disparo;
	}

	public void setDisparo(int disparo) {
		this.disparo = disparo;
	}

	public int getHuellas() {
		return huellas;
	}

	public void setHuellas(int huellas) {
		this.huellas = huellas;
	}

	

	public int getVerde() {
		return verde;
	}

	public int getRojo() {
		return rojo;
	}

	public int getAmarillo() {
		return amarillo;
	}
	
	
	

}
