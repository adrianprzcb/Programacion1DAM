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
 * Interfaz RegistroArtistas
 * @author bth
 */
public interface RegistroArtistas {
    public HashMap<String, Artista> getListaArtistas();
    public void setListaArtistas(HashMap<String, Artista> listaArtistas);
    public String seleccionarArtista() throws NumberFormatException;
    public Artista crearArtista(String cadena) throws IOException;
    public Artista validarYcrearCantante() throws IOException;
    public Artista validarYcrearMusico() throws IOException;
    public Artista validarYcrearMalabarista() throws IOException;
    public Artista validarYcrearPoeta() throws IOException;
}
