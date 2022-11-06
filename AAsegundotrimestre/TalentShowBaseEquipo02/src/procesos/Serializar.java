/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Artista;
import java.io.IOException;
import java.util.HashMap;

/**
 * Interfaz Serializar, declaracion de metodos para la lectura y escritura de archivos serializados
 * @author bth
 */
public interface Serializar {
    public void guardarArtistas(HashMap<String, Artista> listaConcursantes)throws IOException;
    public HashMap<String, Artista> leerArtistas()throws IOException;
}
