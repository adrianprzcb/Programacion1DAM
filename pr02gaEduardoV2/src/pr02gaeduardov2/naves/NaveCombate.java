/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr02gaeduardov2.naves;

/**
 *
 * @author eduardo
 */
abstract public class NaveCombate {
    
    private final String CODIGO_NAVE;

    public String getCODIGO_NAVE() {
        return CODIGO_NAVE;
    }
    protected final int FACTOR_PUNTOS_ATAQUE;
    protected final int FACTOR_PUNTOS_DEFENSA;
    
    public NaveCombate(String codigoNave) {
        this.CODIGO_NAVE = codigoNave;
        this.FACTOR_PUNTOS_ATAQUE = 10;
        this.FACTOR_PUNTOS_DEFENSA = 15;
    }
    abstract public int atacar();
    
    protected int numAleatorio(int limiteMax) {
        return (int) ((Math.random()* limiteMax)+1);
    } 
}
