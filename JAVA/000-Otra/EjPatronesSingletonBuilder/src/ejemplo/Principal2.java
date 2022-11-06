package ejemplo;

import java.io.IOException;

import patrones.BeanESv2;

public class Principal2 {
    
    private BeanESv2 beanESv2 = null;
    
    public Principal2() {
        this.beanESv2 = BeanESv2.getBeanESv2();
    }
    public static void main(String[] args) {
        Principal2 principal = new Principal2();
        principal.ejecutar();
    }

    private void ejecutar() {
        String respuesta = null;
        BeanESv2 otroBeanES = BeanESv2.getBeanESv2();
        if (this.beanESv2==otroBeanES)
            this.beanESv2.mostrarln("Versión 2. Se han solicitado dos beans de ES y ambos son el mismo objeto.");
        this.beanESv2.mostrarln("Esta aplicación muestra un ejemplo de uso del patrón Singleton");
        try {
            respuesta = this.beanESv2.pideCadena("Introduzca su nombre: ");
            this.beanESv2.mostrar("Pues esto ha sido todo, "+respuesta);
            otroBeanES.mostrarln(".Bye!");
        } catch (IOException e) {
            this.beanESv2.mostrarln("Vaya, se ha producido un error al leer desde el teclado...");
        }
    }
}
