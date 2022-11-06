package ejca11ga;

import java.io.Serializable;

/**
 * Created by Javi on 13/04/2021.
 */
public class Usuario {

    private String login;
    private String clave;
    private String email;
    private String nombre;
    private String apellidos;

    public Usuario(String login, String clave, String email, String nombre, String apellidos) {
        this.login=login;
        this.clave=clave;
        this.email=email;
        this.nombre=nombre;
        this.apellidos=apellidos;
    }
    public String getLogin() {
        return login;
    }

    public String getClave() {
        return clave;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

}
