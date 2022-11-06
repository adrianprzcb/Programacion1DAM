package controlador;

import vista.JuegoDados;

public class Main {

    public static void main(String[] args) {
        try{
            JuegoDados juegoDados = new JuegoDados();
            juegoDados.ejecutar();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
