/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author bth
 */
public class Malabarista extends Artista{
    private int numObjetos;
    private String objetos;
    
    public Malabarista(String nombre, int edad, String localidad, int numObjetos, String objetos) {
        super(nombre, edad, localidad);
        this.numObjetos= numObjetos;
        this.objetos=objetos;
    }

    @Override
    public void actuar() {
         System.out.println("El artista "+getNombre()+" esta actuando con "+ getNumObjetos()+" " +getObjetos());
    }
    
    @Override
    public String toString() {
        return "Nombre: "+ getNombre() +"\nLocalidad: " +getLocalidad()+"\nEdad: " +getEdad()+ "\nPuntuacion: " +getPuntuacion();
    }
    /**
     * @return the numObjetos
     */
    public int getNumObjetos() {
        return numObjetos;
    }

    /**
     * @param numObjetos the numObjetos to set
     */
    public void setNumObjetos(int numObjetos) {
        this.numObjetos = numObjetos;
    }

    /**
     * @return the objetos
     */
    public String getObjetos() {
        return objetos;
    }

    /**
     * @param objetos the objetos to set
     */
    public void setObjetos(String objetos) {
        this.objetos = objetos;
    }
    
    
}
