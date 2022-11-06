/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.IOException;

/**
 *
 * @author Marina y Salvador
 */
public interface Serializar {

    /**
     *
     * Recibe un string con la ruta del archivo y abrimos un flujo de salida
     *
     * @param nombreFichero
     * @param object
     * @throws IOException devuelve la excepcion.
     */
    public void serializar(String nombreFichero, Object object) throws IOException;

    /**
     * Lee un objeto serializado.
     *
     * @param nombreFichero
     * @return Object
     * @throws IOException devuelve la excepcion.
     * @throws ClassNotFoundException devuelve la excepcion.
     */
    public Object leer(String nombreFichero) throws IOException, ClassNotFoundException;
}
