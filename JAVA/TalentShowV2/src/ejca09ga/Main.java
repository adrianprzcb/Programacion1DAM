package ejca09ga;

public class Main {

    public static void main(String[] args) {
        try {
            Procesos procesos = new Procesos(4);
            procesos.ejecutar();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error."+e.getMessage());
        }
    }
}
