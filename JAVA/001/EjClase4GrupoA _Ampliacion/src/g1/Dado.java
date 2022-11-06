package g1;
/**
 * Created by Alumno1 on 18/11/2020.
 */
public class Dado {
    private byte numCaras;

    public Dado() {
        numCaras = 6;
    }

    public Dado(byte numCaras) {
        this.numCaras = numCaras;
    }

    public byte getNumCaras() {
        return numCaras;
    }
}