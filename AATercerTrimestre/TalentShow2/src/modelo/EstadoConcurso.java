    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author delta
 */
public class EstadoConcurso implements Serializable{
    private boolean lanzado;
    private boolean finalizado;
    
    /**
     *
     */
    public EstadoConcurso() {
        this.lanzado = false;
        this.finalizado = false;
    }

    /**
     *
     * @return
     */
 

    /**
     *
     * @return
     */
    public boolean getFinalizado() {
        return finalizado;
    }

    /**
     *
     * @param finalizado
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    /**
     *
     * @return
     */
    public boolean getLanzado() {
        return lanzado;
    }

    /**
     *
     * @param lanzado
     */
    public void setLanzado(boolean lanzado) {
        this.lanzado = lanzado;
    }
    
   
    
}
