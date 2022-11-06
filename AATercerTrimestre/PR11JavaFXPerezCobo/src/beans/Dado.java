

package beans;


public class Dado {
    private int numCaras;
    private int valorUltTirada;
    
    public Dado() {
        numCaras = 6;
        valorUltTirada = 1;
    }

   /* public Dado(int numCaras){
        this.numCaras = numCaras;
        valorUltTirada = 1;
    }*/
    
    /**
     * @return the numCaras
     */
    public int getNumCaras() {
        return numCaras;
    }

    

    /**
     * @return the valorUltTirada
     */
    public int getValorUltTirada() {
        return valorUltTirada;
    }

    /**
     * @param valorUltTirada the valorUltTirada to set
     */
    public void setValorUltTirada(int valorUltTirada) {
        this.valorUltTirada = valorUltTirada;
    }
}