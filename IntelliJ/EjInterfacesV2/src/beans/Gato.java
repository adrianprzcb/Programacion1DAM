package beans;

import interfaces.Cantar;
import interfaces.Saludar;

public class Gato implements Cantar, Saludar {
    @Override
    public void canta() {
        System.out.println("miauuuuu");
    }

    @Override
    public void canta(String letra) {
        System.out.println("miauuuuu miau "+ letra);
    }

    @Override
    public void saludo() {
        System.out.println("MIAU :)");
    }

    @Override
    public void saludo(String saludo) {
        System.out.println("MIAU "+ saludo);
    }

    @Override
    public void saludo(String saludo, String nombre) {
        System.out.println("Miau "+saludo+" "+nombre);

    }
}
