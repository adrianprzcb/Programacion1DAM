package ejnumintentos;

import utilidades.EntradaSalida;
import utilidades.FueraLimitesException;

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
            dato = leeEntero("Introduzca el numero: ", 5, 10, 0);
            System.out.println("El numero introducido es: "+dato);
        } catch (IOException ioe) {
            System.out.println("Error: "+ioe.getMessage());
        }catch(NumberFormatException nfe) {
            System.out.println("Error: "+nfe.getMessage());
        } catch (FueraLimitesException fle){
            System.out.println("Error: "+fle.getMessage());
        }
    }
    public int leeEntero(String mensaje, int numeroIntentos, int limSuperior, int limInferior)
            throws IOException, NumberFormatException, FueraLimitesException {
        boolean numCorrecto = false;
        String cadena;
        int entero = 0;
        // Pide el numero entero

        do {
            try{
                entradaSalida.mostrar(mensaje);
                cadena = entradaSalida.pideCadena();
                entero = Integer.parseInt(cadena);
                if(entero <= limSuperior && entero >= limInferior){
                    numCorrecto = true;
                } else {
                    throw new FueraLimitesException("Se ha sobrepasado el limite");
                }
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
            } catch (FueraLimitesException fle){
                numeroIntentos--;
                System.out.println("Se ha producido un error en la introducción del numero ya que no se encuentra entre los límites, número de intentos disponibles: "+numeroIntentos);
                if (numeroIntentos == 0)
                    throw fle;
            }
        }while(!numCorrecto);

        return entero;

    }
}
