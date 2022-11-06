package ej2ga;

/**
 * Created by eduardo on 06/11/2020.
 */
public class EjClase2GrupoA {

    private int[] numeros = {16, 88, 34, 11, 99, 56, 33, 28, 77, 73, 64, 13, 52, 55, 50,
            15, 38, 39, 45, 48};
    private String[] listaPalabras = {"loro", "perro", "gato", "león", "jirafa",
                                    "águila", "serpiente", "cuervo", "delfín", "ballena"};

    public boolean buscaPalabra(String palabra,
                                String[] listaPalabras) {

        boolean encontrada = false;
        int i = 0;
        do {
            if (palabra == listaPalabras[i]) {
                encontrada = true;
            }
            else
            {
                i++;
            }
        } while (encontrada == false && i<listaPalabras.length);
        return encontrada;
    }

    public int sumaNumeros(int[] numeros) {
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        return suma;
    }
    public int sumaNumerosWhile (int[] numeros) {
        int i = 0, suma = 0;
        while (i<numeros.length) {
            suma += numeros[i];
            i++;
        }
        return suma;
    }

    public void ejecutar() {

        String palabra = new String("cuervo");
        System.out.print("La palabra "+palabra+" ");
        if (buscaPalabra(palabra, listaPalabras)) {
            System.out.println(" está en la lista de palabras.");
        } else {
            System.out.println(" no está en la lista de palabras.");
        }

        /*
        System.out.println("La suma del array de números es: "+sumaNumerosWhile(numeros));
        */
    }
}
