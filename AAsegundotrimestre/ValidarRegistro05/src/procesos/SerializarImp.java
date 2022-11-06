/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


/**
 *
 * @author bth
 */
public class SerializarImp implements Serializar{
    
    
    @Override
    public void escribirArchivoSer(Object object, File f) throws IOException{
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                oos = new ObjectOutputStream( new FileOutputStream(f, true));
            } else {
                f.createNewFile();
                oos = new ObjectOutputStream( new FileOutputStream(f));
            }
            oos.writeObject(f);
        } catch (IOException ioe) {
            throw new IOException("Error al escribir el archivo");
        } finally {
            oos.close();
            System.out.println("\nEl archivo " + f.getName() + " se ha escrito correctamente");
        }

    }

    @Override
    public Object leerArchivoSer(File f)throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        HashMap<String, Usuario> map = new HashMap<>();
        try {
            ois = new ObjectInputStream(new FileInputStream(f));
            map = (HashMap<String, Usuario>) ois.readObject();
        } catch (ClassNotFoundException cne) {
            System.out.println(cne.getMessage());
        } finally {
            ois.close();
        }
        return map;
    }
    
}
