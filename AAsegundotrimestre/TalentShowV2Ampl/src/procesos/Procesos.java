/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Artista;
import beans.Cantante;
import beans.Malabarista;
import beans.Musico;
import beans.Poeta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import propertiesmenu.Idioma;
import vista.UtilidadesES;

/**
 *
 * @author Marina y Salvador
 */
public class Procesos implements Serializable {

    private String estado = "Parado";
    ArrayList<Artista> artistas = new ArrayList();
    ArrayList<Artista> artistasPasados = new ArrayList();
    Artista artista;
    int indiceActuaciones = 0;
            int cuantosPasan;
            int limite;

    ArrayList<String> nombres = new ArrayList<>();
    /**
     * @author ana y adrian Variables nuevas
     */
    private final String ES = "es";
    private final String EN = "en";
    private String idiomaActual;
    private Idioma idioma;
    private Properties propiedades;
    private Map<Integer, Integer> fasesConcurso;

    public Procesos() {
        this.idiomaActual = "es";
        idioma = new Idioma();
        propiedades = idioma.cargarPropiedades(idiomaActual);
        fasesConcurso = new HashMap<>();
    }

    /**
     *
     * @param opc opcion para el munú al que se llama.
     * @throws IOException devuelve la exepción.
     */
    public void ejecutarOpc(int opc) throws IOException {

        switch (estado) {
            case "Lanzado":
                ejecutarOpcLanzado(opc);
                break;
            case "Parado":
                ejecutarOpcParado(opc);
                break;
            case "Finalizado":
                ejecutarOpcFinalizado(opc);
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param opc opcion elegida por el usuario.
     * @throws IOException devuelve la exepción.
     */
    void ejecutarOpcLanzado(int opc) throws IOException {
        switch (opc) {
            case 1:
                concurso();
                break;
            case 2:
                comprobarConcursantesYLanzarConcurso();
                break;
            case 3:
                selectLanguage();
                break;
            case 7:
                salir();
                break;
            default:
                opcNoValida();
        }
    }

    /**
     *
     * @param opc opcion elegida por el usuario.
     * @throws IOException devuelve la exepción.
     */
    void ejecutarOpcParado(int opc) throws IOException {
        switch (opc) {
            case 1:
                registroArtistas();
                break;
            case 2:
                comprobarConcursantesYLanzarConcurso();
                break;
            case 3:
                selectLanguage();
                break;
            case 7:
                salir();
                break;
            default:
                opcNoValida();
        }
    }

    /**
     *
     * @param opc opcion elegida por el usuario.
     * @throws IOException devuelve la exepción.
     */
    void ejecutarOpcFinalizado(int opc) throws IOException {
        switch (opc) {
            case 1:
                clasificacionFinal();
                break;
            case 2:
                iniciarNuevoConcurso();
                break;
            case 7:
                salir();
                break;
            default:
                opcNoValida();
        }
    }

    /**
     * Inicia el registro de un artista
     */
    private void registroArtistas() {
        UtilidadesES.mostrarln(propiedades.getProperty("regArtistas"));
        elegirTipoYCrearArtista();
    }

    /**
     * Se encarga de lanzar el concurso. Comprueba antes que hay suficientes
     * concursantes para actuar
     *
     * @author ana y adrian
     */
    private void comprobarConcursantesYLanzarConcurso() {
        UtilidadesES.mostrarln(propiedades.getProperty("lanzarC"));
        try {
            // estado = elegirEstadoConcurso();
            estableberConcursantesDeCadaFase(establecerNumeroDeFases());
            comprobarConcursantes();
        } catch (IOException ex) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
        }
    }

    /**
     * Se pide el numero de fase que se van a realizar en el concurso
     *
     * @author ana y adrian
     * @return numFases entero que define el numero de fases del concurso
     */
    private int establecerNumeroDeFases() {
        int numFases = 0;
        try {
            clasificacionActual();
            numFases = comprobarNumFases();
            return numFases;
        } catch (IOException ioe) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
        }
        return numFases;
    }

    private int comprobarNumFases() throws IOException {
        int numFases = 0;
        do {
            numFases = UtilidadesES.pideEntero(propiedades.getProperty("numFases"));
            if (numFases < 1 || numFases > 5) {
                System.out.println("Introduce un numero entre 1 y 5");
            }
        } while (numFases < 1 || numFases > 5);

        return numFases;
    }

