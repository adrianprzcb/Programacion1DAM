package modelo.beans;

import java.util.ArrayList;

public class Cubilete {
	 private ArrayList<Dado> cubilete;
	 
	 private final int CANTIDAD_DE_DADOS=3;

	    public Cubilete(ArrayList<Dado> cubilete) {
	         this.cubilete = cubilete;
	    }

	   public  int usarCubilete(){ // no me ha dado Tiempo
		   int resultado=0;
	       int cerebros;
	       int disparos;
	       
	       for (int i = 0; i < CANTIDAD_DE_DADOS; i++) {
	    	   int dados=(int)(Math.random()*cubilete.size()-1)+1;
	           cerebros=(int)(Math.random()*cubilete.get(dados).cerebros)+1;
	           disparos=(int)(Math.random()*cubilete.get(dados).disparo)+1;
	           if(disparos>cerebros) {
	        	   resultado=0;
	           }else {
	        	   resultado+=cerebros+disparos;
	           }
	       }
	       return resultado;
	   }
	   

		public ArrayList<Dado> getCubilete() {
			return cubilete;
		}
	    
}
