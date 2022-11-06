package ejemplo;

import java.io.IOException;

import patrones.BeanESv4;
import patrones.BeanESv5;

public class Principal5 {
    public static void main(String[] args) {
        Principal5 principal = new Principal5();
        principal.ejecutar();
    }

    private void ejecutar() {
        String respuesta = null;
        BeanESv5.getBeanESv5().mostrarln("Esta aplicación muestra un ejemplo de uso del patrón Singleton");
        try {
            respuesta = BeanESv5.getBeanESv5().pideCadena("Introduzca su nombre: ");
            BeanESv5.getBeanESv5().mostrar("Pues esto ha sido todo, "+respuesta);
            BeanESv5.getBeanESv5().mostrarln(".Bye!");
        } catch (IOException e) {
            BeanESv5.getBeanESv5().mostrarln("Vaya, se ha producido un error al leer desde el teclado...");
        }
    }
}