    /**
     * Se asignan los concursantes que pasan en cada fase
     *
     * @author ana y adriand
     * @param numFases
     * @throws IOException si se produce un error en la toma de datos
     */
    private void estableberConcursantesDeCadaFase(int numFases) throws IOException {
        int concursantes;
        for (int i = 0; i < numFases; i++) {
            if ((i + 1) == numFases) {
                System.out.println("En la ultima ronda solo puede haber un ganador");
                concursantes = 1;
            } else {
                concursantes = UtilidadesES.pideEntero(propiedades.getProperty("numConcursantes") + (i + 1) + ":");
            }
            fasesConcurso.put(i, concursantes);
        }
    }

    /**
     * Comprueba que el numero de concursantes registrados sea suficiente para
     * empezar el concurso
     *
     * @author ana y adrian
     */
    private void comprobarConcursantes() {
        int concursantesMinimos = 0;
        for (Map.Entry<Integer, Integer> concursantes : fasesConcurso.entrySet()) {
            concursantesMinimos = concursantes.getValue();
        }

        if (artistas.size() <= concursantesMinimos) {
            UtilidadesES.mostrarln(propiedades.getProperty("concursantesInsuficientes"));
        } else {
            concurso();
        }
    }

    /**
     * Inicia el concurso
     */
    private void concurso() {
        UtilidadesES.mostrarln(propiedades.getProperty("concurs"));
        //actuacionesArtistas();
        concursoPorFases();
        estado = "Finalizado";
        
    }

    /**
     * Muestra la acutuacion de un artista, saluda, actua y se despide. Tras la
     * actuación se establece la puntuación del artista.
     */
    public void actuacionesArtistas() {
        int respuesta = 2;

        while (respuesta == 2) {
            if (indiceActuaciones < artistas.size()) {
                artistas.get(indiceActuaciones).saludar();
                artistas.get(indiceActuaciones).actuar();
                artistas.get(indiceActuaciones).despedirse();
                artistas.get(indiceActuaciones).setPuntuacion(determinarPuntuacion());

                indiceActuaciones++;
            } else {
                UtilidadesES.mostrarln(propiedades.getProperty("sinConcursantesPorActuar") + "\n");
            }

            UtilidadesES.mostrarln(propiedades.getProperty("deseaSalir"));
            respuesta = finalizarMetodo();
        }

    }

    public void concursoPorFases() {
        //asignacion
        pasarArtistas();
        //actuan
        for (Integer key : fasesConcurso.keySet()) {
            System.out.println("FASE " + (key + 1));
            actuar();
            System.out.println("KeyActual: "+key + " = " + fasesConcurso.get(key));
            cuantosPasan = fasesConcurso.get(key);
            System.out.println("Cuantos pasan? " + cuantosPasan);

            ordenarArtistasPasadosYMostrar();
            escribirFichero(key + 1);
            int contador = artistasPasados.size();
            limite = contador - cuantosPasan;
            
            eliminarPerdedores();
            decirQuienPasa();
        }

    }
    
    public void decirQuienPasa(){
         for (int i = 0; i < artistasPasados.size(); i++) {
                System.out.println("Pasa " + artistasPasados.get(i).getNombre());
            }
    }
    public void eliminarPerdedores(){
        for (int i = 0; i < limite; i++) {
                     artistasPasados.remove(cuantosPasan);

            }
    }
    public void pasarArtistas() {
           for (int i = 0; i < artistas.size(); i++) {
            artistasPasados.add(artistas.get(i));
        }
        
    }

    
    public void ordenarArtistasPasadosYMostrar() {
        for (int i = 0; i < artistasPasados.size(); i++) {
            for (int j = i + 1; j < artistasPasados.size(); j++) {
                if (artistasPasados.get(i).getPuntuacion() < artistasPasados.get(j).getPuntuacion()) {
                    Collections.swap(artistasPasados, i, j);
                }
            }
        }
        for (int i = 0; i < artistasPasados.size(); i++) {

            System.out.println(artistasPasados.get(i).getNombre() + " = " + artistasPasados.get(i).getPuntuacion());

        }
    }

