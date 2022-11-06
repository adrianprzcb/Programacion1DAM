package pr03b;

/**
 * Created by eduardo on 11/03/2021.
 */
public class ResultadosJugador {
    private String nombreJugador;
    private int partidasGanadas;

    public ResultadosJugador(String nombreJugador, int partidasGanadas) {
        this.nombreJugador = nombreJugador;
        this.partidasGanadas = partidasGanadas;
    }


    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void incPartidasGanadas() {
        this.partidasGanadas++;
    }

    @Override
    public int hashCode() {
        return nombreJugador.hashCode();
    }

    public boolean equals(Object resultadoJugador) {
        ResultadosJugador resultadosJugador;
        boolean iguales = false;
        if (resultadoJugador!=null && resultadoJugador.getClass()==this.getClass())
        {
            resultadosJugador = (ResultadosJugador) resultadoJugador;
            if (nombreJugador.equals(resultadosJugador.getNombreJugador()))
                iguales = true;
        }
        return iguales;
    }
}
