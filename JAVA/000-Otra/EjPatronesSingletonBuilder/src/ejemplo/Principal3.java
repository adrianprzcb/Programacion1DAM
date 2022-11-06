package ejemplo;

import java.io.IOException;
import patrones.BeanESv3;

public class Principal3 {
    private BeanESv3 beanESv3 = null;
    
    public Principal3() {
        this.beanESv3 = BeanESv3.getBeanESv3();
    }
    public static void main(String[] args) {
        Principal3 principal = new Principal3();
        principal.ejecutar();
    }

    private void ejecutar() {
        String respuesta = null;
        BeanESv3 otroBeanES = BeanESv3.getBeanESv3();
        if (this.beanESv3==otroBeanES)
            this.beanESv3.mostrarln("Se han solicitado dos beans de ES y ambos son el mismo objeto.");
        this.beanESv3.mostrarln("Esta aplicación muestra un ejemplo de uso del patrón Singleton");
        try {
            respuesta = this.beanESv3.pideCadena("Introduzca su nombre: ");
            this.beanESv3.mostrar("Pues esto ha sido todo, "+respuesta);
            otroBeanES.mostrarln(".Bye");
        } catch (IOException e) {
            this.beanESv3.mostrarln("Vaya, se ha producido un error al leer desde el teclado...");
        }
    }
}
