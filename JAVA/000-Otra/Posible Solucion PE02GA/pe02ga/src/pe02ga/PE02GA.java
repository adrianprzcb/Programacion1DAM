package pe02ga;

import prog.util.es.EntradaSalida;

/**
 * Created by edu on 29/11/2020.
 */
public class PE02GA {

    private String[] listaPalabras;
    private Dado dado;
    private EntradaSalida entradaSalida;

    public PE02GA() {
        listaPalabras = new String[100]; // Se crea un array grande, suponiendo que el usuario no meterá más de 100 palabras.
        entradaSalida = new EntradaSalida();
    }

    public void ejecutar() {
        String palabra;
        int contPalabra = 0;
        int palabraAleatoria;

        entradaSalida.mostrar("Introduzca una palabra:");
        palabra = entradaSalida.pideCadena();
        while (!palabra.equals("")) {
            listaPalabras[contPalabra] = palabra;
            contPalabra++;
            entradaSalida.mostrar("Introduzca una palabra:");
            palabra = entradaSalida.pideCadena();
        }

        for (int i = 0; i < contPalabra; i++) {
            entradaSalida.mostrar(listaPalabras[i]);
        }
        dado = new Dado(contPalabra);
        do {
            palabraAleatoria = (int) (Math.random()*dado.getNumCaras()); // Se podía haber creado un método tiraDado tomando como entrada el objeto dado.
            entradaSalida.mostrar(listaPalabras[palabraAleatoria]);
            entradaSalida.mostrar("Para salir pulse un .");
            palabra = entradaSalida.pideCadena();
        }while (!palabra.equals("."));
    }
}
