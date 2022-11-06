

package beans;


public class Jugador {
    private Dado[] dados;

    private String nombre;
    private int puntos;
    private int totalRonda;
    
    public Jugador(String nombre, int numDados){
        this.nombre = nombre;
        this.dados = new Dado[numDados];
        for(int i=0;i<dados.length;i++) {
            dados[i] = new Dado();
        }
    }
    
      
public void setTotalRonda(int totalRonda){
            this.totalRonda = totalRonda + this.totalRonda;

}

public int getTotalRonda(){
    return totalRonda;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos ;
    }
    
    public Dado[] tirarDados(){

        for (int i=0; i<dados.length;i++) {
            dados[i].setValorUltTirada(numAleatorio(dados[i].getNumCaras()));
        }
        return dados;
    }
    
    private int numAleatorio(int limSup) {
        return (int) (Math.random() * limSup + 1);
    }

    public Dado[] getDados() {
        return dados;
    }
}
