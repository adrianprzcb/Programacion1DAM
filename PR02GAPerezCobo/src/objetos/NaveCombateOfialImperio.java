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
public class NaveCombateOfialImperio extends NaveDeCombate {
    private int factorLadoOscuro = 13;
    public NaveCombateOfialImperio(String codigoNave) {
        super(codigoNave);
    }

    @Override
    public int atacar() {
        Random ram = new Random();
        int aleatorioAtaque = ram.nextInt(factorAtaque) +1;
        int aleatorioDefensa = ram.nextInt(factorDefensa) +1;
        int aleatorioLadoOscuro = ram.nextInt(factorLadoOscuro) +1;
        puntosTotalesCombate = aleatorioAtaque + aleatorioDefensa + aleatorioLadoOscuro;
        return puntosTotalesCombate;
    }

    /**
     * @return the factorLadoOscuro
     */
    public int getFactorLadoOscuro() {
        return factorLadoOscuro;
    }
    
}
