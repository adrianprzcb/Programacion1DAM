package guerrero;

import java.util.ArrayList;

/**
 * Created by Guerrero on 03/02/2021.
 */
public class CreacionDeClaves {

    public void genClaves(){
        ArrayList<String> ListaClaves = new ArrayList<>();
        int digito=0;
        int numClaves=20;
        int numDigitos=3;
        String clave;

        for (int i = 0; i < numClaves; i++) {
            clave="";
            for (int j = 0; j < numDigitos; j++) {

                digito = (int) (Math.random() * 10);
                clave += String.valueOf(digito);

            }
            //String let1= String.valueOf(digi1);
            //String let2= String.valueOf(digi2);
            //String let3= String.valueOf(digi3);
            //clave = let1+let2+let3;

            ListaClaves.add(clave);
        }

        System.out.println(ListaClaves);

    }
}
