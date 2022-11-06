package ejca09ga;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
	Calculos calculos = new Calculos();
        try {
            calculos.ejecutar();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LimiteException e) {
            e.printStackTrace();
        }
    }
}
