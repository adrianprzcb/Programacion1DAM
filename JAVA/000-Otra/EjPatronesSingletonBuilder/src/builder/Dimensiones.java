package builder;

public class Dimensiones {
    private int alto;
    private int largo;
    private int ancho;

    public Dimensiones(int alto, int largo, int ancho) {
        this.alto = alto;
        this.largo = largo;
        this.ancho = ancho;
    }
    public int getAlto() {
        return alto;
    }

    public int getLargo() {
        return largo;
    }

    public int getAncho() {
        return ancho;
    }
    
    public String toString() {
        return "Alto: "+alto+" - Largo: "+largo+" - Ancho:"+ancho;
    }
}
