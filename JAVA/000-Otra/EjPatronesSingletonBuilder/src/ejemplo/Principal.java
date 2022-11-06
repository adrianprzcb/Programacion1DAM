package ejemplo;

import java.io.IOException;

import patrones.BeanES;

public class Principal {
    
    private BeanES beanES = null;
    
    public Principal() {
        this.beanES = BeanES.getBeanES();
    }
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.ejecutar();
    }

    private void ejecutar() {
        String respuesta = null;
        BeanES otroBeanES = BeanES.getBeanES();
        if (this.beanES==otroBeanES)
            this.beanES.mostrarln("Se han solicitado dos beans de ES y ambos son el mismo objeto.");
        this.beanES.mostrarln("Esta aplicación muestra un ejemplo de uso del patrón Singleton");
        try {
            respuesta = this.beanES.pideCadena("Introduzca su nombre: ");
            this.beanES.mostrar("Pues esto ha sido todo, "+respuesta);
            otroBeanES.mostrarln(". Bye!");
        } catch (IOException e) {
            this.beanES.mostrarln("Vaya, se ha producido un error al leer desde el teclado...");
        }
    }
}
