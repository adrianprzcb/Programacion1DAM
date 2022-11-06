/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Marina y Salvador
 */
public class SerializarImpl implements Serializar {

    private FileOutputStream fileOutput;
    private ObjectOutputStream output;
    private FileInputStream fileInput;
    private ObjectInputStream input;

    /**
     *
     * Recibe un string con la ruta del archivo y abrimos un flujo de salida
     *
     * @param nombreFichero
     * @param object
     * @throws IOException devuelve la excepcion.
     */
    @Override
    public void serializar(String nombreFichero, Object object) throws IOException {
        fileOutput = new FileOutputStream(nombreFichero);
        output = new ObjectOutputStream(fileOutput);
        output.writeObject(object);
        output.close();
    }

    /**
     * Lee un objeto serializado.
     *
     * @param nombreFichero
     * @return Object
     * @throws IOException devuelve la excepcion.
     * @throws ClassNotFoundException devuelve la excepcion.
     */
    @Override
    public Object leer(String nombreFichero) throws IOException, ClassNotFoundException {
        fileInput = new FileInputStream(nombreFichero);
        input = new ObjectInputStream(fileInput);
        Object object = (Object) input.readObject();
        input.close();
        return object;
    }

}
