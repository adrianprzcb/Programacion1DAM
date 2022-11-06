package ejnumintentos;

import utilidades.EntradaSalida;

import java.io.IOException;

public class Principal {

    EntradaSalida entradaSalida = new EntradaSalida();

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.ejecutar();
    }

    private void ejecutar(){
        int dato;

        try {
            dato = leeEntero("Introduzca el numero", 4);
            System.out.println("El numero introducido es: "+dato);
        } catch (IOException ioe) {
            System.out.println("Error: "+ioe.getMessage());
        }catch(NumberFormatException nfe) {
            System.out.println("Error: "+nfe.getMessage());
        }
    }
    public int leeEntero(String mensaje, int numeroIntentos)
            throws IOException, NumberFormatException {
        boolean numCorrecto = false;
        String cadena;
        int entero = 0;
        // Pide el numero entero

        do {
            try{
                entradaSalida.mostrar(mensaje);
                cadena = entradaSalida.pideCadena();
                entero = Integer.parseInt(cadena);
                numCorrecto = true;
            } catch(NumberFormatException nfe){
                numeroIntentos--;
                System.out.println("El digito introducido no es correcto, numero de intentos disponibles: "+ numeroIntentos);
                if (numeroIntentos == 0)
                    throw new NumberFormatException ("Agotado numero de intentos, con error de formato de número, vuelva a intentarlo mas tarde");
            } catch (IOException ioe) {
                numeroIntentos--;
                System.out.println("Se ha producido un error de lectura por teclado, numero de intentos disponibles: "+ numeroIntentos);
                if (numeroIntentos == 0)
                    throw new IOException ("Agotado numero de intentos, con error de lectura de teclado, vuelva a intentarlo mas tarde");
            }
        }while(!numCorrecto);

        return entero;

    }
}
