package ejca09ga;

/**
 * Created by Miguel on 24/02/2021.
 */
public class Triangulo extends Figura {
    private int base=0;
    private int altura=0;

    public Triangulo(int base, int altura) {
        super("triangulo");
        this.base = base;
        this.altura = altura;
        this.area = calcularArea();
    }

    public int getArea() {
        return area;
    }

    public int calcularArea() {
        area=((base*altura)/2);
        return getArea();
    }
}
