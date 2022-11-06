package ud3ejclase02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class UD3EjClase04 {

    public static void main(String[] args) {
        

     
        ArrayList<Artista> artistas =new ArrayList<Artista>();
                Random rand = new Random();
        artistas.add(new Poeta(1, "Pepe", 33, "Poema 1"));
        artistas.add(new Poeta(1, "Paco", 20, "Poema 2"));
        artistas.add(new Poeta(1, "Alfonso", 33, "Poema 3"));
        artistas.add(new Cantante (4, "Luis", 44, "Canción 1"));
        artistas.add(new Cantante (4, "Juan", 24, "Canción 2"));
        artistas.add(new Malabarista (4, "Pedro", 41, 6, "Pelotas"));
        
        for(int i=0; i<artistas.size(); i++) {
            System.out.println("-----------");
            System.out.println(artistas.get(i).getNombre());
            artistas.get(i).saludar();
            artistas.get(i).actuar();
            artistas.get(i).despedirse();
            artistas.get(i).setPuntuacion(rand.nextInt(5));
            System.out.println("Puntuación: " + artistas.get(i).getPuntuacion());
        }
                    System.out.println("-----------");
                    System.out.println("Puntuaciones");

        Collections.sort(artistas, Collections.reverseOrder());
        
        for(Artista el:artistas){
            System.out.println(el.getNombre()+ ": " + el.getPuntuacion());
        }
        
        
    }
}
