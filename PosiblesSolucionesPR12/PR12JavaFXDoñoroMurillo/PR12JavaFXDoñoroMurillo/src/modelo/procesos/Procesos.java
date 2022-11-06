/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.procesos;

import java.util.ArrayList;
import modelo.beans.Dado;
import modelo.beans.Zombie;

/**
 *
 * @author Alumno1DAM
 */
public class Procesos {
    private final int NUMDADOS=13;
    private ArrayList<Dado> cubilete;
    private ArrayList<Zombie> zombies;
    private ArrayList<Dado> dadosExtraidos;
    private int puntuacionTirada;
    
    public Procesos(){
        this.cubilete= new ArrayList<>();
    }
    
    private void rellenarCubilete(){
        addDadosRojos();
        addDadosAmarillos();
        addDadosVerdes();
    }

    private void addDadosRojos() {
        for (int i = 0; i < 3; i++) {
            Dado dado= new Dado("rojo");
            dado.getCaras().add("Cerebro");
            dado.getCaras().add("Disparos");
            dado.getCaras().add("Disparos");
            dado.getCaras().add("Disparos");
            dado.getCaras().add("Huellas");
            dado.getCaras().add("Huellas");
            cubilete.add(dado);
        }
    }

    private void addDadosAmarillos() {
        for (int i = 0; i < 4; i++) {
            Dado dado= new Dado("amarillo");
            dado.getCaras().add("Cerebro");
            dado.getCaras().add("Cerebro");
            dado.getCaras().add("Disparos");
            dado.getCaras().add("Disparos");
            dado.getCaras().add("Huellas");
            dado.getCaras().add("Huellas");
            cubilete.add(dado);
        }
    }

    private void addDadosVerdes() {
        for (int i = 0; i < 6; i++) {
            Dado dado= new Dado("verde");
            dado.getCaras().add("Cerebro");
            dado.getCaras().add("Cerebro");
            dado.getCaras().add("Cerebro");
            dado.getCaras().add("Disparos");
            dado.getCaras().add("Huellas");
            dado.getCaras().add("Huellas");
            cubilete.add(dado);
        }
    }

    public void addZombies(String ... nombres) {
        zombies= new ArrayList<>();
        Zombie zombie1 = new Zombie(nombres[0]);
        zombies.add(zombie1);
        Zombie zombie2= new Zombie(nombres[1]);
        zombies.add(zombie2);
    }

    public String realizarJugada(String zombiActual) {
        String cadena="";
        
        if (!comprobarGanador().equals("")) {
            return comprobarGanador();
        }
        cadena="Tiradas de "+ zombiActual+"\n";
        
        rellenarCubilete();
        
        for (Zombie zombi : zombies) {
            if (zombi.getNombre().equals(zombiActual)) {
                extraerDados();
                cadena += lanzarDados()+ "\n";
                zombi.setCerebros(zombi.getCerebros()+puntuacionTirada);
            } 
        }
        return cadena + "\n Puntuacion de "+zombies.get(0).getNombre()+" --"+ zombies.get(0).getCerebros()+"\n Puntuacion de "+zombies.get(1).getNombre()+" --"+ zombies.get(1).getCerebros();
    }

    private void extraerDados() {
        dadosExtraidos= new ArrayList<>();
        int aleatorio;
        for (int i = 0; i < 3; i++) {
            aleatorio= (int) (Math.random()*cubilete.size());
            dadosExtraidos.add(cubilete.get(aleatorio)) ;
        }
    }

    private String lanzarDados() {
        puntuacionTirada=0;
        String cadena="";
        for (Dado dado : dadosExtraidos) {
            int aleatorio= (int)(Math.random()*dado.getCaras().size());
            cadena+= "Dado de color :" +dado.getColor()+ " tirada: " +dado.getCaras().get(aleatorio)+"\n";
            puntuacionTirada+=comprobarCaras(dado.getCaras().get(aleatorio));
        }

        return cadena;
    }

    private int comprobarCaras(String simbolo) {
        int c=0;
        if (simbolo.equals("Cerebro")) {
            c=1;
        }else if (simbolo.equals("Disparos") ) {
            c=-1;
        }
        return c;
    }

    private String comprobarGanador() {
        String cadena="";
        for (Zombie zombi : zombies) {
            if (zombi.getCerebros()==13) {
                return "El ganador es: "+ zombi.getNombre();
            }
        }
        return cadena;
    }
}
