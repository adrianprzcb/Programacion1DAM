package prtalentshowamp.beansProcesos;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import prtalentshowamp.beansDatos.*;
import prtalentshowamp.errores.OpcionMenuIncorrecta;
import prtalentshowamp.menu.Menu;
import prtalentshowamp.menu.OpcionesMenu;
import utilidades.UtilidadesES;

import java.io.*;
import java.util.*;

public class Concurso {

    private UtilidadesES utilidadesES;
    private ListaArtistas listaArtistas;
    private Jurado jurado;
    private File fArchivo;
    private Menu menu, menuAddArtista;
    private OpcionesMenu opcionesMenu, opcionesMenuArtista;
    private boolean actuacion = false;
    private Logger log;



    public Concurso() {
        this.utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        this.listaArtistas = new ListaArtistas();
        this.fArchivo = null;
        this.jurado = new Jurado();
        log = LogManager.getLogger();

        opcionesMenu = new OpcionesMenu();
        opcionesMenu.add("Añadir un artista");
        opcionesMenu.add("Mostrar la lista de artistas");
        opcionesMenu.add("Actuacion de todos los artistas");
        opcionesMenu.add("Clasificacion general");
        opcionesMenu.add("Seleccionar tres mejores(almacenar en disco)");
        opcionesMenu.add("Mostrar 3 mejores");

        menu = new Menu(opcionesMenu, utilidadesES);

        opcionesMenuArtista = new OpcionesMenu();
        opcionesMenuArtista.add("Poeta");
        opcionesMenuArtista.add("Cantante");
        opcionesMenuArtista.add("Malabarista");

        menuAddArtista = new Menu(opcionesMenuArtista, utilidadesES);
    }

    public void ejecutar() {
        try {
            concurso();
            log.info("Se ha ejecutado el concurso.");
        } catch (IOException ioe) {
            log.fatal("Aplicacion finalizada por error de entrada/salida");
            if (ioe.getMessage().equals("")) {
                utilidadesES.mostrarln("Error de toma de datos. Vuelva a intentarlo mas tarde.");
            } else {
                utilidadesES.mostrarln(ioe.getMessage());
            }
        } finally {
            utilidadesES.mostrarln("Fin del programa");
        }
    }
    private void concurso() throws IOException {
        String opcion = "";
        boolean error = true;
        do {
            menu.presentaMenu();
            try {
                opcion = menu.leeOpcMenu("Introduzca una opción: ");
                ejecutarOpcion(opcion);
                error = false;
                utilidadesES.mostrarln("Fin del proceso asociado a la opción " + opcion);
                log.info("Se ha ejecutado una opción.");
            } catch (OpcionMenuIncorrecta omi) {
                utilidadesES.mostrarln(omi.getMessage());
                log.warn("Se ha elegido una opción incorrecta de menú.");
            } catch(FileNotFoundException fnfe) {
                utilidadesES.mostrarln(fnfe.getMessage());
                log.error("No se ha encontrado el archivo.");
            } catch (ClassNotFoundException cnfe) {
                utilidadesES.mostrarln(cnfe.getMessage());
                log.fatal("No se ha encontrado la clase");
            }
        } while (!opcion.equals(Menu.SALIR) || error);
    }

    private void ejecutarOpcion(String opcion) throws OpcionMenuIncorrecta, FileNotFoundException, IOException,
                                                ClassNotFoundException {
        switch (opcion) {
        case "1":
            pideTipoArtista();
            break;
        case "2":
            mostrarListaArtistas();
            break;
        case "3":
            actuacionesArtistas();
            break;
        case "4":
            mostrarClasificacionGeneral();
            break;
        case "5":
            guardarTresMejoresArtistas();
            break;
        case "6":
            mostrarTresMejoresArtistas();
            break;
        case "S":
            ejecutarOpcSalir();
            break;
        default:
            ejecutarNada();
            break;
        }
    }

    private void pideTipoArtista() {
        if (this.actuacion) {
            utilidadesES.mostrarln("Los artistas ya han actuado anteriormente");
        } else {
        String opcion = "";
        boolean error = true;
        try {
            do {
                menuAddArtista.presentaMenu();
                try {
                    opcion = menuAddArtista.leeOpcMenu("Introduzca una opción: ");
                    addArtista(opcion);
                    error = false;
                    utilidadesES.mostrarln("Fin del proceso asociado a la opción " + opcion);
                    log.info("Se ha añadido un artista");
                } catch (OpcionMenuIncorrecta omi) {
                    utilidadesES.mostrarln(omi.getMessage());
                    log.warn("Se ha elegido una opción incorrecta de menú.");
                }
            } while (!opcion.equals(Menu.SALIR) | error);
        } catch (IOException ioe) {
            log.warn("Error en la aplicación de entrada/salida.");
            }
        }
    }

