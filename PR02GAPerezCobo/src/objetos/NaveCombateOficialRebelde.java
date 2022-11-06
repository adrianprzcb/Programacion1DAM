/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.Random;

/**
 *
 * @author alumno
 */
public class NaveCombateOficialRebelde extends NaveDeCombate {

        private int factorAstucia = 20;
    public NaveCombateOficialRebelde(String codigoNave) {
        super(codigoNave);
            }

    @Override
    public int atacar() {
       Random ram = new Random();
        int aleatorioAtaque = ram.nextInt(factorAtaque) +1;
        int aleatorioDefensa = ram.nextInt(factorDefensa) +1;
        int aleatorioAstucia = ram.nextInt(factorAstucia) +1;
        puntosTotalesCombate = aleatorioAtaque + aleatorioDefensa + aleatorioAstucia;
        return puntosTotalesCombate;
    }

    /**
     * @return the factorAstucia
     */
    public int getFactorAstucia() {
        return factorAstucia;
    }
    
}
