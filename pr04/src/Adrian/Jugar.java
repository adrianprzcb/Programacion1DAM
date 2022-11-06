package Adrian;

import Adrian.Objetos.Dado;
import prog.util.es.UtilidadesES;

import java.lang.reflect.Array;
import java.util.ArrayList;



public class Jugar {

    private ArrayList<String> jugadores ;
    private UtilidadesES utilidadesES;
    private Dado dado1;
    private String valor;
    private String valor2;
    private String valor3;
    private String valor4;
    private String valor5;
    private int puntos = 0;

    public Jugar(){
        this.jugadores = new ArrayList<String>();
        this.utilidadesES = utilidadesES;
        dado1=new Dado();



    }

    public void ejecutar(){
        if(jugadores.isEmpty()) {
            System.out.println("No se han añadido jugadores");
        }else{
            partidas();
        }
    }


    public void partidas(){
    for(int e=1; e!=7;e++){
        System.out.println("--------------------");
        System.out.println("Partida "+e);
        System.out.println("--------------------");
        for (int in=0; in<jugadores.size();in++) {
            System.out.println("Turno de "+jugadores.get(in));
            valor = dado1.lanzarDados();
            valor2 = dado1.lanzarDados();
            valor3 = dado1.lanzarDados();
            valor4 = dado1.lanzarDados();
            valor5 = dado1.lanzarDados();
            System.out.println("Valor 1 = "+valor);
            System.out.println("Valor 2 = "+valor2);
            System.out.println("Valor 3 = "+valor3);
            System.out.println("Valor 4 = "+valor4);
            System.out.println("Valor 5 = "+valor5);
            puntuar();
            System.out.println(puntos);

        }}
    }

    public void puntuar(){

        if(valor == valor2 && valor2 == valor3 && valor3 == valor4 && valor5 == valor2){
            puntos=+10;
        }
        else if(valor == valor2 && valor2 == valor3 && valor3 == valor4 ||
                valor == valor5 && valor5 == valor3 && valor3 == valor4 ||
                valor == valor2 && valor2 == valor3 && valor3 == valor5 ||
                valor == valor2 && valor2 == valor5 && valor5 == valor4 ||
                valor5 == valor2 && valor2 == valor3 && valor3 == valor4
                ){
            puntos=+8;
        }

    }















    public void setJugadores(ArrayList<String> jugadores) {
        for(int i =0;i<jugadores.size(); i++){
            this.jugadores.add(jugadores.get(i));
        }
        System.out.println(this.jugadores.size());
    }
}

