package ud2ejclase3;


import java.util.Random;
import ud2ejclase3.Dado;

public class Jugador {

    private String nombre;
    private Dado dado;

    public Jugador(String nombre, int numCaras){
    this.nombre = nombre;
    this.dado = new Dado(numCaras);
    }
      public Jugador(String nombre, Dado dado){
    this.nombre = nombre;
    this.dado = dado;
    }
        public Jugador(String nombre){
    this.nombre = nombre;
    this.dado = new Dado(6);
    }
    
    
    public int tirarDado() {
        int resultado=0;       
        Random claseRandom = new Random();
        resultado = claseRandom.nextInt(dado.getNumCaras())+ 1;
        return resultado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the dado
     */
    public Dado getDado() {
        return dado;
    }



}
