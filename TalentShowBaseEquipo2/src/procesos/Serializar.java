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
 *
 * @author bth
 */
public interface Serializar {
    public void guardarEstadoConcurso(HashMap<String, Artista> lista)throws IOException;
    public void guardarArtistas(HashMap<String, Artista> listaConcursantes)throws IOException;
    public HashMap<String, Artista> leerArtistas()throws IOException;
}
