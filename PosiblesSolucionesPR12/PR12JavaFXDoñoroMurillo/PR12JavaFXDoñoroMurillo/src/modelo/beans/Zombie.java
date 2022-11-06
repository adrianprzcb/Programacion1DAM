/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author Alumno1DAM
 */
public class Zombie {
    private String nombre;
    private int cerebros;
    
    public Zombie(String nombre){
        this.nombre=nombre;
        this.cerebros=0;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the cerebros
     */
    public int getCerebros() {
        return cerebros;
    }

    /**
     * @param cerebros the cerebros to set
     */
    public void setCerebros(int cerebros) {
        this.cerebros = cerebros;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+getNombre() + " se ha comido "+ getCerebros()+" cerebros";
    }
}
