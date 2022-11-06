package builder;

import java.util.Date;
/**
 * Patrón Builder - Clase PRODUCT 
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class Vehiculo {
    private int numPuertas;
    private String numBastidor;
    private Date fechaFabricacion;

    /**
     * @aggregation composite
     */
    private ModeloFabricante modelo;

    /**
     * @aggregation composite
     */
    private Matricula matricula;

    /**
     * @aggregation composite
     */
    private Color color;

    /**
     * @aggregation composite
     */
    private Motor motor;

    /**
     * @aggregation composite
     */
    private Dimensiones dimensiones;

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumBastidor(String numBastidor) {
        this.numBastidor = numBastidor;
    }

    public String getNumBastidor() {
        return numBastidor;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setModelo(ModeloFabricante modelo) {
        this.modelo = modelo;
    }

    public ModeloFabricante getModelo() {
        return modelo;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setDimensiones(Dimensiones dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