    public void escribirFichero(int fase) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("clasificaciones.txt", true);
            pw = new PrintWriter(fichero);
             pw.println("----------");
             pw.println("Fase " + fase);
            for (int i = 0; i < artistasPasados.size(); i++) {
                pw.println(artistasPasados.get(i).getNombre() + " = " + artistasPasados.get(i).getPuntuacion());

            }

        } catch (IOException e) {
           System.out.println("Error IOE");
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
                           System.out.println("Error IOE");
            }
        }
    }

    public void actuar() {
        for (int i = 0; i < artistasPasados.size(); i++) {
            artistasPasados.get(i).saludar();
            artistasPasados.get(i).actuar();
            artistasPasados.get(i).despedirse();
            artistasPasados.get(i).setPuntuacion(determinarPuntuacion());
        }
    }

    /**
     * Cambia el idioma del concurso
     *
     * @author ana
     * @throws IOException si se produce un error en la toma de datos
     */
    public void selectLanguage() throws IOException {
        int opc = UtilidadesES.pideEntero(propiedades.getProperty("seleccionIdioma") + "\n");

        switch (opc) {
            case 1:
                setPropertiesLanguage(ES);
                break;
            case 2:
                setPropertiesLanguage(EN);
                break;
            default:
                idiomaNoValido();
                break;
        }
    }

    /**
     * Se encarga de cargar las propiedades del idioma seleccionado
     *
     * @author ana
     * @param nombreArchivo
     */
    public void setPropertiesLanguage(String nombreArchivo) {
        propiedades = idioma.cargarPropiedades(nombreArchivo);
        idiomaActual = nombreArchivo;
    }

    /**
     * Muestra la opcion por defecto
     *
     * @author ana
     */
    private void idiomaNoValido() {
        System.out.println(propiedades.getProperty("idiomaNoValido"));
    }

    /**
     * Devuelve el idioma actual
     *
     * @author ana
     * @return idiomaActual idioma establecido actualmente
     */
    public String getIdiomaActual() {
        return idiomaActual;
    }

    /**
     * Muestra la calificación actual.
     */
    private void clasificacionActual() {
        UtilidadesES.mostrarln("Clasificacion actual");
        mostrarClasificacion();
    }

    /**
     * Muestra la calificación final.
     */
    private void clasificacionFinal() {
      //  UtilidadesES.mostrarln(propiedades.getProperty("rankingFinal"));
      //  mostrarClasificacion();
          try {
      File myObj = new File("clasificaciones.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      //e.printStackTrace();
    }
    }

    /**
     * Inicia un nuevo concurso
     *
     * @throws IOException devuelve la excepción.
     */
    private void iniciarNuevoConcurso() throws IOException {
        UtilidadesES.mostrarln(propiedades.getProperty("nuevoConcurso"));
        borrarRegistros();
        estado = "Parado";
    }

    /**
     * Sale de la aplicación.
     */
    private void salir() {

        UtilidadesES.mostrarln(propiedades.getProperty("salirPrograma"));
    }

    /**
     * Notifica al usuario de que no hay proceso asociado.
     */
    private void opcNoValida() {
        UtilidadesES.mostrarln(propiedades.getProperty("opcNValida"));
    }

    /**
     * Permite seleccionar el tipo del artista.
     */
    private void elegirTipoYCrearArtista() {
        int respuesta;
        boolean verificado = false;

        do {
            UtilidadesES.mostrarln(propiedades.getProperty("tipoArtista"));
            determinarTipoArtista(verificado);
            UtilidadesES.mostrarln(propiedades.getProperty("deseaSalir"));
            respuesta = finalizarMetodo();

        } while (respuesta == 2);

    }

    /**
     * Notifica al usuario el tipo de artista que ha registrado.
     *
     * @param verificado parametro que devuelve un boolean para comprobar si el
     * artista existe.
     */
    private void determinarTipoArtista(boolean verificado) {
        int eleccionArtista;

        while (verificado == false) {
            UtilidadesES.mostrar(propiedades.getProperty("elejirOpc"));

            try {
                eleccionArtista = UtilidadesES.leerInt();

                if (eleccionArtista < 1 || eleccionArtista > 4) {
                    throw new ArithmeticException();
                } else {
                    verificado = true;
                    switch (eleccionArtista) {

                        case 1:
                            registroPoeta();
                            UtilidadesES.mostrarln(propiedades.getProperty("poetaRegistrado"));
                            break;

                        case 2:
                            registroCantante();
                            UtilidadesES.mostrarln(propiedades.getProperty("cantanteRegistrado"));
                            break;

                        case 3:
                            registroMusico();
                            UtilidadesES.mostrarln(propiedades.getProperty("musicoRegistrado"));
                            break;

                        case 4:
                            registroMalabarista();
                            UtilidadesES.mostrarln(propiedades.getProperty("malabaristaRegistrado"));
                            break;

                    }
                }
            } catch (ArithmeticException ae) {
                UtilidadesES.mostrarln(propiedades.getProperty("ae"));
            } catch (InputMismatchException e) {
                UtilidadesES.mostrarln(propiedades.getProperty("ime"));
            }
        }

    }

    /**
     * Crea un poeta
     */
    public void registroPoeta() {
        boolean verificado = false;
        Poeta poeta = new Poeta(determinarLocalidad(verificado), determinarNombre(verificado), determinarEdad(verificado), insertarTituloPoema(verificado));
        nombres.add(poeta.getNombre().toLowerCase());
        artistas.add(poeta);

    }

    /**
     * Crea un cantante
     */
    public void registroCantante() {
        boolean verificado = false;
        Cantante cantante = new Cantante(determinarLocalidad(verificado), determinarNombre(verificado), determinarEdad(verificado), insertarTituloCancion(verificado));
        nombres.add(cantante.getNombre().toLowerCase());
        artistas.add(cantante);

    }

    /**
     * Crea un musico
     */
    public void registroMusico() {
        boolean verificado = false;
        Musico musico = new Musico(determinarLocalidad(verificado), determinarNombre(verificado), determinarEdad(verificado), insertarInstrumento(verificado));
        nombres.add(musico.getNombre().toLowerCase());
        artistas.add(musico);

    }

    /**
     * Crea un malabarista
     */
    public void registroMalabarista() {
        boolean verificado = false;
        Malabarista malabarista = new Malabarista(determinarLocalidad(verificado), determinarNombre(verificado), determinarEdad(verificado),
                insertarNumeroObjeto(verificado), insertarNombreObjeto(verificado));
        nombres.add(malabarista.getNombre().toLowerCase());
        artistas.add(malabarista);

    }

    /**
     * Solicita al usuario la localidad del artista.
     *
     * @param verificado valor false para ejecución del bucle.
     * @return devuelve la localidad del artista.
     */
    private String determinarLocalidad(boolean verificado) {

        String localidad = null;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("localidadArtista"));
            try {
                localidad = UtilidadesES.leerString();

                if (localidad.isEmpty() || localidad == null) {
                    throw new NullPointerException();
                } else {
                    verificado = true;
                }

            } catch (NullPointerException npe) {
                UtilidadesES.mostrarln(propiedades.getProperty("npe"));
            } catch (IllegalFormatException ife) {
                UtilidadesES.mostrarln(propiedades.getProperty("ife"));
            }

        }
        return localidad;
    }

    /**
     * Solicita al usuario el nombre del artista.
     *
     * @param verificado valor false para ejecución del bucle.
     * @return devuelve el nombre del artista.
     */
    private String determinarNombre(boolean verificado) {
        String nombre = null;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("nombreArtista"));
            try {
                nombre = UtilidadesES.leerString().trim();

                if (nombre.isEmpty() || nombre == null) {
                    throw new NullPointerException();
                } else if (nombres.contains(nombre.toLowerCase())) {
                    UtilidadesES.mostrarln(propiedades.getProperty("nombreExiste"));
                } else {
                    verificado = true;
                }

            } catch (NullPointerException npe) {
                UtilidadesES.mostrarln(propiedades.getProperty("npe"));
            } catch (IllegalFormatException ife) {
                UtilidadesES.mostrarln(propiedades.getProperty("ife"));
            }

        }
        return nombre;

    }

    /**
     * Solicita al usuario a edad del artista.
     *
     * @param verificado valor false para ejecución del bucle.
     * @return devulve la edad del artista.
     */
    private int determinarEdad(boolean verificado) {
        int edad = 0;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("edadArtista"));

            try {
                edad = UtilidadesES.leerInt();

                if (edad < 18) {
                    throw new ArithmeticException();
                } else {
                    verificado = true;
                }
            } catch (ArithmeticException ae) {
                UtilidadesES.mostrarln(propiedades.getProperty("aeEdad"));
            } catch (InputMismatchException ime) {
                UtilidadesES.mostrarln(propiedades.getProperty("ime"));
            }
        }
        return edad;
    }

    /**
     * Solicita al usuario el nombre del instrumento.
     *
     * @param verificado valor false para ejecución del bucle.
     * @return devuelve el instruento del artista.
     */
    private String insertarInstrumento(boolean verificado) {
        String instrumento = null;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("nombreInstrumento"));
            try {
                instrumento = UtilidadesES.leerString();

                if (instrumento.isEmpty() || instrumento == null) {
                    throw new NullPointerException();
                } else {
                    verificado = true;
                }

            } catch (NullPointerException npe) {
                UtilidadesES.mostrarln(propiedades.getProperty("npe"));
            } catch (IllegalFormatException ife) {
                UtilidadesES.mostrarln(propiedades.getProperty("ife"));
            }

        }
        return instrumento;
    }

    /**
     * Solicita al usuario el nombre del objeto
     *
     * @param verificado valor false para ejecución del bucle.
     * @return devuelve el nombre del objeto del artista.
     */
    private String insertarNombreObjeto(boolean verificado) {
        String nombreObjeto = null;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("nombreObjeto"));
            try {
                nombreObjeto = UtilidadesES.leerString();

                if (nombreObjeto.isEmpty() || nombreObjeto == null) {
                    throw new NullPointerException();
                } else {
                    verificado = true;
                }

            } catch (NullPointerException npe) {
                UtilidadesES.mostrarln(propiedades.getProperty("npe"));
            } catch (IllegalFormatException ife) {
                UtilidadesES.mostrarln(propiedades.getProperty("ife"));
            }

        }
        return nombreObjeto;
    }

    /**
     * Solicita al usuario el numero de objetos.
     *
     * @param verificado valor false para ejecución del bucle.
     * @return devuelve el numero de objetos del artista.
     */
    private int insertarNumeroObjeto(boolean verificado) {
        int numeroObjeto = 0;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("numObjetos"));

            try {
                numeroObjeto = UtilidadesES.leerInt();

                if (numeroObjeto < 2) {
                    throw new ArithmeticException();
                } else {
                    verificado = true;
                }
            } catch (ArithmeticException ae) {
                UtilidadesES.mostrarln(propiedades.getProperty("aeNumObjetos"));
            } catch (InputMismatchException ime) {
                UtilidadesES.mostrarln(propiedades.getProperty("ime"));
            }
        }
        return numeroObjeto;
    }

    /**
     * Solicita al usuario el titulo del poema.
     *
     * @param verificado valor false para ejecución del bucle.
     * @return devuelve el titulo de poema del artista.
     */
    private String insertarTituloPoema(Boolean verificado) {
        String tituloPoema = null;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("tituloPoema"));
            try {
                tituloPoema = UtilidadesES.leerString();

                if (tituloPoema.isEmpty() || tituloPoema == null) {
                    throw new NullPointerException();
                } else {
                    verificado = true;
                }

            } catch (NullPointerException npe) {
                UtilidadesES.mostrarln(propiedades.getProperty("npe"));
            } catch (IllegalFormatException ife) {
                UtilidadesES.mostrarln(propiedades.getProperty("ife"));
            }

        }
        return tituloPoema;
    }

    /**
     * Solicita al usuario el titulo de la canción.
     *
     * @param verificado valor false para ejecución del bucle.
     * @return devuelve el titulo de la canción del artista.
     */
    private String insertarTituloCancion(boolean verificado) {
        String tituloCancion = null;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("npe"));
            try {
                tituloCancion = UtilidadesES.leerString();

                if (tituloCancion == null) {
                    throw new NullPointerException();
                } else {
                    verificado = true;
                }

            } catch (NullPointerException npe) {
                UtilidadesES.mostrarln(propiedades.getProperty("npe"));
            } catch (IllegalFormatException ife) {
                UtilidadesES.mostrarln(propiedades.getProperty("ife"));
            }

        }
        return tituloCancion;
    }

    /**
     * Se solicita al usuario la puntuación del artista.
     *
     * @return devuelve la puntuación del artista.
     */
    private int determinarPuntuacion() {
        boolean verificado = false;
        int puntuacion = 0;

        while (verificado == false) {
            UtilidadesES.mostrarln(propiedades.getProperty("puntuacionArtista"));

            try {
                puntuacion = UtilidadesES.leerInt();

                if (puntuacion < 1 || puntuacion > 12) {
                    throw new ArithmeticException();
                } else {
                    verificado = true;
                }
            } catch (ArithmeticException e) {
                UtilidadesES.mostrarln(propiedades.getProperty("aePuntuacion"));
            } catch (InputMismatchException e) {
                UtilidadesES.mostrarln(propiedades.getProperty("ime"));
            }
        }
        return puntuacion;
    }

    /**
     * Se solicita al usuario si quiere salir del proceso actual.
     *
     * @return devuelve un entero con la respuesta.
     */
    private int finalizarMetodo() {
        int respuesta = 0;
        boolean verificado = false;
        while (verificado == false) {

            try {
                respuesta = UtilidadesES.leerInt();

                if (respuesta != 1 && respuesta != 2) {
                    throw new ArithmeticException();
                } else {
                    verificado = true;
                }
            } catch (ArithmeticException e) {
                UtilidadesES.mostrarln(propiedades.getProperty("aeSalir"));
            } catch (InputMismatchException e) {
                UtilidadesES.mostrarln(propiedades.getProperty("ime"));
            }

        }

        return respuesta;
    }

    /**
     * Solicita al usuario que seleccione el estado del concurso.
     *
     * @return devuelve un string con el estado del concurso.
     */
    private String elegirEstadoConcurso() {
        int respuesta = 0;
        int opcion = 0;
        do {
            UtilidadesES.mostrarln("¿Qué estado desea ejecutar? \n 1.Lanzado \n 2.Parado \n 3.Finalizar");

            opcion = UtilidadesES.leerInt();
            switch (opcion) {
                case 1:
                    estado = "Lanzado";
                    UtilidadesES.mostrarln("Estado cambiado a \"Lanzado\"");
                    ;
                    break;
                case 2:
                    estado = "Parado";
                    UtilidadesES.mostrarln("Estado cambiado a \"Parado\"");
                    ;
                    break;
                case 3:
                    estado = "Finalizado";
                    UtilidadesES.mostrarln("Estado cambiado a \"Finalizado\"");
                    ;
                    break;

                default:
                    UtilidadesES.mostrarln("La opción introducida no es válida. \n El estado de la aplicación sigue siendo \"" + estado + "\"");
                    ;

            }
            UtilidadesES.mostrarln("¿Desea salir? \n 1.Si   2.No");
            respuesta = finalizarMetodo();
        } while (respuesta == 2);

        return estado;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Muestra la clasificacion actual.
     */
    private void mostrarClasificacion() {

        if (!artistas.isEmpty()) {
            artistas = ordenarArtistas();

            for (int i = 0; i < artistas.size(); i++) {
                UtilidadesES.mostrarln(propiedades.getProperty("puntuacionClasificacion") + artistas.get(i).getNombre() + ": " + artistas.get(i).getPuntuacion());
            }
        } else {
            UtilidadesES.mostrarln(propiedades.getProperty("sinArtistasRegistrados"));
        }

    }

    /**
     * Ordena los artistas
     *
     * @return devuleve el ArrayList ordenado de artistas.
     */
    private ArrayList<Artista> ordenarArtistas() {

        for (int i = 0; i < artistas.size(); i++) {
            for (int j = i + 1; j < artistas.size(); j++) {
                if (artistas.get(i).getPuntuacion() < artistas.get(j).getPuntuacion()) {
                    Collections.swap(artistas, i, j);
                }
            }
        }

        return artistas;
    }

    /**
     * Borra los registro de los artistas.
     *
     * @return devuelve el ArrayList de artistas.
     * @throws IOException devuelve la exepción.
     */
    private ArrayList<Artista> borrarRegistros() throws IOException {
        int respuesta;

        UtilidadesES.mostrarln("\n " + propiedades.getProperty("finalizarConcurso"));
        respuesta = finalizarMetodo();
        if (respuesta == 1) {
            artistas = new ArrayList<>();
            Files.deleteIfExists(Paths.get("proceso.ser"));
        }

        return artistas;
    }

}
