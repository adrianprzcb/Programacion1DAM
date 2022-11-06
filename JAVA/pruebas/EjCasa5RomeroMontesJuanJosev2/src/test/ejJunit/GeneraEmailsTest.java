package ejJunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Paqui on 08/03/2021.
 */
@RunWith(Parameterized.class)
public class GeneraEmailsTest {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String resultado;

    public GeneraEmailsTest(String nombre, String apellido1, String apellido2, String resultado) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.resultado = resultado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> emails(){
        return Arrays.asList(new Object[][] {{"Juan","Lopez","Perez","jualopper@iespuntadelverde.es"},{"Jon","Ho",null,"jonho1234@iespuntadelverde.es"},{"A","b","C","abc123456@iespuntadelverde.es"} } );
    }
    @Test
    public void testEmails(){
        GeneraEmails generaEmails = new GeneraEmails();
        String result=generaEmails.generarEmail(nombre,apellido1,apellido2);
        assertEquals(result,resultado);
    }
}
