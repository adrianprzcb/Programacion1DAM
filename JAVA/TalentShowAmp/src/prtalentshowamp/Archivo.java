package prtalentshowamp;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class Archivo {
    ListaArtistasMap listaartistasmap = new ListaArtistasMap();
    /**Constructor de archivo**/
    public Archivo(ListaArtistasMap listaartistamap){
        this.listaartistasmap = listaartistamap;
    }
    /**Metodo que crea un archivo .dat en la carpeta del proyecto **/
    public void crearArchivo(){
        ObjectOutputStream oos = null;
        try{
        oos = new ObjectOutputStream(new FileOutputStream("artistas.dat"));
            for(int i=0;i<3;i++){
              oos.writeObject(listaartistasmap.listanotas);
            }
            oos.close();
        } catch (IOException ioe){
            System.out.println("Error toma de datos archivo.");
        }
    }
    /**Metodo que recupera la clase desde un archivo del exterior
     * 
     * **/
    public void recuperarArchivo(){
        ObjectInputStream ois= null;
        TreeMap listamap_recuperacion = new TreeMap();
        try {
            ois = new ObjectInputStream(new FileInputStream("artistas.dat"));
          listamap_recuperacion =(TreeMap) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error de datos de archivo.");
        } catch (ClassNotFoundException e) {
            System.out.println("La clase no se ha encontrado.ERROR");
        }
        System.out.println(listamap_recuperacion);
        
    }
}
