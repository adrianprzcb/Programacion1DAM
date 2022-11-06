package ejJunit;

/**
 * Created by Paqui on 08/03/2021.
 */
public class GeneraEmails {
    private String nombreConc="";
    private String apellido1Conc="";
    private String apellido2Conc="";

    public String generarEmail(String nombre, String apellido1, String apellido2){
        String email;

        procesarDatos(nombre, apellido1, apellido2, 3);
        email=formarEmail(9);
        System.out.println(email);
        return email;
    }

    private void procesarDatos(String nombre, String apellido1, String apellido2, int longitud){
        System.out.println("Antes: "+nombreConc);
        this.nombreConc = procesarCadena(nombre,longitud);
        System.out.println("Después: "+nombreConc);
        this.apellido1Conc = procesarCadena(apellido1,longitud);
        this.apellido2Conc = procesarCadena(apellido2,longitud);
    }

    private String procesarCadena(String nom, int longNom){
        String ArrayNom[];
        String cadenaFinal="";
        if (nom==null) {cadenaFinal="";}

        else

            if (nom.length() > longNom){
                ArrayNom = nom.split("");
                for (int i = 0; i <longNom ; i++) {
                    cadenaFinal=cadenaFinal+ArrayNom[i];
                }
            }
            else
                {cadenaFinal=nom;}
        return cadenaFinal;
    }

    private void procesarApe1(String ape1, int longApe1){
        String ArrayApe1[];

        if (ape1==null) {ape1="";}

        if (ape1.length() > longApe1){
            ArrayApe1 = ape1.split("");
            for (int i = 0; i <longApe1 ; i++) {
                apellido1Conc=apellido1Conc+ArrayApe1[i];
            }
        }
        else {apellido1Conc=ape1;}
    }

    private void procesarApe2(String ape2, int longApe2){
        String ArrayApe2[];

        if (ape2==null) {ape2="";}

        if (ape2.length() > longApe2){
            ArrayApe2 = ape2.split("");
            for (int i = 0; i <longApe2 ; i++) {
                apellido2Conc=apellido2Conc+ArrayApe2[i];
            }
        }
        else {apellido2Conc=ape2;}
    }

    private String formarEmail(int longitudEmail){
        String emailConc;
        int huecos;

        emailConc= nombreConc+apellido1Conc+apellido2Conc;
        huecos=longitudEmail-emailConc.length();
        for (int i = 1; i < (huecos+1) ; i++) {
            emailConc= emailConc+i;
        }
        emailConc=emailConc+"@iespuntadelverde.es";
        return emailConc.toLowerCase();
    }
}
