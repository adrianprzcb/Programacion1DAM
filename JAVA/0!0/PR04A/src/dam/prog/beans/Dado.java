package dam.prog.beans;

public class Dado {

    private int numCaras;

    private CarasDadoPoker valorUltimaTirada;

    public Dado() {
        this.numCaras = CarasDadoPoker.values().length;
        this.valorUltimaTirada = CarasDadoPoker.NEGRO;
    }
    public int getNumCaras() {
        return numCaras;
    }

    public CarasDadoPoker getValorUltimaTirada() {
        return valorUltimaTirada;
    }

    public void setValorUltimaTirada(CarasDadoPoker valorUltimaTirada) {
        this.valorUltimaTirada = valorUltimaTirada;
    }
}
