package dam.prog.beans;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Contenedor de usuarios
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class ListaUsuarios {
	/**
	 * Propiedad que contiene la lista de usuarios
	 */
	private LinkedList<Usuario> listaUsr = null;
	
	/**
	 * Constructor por defecto
	 */
	public ListaUsuarios() {
		setListaUsr(new LinkedList<Usuario>());
	}
	
	/**
	 * Constructor que recibe como parámetro una lista de usuarios
	 */
	public ListaUsuarios(LinkedList<Usuario> listaUsr) {
		this.setListaUsr(listaUsr);
	}
	
	/**
	 * A�ade un usuario a la lista de usuarios
	 * @param usr
	 */
	public void addUsuario(Usuario usr) {
		getListaUsr().add(usr);
	}
	
	/**
	 * Obtiene el usuario que posee un determinado dni
	 * @param dni Valor correspondiente al dni del usuario a devolver
	 * @return Objeto Usuario correspondiente
	 */
	public Usuario getUsuario(String dni) {
		Usuario usr = null;
		Usuario usrTmp = null;
		ListIterator<Usuario> li = getListaUsr().listIterator();
		
		//Si la lista de usuarios no está vacía, devolver el objeto correspondiente
		//al dni proporcionado. En caso contrario devuelve null
		if (getListaUsr().size()>0) {
			while (li.hasNext() && usr==null) {
				usrTmp = li.next();
				if (usrTmp.getDni().equals(dni)) {
					usr = usrTmp;
				}
			}
		}
		return usr;
	}
	/**
	 * Devuelve el tamaño de la lista de usuarios
	 */
	public int size() {
		return getListaUsr().size();
	}
	
	/**
	 * Elimina el objeto Usuario con un dni determinado devolviéndolo
	 * @param dni El dni del usuario a eliminar y devolver
	 * @return El objeto Usuario que se ha eliminado
	 */
	public Usuario remove(String dni) {
		Usuario usr = null;
		Usuario usrTmp = null;
		ListIterator<Usuario> li = getListaUsr().listIterator();
		
		//Si la lista de usuarios no está vacía, devolver el objeto correspondiente
		//al dni proporcionado, eliminándolo de ella. En caso contrario devuelve null
		if (getListaUsr().size()>0) {
			while (li.hasNext() && usr==null) {
				usrTmp = li.next();
				if (usrTmp.getDni().equals(dni)) {
					li.remove();
					usr = usrTmp;
				}
			}
		}
		return usr;
	}
	/**
	 * Obtiene el valor de listaUsr
	 * @return El listaUsr
	 */
	public LinkedList<Usuario> getListaUsr() {
		return listaUsr;
	}

	/**
	 * Establece el valor de listaUsr
	 * @param listaUsr El valor de listaUsr a establecer
	 */
	public void setListaUsr(LinkedList<Usuario> listaUsr) {
		this.listaUsr = listaUsr;
	}
}

