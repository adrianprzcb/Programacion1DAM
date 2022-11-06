package ejca09ga;

/**
 * Created by Miguel on 24/02/2021.
 */
public class Cuadrado extends Figura {
    private int lado=0;

    public Cuadrado(int lado) {
        super("cuadrado");
        this.lado = lado;
        this.area = calcularArea();
    }

    public int getArea() {
        return area;
    }

    public int calcularArea() {
        this.area=lado*lado;
        return getArea();
    }

}
