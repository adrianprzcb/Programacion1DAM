package prtalentshowamp;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import packagemenu.OpcionesMenu;
import packagemenu.Menu;
import packageutilidadeses.UtilidadesES;


public class Concurso {
    UtilidadesES ues = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)),System.out);
    OpcionesMenu opcmenu = new OpcionesMenu();
    Menu menu = new Menu(opcmenu);
    OpcionesMenu opcsubmenu = new OpcionesMenu();
    Menu submenu = new Menu(opcsubmenu);
    ListaArtistasMap listamap = new ListaArtistasMap();
    Jurado jurado = new Jurado();
    Archivo archivo = new Archivo(listamap);
    private boolean bucle=true;
    
    public void ejecutar(){
        agregarOpcionesmenu();
        agregarOpcionesSubMenu();
        do {
        menu.presentaMenu();
        menu.elegirOpc();
        talentshow();
        } while (bucle);
    }
    /** Metodo que ejecuta el menu **/
    private void talentshow(){
        System.out.println("Esta aplicación muestra un ejemplo de uso del patrón Singleton.");
        switch (menu.getOpc()){
        case "1":
            agregarArtista();
            break;
        case "2":
            ListaArtistasMap.getListaArtistasMap().listarArtistas();
            break;
        case "3":
            ListaArtistasMap.getListaArtistasMap().actuacionArtistas();
            break;
        case "4":
            ListaArtistasMap.getListaArtistasMap().mostrarNotas();
            break;
        case "5":
            archivo.crearArchivo();
            break;
        case "6":
            archivo.recuperarArchivo();
            break;
        case "7":
            bucle = false;
            break;
        default:
            ues.mostrarln("No ha introducido ninguna opcion valida"+"\n");
        }
    }
    /** Metodo que agrega todas las opciones de menu **/
    private void agregarOpcionesmenu(){
        opcmenu.add("Agregar un artista");
        opcmenu.add("Mostrar lista de artista");
        opcmenu.add("Actuacion de todos los artistas");
        opcmenu.add("Clasificacion general");
        opcmenu.add("Crear archivo con los 3 mejores");
        opcmenu.add("Mostrar tres mejores");
        opcmenu.add("Salir");
    }
    /** Metodo que crea al artista, crea sus datos y los añade en el map **/
    private void agregarArtista(){
         /**Artista artista = new Artista();
         artista.creacionArtista();
         listamap.putArtista(artista.getIdArtista(), artista);
        **/
        submenu.presentaMenu();
        submenu.elegirOpc();
        subMenu();
    }
    /** Metodo que agrega opcions al submenu de Creacion de Artistas**/
    private void agregarOpcionesSubMenu(){
        opcsubmenu.add("Crear poeta");
        opcsubmenu.add("Crear malabarista");
        opcsubmenu.add("Crear cantante");
        opcsubmenu.add("Salir");
    }
    /**Metodo que ejecuta el submenu de Creacion Artista, dependiendo de la opcion elegida **/
    private void subMenu(){
        switch (submenu.getOpc()){
        case "1":
            creacionPoeta();
            break;
        case "2":
            creacionMalabarista();
            break;
        case "3":
            creacionCantante();
            break;
        case "4":
            ues.mostrarln("Saliendo al menu principal");
            break;
        default:
            ues.mostrarln("No ha introducido una opcion valida");
            break;
        }
    }
    /**Metodo que crea al Poeta y lo mete en un map **/
    private void creacionPoeta(){
        Poeta poeta = new Poeta();
        poeta.creacionArtista();
        listamap.putArtista(poeta.getIdArtista(),poeta);
    }
    /**Metodo que crea al Malabarista y lo mete en un map **/
    private void creacionMalabarista(){
        Malabarista malabarista = new Malabarista();
        malabarista.creacionArtista();
        listamap.putArtista(malabarista.getIdArtista(),malabarista);
    }
    /**Metodo que crea al Cantante y lo mete en un map **/
    private void creacionCantante(){
        Cantante cantante = new Cantante();
        cantante.creacionArtista();
        listamap.putArtista(cantante.getIdArtista(),cantante);
    }
}
