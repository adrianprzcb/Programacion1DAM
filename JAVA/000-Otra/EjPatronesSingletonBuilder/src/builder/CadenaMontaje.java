package builder;

/**
 * Patrón Builder - Clase DIRECTOR que se encarga de montar/construir el producto
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class CadenaMontaje {
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Vehiculo getVehiculo() {
        return builder.getVehiculo();
    }

    public void montarVehiculo() {
        builder.setVehiculo(new Vehiculo());
        builder.creaElementosBasicos();
        builder.creaDimensiones();
        builder.creaModeloFabricante();
        builder.creaMotor();
        builder.creaMatricula();
        builder.creaColor();
    }

}
