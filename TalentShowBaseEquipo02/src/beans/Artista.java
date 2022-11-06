/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author bth
 */
public abstract class Artista  implements Comparable<Artista> , Serializable{
    private String nombre;
    private int edad;
    private String localidad;
    private int puntuacion;
    
    public Artista(String nombre, int edad, String localidad){
        this.nombre=nombre;
        this.edad=edad;
        this.localidad=localidad;
        this.puntuacion=0;
    }
    public Artista(){
        this.puntuacion=0;
    }
    
    public void saludar(){System.out.println("Hola soy " +getNombre()+" tengo "+ getEdad()+" y vengo de "+ getLocalidad());};
    public abstract void actuar();
    public void despedirse(){System.out.println("Adios");};
    @Override
    public abstract String toString();

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the puntuacion
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * @param puntuacion the puntuacion to set
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    @Override
    public int compareTo(Artista art) {
       
        if (this.puntuacion==art.getPuntuacion()) {
            return 0;
        }else if(this.puntuacion>art.getPuntuacion()){
            return 1;
        }else
            return -1;

    }
}
