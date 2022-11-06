package ejca11ga;

import prog.util.es.EntradaSalida;

import java.io.*;
import java.util.*;

/**
 * Created by Javi on 13/04/2021.
 */
public class Procesos {
    private EntradaSalida entradaSalida;
    private HashMap<String, Usuario> listaUsuarios;
    private HashMap<String, Usuario> listaIncidencias;
    private File fArchivo;
    private Usuario usuario;

    public Procesos() {
        entradaSalida = new EntradaSalida(new BufferedReader(new InputStreamReader(System.in)), System.out);
        listaUsuarios = new HashMap<String, Usuario>();
        listaIncidencias = new HashMap<String, Usuario>();
    }

    public void ejecutar() {
        try {
            boolean ok;
            do {
                preguntarArchivo();
                recogerInformacion();
                ok = pedirOtro();


            } while (ok);
            nombrarArchivos();
        } catch (IOException e) {
            entradaSalida.mostrar("Errorsito pa");
        }

    }

    private void preguntarArchivo() throws IOException {
        boolean ok = false;
        do {
            String nombreArchivo = entradaSalida.pideCadenaMensaje("Introduce el nombre del archivo: ");
            fArchivo = new File(nombreArchivo);
            if (fArchivo.exists()) {
                entradaSalida.mostrar("Archivo correcto.");
                ok = true;
            } else entradaSalida.mostrar("El archivo introducido no existe.");
        } while (!ok);
    }

    private void recogerInformacion() throws IOException {
        String cadena = "";
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(fArchivo));
        while ((cadena = br.readLine()) != null) {
            String[] datosUsuario = cadena.split(":");
            usuario = new Usuario(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3], datosUsuario[4]);
            if (listaUsuarios.containsKey(usuario.getLogin())) {
               entradaSalida.mostrar("Login repetido. Añadido a incidencias");
                listaIncidencias.put(usuario.getLogin(), usuario);
            } else {
                entradaSalida.mostrar("Usuario añadido correctamente");
                listaUsuarios.put(usuario.getLogin(), usuario);
            }
        }
    }

    private boolean pedirOtro() throws IOException {
        boolean ok = false;
        String respuesta = entradaSalida.pideCadenaMensaje("Desea introducir otro archivo? (S/Cualquier otra tecla)");
        if (respuesta.equalsIgnoreCase("s")) {
            ok = true;
        }
        return ok;
    }

    private ArrayList<String> convertirUsuarios(HashMap<String, Usuario> lista) {
        Set<Map.Entry<String, Usuario>> entradas = null;
        entradas = lista.entrySet();
        ArrayList<String> listaPasada = new ArrayList<>();
        String cadena = "";
        for (Map.Entry<String, Usuario> elemento : entradas) {
            cadena = (elemento.getKey() + ":" + (elemento.getValue()).getClave() + ":" + (elemento.getValue()).getEmail() +
                    ":" + (elemento.getValue()).getNombre()) + ":" + (elemento.getValue()).getApellidos();
            listaPasada.add(cadena);
        }
        return listaPasada;
    }

    private void nombrarArchivos() throws IOException {
        String nombreListaUsuarios = entradaSalida.pideCadenaMensaje("Nombre del archivo de usuarios: ");
        String nombreListaIncidencias = entradaSalida.pideCadenaMensaje("Nombre del archivo de incidencias: ");
        crearFichero(nombreListaUsuarios, convertirUsuarios(listaUsuarios));
        crearFichero(nombreListaIncidencias, convertirUsuarios(listaIncidencias));
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


    private void elegirLista() throws IOException {
        String eleccion = entradaSalida.pideCadenaMensaje("M o I");
        if (eleccion.equalsIgnoreCase("m")) {
            mostrarUsuarios();
        } else if (eleccion.equalsIgnoreCase("i")) {
            mostrarIncidencias();
        }
    }

    private void mostrarUsuarios() {
        listaUsuarios.entrySet().forEach(entry -> {
            String cadena = "" + entry.toString();
            entradaSalida.mostrar(cadena);
        });

    }

    private void mostrarIncidencias() {
        listaIncidencias.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        });
    }


}