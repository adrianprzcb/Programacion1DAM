package ejca08ga;

import prog.util.es.EntradaSalida;

/**
 * Created by Javi on 08/02/2021.
 */
public class Cuadrado {
    private int lado=0;
    private int area=0;

    public Cuadrado(int lado) {
        this.setLado(lado);
    }


    public int calcularArea() {
        area=lado*lado;
        return area;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
}
