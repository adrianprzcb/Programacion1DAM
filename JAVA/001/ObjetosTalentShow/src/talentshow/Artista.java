package talentshow;

/**
 * Created by eduardo on 09/10/2020.
 */
public class Artista {
    private String nombre;
    private String melodia;
    private String instrumento;
    private int puntuacion;

    public Artista(String nombre, String melodia, String instrumento) {
        this.nombre = nombre;
        this.melodia = melodia;
        this.instrumento = instrumento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMelodia() {    //Declaración
        return melodia;            //Implementación
    }

    public String getInstrumento() {
        return instrumento;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String actuar() {
        return "Interpretando "+getMelodia()+" con "+getInstrumento();
    }
}
