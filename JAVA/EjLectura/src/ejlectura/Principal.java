package ejlectura;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {

        try {
            EjemploLectura ejemploLectura1 = new EjemploLectura();
            ejemploLectura1.ejecutar();
        }catch (ExceptionInInitializerError e){
            System.out.println("Error");
        }
    }
}

