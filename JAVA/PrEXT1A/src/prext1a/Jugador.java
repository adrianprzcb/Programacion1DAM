package prext1a;

/**
 * Created by edu on 30/11/2020.
 */
public class Jugador {
    private Dado dado;
    private String nombre;

    public Jugador(String nombre, Dado dado) {
        this.nombre = nombre;
        this.dado = dado;
    }

    public Dado getDado() {
        return dado;
    }
    public String getNombre() {
        return nombre;
    }

    public int tirarDado() {
        return (int) (Math.random()*dado.getNumCaras()+1);
    }
}
