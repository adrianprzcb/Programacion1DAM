package patron;

/**
 * Created by MiguelBoSo on 14/05/2021.
 */
public class Singleton {
    private static Singleton instancia;

    public static Singleton getInstancia() {
        if (Singleton.instancia == null)
            Singleton.instancia = new Singleton();
        return instancia;
    }
}
