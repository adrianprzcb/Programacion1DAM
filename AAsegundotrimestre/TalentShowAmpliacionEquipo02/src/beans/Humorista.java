/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author ana y adrian
 */
public class Humorista extends Artista{
    private ArrayList<String> arrayChistes;
    
    public Humorista(String localidad, String nombre, int edad, ArrayList<String> array) {
        super(localidad,nombre, edad);
        this.arrayChistes= array;
    }
    
    @Override
    public void actuar() {
        for (String chiste : arrayChistes) {
            System.out.println("Recitando "+chiste);
        }
    }

    /**
     * @return the arrayChistes
     */
    public ArrayList<String> getChistes() {
        return arrayChistes;
    }

    /**
     * @param chistes the arrayChistes to set
     */
    public void setChistes(ArrayList<String> chistes) {
        this.arrayChistes = chistes;
    }
}
