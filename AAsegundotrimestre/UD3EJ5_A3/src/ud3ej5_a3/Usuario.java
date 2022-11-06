
package ud3ej5_a3;

import java.io.Serializable;


public class Usuario implements Serializable{
    private String login;
    private String password;
    private String email;
    private String nombreCompleto;

    public Usuario(String login, String password, String email,String nombreCompleto){
        this.login = login;
        this.password = password;
        this.email= email;
        this.nombreCompleto = nombreCompleto;
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
	public String toString() {
	return (this.login+":"+this.password+":"+ this.email+":"+ this.nombreCompleto);
	}

    
    
}
