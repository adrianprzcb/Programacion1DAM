package pr03b;

/**
 * Created by eduardo on 11/03/2021.
 */
public class Partida {

    private String nombreGanador;
    private String nombrePerdedor;
    private int puntosGanador;
    private int puntosPerdedor;

    public Partida(String nombreGanador, int puntosGanador, String nombrePerdedor, int puntosPerdedor) {
        this.nombreGanador = nombreGanador;
        this.nombrePerdedor = nombrePerdedor;
        this.puntosGanador = puntosGanador;
        this.puntosPerdedor = puntosPerdedor;
    }

    public String getNombreGanador() {
        return nombreGanador;
    }

    public String getNombrePerdedor() {
        return nombrePerdedor;
    }

    public int getPuntosGanador() {
        return puntosGanador;
    }

    public int getPuntosPerdedor() {
        return puntosPerdedor;
    }

    public String toString() {
        return "Ganador: "+nombreGanador+" con "+puntosGanador+" puntos."+"\n"+"Perdedor: "+nombrePerdedor+" con "+puntosPerdedor+" puntos.";
    }
}
