package ejpatrones.modelo;

public class Singleton {
    private static Singleton instancia;

    public static Singleton getInstancia() {
        if (Singleton.instancia == null)
            Singleton.instancia = new Singleton();
        return instancia;
    }
}
