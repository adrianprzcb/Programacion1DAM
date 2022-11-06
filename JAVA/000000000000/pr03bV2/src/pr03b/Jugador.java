package pr03b;

import java.util.ArrayList;

/**
 * Created by eduardo on 09/03/2021.
 */
public class Jugador {

    private String nombre;
    private java.util.ArrayList<Dado> cubilete;

    public Jugador(String nombre, ArrayList<Dado> cubilete) {
        this.nombre = nombre;
        this.cubilete = cubilete;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Se lanzan aleatoriamente los dados del jugador, se suman los valores,
     * y se devuelve el resultado.
     * @return Resultado de la tirada
     */
    public int lanzarDados() {
        int totalTirada=0;

        for(Dado dado: cubilete) {
            totalTirada += (int) (Math.random()*dado.getNumCaras()+1);
        }
        /*
        numCaras = cubilete.get(0).getNumCaras();
        for (int i=0; i<cubilete.size(); i++)
            totalTirada += (int) (Math.random()*numCaras()+1);
         */
        return totalTirada;
    }
}
