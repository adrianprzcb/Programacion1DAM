package Adrian.Objetos;

import java.lang.reflect.Array;
import java.util.Random;


public class Dado {
    String[] caras = {"As","K","Q","J","8","7"};

    public Dado(){

    }

    public String lanzarDados(){
        int valorTirada;

        Random random = new Random();
        valorTirada = random.nextInt(5)+1;
        String valor= caras[valorTirada];
        return valor;
    }
}
