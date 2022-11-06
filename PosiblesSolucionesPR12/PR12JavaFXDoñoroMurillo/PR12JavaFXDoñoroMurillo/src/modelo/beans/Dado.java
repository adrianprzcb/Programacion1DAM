/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.util.ArrayList;

/**
 *
 * @author Alumno1DAM
 */
public class Dado {
    private ArrayList<String> caras;
    private String color;
    
    public Dado(String color){
        this.color=color;
        this.caras=new ArrayList<>();
    }

    /**
     * @return the caras
     */
    public ArrayList<String> getCaras() {
        return caras;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }
    
}
