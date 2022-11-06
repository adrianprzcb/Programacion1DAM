package serializacion.utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializar {
    public void guardarObjeto(Object objeto, File archivo) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = null;
        try {
                oos = new ObjectOutputStream(new FileOutputStream(archivo));
                oos.writeObject(objeto);
        }
        // Este catch debe ir antes que el de IOException.
        catch (FileNotFoundException fnfe) {
                throw new FileNotFoundException("No se encuentra archivo en método grabaListaUsuarios()");
        }
        catch (IOException ioe) {
                throw new IOException("Error al escribir el objeto en método grabaListaUsuarios()",ioe);
        }
        finally {
                if (oos != null)
                        oos.close();
        }
    }
    public void guardarObjeto(Object objeto, String nombreArchivo) throws FileNotFoundException, IOException {
        File fArchivo = new File(nombreArchivo);
        guardarObjeto(objeto, fArchivo);
    }
}
