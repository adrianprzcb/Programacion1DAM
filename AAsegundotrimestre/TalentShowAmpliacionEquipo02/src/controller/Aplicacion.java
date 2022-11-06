    package controller;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import procesos.Procesos;
import procesos.Serializar;
import procesos.SerializarImpl;
import procesos.Idioma;
import vista.OpcionesMenu;
import vista.Menu;
import vista.UtilidadesES;

/**
 * 
 * @author Marina y Salvador
 */
public class Aplicacion {
    private Menu menu;
    private OpcionesMenu opcionesMenu;
    private Procesos procesos;
    
    //Propiedades nuevas
    private final Idioma idioma= new Idioma();
    private Properties properties;
    private final String IDIOMADEFAULT="es";
    String estado;
    
    
    /**
     * Construye un objeto del tipo aplicación.
     */
    public Aplicacion() {
        cargarOpcMenu(IDIOMADEFAULT);
        
        File ficheroProceso = new File("proceso.ser");
        if(ficheroProceso.exists()){
            actualizarProceso();
        }else{
            procesos = new Procesos();
        }
        
    }
    /**
     * Ejecuta el menú
     * @author ana
     */
    public void ejecutar() {
        int opc = -1;
        try {
            do {//null
                estado=procesos.getEstado();
                opc = ejecutarMenuyProceso();
            }
            while (estado.equals("Parado") && opc!=5 || estado.equals("Finalizado") && opc!=4|| estado.equals("Lanzado") && opc!=4);
            serializarProceso();
        } catch (IOException e) {
            UtilidadesES.mostrarln(properties.getProperty("ioe"));
        } catch(NullPointerException npe){
            UtilidadesES.mostrarln(properties.getProperty("npeMenu"));
        }
    }
    /**
     * carga las opciones del menu en funcion del idioma actual
     * @author ana 
     */
    private void cargarOpcMenu(String seleccionIdioma){
        
        properties= idioma.cargarPropiedades(seleccionIdioma);
        
        opcionesMenu = new OpcionesMenu();
        opcionesMenu.add(properties.getProperty("registroArtistas"));
        opcionesMenu.add(properties.getProperty("concurso"));
        opcionesMenu.add(properties.getProperty("lanzarConcurso"));
        opcionesMenu.add(properties.getProperty("cambiarIdioma"));
        opcionesMenu.add(properties.getProperty("clasificacionActual"));
        opcionesMenu.add(properties.getProperty("clasificacionFinal"));
        opcionesMenu.add(properties.getProperty("iniciarNuevoConcurso"));
        opcionesMenu.add(properties.getProperty("salir"));
        opcionesMenu.add(properties.getProperty("continuarConcurso"));
    }
    /**
     * Comprueba el idioma establecido antes de mostrar el menu
     * @author ana
     */
    private void getIdiomaSeleccionadoYactualizarMenu(){
        cargarOpcMenu(procesos.getIdiomaActual());
        menu = new Menu(opcionesMenu);
        
    }
    /**
     * 
     * @return devuelve la opción escogida por el usuario.
     * @throws IOException error de entrada y salida.
     */
    private int ejecutarMenuyProceso() throws IOException {
        int opc = -1;
        try {
            getIdiomaSeleccionadoYactualizarMenu();
            menu.presentaMenu(procesos.getEstado());
            opc = menu.leeOpcMenu(properties.getProperty("introducirOpc"));
            procesos.ejecutarOpc(opc);
        } catch(NumberFormatException nfe) {
            UtilidadesES.mostrarln(properties.getProperty("opcIntroducida"));
        }
        return opc;
    } 
    /**
     * 
     * @throws IOException devuelve la excepcion.
     */
    public void serializarProceso() throws IOException{
        Serializar serializador = new SerializarImpl();
        serializador.serializar("proceso.ser", procesos);
    }
    /**
     * 
     */
    public void actualizarProceso(){
        Serializar serializador = new SerializarImpl();
        try {
            procesos = (Procesos)serializador.leer("proceso.ser");
        } catch (IOException ioe) {
            UtilidadesES.mostrarln(properties.getProperty("ioe"));
        } catch (ClassNotFoundException cnfe) {
            UtilidadesES.mostrarln(properties.getProperty("cnfe"));
        }
    }
}
