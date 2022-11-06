/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Alumno1DAM
 */
public class Usuario implements Serializable{
    private String login;
    private String clave;
    private String email;
    private String nombreApellidos;
    
    public Usuario(String login, String clave, String email, String nombreApellidos){
        this.login=login;
        this.clave=clave;
        this.email=email;
        this.nombreApellidos=nombreApellidos;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nombreApellidos
     */
    public String getNombreApellidos() {
        return nombreApellidos;
    }

    /**
     * @param nombreApellidos the nombreApellidos to set
     */
    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }
    
    @Override
    public String toString(){
        return "Login: "+getLogin()+"\nClave: "+getClave()+ "\nEmail: "+ getEmail()+"\nNombre: "+getNombreApellidos();
    }
}
