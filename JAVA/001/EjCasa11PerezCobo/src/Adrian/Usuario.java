package Adrian;


public class Usuario {

    private String login;
    private String clave;
    private String email;
    private String nombreCompleto;

    public Usuario(String login, String clave, String email, String nombreCompleto) {
        this.login=login;
        this.clave=clave;
        this.email=email;
        this.nombreCompleto=nombreCompleto;

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

    public String getNombreCompleto() {
        return nombreCompleto;
    }


}
