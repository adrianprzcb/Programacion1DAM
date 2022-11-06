package ejca09ga;

import prog.util.es.EntradaSalida;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Miguel on 24/02/2021.
 */
public class Calculos {
    EntradaSalida entradaSalida = new EntradaSalida();
    private int numFiguras;
    private ArrayList <Figura> listaFigura = new ArrayList<>();
    int area=0;

    public void ejecutar() throws IOException, LimiteException {
        pedirNumFiguras();
        crearFiguras();
        pedirArea();
    }

    private void pedirNumFiguras() throws NumberFormatException {
        boolean correcto=false;
        do {
            try {
                numFiguras=tomarDatoEnteroPositivo("Por favor, introduzca el número de figuras.");
                correcto=true;
            } catch (NumberFormatException nfe) {
                entradaSalida.mostrar("No se ha introducido ningún numero.\n");
            }
        } while (!correcto);

    }

    public int tomarDatoEnteroPositivo(String mensaje) {
        int entero=0;
        while(entero<=0){
            try {
                entero=entradaSalida.pideEntero(mensaje);
                if (entero<=0){
                    entradaSalida.mostrar("No es posible que el dato sea 0 o menor que cero, por favor, introduzca el dato de nuevo.\n");
                }
            } catch (NumberFormatException nfe){
                mostrarAtencionCampoOblig();
            }
        }
        return entero;
    }

    private void crearFiguras() throws IOException, LimiteException {
        boolean correcto;
        String letra;
        for (int i = 0; i < numFiguras; i++) {
            correcto = false;
            do {
                letra=entradaSalida.pideCadena("Por favor, introduzca c para introducir un cuadrado y t para introducir un triángulo:\n");
                if (letra.equals("c")){
                    agregarCuadrado();
                    correcto = true;
                } else if (letra.equals("t")){
                    agregarTriangulo();
                    correcto = true;
                } else {
                    entradaSalida.mostrar("Por favor, introduzca 'c' o 't' correctamente.\n");
                }
            } while (!correcto);
        }
    }

    private void agregarCuadrado() throws IOException,LimiteException{
        int lado = 0;
        boolean correcto = false;

        do {
            try {
                lado=entradaSalida.pideEntero("Por favor, introduzca el lado del cuadrado.");
                if (lado < 1 || lado > 10) {
                    throw new LimiteException("Introduce un número entre 1 y 10.\n");
                }
                correcto = true;
            } catch(NumberFormatException nfe) {
                entradaSalida.mostrar("Formato de número incorrecto.");
            } catch(LimiteException le) {
                entradaSalida.mostrar("El valor del lado esta fuera de los limites.");
            }

        } while (!correcto);

        listaFigura.add(new Cuadrado(lado));

    }
    private void agregarTriangulo() throws IOException,LimiteException{
        int base = 0;
        int altura = 0;

        boolean correcto = false;
        do {
            try {
                base=entradaSalida.pideEntero("Por favor, introduzca la base del triangulo.");
                if (base < 1 || base > 10) {
                    throw new LimiteException("Introduce un número entre 1 y 10.\n");
                }
                altura=entradaSalida.pideEntero("Por favor, introduzca la altura del triangulo.");
                if (altura < 1 || altura > 10) {
                    throw new LimiteException("Introduce un número entre 1 y 10.\n");
                }
                correcto = true;
            } catch(NumberFormatException nfe) {
                entradaSalida.mostrar("Formato de número incorrecto.");
            } catch(LimiteException le) {
                entradaSalida.mostrar("El valor del lado esta fuera de los limites.");
            }

        } while (!correcto);

        listaFigura.add(new Triangulo(base, altura));
    }


    private int pedirArea() {
        boolean salir=false;

        do {
            try {
                area = entradaSalida.pideEntero("Por favor, introduzca un área para buscar coincidencias (número menor que 1 para salir): ");
                if (area <= 0) {
                    entradaSalida.mostrar("Finalizando.");
                    salir = true;
                } else {
                    mostrarAreas();
                }
            } catch(NumberFormatException nfe){
                entradaSalida.mostrar("No se ha introducido ningún número.\n");
            }
        } while (!salir);
        return area;
    }

    private void mostrarAreas(){
        int contador = 0;

        for (int i = 0; i < numFiguras; i++) {
            if (area <= listaFigura.get(i).getArea()) {
                entradaSalida.mostrar("---------------------------------------\n"+"Área del "+listaFigura.get(i).getTipo()+" nª" + (i + 1) + ": " + listaFigura.get(i).getArea() + "cm^2.\n" + "---------------------------------------\n");
                contador++;
            }
        }
        if (contador==0) {
            entradaSalida.mostrar("No se ha encontrado ningún cuadrado para esa área.\n");
        }
    }
    private void mostrarAtencionCampoOblig(){
        entradaSalida.mostrar("Es obligatorio que este dato sea rellenado correctamente.\n");
    }
}
