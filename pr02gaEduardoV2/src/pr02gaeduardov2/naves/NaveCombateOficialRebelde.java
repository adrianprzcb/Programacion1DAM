/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr02gaeduardov2.naves;

import pr02gaeduardov2.naves.NaveCombate;

/**
 *
 * @author eduardo
 */
public class NaveCombateOficialRebelde extends NaveCombate {

    private final int FACTOR_ASTUCIA;
    
    public NaveCombateOficialRebelde(String codigoNave) {
        super(codigoNave);
        this.FACTOR_ASTUCIA = 20;
    }

    
    @Override
    public int atacar() {
        int valor;
        valor = numAleatorio(this.FACTOR_PUNTOS_ATAQUE)+ numAleatorio(this.FACTOR_PUNTOS_DEFENSA)+numAleatorio(this.FACTOR_ASTUCIA);
        return valor;
    }
    
}
