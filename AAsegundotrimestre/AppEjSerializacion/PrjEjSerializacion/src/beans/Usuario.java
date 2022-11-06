package beans;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable {
	private String login;
	private String clave;
	private String email;
	
	public Usuario(String login, String clave, String email) {
		this.login = login;
		this.clave = clave;
		this.email = email;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	public String toString() {
		return ("Login: "+this.login+" Clave: "+this.clave+" Email: "+ this.email);
	}
}
