package eduardo.prog;

public class EjemploArrays {

    public void ejecutar() {
        ejemploArrayEntero();
        ejemploArrayString();
    }

    private void ejemploArrayString() {
        String[] frase1 = {"En","un","lugar","de","La","Mancha"};
        String frase2[];
        String fraseCompleta ="";
        frase2 = new String[6];

        frase2[0]="de";
        frase2[1]="cuyo";
        frase2[2]="nombre";
        frase2[3]="no";
        frase2[4]="quiero";
        frase2[5]="acordarme";

        //Muestra la primera frase
        for (int i = 0; i < frase1.length; i++) {
            System.out.println(frase1[i]);
        }

        //Muestra la segunda frase
        for (int i = 0; i < frase2.length; i++) {
            System.out.println(frase2[i]);
        }

        // Construímos una frase formada por ambas, usando un String
        for (int i = 0; i < frase1.length; i++) {
            fraseCompleta = fraseCompleta + frase1[i];
        }
        for (int i = 0; i < frase2.length; i++) {
            fraseCompleta += frase2[i];
        }
        System.out.println("La frase completa es: "+fraseCompleta);
        System.out.println("¿Serías capaz de mostrarla empleando espacios entre las palabras?");
    }

    private void ejemploArrayEntero() {
        int numeros[] = new int[10];
        int numeros2[] = {22,10,15,89};
        int acumulador = 0;

        // Rellenar un array. Simula la table de multiplicar del 3
        for (int i = 0; i<10; i++) {
            numeros[i] = 3 * i;
        }
        // Muestra el contenido del array entero
        System.out.println("Tabla de multiplicar del 3");
        for (int i = 0; i < 10; i++) {
            System.out.println("3 * "+i+" = "+numeros[i]);
        }
        // Muestra la suma de todos los números de numeros2
        System.out.println("Suma total del array numeros2: ");
        for (int i = 0; i < numeros2.length; i++) {
            System.out.println("Posición "+i+"; "+numeros2[i]+", valor acumulador: "+acumulador);
            acumulador += numeros2[i];
        }
        System.out.println("Suma total del array numeros2: "+acumulador);
    }
}
