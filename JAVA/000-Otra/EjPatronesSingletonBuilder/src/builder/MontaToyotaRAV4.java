package builder;

import java.util.Date;
/**
 * Patrón Builder - Clase CONCRETBUILDER, que monta/crea un tipo de producto determinado
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class MontaToyotaRAV4 extends Builder {
    
    public MontaToyotaRAV4() {
        super();
    }

    @Override
    public void creaDimensiones() {
        this.vehiculo.setDimensiones(new Dimensiones(183,475,174));
    }

    @Override
    public void creaMatricula() {
        this.vehiculo.setMatricula(new Matricula("1932 - GOV"));
    }

    @Override
    public void creaModeloFabricante() {
        this.vehiculo.setModelo(new ModeloFabricante("Toyota","RAV4"));
    }

    @Override
    public void creaMotor() {
        this.vehiculo.setMotor(new Motor(1,124,"Toyota"));
    }

    @Override
    public void creaElementosBasicos() {
        this.vehiculo.setNumPuertas(5);
        this.vehiculo.setFechaFabricacion(new Date());
        this.vehiculo.setNumBastidor("JWB34582KKDP992");
    }
    @Override
    public void creaColor() {
        this.vehiculo.setColor(new Color("Negro","B21"));
    }
}
