package talentshow;

/**
 * Created by Miguel on 09/10/2020.
 */
public class Artista {
    private String nombre;
    private String melodia;
    private String instrumento;
    private int edad;

    public Artista(String nombre, String melodia, String instrumento, int edad) {
        this.setNombre(nombre);
        this.setMelodia(melodia);
        this.setInstrumento(instrumento);
        this.setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public String getMelodia() { return melodia; }

    public String getInstrumento() {
        return instrumento;
    }

    public int getEdad() { return edad; }

    public String actuar() {
        return "Interpretando "+getMelodia()+" con "+getInstrumento() + ".";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMelodia(String melodia) {
        this.melodia = melodia;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
