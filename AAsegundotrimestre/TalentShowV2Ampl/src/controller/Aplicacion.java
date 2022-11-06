package controller;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import procesos.Procesos;
import procesos.Serializar;
import procesos.SerializarImpl;
import propertiesmenu.Idioma;
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
    private final Idioma idioma= new Idioma();
    private Properties properties;
    private final String IDIOMADEFAULT="es";
    
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
     */
    public void ejecutar() {
        int opc = -1;
        try {
            do {
                opc = ejecutarMenuyProceso();
            }
            while (opc != Menu.SALIR);
            serializarProceso();
        } catch (IOException e) {
            UtilidadesES.mostrarln(properties.getProperty("ioe"));
            
        }
        finally {
            UtilidadesES.mostrarln(properties.getProperty("fin"));
        }
    }
    /**
     * carga las opciones del menu en funcion del idioma actual
     */
    private void cargarOpcMenu(String seleccionIdioma){
        
        properties= idioma.cargarPropiedades(seleccionIdioma);
        
        opcionesMenu = new OpcionesMenu();
        opcionesMenu.add(properties.getProperty("registroArtistas"));
        opcionesMenu.add(properties.getProperty("concurso"));
        opcionesMenu.add(properties.getProperty("lanzarConcurso"));
        opcionesMenu.add(properties.getProperty("cambiarIdioma"));
        //opcionesMenu.add(properties.getProperty("casificacionActual"));
        opcionesMenu.add(properties.getProperty("clasificacionFinal"));
        opcionesMenu.add(properties.getProperty("iniciarNuevoConcurso"));
        opcionesMenu.add(properties.getProperty("salir"));
    }
    /**
     * Comprueba el idioma establecido antes de mostrar el menu
     */
    private void getIdiomaSeleccionadoYactualizarMenu(){
        //properties= idioma.cargarPropiedades(procesos.getIdiomaActual());
       // System.out.println(procesos.getIdiomaActual());
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
        } catch (IOException ex) {
            UtilidadesES.mostrarln(properties.getProperty("ioe"));
        } catch (ClassNotFoundException ex) {
            UtilidadesES.mostrarln(properties.getProperty("cnfe"));
        }
    }
}