    private void addArtista(String opcion) throws OpcionMenuIncorrecta {
        switch (opcion) {
        case "1":
            listaArtistas.addArtista(new Poeta(pideNombreArtista("poeta"), pideEdadArtista("poeta")));
            break;
        case "2":
            listaArtistas.addArtista(new Cantante(pideNombreArtista("cantante"), pideEdadArtista("cantante")));
            break;
        case "3":
            listaArtistas.addArtista(new Malabarista(pideNombreArtista("malabarista"), pideEdadArtista("malabarista")));
            break;
        case "S":
            ejecutarOpcSalir();
            break;
        default:
            ejecutarNada();
            break;
        }
    }

    private String pideNombreArtista(String tipoArtista) {
        boolean error = true;
        String nombre = "";
        do {
            try {
                nombre = utilidadesES.pideCadena("Indica el nombre del " + tipoArtista + ": ");
                error = false;
                log.info("Se ha introducido el nombre del artista.");
            } catch (IOException ioe) {
                log.error("Error en la aplicación de entrada/salida.");
                if (ioe.getMessage().equals("")) {
                    utilidadesES.mostrarln("Error de toma de datos. Vuelva a intentarlo mas tarde.");
                } else {
                    utilidadesES.mostrarln(ioe.getMessage());
                }
            }
        } while (error);
        return nombre;
    }
    
    private int pideEdadArtista(String tipoArtista) {
        boolean error = true;
        int nombre = 0;
        do {
            try {
                nombre = Integer.parseInt(utilidadesES.pideCadena("Indica la edad del "+tipoArtista+": "));
                error = false;
                log.info("Se ha introducido la edad del artista.");
            }catch (NumberFormatException nfe) {
                    utilidadesES.mostrarln("No has introducido un numero en la edad, vuelva a intentarlo");
                    log.warn("No se ha introducido un número.");
                } catch (IOException ioe) {
                    log.error("Error en la aplicación de entrada/salida.");
                    if (ioe.getMessage().equals("")) {
                        utilidadesES.mostrarln("Error de toma de datos. Vuelva a intentarlo mas tarde.");
                    } else {
                        utilidadesES.mostrarln(ioe.getMessage());
                    }
                } 
        } while (error);
        return nombre;
    }

    private void mostrarListaArtistas() {
        if (this.listaArtistas.getListaArtistas().isEmpty()) {
            utilidadesES.mostrarln("No se hay inscrito ningun participante en el concurso actualmente, prueba añadir artistas con la opcion 1.");
        } else {
            utilidadesES.mostrarln("Artistas que participaran en el concurso: ");
            for (Artista artista : listaArtistas.getListaArtistas()) {
                utilidadesES.mostrarln(artista.getTipoArtista() + ": " + artista.getNombre() + ", edad " +
                                       artista.getEdad());
            }
        }
    }

    private void actuacionesArtistas() {
        if (this.actuacion) {
            utilidadesES.mostrarln("Los artistas ya han actuado anteriormente");
        } else {
            if (this.listaArtistas.getListaArtistas().isEmpty()) {
                utilidadesES.mostrarln("No se ha inscrito ningun artista a este concurso actualmente, prueba añadir artistas con la opcion 1.");
            } else {
                int puntuacion;
                for (Artista artista : listaArtistas.getListaArtistas()) {
                    utilidadesES.mostrarln(artista.saludar());
                    utilidadesES.mostrarln(artista.actuar());
                    utilidadesES.mostrarln(artista.despedirse());
                    puntuacion = puntuarArtistaJurado(artista);
                    utilidadesES.mostrarln("El jurado ha puntuado la actuacion con " + puntuacion+"\n");
                }
                this.actuacion = true;
            }
        }
    }

    private void mostrarClasificacionGeneral() {
        if (!this.actuacion) {
            utilidadesES.mostrarln("No se ha realizado el concurso, eliga la opcion 3 para comenzar el concurso");
        } else {
            jurado.dameListaPuntuacionOrdenada().forEach((entry) -> utilidadesES.mostrarln("Artista: "+ entry.getKey().getNombre()+" -- Puntuacion: "+ entry.getValue()));
            }
    }

