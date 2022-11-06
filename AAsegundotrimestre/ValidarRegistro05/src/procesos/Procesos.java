/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import beans.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import util.es.EntradaSalida;

/**
 *
 * @author bth
 */
public class Procesos {

    private File archivo;
    private File usrValidos;
    private HashMap<String, Usuario> listaUsrLeidos;
    private HashMap<String, Usuario> listaUsrValidos;
    private EntradaSalida es;
    private SerializarImp serializar;

    public Procesos() {
        this.listaUsrLeidos = new HashMap<>();
        this.listaUsrValidos = new HashMap<>();
        this.serializar = new SerializarImp();
        this.es = new EntradaSalida();
    }

    public void ejecutar() {
        try {
            solicitarArchivo();
            leerArchivo(archivo);
            validarYmostrarDatos();
            volcarDatosValidos();
            leerArchivoSer();
        } catch (FileNotFoundException fne) {
            System.out.println("No se encuentra el archivo " + archivo.getName());
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    private void solicitarArchivo() {
        archivo = new File(es.pideCadena("Introduce el nombre del archivo:"));
    }

    private void leerArchivo(File archivo) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(archivo);
        BufferedReader br = null;
        String cadena;

        try {
            br = new BufferedReader(fr);
            System.out.println("---Datos del archivo---\n");
            while ((cadena = br.readLine()) != null) {
                System.out.println(cadena);
                separarDatos(cadena);
            }
        } catch (IOException ioe) {
            throw new IOException("Error al leer el archivo");
        } finally {
            br.close();
        }

    }

    private void separarDatos(String cadena) {
        String login = "", clave = "", email = "", nombre = "";
        Usuario usr;
        String[] split = cadena.split(":");
        for (int i = 0; i < split.length; i++) {
            login = split[0];
            clave = split[1];
            email = split[2];
            nombre = split[3];
        }
        usr = new Usuario(login, clave, email, nombre);
        listaUsrLeidos.put(login, usr);
    }

    private void validarYmostrarDatos() {
        System.out.println("\n---Usuarios validos---");
        for (Map.Entry<String, Usuario> usr : listaUsrLeidos.entrySet()) {
            if (usr.getValue().getLogin().length() > 5 && usr.getValue().getClave().length() > 5 && usr.getValue().getEmail().length() > 5 && usr.getValue().getNombreApellidos().length() > 5 && usr.getValue().getEmail().contains("@")) {
                System.out.println("\n" + usr.getValue().toString());
                listaUsrValidos.put(usr.getKey(), usr.getValue());
            }
        }
    }

    private void volcarDatosValidos() {
        usrValidos = new File(es.pideCadena("\nIntroduce el nombre para el archivo de usr validos:"));
        
        try {
            serializar.escribirArchivoSer(listaUsrValidos, usrValidos);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void leerArchivoSer() throws IOException, ClassNotFoundException {
        HashMap<String, Usuario> leidosSer;
        leidosSer = (HashMap<String, Usuario>) serializar.leerArchivoSer(usrValidos);
        mostrarDatos(leidosSer);
    }

    private void mostrarDatos(HashMap<String, Usuario> usr) {
        System.out.println("---Leyendo archivo serializado---\n");
        for (Map.Entry<String, Usuario> entry : usr.entrySet()) {
            Usuario usuario = entry.getValue();
            System.out.println(usuario.toString() + "\n");
        }
    }
}
