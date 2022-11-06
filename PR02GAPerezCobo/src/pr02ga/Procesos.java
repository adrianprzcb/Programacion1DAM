
package pr02ga;

import objetos.NaveCombateOfialImperio;
import objetos.NaveCombateOficialRebelde;


public class Procesos {

       NaveCombateOficialRebelde[] rebeldes = new NaveCombateOficialRebelde[4];
        NaveCombateOfialImperio[] imperios = new NaveCombateOfialImperio[4];
        String[] ganadores = new String[4];
        private int combates = 4;
       
       
    public void ejecutar(){
        combates();
        ganadores();
    }
    
    public void combates(){
        rebeldes[0] = new NaveCombateOficialRebelde("RE534043");
        rebeldes[1] = new NaveCombateOficialRebelde("RE46OEOR");
        rebeldes[2] = new NaveCombateOficialRebelde("RE4330GK");
        rebeldes[3] = new NaveCombateOficialRebelde("RE34OE5T");
        imperios[0] = new NaveCombateOfialImperio("IM8745YT");
       imperios[1] = new NaveCombateOfialImperio("IM654665");
       imperios[2] = new NaveCombateOfialImperio("IM656Y54");
       imperios[3] = new NaveCombateOfialImperio("IM542PRP");
        for (int i = 0; i <combates; i++) {
            System.out.println("Combate " + (i+1));
             System.out.println("Nave Rebelde " + rebeldes[i].getCodigoNave() + " atacando...");
            rebeldes[i].atacar();
           System.out.println(rebeldes[i].getPuntosTotalesCombate() + " es la puntuación.");
            System.out.println("Nave de Imperio " + imperios[i].getCodigoNave() + " atacando...");
           imperios[i].atacar();
           System.out.println(imperios[i].getPuntosTotalesCombate() + " es la puntuación.");

           if(rebeldes[i].getPuntosTotalesCombate() > imperios[i].getPuntosTotalesCombate()){
               ganadores[i] = rebeldes[i].getCodigoNave();
           }else if(rebeldes[i].getPuntosTotalesCombate() < imperios[i].getPuntosTotalesCombate())
            ganadores[i] = imperios[i].getCodigoNave();
        }
    }
    
    public void ganadores(){
        System.out.println("GANADORES:");
        for (int i = 0; i < ganadores.length; i++) {
            if(ganadores[i] != null){
                System.out.println(ganadores[i]);
            }
        }
    }
}
