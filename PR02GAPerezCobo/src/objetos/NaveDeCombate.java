/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author alumno
 */
public abstract class NaveDeCombate {


    private final String codigoNave;
     int factorAtaque = 10;
     int factorDefensa = 15;
    int puntosTotalesCombate;
    
    public NaveDeCombate(String codigoNave){
        this.codigoNave = codigoNave;
    }
    
    
    abstract public int atacar() ;

    /**
     * @return the codigoNave
     */
    public String getCodigoNave() {
        return codigoNave;
    }

    /**
     * @return the factorAtaque
     */
    public int getFactorAtaque() {
        return factorAtaque;
    }

    /**
     * @return the factorDefensa
     */
    public int getFactorDefensa() {
        return factorDefensa;
    }
    
        /**
     * @return the puntosTotalesCombate
     */
    public int getPuntosTotalesCombate() {
        return puntosTotalesCombate;
    }

 
}
