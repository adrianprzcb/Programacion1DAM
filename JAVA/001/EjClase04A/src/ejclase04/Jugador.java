package ejclase04;

/**
 * Created by eduardo on 18/11/2020.
 */
public class Jugador {
    private String nombre;
    private Dado dado = null;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dado = new Dado();
    }

    public Jugador(String nombre, Dado dado) {
        this.nombre = nombre;
        this.dado = dado;
    }
    public byte tirarDado() {
        return  (byte) ((int)(Math.random()*dado.getNumCaras())+1);
    }

    public String getNombre() {
        return nombre;
    }


}
