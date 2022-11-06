package ejemplo;

import java.io.IOException;

import patrones.BeanESv4;

public class Principal4 {
    
    public Principal4() {
    }
    public static void main(String[] args) {
        Principal4 principal = new Principal4();
        principal.ejecutar();
    }

    private void ejecutar() {
        String respuesta = null;
        BeanESv4.getBeanESv4().mostrarln("Esta aplicación muestra un ejemplo de uso del patrón Singleton");
        try {
            respuesta = BeanESv4.getBeanESv4().pideCadena("Introduzca su nombre: ");
            BeanESv4.getBeanESv4().mostrar("Pues esto ha sido todo, "+respuesta);
            BeanESv4.getBeanESv4().mostrarln(".Bye!");
        } catch (IOException e) {
            BeanESv4.getBeanESv4().mostrarln("Vaya, se ha producido un error al leer desde el teclado...");
        }
    }
}
