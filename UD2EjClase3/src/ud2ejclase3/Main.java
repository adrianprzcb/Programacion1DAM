package ud2ejclase3;

public class Main {

    public static void main(String[] args) {
        
        
        Jugador jugador = new Jugador("Pepe", 6);
        Jugador jug2 = new Jugador("Ramón");

        //System.out.println("Numeros de Caras del dado del jugador 1: " + jugador.getDado().getNumCaras());
        //System.out.println("Numeros de Caras del dado del jugador 2:" + jug2.getDado().getNumCaras());
        
        
        
        System.out.println("Resultado del jugador " +jugador.getNombre());
        System.out.println(jugador.tirarDado());
        System.out.println("Resultado del jugador " +jug2.getNombre());
        System.out.println(jug2.tirarDado());
    }
}
