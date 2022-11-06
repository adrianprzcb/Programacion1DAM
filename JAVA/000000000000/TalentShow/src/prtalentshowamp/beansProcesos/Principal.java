package prtalentshowamp.beansProcesos;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Principal {
    public static void main(String[] args) {
        Concurso concurso;
        concurso = new Concurso();
        concurso.ejecutar();
   }
}
