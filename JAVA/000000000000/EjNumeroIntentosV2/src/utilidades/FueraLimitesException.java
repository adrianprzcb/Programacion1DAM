package utilidades;

/**
 * Created by alumno on 28/01/2021.
 */
public class FueraLimitesException extends Exception {
    public FueraLimitesException(String mensajeError){
        super(mensajeError);
    }
}
