package dam.prog;

import dam.prog.procesos.PR04A;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            PR04A pr04A = new PR04A();
            pr04A.ejecutar();
        } catch(Exception excepcion) {
            System.out.println("Se ha producido un error. Finaliza la aplicación.");
            System.out.println("Error: "+excepcion.getMessage());
            excepcion.printStackTrace();
        }
    }
}
