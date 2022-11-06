package builder;

import java.util.Date;

public class Matricula {
    private String numero;
    private Date fechaMatriculacion;

    public Matricula(String numero) {
        this.numero = numero;
        this.fechaMatriculacion = new Date();
    }
    public String getNumero() {
        return numero;
    }

    public Date getFechaMatriculacion() {
        return fechaMatriculacion;
    }
    public String toString() {
        return "Número matrícula: "+numero+" - Fecha matriculación: "+fechaMatriculacion;
    }
}
