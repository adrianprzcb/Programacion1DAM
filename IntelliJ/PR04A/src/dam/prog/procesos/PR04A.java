package dam.prog.procesos;

import dam.prog.beans.Jugador;
import dam.prog.vista.UtilidadesES;
import dam.prog.vista.menu.Menu;
import dam.prog.vista.menu.OpcionesMenu;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Administrador on 31/05/2021.
 */
public class PR04A {

    private static final int SALIR = 4;
    private static final int NUM_DADOS = 5;
    private static final String ARCHIVO_DATOS = "datos.txt";
    private final UtilidadesES utilidadesES;
    private final Menu menu;
    private final ArrayList<Jugador> jugadores;
    private int totalPartidas;
    private Jugar jugar;


    public PR04A() {
        this.totalPartidas = 6;
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        OpcionesMenu opcionesMenu = new OpcionesMenu();
        opcionesMenu.add("Leer datos de jugadores");
        opcionesMenu.add("Guardar resultados");
        opcionesMenu.add("Jugar");
        menu = new Menu(opcionesMenu,utilidadesES);
        this.jugadores = new ArrayList<>();
        jugar = new Jugar(this.totalPartidas,this.jugadores);
    }

    public void ejecutar() {
        int opc = -1;
        do {
            try {
                menu.presentaMenu();
                opc = menu.leeOpcMenu("Introduzca una opción: ");
                procesarOpcion(opc);
            } catch (IOException e) {
                utilidadesES.mostrarln("Se ha producido un error de entrada - salida de datos. ");
            }
        } while (opc != SALIR);
    }

    /**
     * Procesa las opciones del menú
     * @param opc Opción escogida por el usuario
     * @throws IOException
     */
    private void procesarOpcion(int opc) throws IOException {
        switch (opc) {
            case 1:
                leerDatosJugadores();
                break;
            case 2:
                guardarResultados();
                break;
            case 3:
                jugar();
                break;
            case 4:
                salir();
                break;
            default:
                ejecutarNada();
        }
    }

    private void guardarResultados()  {

            String ruta = "resultados.txt";
            File file = new File(ruta);
             String encoding = "UTF-8";
             PrintWriter writer = null;
            try{
                writer = new PrintWriter(file, encoding);
                for (Jugador jugador: jugadores) {
                    writer.println(jugador.getNombre() + ": Puntuación = "+jugador.getPuntosTotales()+".");
                }

            }
            catch (Exception e){
                System.out.println("Error.");
            }finally {
               if (writer != null){
                   writer.close();
               }
            }
    }



    private void leerDatosJugadores() throws IOException, FileNotFoundException {
        String nombre;
        BufferedReader br = null;
        File fichero = new File(ARCHIVO_DATOS);;

        try {
            br = new BufferedReader(new FileReader(fichero));

            while ((nombre = br.readLine()) != null) {
                jugadores.add(new Jugador(nombre, NUM_DADOS));
            }
        } finally {
            br.close();
        }

    }

    private void jugar() {
        this.jugar.jugar();
    }

    /**
     * Si no se selecciona una opción válida
     */
    private void ejecutarNada() {
        utilidadesES.mostrarln("Opción no válida.");
    }

    /**
     * Salir
     */
    private void salir() {
        utilidadesES.mostrar("Fin de la aplicación");
    }
}
