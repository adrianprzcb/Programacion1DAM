package Ficheros;

import java.io.File;

public class Ficheros {

    public static void main(String[] args){

        File archivo = new File("ejemploarchivo.txt");
        System.out.println(archivo.getAbsolutePath());
    }
}
