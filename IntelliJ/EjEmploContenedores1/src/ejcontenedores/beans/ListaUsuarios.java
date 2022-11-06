package ejcontenedores.beans;


import java.util.ArrayList;

/**
 * Contenedor de usuarios
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class ListaUsuarios {
    /**
     * Propiedad que contiene la lista de usuarios
     */
    private ArrayList<Usuario> listaUsr = null;

    /**
     * Constructor por defecto
     */
    public ListaUsuarios() {
        setListaUsr(new ArrayList<Usuario>());
    }

    /**
     * Constructor que recibe como parámetro una lista de usuarios
     */
    public ListaUsuarios(ArrayList<Usuario> listaUsr) {
        this.setListaUsr(listaUsr);
    }

    /**
     * Añade un usuario a la lista de usuarios
     * @param usr
     */
    public void addUsuario(Usuario usr) {
        getListaUsr().add(usr);
    }

    /**
     * Obtiene el usuario que ocupa la posición index de la lista de usuarios
     * @param index Valor correspondiente a la posición del objeto Usuario a devolver
     * @return Objeto Usuario correspondiente
     */
    public Usuario getUsuario(int index) {
        Usuario usr = null;
        //Si la lista de usuarios no está vacía, devolver el objeto correspondiente
        //a la posición index, siempre que index sea inferior a size(). En caso contrario
        //devuelve null
        if (getListaUsr().size()>0 && index<getListaUsr().size())
            usr=getListaUsr().get(index);
        return usr;
    }
    /**
     * Devuelve el tamaño de la lista de usuarios
     */
    public int size() {
        return getListaUsr().size();
    }

    /**
     * Elimina el objeto Usuario especificado en index devolvi�ndolo
     * @param index El índice del objeto a eliminar y devolver
     * @return El objeto Usuario que se ha eliminado
     */
    public Usuario remove(int index) {
        Usuario usr = null;
        if (!getListaUsr().isEmpty() && index<getListaUsr().size()) {
            usr = getListaUsr().remove(index);
        }
        return usr;
    }
    /**
     * Obtiene el valor de listaUsr
     * @return El listaUsr
     */
    public ArrayList<Usuario> getListaUsr() {
        return listaUsr;
    }

    /**
     * Establece el valor de listaUsr
     * @param listaUsr El valor de listaUsr a establecer
     */
    public void setListaUsr(ArrayList<Usuario> listaUsr) {
        this.listaUsr = listaUsr;
    }
}

