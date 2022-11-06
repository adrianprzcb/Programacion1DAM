package ejca09ga;

/**
 * Created by MiguelBoSo on 24/02/2021.
 */
public abstract class Figura {
    private String tipo;
    protected int area;

    public Figura(String tipo) {
        this.tipo = tipo;
    }
    abstract public int calcularArea();

    public String getTipo() { return tipo; }
    public int getArea() {return area;}
}
