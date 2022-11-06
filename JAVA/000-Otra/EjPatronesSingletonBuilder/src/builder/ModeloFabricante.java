package builder;

public class ModeloFabricante {
    private String fabricante;
    private String modelo;

    public ModeloFabricante(String fabricante, String modelo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }
    
    public String toString() {
        return "Modelo: "+modelo+" - Fabricante: "+fabricante;
    }
}
