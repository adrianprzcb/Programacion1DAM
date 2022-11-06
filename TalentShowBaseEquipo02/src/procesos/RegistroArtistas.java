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
import java.io.IOException;
import java.util.HashMap;
import vista.UtilidadesES;

/**
 *
 * @author bth
 */
public class RegistroArtistas {

    UtilidadesES util;
    private HashMap<String, Artista> listaArtistas;

    public RegistroArtistas(UtilidadesES util) {
        this.util = util;
        this.listaArtistas = new HashMap<>();
    }

    /**
     * @return the listaArtistas
     */
    public HashMap<String, Artista> getListaArtistas() {
        return listaArtistas;
    }

    /**
     * @param listaArtistas the listaArtistas to set
     */
    public void setListaArtistas(HashMap<String, Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    public String seleccionarArtista() throws NumberFormatException {
        String seleccion = "";// comprobar datos dsp
        try {
            seleccion = util.pideCadena("\nIntroduce el artista a crear (Cantante, Poeta , Musico o Malabarista) :\n").toLowerCase();
            if ("cantante".equals(seleccion) && "poeta".equals(seleccion) && "musico".equals(seleccion) && "malabarista".equals(seleccion)) {
                return seleccion;
            }
        } catch (IOException ioe) {
            System.out.println("Error en la toma de datos");
        }
        return seleccion;
    }

    public void crearArtista(String cadena) throws IOException {
        Artista artista;

        switch (cadena) {
            case "cantante":
                artista = new Cantante(util.pideCadena("Introduce el nombre: "), Integer.parseInt(util.pideCadena("Introduce la edad: ")), util.pideCadena("Introduce la localidad: "), util.pideCadena("Introduce el titulo de la cancion: "));
                validarDatosYadd(artista);
                break;
            case "malabarista":
                artista = new Malabarista(util.pideCadena("Introduce el nombre: "), Integer.parseInt(util.pideCadena("Introduce la edad: ")), util.pideCadena("Introduce la localidad: "), Integer.parseInt(util.pideCadena("Introduce numero de objetos: ")), util.pideCadena("Introduce el objeto: "));
                listaArtistas.put(artista.getNombre(), artista);
                break;
            case "musico":
                artista = new Musico(util.pideCadena("Introduce el nombre: "), Integer.parseInt(util.pideCadena("Introduce la edad: ")), util.pideCadena("Introduce la localidad: "), util.pideCadena("Introduce el instrumento: "));
                validarDatosYadd(artista);
                break;
            case "poeta":
                artista = new Poeta(util.pideCadena("Introduce el nombre: "), Integer.parseInt(util.pideCadena("Introduce la edad: ")), util.pideCadena("Introduce la localidad: "), util.pideCadena("Introduce el titulo del poema: "));
                validarDatosYadd(artista);
                break;
            default:
                System.out.println("Introduce un tipo de artista valido");
        }
    }

    private Artista validarDatosYadd(Artista artista) {

        if ("".equals(artista.getLocalidad()) || "".equals(artista.getNombre()) || artista.getEdad() < 18) {
            System.out.println("Los datos introducidos no son validos");
        } else {
            listaArtistas.put(artista.getNombre(), artista);
        }

        return artista;
    }
}
