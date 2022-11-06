package main;



import java.io.*;
import java.util.ArrayList;

/**
 * Prueba el uso de serialización  para leer y escribir objetos
 * en archivos.
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class Aplicacion {

    /**
     * Propiedad que encapsula los flujos para entrada y salida, así como los procesos que los usan.
     */
    UtilidadesES utilES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
    
    /**
     * Archivo sobre el que se serializará el objeto.
     */
    File fArchivo = null;
    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {
            try {
                    (new Aplicacion()).ejecutar();
            }
            catch(Exception excep) {
                    System.out.println("Error:"+excep.getMessage());
                    excep.getCause().printStackTrace();
            }
    }
    /**
     * Ejecuta el proceso que muestra cómo trabajar con la serialización
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void ejecutar() throws FileNotFoundException, IOException, ClassNotFoundException{

            ArrayList<Usuario> listaUsuarios = null;
            ArrayList<Usuario> listaUsuariosNueva = null;
            fArchivo = new File("usuarios.dat");
            
            if (!fArchivo.exists()) {
                    listaUsuarios = creaListaUsuarios();
                    if (grabaListaUsuarios(fArchivo, listaUsuarios)) {
                            listaUsuariosNueva = leeListaUsuarios(fArchivo);
                            this.utilES.mostrarln(listaUsuariosNueva);
                    }
                    else
                            this.utilES.mostrarln("No se ha podido serializar el objeto.");
            }
            else
                    this.utilES.mostrarln("El archivo ya existe. Hay que borrarlo antes.");
    }
    /**
     * Crea una lista de usuarios nueva
     * @return La lista de usuarios creada
     */
    public ArrayList<Usuario> creaListaUsuarios() {
            Usuario usr = null;
            ArrayList<Usuario> listaUsr = null;
            
            listaUsr = new ArrayList<Usuario>();
            
            usr = new Usuario("pepe","oculto","correo@hotmail.com");
            listaUsr.add(usr);
            usr = new Usuario("manolo","secreta","buzon@hotmail.com");
            listaUsr.add(usr);
            usr = new Usuario("pepa","abracadabra","micorreo@gmail.com");
            listaUsr.add(usr);
            usr = new Usuario("luis","cerrado","correo@hotmail.es");
            listaUsr.add(usr);		
            
            return listaUsr;
    }
    /**
     * Almacena una conjunto de usuarios en un archivo mediante una serialización de un objeto de tipo ArrayList
     * @param fArchivo Archivo sobre el que se grabará.
     * @param listaUsuarios ArrayList que contiene el conjunto de usuarios que se grabará.
     * @return true si se ha grabado correctamente, false en caso contrario.
     * @throws FileNotFoundException Si no se encuentra el archivo.
     * @throws IOException Si hay un problema al grabar sobre el archivo.
     */
    public boolean grabaListaUsuarios(File fArchivo, ArrayList listaUsuarios) throws FileNotFoundException, IOException{
            ObjectOutputStream oos = null;
            boolean ok = true;
            
            try {
                    oos = new ObjectOutputStream(new FileOutputStream(fArchivo));
                    oos.writeObject(listaUsuarios);
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
            return ok;
    }
    /**
     * Lee una serie de usuarios desde un archivo, leyendo un objeto serializado de tipo ArrayList<Usuario>
     * @param fArchivo Archivo desde el que se va a leer.
     * @return La lista de usuarios leída.
     * @throws FileNotFoundException Si no se encuentra el archivo.
     * @throws IOException Si hay un problema al leer del archivo.
     * @throws ClassNotFoundException Se intenta leer desde el archivo un tipo de objeto que no se corresponde con el tipo especificado.
     */
    public ArrayList<Usuario> leeListaUsuarios(File fArchivo) throws FileNotFoundException, IOException, ClassNotFoundException {
            ObjectInputStream ois = null;
            ArrayList<Usuario> listaUsr = null;
            try {
                    ois = new ObjectInputStream(new FileInputStream(fArchivo));
                    listaUsr = (ArrayList<Usuario>) ois.readObject();
            }
            // Este catch debe ir antes que el de IOException.
            catch (FileNotFoundException fnfe) {
                    throw new FileNotFoundException("No se encuentra archivo en método leeListaUsuarios()");
            }
            catch (IOException ioe) {
                    throw new IOException("Error al leer el objeto en método leeListaUsuarios()",ioe);
            } catch (ClassNotFoundException cnfe) {
                    throw new ClassNotFoundException("Error al leer el objeto en método leeListaUsuarios()",cnfe);
            }
            finally {
                    if (ois != null)
                            ois.close();
            }		
            return listaUsr;
    }
}

