package Adrian;

import utilidades.UtilidadesES;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Aplicacion {

    private UtilidadesES utilES;
    private File archivo = null;
    private Usuario Usuario;
    private HashMap<String, Usuario> Usuarios;
    private HashMap<String, Usuario> Incidencias;


    public Aplicacion() {
        utilES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        Usuarios = new HashMap<String, Usuario>();
        Incidencias = new HashMap<String, Usuario>();
    }

    public void ejecutar() {
        try {
            boolean cor;
            do {
                preguntarArchivo();
                recogerInfo();
                cor = pedirOtroArchivo();
            } while (cor);
            crearArchivos();
        } catch (IOException e) {
            utilES.mostrarln("Ha ocurrido un error en la aplicación");
        }

    }

    private void preguntarArchivo() throws IOException {
        boolean ok = false;
        do {
            String nombreArchivo = utilES.pideCadena("Introduce el nombre del archivo: ");
            archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                utilES.mostrarln("Archivo correcto.");
                ok = true;
            } else utilES.mostrarln("El archivo introducido no existe.");
        } while (!ok);
    }

    private void recogerInfo() throws IOException {
        String cadena = "";
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        while ((cadena = br.readLine()) != null) {
            String[] datosUsuario = cadena.split(":");

            Usuario = new Usuario(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3]);
            if (Usuarios.containsKey(Usuario.getLogin())) {
                utilES.mostrarln("Login repetido. Añadido a incidencias");
                Incidencias.put(Usuario.getLogin(), Usuario);
            } else {
                utilES.mostrarln("Usuario añadido correctamente");
                Usuarios.put(Usuario.getLogin(), Usuario);
            }
        }
    }

    private boolean pedirOtroArchivo() throws IOException {
        boolean ok = false;
        String respuesta = utilES.pideCadena("Desea introducir otro archivo? (Pulsa 'S' para que sí y cualquier otra tecla para que no)");
        if (respuesta.equalsIgnoreCase("s")) {
            ok = true;
        }
        return ok;
    }

    private ArrayList<String> convertirUsuarios(HashMap<String, Usuario> lista) throws IOException {

        /*Set<Map.Entry<String, Usuario>> entradas = null;
        entradas = lista.entrySet();
        FileWriter archivoCreado = new FileWriter("bien.txt");
        BufferedWriter br = new BufferedWriter(archivoCreado);
        String cadena = "";
        for (Map.Entry<String, Usuario> elemento : entradas) {
            cadena = (elemento.getKey() + ":" + (elemento.getValue()).getClave() + ":" + (elemento.getValue()).getEmail() +
                    ":" + (elemento.getValue()).getNombreCompleto());
            br.write(cadena);
            br.newLine();

        }
        br.close();
        return null;*/


       Set<Map.Entry<String, Usuario>> entradas = null;
        entradas = lista.entrySet();
        ArrayList<String> listaPasada = new ArrayList<>();
        String cadena = "";
        for (Map.Entry<String, Usuario> elemento : entradas) {
            cadena = (elemento.getKey() + ":" + (elemento.getValue()).getClave() + ":" + (elemento.getValue()).getEmail() +
                    ":" + (elemento.getValue()).getNombreCompleto());
            listaPasada.add(cadena);
        }
        return listaPasada;


    }

    private void crearArchivos() throws IOException {
        String nombreListaUsuarios = utilES.pideCadena("Nombre del archivo de usuarios: ");
        String nombreListaIncidencias = utilES.pideCadena("Nombre del archivo de incidencias: ");
        crearFichero(nombreListaUsuarios, convertirUsuarios(Usuarios));
        crearFichero(nombreListaIncidencias, convertirUsuarios(Incidencias));
    }

    private void crearFichero(String nombreArchivo, ArrayList<String> lista) throws IOException {
        FileWriter archivoCreado = new FileWriter(nombreArchivo);
        BufferedWriter br = new BufferedWriter(archivoCreado);
        for (int i = 0; i < lista.size(); i++) {
            br.write(lista.get(i));
            br.newLine();
        }
        br.close();
    }

}
