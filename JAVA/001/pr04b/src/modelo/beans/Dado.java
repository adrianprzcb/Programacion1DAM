package modelo.beans;

import java.util.Random;

/**
 * Created by alumno2 on 30/04/2021.
 */
public class Dado {
    private int numCaras;

    public Dado(){
        numCaras = 6;
    }

    public int lanzarDados(){
        int valorTirada;
        Random random = new Random();
        valorTirada = random.nextInt(numCaras)+1;
        return valorTirada;
    }
}