    private void guardarTresMejoresArtistas() throws FileNotFoundException, IOException {
        if (!this.actuacion) {
            utilidadesES.mostrarln("No se ha realizado el concurso, eliga la opcion 3 para comenzar el concurso");
        } else {
            fArchivo = new File("TresMejores.dat");
            int contador = 0;
            HashMap<Artista,Integer> listaTresMejores = new HashMap<Artista, Integer>();
            // LinkedList<Map.Entry<Artista, Integer>> listaTresMejores = new LinkedList<Map.Entry<Artista, Integer>>();
            for (Map.Entry<Artista, Integer> entry : jurado.dameListaPuntuacionOrdenada()) {
                contador++;
                if (contador <= 3) {
                    listaTresMejores.put(entry.getKey(), entry.getValue());
                }
            }
            if (fArchivo.exists()) {
                utilidadesES.mostrarln("El archivo ya estaba creado anteriormente.");
            } else {
                if (grabaListaTresMejoresArtistas(fArchivo, listaTresMejores)) {
                    utilidadesES.mostrarln("Se ha guardado correctamente los tres mejores artistas");
                } else {
                    utilidadesES.mostrarln("No se ha podido guardar");
                }
            }
        }
    }
    /**
     * 
     * @param fArchivo
     * @param listaTresMejores
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private boolean grabaListaTresMejoresArtistas(File fArchivo, HashMap<Artista,Integer> listaTresMejores) throws FileNotFoundException,
                                                                                                  IOException {
        ObjectOutputStream oos = null;
        boolean ok = true;

        try {
                oos = new ObjectOutputStream(new FileOutputStream(fArchivo));
                oos.writeObject(listaTresMejores);
                log.info("Se ha mostrado el archivo.");
        }
        // Este catch debe ir antes que el de IOException.
        catch (FileNotFoundException fnfe) {
                log.error("No se ha encontrado el archivo.");
                throw new FileNotFoundException("No se encuentra archivo en metodo grabaListaTresMejoresArtistas()");
        }
        catch (IOException ioe) { // Este salta a la hora de guardar la lista de los tres mejores artistas segun puntuacion
                log.error("Error al guardar los artistas.");
                throw new IOException("Error al escribir el objeto en metodo grabaListaTresMejoresArtistas()",ioe);
        }
        finally {
                if (oos != null)
                        oos.close();
        }
        return ok;
    }

    private void mostrarTresMejoresArtistas() throws IOException, ClassNotFoundException {
        if (!this.actuacion) {
            utilidadesES.mostrarln("No se ha realizado el concurso, eliga la opcion 3 para comenzar el concurso");
        } else {
            utilidadesES.mostrarln("Lista 3 mejores recuperada:");
            Map<Artista, Integer> unsortedMap = leeLista3Mejores(fArchivo);
            List<Map.Entry<Artista,Integer>> sortedMap = new LinkedList<Map.Entry<Artista, Integer>>(unsortedMap.entrySet());
            
            Collections.sort(sortedMap, new Comparator<Map.Entry<Artista,Integer>>() {
                @Override
                public int compare(Map.Entry<Artista,Integer> o1, Map.Entry<Artista,Integer> o2) {
                    // TODO Implement this method
                    return (o2.getValue().compareTo(o1.getValue()));
                }
            });
            for (Map.Entry<Artista,Integer> entry : sortedMap) {
                utilidadesES.mostrarln("Artista: "+entry.getKey().getNombre()+" -- Puntuacion: "+entry.getValue());
            }
        }
    }
    
    private HashMap<Artista,Integer> leeLista3Mejores(File fArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        HashMap<Artista,Integer> lista3Mejores = null;
        try {
                ois = new ObjectInputStream(new FileInputStream(fArchivo));
                lista3Mejores = (HashMap<Artista,Integer>) ois.readObject();
                log.info("Se ha introducido algo en el archivo.");
        }
        // Este catch debe ir antes que el de IOException.
        catch (FileNotFoundException fnfe) {
                log.error("No se ha encontrado el archivo.");
                throw new FileNotFoundException("No se encuentra archivo en metodo leeListaUsuarios()");
        }
        catch (IOException ioe) {
                log.error("Error al leer los artistas");
                throw new IOException("Error al leer el objeto en m�todo leeListaUsuarios()",ioe);
        } catch (ClassNotFoundException cnfe) {
                log.fatal("No se ha encontrado la clase al leer los artistas");
                throw new ClassNotFoundException("Error al leer el objeto en metodo leeListaUsuarios()",cnfe);
        }
        finally {
                if (ois != null)
                        ois.close();
        }           
        return lista3Mejores;
    }

    private void ejecutarOpcSalir() {
        utilidadesES.mostrarln("Saliste de la aplicacion");
    }

    private void ejecutarNada() throws OpcionMenuIncorrecta {
        throw new OpcionMenuIncorrecta("No has introducido una opcion correcta");
    }

    private int puntuarArtistaJurado(Artista artista) {
        int puntuacion = 0;
        boolean error = true;
        do {
            try {
                puntuacion = jurado.puntuar(artista);
                error = false;
                log.info("Se ha puntuado.");
            } catch (NumberFormatException nfe) {
                utilidadesES.mostrarln(nfe.getMessage());
                log.warn("No se ha introducido un número.");
            } catch (IOException ioe) {
                log.error("Error en la aplicación de entrada/salida");
                utilidadesES.mostrarln(ioe.getMessage());
            }
        } while (error);
        return puntuacion;
    }
}
