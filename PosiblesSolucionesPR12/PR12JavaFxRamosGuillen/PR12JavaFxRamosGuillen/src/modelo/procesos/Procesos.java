package modelo.procesos;

import java.util.ArrayList;

import modelo.beans.Cubilete;
import modelo.beans.Dado;
import modelo.beans.Jugador;

public class Procesos {

	ArrayList<Jugador>jugadores;
	
	public Procesos() {
		jugadores=new ArrayList();
	}
	public void crearJugadores(String[] nombres) {
		
		Cubilete cubileteTemp;
		cubileteTemp=new Cubilete(crearCubilete());
		for(int i=0;i<nombres.length;i++) {
			jugadores.add(new Jugador(nombres[i],cubileteTemp));
		}
		
		
		
		
		
	}
	
	private ArrayList<Dado> crearCubilete() { //No entendi bien el enunciado y lo he dejado asi
		int color;
		Dado dadoTemp =null;
		ArrayList<Dado>dados=null;
		
		dadoTemp= new Dado();
		dados=new ArrayList();
		
		for(int i=0;i<13;i++) {
			color=(int)(Math.random()*3)+1;
			if(i<6) {
				dadoTemp=new Dado(3,1,2);
				dados.add(dadoTemp);
			}else if(i<10) {
				dadoTemp=new Dado(2,2,2);
				dados.add(dadoTemp);
			}else if (i<13) {
				dadoTemp=new Dado(1,3,2);
				dados.add(dadoTemp);
			}
			}
		
		return dados;
	}
	
	public String jugar() {
		String resultado="";
		if(jugadores.get(0).getPuntosCerebro()>13 ) {
			resultado="El ganador es "+jugadores.get(0).getNombre();
		}else if(jugadores.get(1).getPuntosCerebro()>13){ //lo he hecho con prisas
			resultado="El ganador es "+jugadores.get(1).getNombre();
		}else {
		for(int i=0;i<jugadores.size();i++) {
			jugadores.get(i).setPuntosCerebro(jugadores.get(i).getCubilete().usarCubilete()+
					jugadores.get(i).getPuntosCerebro());
			
			
			
			
		}
		for(int i=0;i<jugadores.size();i++) {
			resultado+=jugadores.get(i);
		}
		}
		
		
		
		return resultado;
	}

	public void reiniciar() {
		jugadores=new ArrayList();
		
	}
	public void volverAJugar() {
		for(int i=0;i<jugadores.size();i++)
			jugadores.get(i).setPuntosCerebro(0);
	}

}
