package dam.prog.modelo.procesos;

import dam.prog.modelo.beans.Artista;
import dam.prog.modelo.beans.Cantante;
import dam.prog.modelo.beans.Musico;
import dam.prog.modelo.beans.Poeta;
import dam.prog.vista.UtilidadesES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ext3A {

    private UtilidadesES utilES;
    private ArrayList<Artista> listaConcursantes;
    private ArrayList<Artista> listaActuaciones;

    public Ext3A() {
        this.listaActuaciones = new ArrayList<Artista>();
        this.listaConcursantes = new ArrayList<Artista>();
        this.utilES = new UtilidadesES();
    }

    public ArrayList<Artista> concursar(ArrayList<Artista> listaConsursantes, ArrayList<Artista> listaActuaciones) {
        if (parametrosCorrectos(listaConsursantes,listaActuaciones))
            for (Artista artista: listaActuaciones) {
                if(listaConsursantes.contains(artista)) {
                    actuar(artista);
                    puntuar(artista);
                } else
                    utilES.mostrarln("El artista "+artista.getNombre()+" no se ha encontrado.");
            }
        else
            utilES.mostrarln("Alguno de los parámetros proporcionado o es nulo o no tiene aristas.");
        return listaActuaciones;
    }

    private void actuar(Artista artista) {
        utilES.mostrarln(artista.saludar());
        utilES.mostrarln(artista.actuar());
        utilES.mostrarln(artista.despedirse());
    }

    private void puntuar(Artista artista) {
        int puntuacion;
        boolean error = true;
        do {
            try {
                puntuacion = Integer.parseInt(utilES.pideCadena("Introduzca puntuación para " + artista.getNombre() + ": "));
                artista.setPuntuacion(puntuacion);
                error = false;
            } catch (IOException e) {
                utilES.mostrarln("Error de entrada de datos. Se vuelve a intentar.");
            } catch (NumberFormatException nfe) {
                utilES.mostrarln("Error de entrada de datos. Se introdujo un dato que no se corresponde con un número. Se vuelve a intentar.");
            }
        } while(error);
    }

    private boolean parametrosCorrectos(ArrayList<Artista> listaConsursantes, ArrayList<Artista> listaActuaciones) {
        if (listaActuaciones != null && listaConsursantes!=null && listaActuaciones.size()>0 && listaConsursantes.size()>0)
            return true;
        else
            return false;
    }

    public void ejecutar() {
        crearContenedores();
        probarMetodo();
    }

    private void probarMetodo() {
        concursar(listaConcursantes, listaActuaciones);
        ordenarPuntuaciones();
    }

    public void ordenarPuntuaciones(){
        Collections.sort(listaActuaciones, new Comparator<Artista>() {
            @Override
            public int compare(Artista a1, Artista a2) {
                return new Integer(a2.getPuntuacion()).compareTo(new Integer(a1.getPuntuacion()));//ordena de mayor a menor, para hacerlo al reves cambiamos el a2 por el a1.
            }
        });
        for(int i=0;i<listaActuaciones.size(); i++){
            System.out.println(listaActuaciones.get(i).getNombre()+ ": " + listaActuaciones.get(i).getPuntuacion()+ " Puntos.");
        }
    }


    private void crearContenedores() {
        this.listaConcursantes.add(new Poeta("Pepe","El fin de los días"));
        this.listaConcursantes.add(new Poeta("Francisco","El inicio de los días"));
        this.listaConcursantes.add(new Poeta("José","El fin de los veranos"));
        this.listaConcursantes.add(new Cantante("Paco","Si lo se no vengo"));
        this.listaConcursantes.add(new Cantante("Alberto","Si lo se voy"));
        this.listaConcursantes.add(new Cantante("Marta","Otro verano menos"));
        this.listaConcursantes.add(new Cantante("Luisa","Otro invierno más"));
        this.listaConcursantes.add(new Musico("Diana","El verano","tambor"));
        this.listaConcursantes.add(new Musico("Sara","Ojú que caló","trompeta"));
        this.listaConcursantes.add(new Musico("María","Adios mundo!","clarinete"));

        this.listaActuaciones.add(new Cantante("Paco","Si lo se no vengo"));
        this.listaActuaciones.add(new Musico("María","Adios mundo!","clarinete"));
        this.listaActuaciones.add(new Poeta("Pepe","El fin de los días"));
        this.listaActuaciones.add(new Poeta("José","El fin de los veranos"));
        this.listaActuaciones.add(new Cantante("Marta","Otro verano menos"));
    }
}
