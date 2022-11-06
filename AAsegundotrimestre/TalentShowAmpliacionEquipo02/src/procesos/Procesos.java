/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Artista;
import beans.Cantante;
import beans.Humorista;
import beans.Malabarista;
import beans.Musico;
import beans.Poeta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import java.util.Properties;
import vista.UtilidadesES;

/**
 *
 * @author Marina y Salvador
 */
public class Procesos implements Serializable {

    private String estado = "Parado";
    ArrayList<Artista> artistas = new ArrayList();
    Artista artista;
    int indiceActuaciones = 0;
    ArrayList<String> nombres = new ArrayList<>();
    /**
     * @author ana y adrian
     */
    private final String ES = "es";
    private final String EN = "en";
    private String idiomaActual;
    private Idioma idioma;
    private Properties propiedades;
    private HashMap<Integer, Integer> fasesConcurso;
    private ArrayList<Artista> artistaClasificados;
    private int numFases, faseActual;
    private final String ARCHIVORANKING = "ranking.txt";

    public Procesos() {
        this.idiomaActual = ES;
        idioma = new Idioma();
        propiedades = idioma.cargarPropiedades(idiomaActual);
        artistaClasificados = new ArrayList<>();
        faseActual = 0;
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
                seleccionarIdioma();
                break;
            case 3:
                clasificacionActual();
                break;
            case 4:
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
                lanzarConcurso();
                break;
            case 3:
                seleccionarIdioma();
                break;
            case 4:
                clasificacionActual();
                break;
            case 5:
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
                seleccionarIdioma();
                break;
            case 2:
                clasificacionFinal();
                break;
            case 3:
                iniciarNuevoConcurso();
                break;
            case 4:
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
     * Inicia el concurso
     */
    private void concurso() {
        try {
            iniciarConcurso();
        } catch (IOException ioe) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
        }

    }

    /**
     * Metodo que pide el numero de fases y concursantes por fase
     *
     * @auhtor ana
     */
    private void lanzarConcurso() {
        try {
            UtilidadesES.mostrarln(propiedades.getProperty("lanzarConcurso"));
            fasesConcurso = new HashMap<>();
            establecerConcursantesDeCadaFase(introducirNumFases());
            comprobarNumeroMinimoConcursantes();
        } catch (Exception e) {
        }
    }

