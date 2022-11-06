/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import vista.ValidarDatos;
import beans.Artista;
import beans.Cantante;
import beans.Malabarista;
import beans.Musico;
import beans.Poeta;
import java.io.IOException;
import java.util.HashMap;
import vista.UtilidadesES;

/**
 * Implementacion de los metodos de la interfaz RegistroArtistas
 * @author bth
 */
public class RegistroArtistasImpl implements RegistroArtistas{

    UtilidadesES util;
    ValidarDatos validar;
    Artista artista;
    private HashMap<String, Artista> listaArtistas;

    public RegistroArtistasImpl(UtilidadesES util) {
        this.util = util;
        this.listaArtistas = new HashMap<>();
        this.validar= new ValidarDatos(util);
    }

    /**
     * @return the listaArtistas
     */
    @Override
    public HashMap<String, Artista> getListaArtistas() {return listaArtistas;}

    /**
     * @param listaArtistas the listaArtistas to set
     */
    @Override
    public void setListaArtistas(HashMap<String, Artista> listaArtistas) {this.listaArtistas = listaArtistas;}
    /**
     * Selecciona el tipo de artista hasta que la opcion sea valida
     * @author ana
     * @return seleccion Cadena introducida por el usuario
     * @throws NumberFormatException si no se introduce un numero
     */
    @Override
    public String seleccionarArtista() throws NumberFormatException {
        String seleccion = "";
        try {
            seleccion = validar.validarArtista("\nIntroduce el artista a crear (Cantante, Poeta , Musico o Malabarista) :\n").toLowerCase();
            
        } catch (IOException ioe) {
            System.out.println("Error en la toma de datos");
        }
        return seleccion;
    }
    /**
     * Ejecuta la el metodo asociado a la opcion introducida por el usuario 
     * @author ana
     * @param cadena recibe una cadena con el tipo de artista a crear
     * @throws IOException si se produce un error en la toma de datos
     * @return artista Devuelve el artista que se acaba de crear
     */
    @Override
    public Artista crearArtista(String cadena) throws IOException {
        Artista nuevoArtista=null;
        switch (cadena) {
            case "cantante":
                nuevoArtista=validarYcrearCantante();
                break;
            case "malabarista":
                nuevoArtista=validarYcrearMalabarista();
                break;
            case "musico":
                nuevoArtista=validarYcrearMusico();
                break;
            case "poeta":
                nuevoArtista=validarYcrearPoeta();
                break;
            default:
                System.out.println("Introduce un tipo de artista valido");
        }
        System.out.println("\nArtista creado correctamente");
        return nuevoArtista;
    }
    /**
     * Valida los datos al crear un nuevo cantante
     * @author ana
     * @throws IOException si se produce un error en la toma de datos
     */
    @Override
    public Artista validarYcrearCantante() throws IOException{
        artista = new Cantante(validar.validarCadena("Introduce el nombre: "), validar.validarEdad("Introduce la edad: "),
                validar.validarCadena("Introduce la localidad: "), validar.validarCadena("Introduce el titulo de la cancion: "));
        return artista;
    }
    /**
     * Valida los datos al crear un nuevo musico
     * @author ana
     * @throws IOException si se produce un error en la toma de datos
     */
    @Override
    public Artista validarYcrearMusico() throws IOException{
        artista = new Musico(validar.validarCadena("Introduce el nombre: "), validar.validarEdad("Introduce la edad: "),
                validar.validarCadena("Introduce la localidad: "), validar.validarCadena("Introduce el instrumento: "), validar.validarCadena("Introduce la melodia: "));
        return artista;
    }
    /**
     * Valida los datos al crear un nuevo malabarista
     * @author ana
     * @throws IOException si se produce un error en la toma de datos
     */
    @Override
    public Artista validarYcrearMalabarista() throws IOException{
        artista = new Malabarista(validar.validarCadena("Introduce el nombre: "), validar.validarEdad("Introduce la edad: "),
                validar.validarCadena("Introduce la localidad: "), validar.validarNumero("Introduce numero de objetos: "), validar.validarCadena("Introduce el objeto: "));
        return artista;
    }
    /**
     * Valida los datos al crear un nuevo poeta
     * @author ana
     * @throws IOException si se produce un error en la toma de datos
     */
    @Override
    public Artista validarYcrearPoeta() throws IOException{
        artista = new Poeta(validar.validarCadena("Introduce el nombre: "), validar.validarEdad("Introduce la edad: "),
                validar.validarCadena("Introduce la localidad: "), validar.validarCadena("Introduce el titulo del poema: "));
        return artista;
    }
}
