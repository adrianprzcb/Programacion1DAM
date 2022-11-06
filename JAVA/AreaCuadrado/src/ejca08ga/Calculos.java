package ejca08ga;

import prog.util.es.EntradaSalida;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Javi on 08/02/2021.
 */
public class Calculos {
    private EntradaSalida entradaSalida;
    private int numCuadrados;
    private ArrayList<Cuadrado> listaCuadrados;

    public Calculos() {
        entradaSalida = new EntradaSalida();
        listaCuadrados = new ArrayList<Cuadrado>();
    }

    public void ejecutar() {
            pedirNumCuadrados();
            crearCuadrados();
            pedirArea();
    }

    private void pedirNumCuadrados() throws NumberFormatException {
        boolean correcto=false;
        do {
            try {
                recogerNumero();
                correcto=true;
            } catch (NumberFormatException nfe) {
                entradaSalida.mostrar("No se ha introducido ningún numero");
            } catch (IOException ioe) {
                entradaSalida.mostrar("Error");
            } catch (LimiteException le) {
                entradaSalida.mostrar( le.getMessage());
            }
        } while (!correcto);

    }

    private void recogerNumero() throws LimiteException,IOException{
        entradaSalida.mostrar("Introduce el número de cuadrados");
        numCuadrados = entradaSalida.pideNumero();
        if (numCuadrados<1) {
            throw new LimiteException("Introduce al menos 1");
        }
    }

    private void crearCuadrados() {
        boolean correcto;
        for (int i = 0; i < numCuadrados; i++) {
            correcto=false;
            do {
                try {
                    agregarCuadrado(i);
                    correcto=true;
                } catch (NumberFormatException nfe) {
                    entradaSalida.mostrar("No se ha introducido ningún numero");
                } catch (IOException ioe) {
                    entradaSalida.mostrar("Error");
                } catch (LimiteException le) {
                    entradaSalida.mostrar(le.getMessage());
                }
            } while (!correcto);
        }
    }

    private void agregarCuadrado(int numCuadrado) throws IOException,LimiteException{
        int lado;
        entradaSalida.mostrar("Introduce el lado del cuadrado " + (numCuadrado+1));
        lado=entradaSalida.pideNumero();
        if (lado < 1 || lado > 10) {
            throw new LimiteException("Introduce un número entre 1 y 10");
        } else listaCuadrados.add(numCuadrado, new Cuadrado(lado));
    }


    private void pedirArea() {
        int area=0;
        int contador = 0;
        boolean salir=false;
        do {
                try {
                    entradaSalida.mostrar("Introduce el área deseado (Introduce 0 para salir): ");
                    area = entradaSalida.pideNumero();
                    if (area == 0) {
                        salir = true;
                    } else {
                        for (int i = 0; i < numCuadrados; i++) {
                            if (area == listaCuadrados.get(i).calcularArea()) {
                                entradaSalida.mostrar("El área coincide con el cuadrado nª " + (i + 1));
                                contador++;
                            }
                        }
                        if (contador==0) {
                            entradaSalida.mostrar("No se ha encontrado ningún cuadrado para esa área.");
                        } else {
                            entradaSalida.mostrar("Se han encontrado "+contador+" cuadrados.");
                        }
                    }
                }catch(IOException ioe){
                        entradaSalida.mostrar("Error de entrada desde teclado.");
                }catch(NumberFormatException nfe){
                        entradaSalida.mostrar("No se ha introducido ningún número");
                }
        }
        while (!salir);
    }


}
