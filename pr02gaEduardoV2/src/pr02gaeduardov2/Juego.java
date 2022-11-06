/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr02gaeduardov2;

import pr02gaeduardov2.naves.NaveCombate;
import pr02gaeduardov2.naves.NaveCombateOficialImperio;
import pr02gaeduardov2.naves.NaveCombateOficialRebelde;

/**
 *
 * @author eduardo
 */
public class Juego {
    private final int NUMERO_NAVES;
    private NaveCombateOficialImperio[] navesImperio;
    private NaveCombateOficialRebelde[] navesRebelde;
    private NaveCombate[] navesSupervivientes;
    private int contadorNaveSuperviviente = 0;
    
    public Juego() {
        NUMERO_NAVES = 4;
        crearNavesCombate();
    }

    private void crearNavesCombate() {
        inicializarContenedoresNaves();
        crearNavesOficialImperio();
        crearNavesOficialRebelde();
    }
    private void inicializarContenedoresNaves() {
        navesImperio = new NaveCombateOficialImperio[NUMERO_NAVES];
        navesRebelde = new NaveCombateOficialRebelde[NUMERO_NAVES];
        navesSupervivientes = new NaveCombate[NUMERO_NAVES];    
    }
    private void crearNavesOficialImperio() {
        for (int i=0; i<NUMERO_NAVES; i++) { 
            navesImperio[i] = new NaveCombateOficialImperio("IMPERIO"+i);
        }
    }
    
    private void crearNavesOficialRebelde() {
        for (int i=0; i<NUMERO_NAVES; i++) { 
            navesRebelde[i] = new NaveCombateOficialRebelde("REBELDE"+i);
        } 
    }
    public void jugar() {
        combateNaves();
        mostrarNavesSupervivientes();
    }

    private void mostrarNavesSupervivientes() {
        System.out.println("Naves supervivientes: ");
        for (int i=0; i < contadorNaveSuperviviente; i++) {
            System.out.println(navesSupervivientes[i].getCODIGO_NAVE());
        }
    }

    private void combateNaves() {
                
        for (int i=0; i<NUMERO_NAVES; i++) {
            ataqueYResultado(i);
        }
    }
    
    private NaveCombate[] ataqueYResultado(int i) {
        int valorAtaqueRebelde;
        int valorAtaqueImperio;
        
        valorAtaqueRebelde = navesRebelde[i].atacar();
        valorAtaqueImperio = navesImperio[i].atacar();

        if (valorAtaqueRebelde > valorAtaqueImperio) {
            navesSupervivientes[contadorNaveSuperviviente] = navesRebelde[i];
            contadorNaveSuperviviente++;
        }
        else if (valorAtaqueRebelde < valorAtaqueImperio) {
                navesSupervivientes[contadorNaveSuperviviente] = navesImperio[i];
                contadorNaveSuperviviente++;
        }
            
        return navesSupervivientes;
    }


}
