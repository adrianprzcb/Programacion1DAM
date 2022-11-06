package ejlectura;

public class Producto {
    private String referencia;
    private int nivelStock;
    private double precio;

    public Producto(String referencia) {
        this.referencia = referencia;
        this.precio = 0;
        this.nivelStock = 0;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setNivelStock(int nivelStock) {
        this.nivelStock = nivelStock;
    }

    public int getNivelStock() {
        return nivelStock;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
