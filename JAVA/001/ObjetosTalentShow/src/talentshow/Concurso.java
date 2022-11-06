package talentshow;

/**
 * Created by eduardo on 09/10/2020.
 */
public class Concurso {
    private Artista artista1;
    private Artista artista2;

    public void ejecutarConcurso() {
        crearArtistas();
        actuarPuntuar();
        mostrarMejorArtista();
    }

    private void mostrarMejorArtista() {
        if(artista1.getPuntuacion()>artista2.getPuntuacion()) {
            //Caso afirmativo
            System.out.println(artista1.getNombre()+":Es el mejor");
        }
        else
        {   //Caso negativo
            if (artista1.getPuntuacion()<artista2.getPuntuacion()) {
                // Caso afirmativo del segundo if
                System.out.println(artista2.getNombre()+":Es el mejor");
            }
            else
            {
                // Caso negativo del segundo if
                System.out.println("Ambos artistas han empatado.");
            }
        }
    }

    private void actuarPuntuar() {
        System.out.println(artista1.actuar());
        System.out.println(artista2.actuar());

        artista1.setPuntuacion(8);
        artista2.setPuntuacion(8);
    }

    private void crearArtistas() {
        artista1 = new Artista("pepe","mi valle","armónica");
        artista2 = new Artista("paco","terror en el supermercado","guitarra eléctrica");
    }


}
