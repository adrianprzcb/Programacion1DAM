package pe02gb;

import prog.util.es.EntradaSalida;

/**
 * Created by eduardo on 02/12/2020.
 */
public class Jugar {
    private int numeros[];
    private Dado dado;
    private double sumaTotal;
    private EntradaSalida entradaSalida;

    public Jugar() {
        dado = new Dado();
        sumaTotal = 0;
        entradaSalida = new EntradaSalida();
    }
    public void ejecutar() {
        int numero;
        int aleatorio;

        entradaSalida.mostrar("Introduzca un número: ");
        numero = entradaSalida.pideNumeroSC();
        while(numero != 0) {
            numeros = new int[numero];
            for (int i = 0; i < numeros.length; i++) {
                aleatorio = (int) (Math.random()*dado.getNumCaras()+1);
                numeros[i] = aleatorio;
            }
            for (int i = 0; i <numeros.length ; i++) {
                sumaTotal += numeros[i];
            }
            entradaSalida.mostrar("La media es: "+ (sumaTotal/numero));
            sumaTotal=0;

            entradaSalida.mostrar("Introduzca un número: ");
            numero = entradaSalida.pideNumeroSC();
        }
    }
}
