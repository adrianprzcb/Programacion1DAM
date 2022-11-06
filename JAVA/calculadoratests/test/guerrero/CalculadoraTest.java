package guerrero;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alumno1 on 15/02/2021.
 */
public class CalculadoraTest {

    @Test
    public void testSuma() throws Exception {
        Calculadora calc = new Calculadora(5, 5);
        int resultado = calc.suma();
        assertEquals("La suma no es la esperada", 10, resultado);
    }

    @Test
    public void testMultiplica() throws Exception {
        Calculadora calc = new Calculadora(1, 10);
        int resultado = calc.multiplica();
        assertEquals("La multiplicacion no es la esperada", 10, resultado);
    }

    @Test
    public void testDivide() throws Exception {
       try {
           Calculadora calc = new Calculadora(100, 0);
            int resultado = calc.divide();
            assertEquals("La division no es la esperada", 10, resultado);
      }catch (ArithmeticException ae){

       }
    }

    @Test
    public void testResta1() throws Exception {
        Calculadora calc = new Calculadora(20, 10);
        int resultado = calc.resta();
        if (calc.resta2()) assertEquals("La resta no es la esperada", 10, resultado);
    }

    @Test
    public void testResta12() throws Exception {
        Calculadora calc = new Calculadora(10, 20);
        int resultado = calc.resta();
        if (!calc.resta2()) assertEquals("La resta no es la esperada", 10, resultado);
    }

    @Test
    public void testResta2() throws Exception {
        Calculadora calc = new Calculadora(20, 10);
        assertTrue("No se esperaba que fuera falso", calc.resta2());
    }

    @Test
    public void testResta22() throws Exception {
        Calculadora calc = new Calculadora(10, 20);
        assertFalse("No se esperaba que fuera verdadero", calc.resta2());
    }

    @Test
    public void testDivide2() throws Exception {
        Calculadora calc = new Calculadora(20, 0);
        assertNull("Se esperaba un 0 de segundo numero", calc.divide2());
    }

    @Test
    public void testDivide22() throws Exception {
        Calculadora calc = new Calculadora(20, 5);
        assertNotNull("La division no es la esperada", calc.divide2());
    }
}