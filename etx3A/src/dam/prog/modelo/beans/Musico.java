package dam.prog.modelo.beans;

import dam.prog.modelo.beans.Artista;

/**
 * Created by Administrador on 15/03/2021.
 */
public class Musico extends Artista {
    private String tituloMelodia;
    private String instrumento;

    public Musico(String nombre, String tituloMelodia, String instrumento) {
        super(nombre);
        this.tituloMelodia = tituloMelodia;
        this.setInstrumento(instrumento);
    }
    public Musico(String nombre, String tituloMelodia, String instrumento, int puntuacion) {
        super(nombre);
        this.tituloMelodia = tituloMelodia;
        this.setInstrumento(instrumento);
        this.setPuntuacion(puntuacion);
    }
    @Override
    public String actuar() {
        return "Voy a interpretar la melodía "+tituloMelodia+" con "+ getInstrumento();
    }

    public String getTituloMelodia() {
        return tituloMelodia;
    }

    public void setTituloMelodia(String tituloMelodia) {
        this.tituloMelodia = tituloMelodia;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }
}
