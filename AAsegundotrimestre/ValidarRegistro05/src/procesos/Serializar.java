/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author bth
 */
public interface Serializar {
    public void escribirArchivoSer(Object object ,File f)throws IOException;
    public Object leerArchivoSer(File f) throws IOException, ClassNotFoundException;
}