    /**
     * Se encarga de devolver un numero de fases valido
     *
     * @author ana
     * @return numFases entero introducido por el usuario
     */
    private int introducirNumFases() {
        try {
            numFases = comprobarNumeroFases();
            return numFases;
        } catch (NumberFormatException nfe) {
            UtilidadesES.mostrarln(propiedades.getProperty("introduceUnNumero"));
        } catch (IOException ioe) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
        }
        return numFases;
    }

    /**
     * Comprueba que el numero de fases se encuentre dentro del rango
     *
     * @author ana
     * @return numeroFases entero validado
     * @throws IOException si se produce un error al introducir los datos
     */
    private int comprobarNumeroFases() throws IOException {
        int numeroFases = 0;
        while (numeroFases < 1 || numeroFases > 5) {
            numeroFases = UtilidadesES.pideEntero(propiedades.getProperty("introducirNumFases"));
            if (numeroFases < 1 || numeroFases > 5) {
                UtilidadesES.mostrarln(propiedades.getProperty("rangoFases"));
            } else {
                return numeroFases;
            }
        }
        return numeroFases;
    }

    /**
     * Establece los concursantes de cada fase
     *
     * @author ana
     * @param numFases numero de fases que se van a desarrollar
     * @throws IOException si se produce un error en la toma de datos
     */
    private void establecerConcursantesDeCadaFase(int numFases) throws IOException {
        int numConcursantesAnterior = 0, concursantes;
        for (int i = 0; i < numFases; i++) {
            concursantes = UtilidadesES.pideEntero(propiedades.getProperty("numConcursantesFase") + (i + 1) + ":");
            if (comprobarNumeroConcursantes(concursantes, numConcursantesAnterior)) {
                fasesConcurso.put(i, concursantes);
                numConcursantesAnterior = concursantes;
            } else {
                UtilidadesES.mostrarln(propiedades.getProperty("limiteNumConcursantesFase") + numConcursantesAnterior);
                i--;
            }
        }
    }

    /**
     * Comprueba el numero de concursantes que pasan de ronda
     *
     * @author ana y adrian
     * @param numConcursantes numero de concursantes que se han introducido
     * @param numConcursantesAnterior el numero de concursantes asignado en la
     * ronda anterior
     * @return true si el numero es valido , false si no lo es
     */
    private boolean comprobarNumeroConcursantes(int numConcursantes, int numConcursantesAnterior) {
        if (numConcursantesAnterior == 0 || numConcursantesAnterior > numConcursantes) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprueba que el numero de concursantes registrados sea suficiente para
     * empezar el concurso
     *
     * @author ana y adrian
     */
    private void comprobarNumeroMinimoConcursantes() throws IOException {
        int concursantesMinimos = 0;
        concursantesMinimos = fasesConcurso.get(0);
        comprobarConcursantesSuficientes(concursantesMinimos);

    }

    /**
     * Comprueba que hay suficientes concursantes para lanzar el concurso
     *
     * @author ana
     * @param concursantesMinimos
     * @throws IOException
     */
    private void comprobarConcursantesSuficientes(int concursantesMinimos) throws IOException {
        if (artistas.size() < concursantesMinimos) {
            concursantesInsuficientes();
        } else if (concursantesMinimos == 0) {
            System.out.println(propiedades.getProperty("noSePuedeEmpezarConcurso") + "\n");
        } else {
            estado = "Lanzado";
        }
    }

    /**
     * Pregunta si Cambiar rondas o añadir concursantes en caso de que no se
     * pueda empezar el concurso
     *
     * @author ana y adrian
     */
    private void concursantesInsuficientes() throws IOException {
        UtilidadesES.mostrarln(propiedades.getProperty("concursantesInsuficientes"));
        int respuesta = UtilidadesES.pideEntero(propiedades.getProperty("cambiarNumeroDeFases") + "\n");
        if (respuesta == 1) {
            lanzarConcurso();
        } else {
            UtilidadesES.mostrarln(propiedades.getProperty("volviendoAlMenu"));
        }
    }

    /**
     * Se encarga de ejecutar el concurso
     *
     * @author ana
     */
    private void iniciarConcurso() throws IOException {
        UtilidadesES.mostrarln(propiedades.getProperty("inicioConcurso") + "\n");
        boolean seguirConcurso = true;

        while (seguirConcurso) {
            seguirConcurso = desarrolloFases();
        }
    }

    /**
     * Desarrollo de las fases del concurso
     *
     * @author ana y adruan
     * @return false si se para el concurso true si se sigue desarrollando
     * @throws IOException
     */
    private boolean desarrolloFases() throws IOException {
        boolean seguirConcurso = true;
        indiceActuaciones = 0;
        if (artistaClasificados.size() < 1) {
            artistaClasificados = (ArrayList<Artista>) artistas.clone();
        }

        for (int i = faseActual; i < numFases; i++) {
            ejecutarActuacionesFase(i);
            seleccionarConcursantesClasificados(faseActual);
            faseActual++;

            if (faseActual == numFases) {
                seguirConcurso = comprobarFinConcurso();
                return seguirConcurso;
            }

            seguirConcurso = pararConcurso();
            if (!seguirConcurso) {
                return seguirConcurso;
            }
        }
        return seguirConcurso;
    }

    /**
     * Se decide si se para el concurso
     *
     * @author ana y adruan
     * @return false si queremos parar el concurso true si seguimos
     */
    private boolean pararConcurso() {
        int opcSalir;
        boolean seguirConcurso = true;
        try {
            opcSalir = UtilidadesES.pideEntero(propiedades.getProperty("deseaSalir"));
            seguirConcurso = continuarSiguienteFase(opcSalir);
        } catch (NumberFormatException nfe) {
            UtilidadesES.mostrarln(propiedades.getProperty("nfe"));
        } catch (IOException ioe) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
        }

        return seguirConcurso;
    }

    /**
     * Comprueba si se ha llegado al final del concurso
     *
     * @author ana
     * @return devuelve false si se ha finalizado el concurso y true si se sigue
     */
    private boolean comprobarFinConcurso() {
        if (artistaClasificados.size() == 1) {
            UtilidadesES.mostrarln(propiedades.getProperty("concursoFinalizado") + artistaClasificados.get(0).getNombre());
            estado = "Finalizado";
            return false;
        }
        return true;
    }

    /**
     * Se encarga de ejecutar las actuaciones
     *
     * @author ana y adrian
     * @param numRonda recibe el numero de ronda que se va a desarrollar
     */
    private void ejecutarActuacionesFase(int numRonda) {
        UtilidadesES.mostrarln(propiedades.getProperty("ronda") + (numRonda + 1));
        actuacionesArtistas();
        UtilidadesES.mostrarln(propiedades.getProperty("ronda") + (numRonda + 1) + propiedades.getProperty("finalizada"));
    }

    /**
     * Se encarga de devolver un boolean
     *
     * @author ana y adrian
     * @param opc numero entero que contiene el valor de la opcion
     * @return seguir true si se decide continuar , false si queremos parar y
     * volver al menu
     */
    private boolean continuarSiguienteFase(int opc) {
        boolean seguirConcurso = false;

        switch (opc) {
            case 1:
                seguirConcurso = false;
                break;
            case 2:
                seguirConcurso = true;
                break;
            default:
                UtilidadesES.mostrarln(propiedades.getProperty("opcNoCorrecta"));
                break;
        }
        return seguirConcurso;
    }

    /**
     * Metodo que escoge a los concursantes que pasan de ronda
     *
     * @author ana y adrian
     */
    private void seleccionarConcursantesClasificados(int faseActual) throws IOException {
        int numClasificados, fase;
        for (HashMap.Entry<Integer, Integer> clasificados : fasesConcurso.entrySet()) {
            fase = clasificados.getKey();
            numClasificados = clasificados.getValue();
            if (faseActual == fase) {
                artistaClasificados = ordenacionDeConsurantes(numClasificados, fase);
            }
        }
    }

    /**
     * Ordena a los concursantes y escoge a los clasificados
     *
     * @author ana y adrian
     * @param numClasificados numero de personas que se clasifican
     * @param fase numero de fase actual
     * @return array con los artistas que han pasado de fase
     * @throws IOException
     */
    private ArrayList<Artista> ordenacionDeConsurantes(int numClasificados, int fase) throws IOException {
        ArrayList<Artista> clasificadosTemp = new ArrayList<>();
        Collections.sort(artistaClasificados, Collections.reverseOrder());
        guardarClasificacion(artistaClasificados, fase);
        for (int i = 0; i < numClasificados; i++) {
            clasificadosTemp.add(artistaClasificados.get(i));
        }
        return clasificadosTemp;
    }

    /**
     * Guarda en un archivo la clasificacion por fases
     *
     * @author ana y adrian
     * @param clasificadosTemp array temporal con los participantes de la ronda
     * actual
     */
    private void guardarClasificacion(ArrayList<Artista> clasificadosTemp, int fase) throws IOException {
        File ranking = new File(ARCHIVORANKING);
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(ranking, true);
            pw = new PrintWriter(fw);

            pw.println("Fase" + (fase + 1));
            for (Artista artistaClasificado : clasificadosTemp) {
                pw.println("Nombre: " + artistaClasificado.getNombre() + " Puntuacion: " + artistaClasificado.getPuntuacion());
            }

        } catch (IOException ex) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
        } finally {
            fw.close();
        }

    }

    /**
     *
     * Cambia el idioma del concurso
     *
     * @author ana
     * @throws IOException si se produce un error en la toma de datos
     */
    public void seleccionarIdioma() throws IOException {
        int opc = UtilidadesES.pideEntero(propiedades.getProperty("seleccionIdioma") + "\n");

        switch (opc) {
            case 1:
                cargarPropiedadesIdioma(ES);
                break;
            case 2:
                cargarPropiedadesIdioma(EN);
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
    public void cargarPropiedadesIdioma(String nombreArchivo) {
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
     * Devuelve el idioma que esta mostrando actualmente
     *
     * @author ana
     * @return idiomaActual idioma establecido actualmente
     */
    public String getIdiomaActual() {
        return idiomaActual;
    }

    /**
     *
     * Muestra la calificación actual.
     */
    private void clasificacionActual() {
        UtilidadesES.mostrarln(propiedades.getProperty("clasificacionActual"));
        try {
            mostrarClasificacion();
        } catch (IOException ioe) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
        }
    }

    /**
     * Muestra la calificación final.
     */
    private void clasificacionFinal() {
        UtilidadesES.mostrarln(propiedades.getProperty("rankingFinal"));
        try {
            mostrarClasificacion();
        } catch (IOException ioe) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
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
     * @author ana y adrian --> Nueva opcion al switch
     * @param verificado parametro que devuelve un boolean para comprobar si el
     * artista existe.
     */
    private void determinarTipoArtista(boolean verificado) {
        int eleccionArtista;

        while (verificado == false) {
            UtilidadesES.mostrar(propiedades.getProperty("elejirOpc"));

            try {
                eleccionArtista = UtilidadesES.leerInt();

                if (eleccionArtista < 1 || eleccionArtista > 5) {
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
                        case 5:
                            registroHumorista();
                            UtilidadesES.mostrarln(propiedades.getProperty("humoristaRegistrado"));
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
     *
     * @author ana y adrian
     */
    public void registroHumorista() {
        boolean verificado = false;
        Humorista humorista = new Humorista(determinarLocalidad(verificado), determinarNombre(verificado), determinarEdad(verificado), seleccionarNumChistes(verificado));
        nombres.add(humorista.getNombre().toLowerCase());
        artistas.add(humorista);
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
     * Se encarga de comprobar que el array de chistes no este vacio
     *
     * @author ana y adrian
     * @param verificado
     * @return chistes ArrayList que contiene los chistes del humorista
     */
    private ArrayList<String> seleccionarNumChistes(boolean verificado) {
        ArrayList<String> chistes = new ArrayList<>();

        while (verificado == false) {
            try {
                chistes = insertarChistes(UtilidadesES.pideEntero(propiedades.getProperty("numChiste")));

                if (chistes.isEmpty()) {
                    UtilidadesES.mostrarln(propiedades.getProperty("chisteMin"));
                } else {
                    verificado = true;
                }

            } catch (IllegalFormatException ife) {
                UtilidadesES.mostrarln(propiedades.getProperty("ife"));
            } catch (IOException ioe) {
                UtilidadesES.mostrarln("ioe");
            }

        }
        return chistes;
    }

    /**
     * Recibe el numero de chistes que recitara el humorista y se añaden las
     * cadenas a un ArrayList
     *
     * @author ana y adrian
     * @param num recibe un entero que sera el numero de chistes que cuente el
     * humorista
     * @return chistes Array que contiene los chistes del humorista
     */
    private ArrayList<String> insertarChistes(int num) {
        ArrayList<String> chistes = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            UtilidadesES.mostrarln(propiedades.getProperty("introducirChiste") + i);
            chistes.add(UtilidadesES.leerString());
        }
        return chistes;
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
            UtilidadesES.mostrarln(propiedades.getProperty("tituloCancion"));
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
     * Muestra la acutuacion de un artista, saluda, actua y se despide. Tras la
     * actuación se establece la puntuación del artista.
     *
     * @author ana y adrian
     */
    public void actuacionesArtistas() {
        indiceActuaciones = 0;
        if (indiceActuaciones < artistaClasificados.size()) {

            for (Artista artistaClasificado : artistaClasificados) {
                artistaClasificado.saludar();
                artistaClasificado.actuar();
                artistaClasificado.despedirse();
                artistaClasificado.setPuntuacion(determinarPuntuacion());
                indiceActuaciones++;
            }
        } else {
            UtilidadesES.mostrarln(propiedades.getProperty("sinConcursantesPorActuar") + "\n");
        }

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
    /*private String elegirEstadoConcurso() {
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
     */
    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Muestra la clasificacion actual.
     *
     * @author ana
     */
    private void mostrarClasificacion() throws IOException {
        if (artistaClasificados.size() < 1) {
            mostrarArtistasRegistrados();
        } else {
            leerArchivoRanking();
        }

    }

    /**
     * Muestra los artistas registrados
     *
     * @author ana
     */
    private void mostrarArtistasRegistrados() {
        if (artistas.size() < 1) {
            UtilidadesES.mostrarln(propiedades.getProperty("sinArtistasRegistrados"));
        } else {
            artistas.forEach((artistaRegistrado) -> {
                System.out.println("Nombre: " + artistaRegistrado.getNombre() + " Puntuacion: " + artistaRegistrado.getPuntuacion());
            });
        }

    }

    /**
     * Lee el archivo txt en el que se almacenan las puntuaciones
     *
     * @author ana
     * @throws IOException
     */
    private void leerArchivoRanking() throws IOException {
        String cadena;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(ARCHIVORANKING));

            while ((cadena = br.readLine()) != null) {
                System.out.println(cadena);
            }
        } catch (FileNotFoundException fnfe) {
            UtilidadesES.mostrarln(propiedades.getProperty("fnfe"));
        } catch (IOException ioe) {
            UtilidadesES.mostrarln(propiedades.getProperty("ioe"));
        } finally {
            br.close();
        }
    }

    /**
     * Ordena los artistas
     *
     * @return devuleve el ArrayList ordenado de artistas.
     */
    /*
    private ArrayList<Artista> ordenarArtistas() {

        for (int i = 0; i < artistas.size(); i++) {
            for (int j = i + 1; j < artistas.size(); j++) {
                if (artistas.get(i).getPuntuacion() < artistas.get(j).getPuntuacion()) {
                    Collections.swap(artistas, i, j);
                }
            }
        }

        return artistas;
    }*/
    /**
     * Borra los registro de los artistas.
     *
     * @author ana
     * @return devuelve el ArrayList de artistas.
     * @throws IOException devuelve la exepción.
     */
    private ArrayList<Artista> borrarRegistros() throws IOException {
        int respuesta;
        File archivo = new File(ARCHIVORANKING);

        UtilidadesES.mostrarln("\n " + propiedades.getProperty("finalizarConcurso"));
        respuesta = finalizarMetodo();
        try {
            if (respuesta == 1) {
                artistas = new ArrayList<>();
                Files.deleteIfExists(Paths.get("proceso.ser"));
                archivo.delete();
            }
        } catch (Exception e) {
            UtilidadesES.mostrarln("Error");
        }

        return artistas;
    }

}
