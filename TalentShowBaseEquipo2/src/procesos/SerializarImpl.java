/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Artista;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author bth
 */
public class SerializarImpl implements Serializar{
    
    @Override
    public void guardarEstadoConcurso(HashMap<String, Artista> lista)throws IOException{
        guardarArtistas(lista);
    }
    
    @Override
    public void guardarArtistas(HashMap<String, Artista> listaConcursantes) throws IOException{
        File saveArt=new File("artistas.ser");
        FileOutputStream fos;
        ObjectOutputStream oos=null;
        
        try {
            fos= new FileOutputStream(saveArt);
            oos= new ObjectOutputStream(fos);
            oos.writeObject(listaConcursantes);
        } catch (FileNotFoundException fne) {
            System.out.println("No se encuentra el archivo " + saveArt.getName()+"\n");
        } catch (IOException ioe){
            System.out.println("Error al escribir el archivo\n");
        }finally{
            oos.close();
            System.out.println("**BORRAR :Datos guardados correctamente");
        }
    }
    
    @Override
    public HashMap<String, Artista> leerArtistas()throws IOException{
        File saveArt=new File("artistas.ser");
        ObjectInputStream ois=null;
        HashMap<String, Artista> lista= new HashMap<>();
        try {
            ois = new ObjectInputStream(new FileInputStream(saveArt));
            lista= (HashMap<String, Artista>) ois.readObject();
        }  catch (IOException ioe){
            System.out.println("Error al leer el archivo\n");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se han podido leer los datos del archivo\n");
        }finally{
            ois.close();
            System.out.println("Datos leidos correctamente");
        }
        return lista;
    }

   
}
