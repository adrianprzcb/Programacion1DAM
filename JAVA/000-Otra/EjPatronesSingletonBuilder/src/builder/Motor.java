package builder;

public class Motor {
    
    private int tipoMotor;
    private int potencia;
    private String fabricante;

    public Motor(int tipoMotor, int potencia, String fabricante) {
        this.tipoMotor = tipoMotor;
        this.potencia = potencia;
        this.fabricante = fabricante;
    }
    
    public int getTipoMotor() {
        return tipoMotor;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String toString() {
        return "Fabricante motor: "+fabricante+" - Tipo de motor: "+tipoMotor+" - Potencia (CV): "+potencia;
    }

}
