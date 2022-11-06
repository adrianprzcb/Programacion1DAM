package builder;

public class Color {
    private String nombre;
    private String codigo;

    public Color (String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    public String toString() {
        return "Nombre color: "+nombre+" - Código de color: "+codigo;
    }
}
