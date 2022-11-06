package g1;

/**
 * Created by Alumno1 on 18/11/2020.
 */

public class Jugador {
    private String nombre;
    private Dado dado;

    public Jugador(String nombre){
        this.nombre= nombre;
        this.dado=new Dado();
    }

    public Jugador(String nombre, Dado dado){
        this.nombre=nombre;
        this.dado=dado;
    }

    public byte tirarDado() {

        byte valorTirada = (byte) (Math.random()*dado.getNumCaras()+1);

        return valorTirada;
        //forma2
        //return (byte) (Math.random()*6+1);
    }
    public String getNombre(){
        return nombre;
    }
}
