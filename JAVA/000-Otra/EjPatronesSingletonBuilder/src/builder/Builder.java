package builder;
/**
 * Patrón Builder - Clase BUILDER que es el constructor abstracto
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public abstract class Builder {
    /**
     * @aggregation shared
     */
    protected Vehiculo vehiculo;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public abstract void creaDimensiones();

    public abstract void creaMatricula();

    public abstract void creaModeloFabricante();

    public abstract void creaMotor();

    public abstract void creaElementosBasicos();
    
    public abstract void creaColor();
}
