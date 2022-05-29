package proyecto_java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aaron Serna
 */
public class EmpleadoTest {

    /**
     * Método constructor
     */
    public EmpleadoTest() {
    }

    /**
     * Iniciamos la prueba
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Inicio de la prueba de la clase Empleado");
    }

    /**
     * Finalizamos la prueba
     */
    @AfterClass
    public static void afterClass() {
        System.out.println("Testeo de la clase finalizado");
    }

    /**
     * Hacemos el testeo
     */
    @Test
    public void testSetDNI() {

        Empleado instance = new Empleado("12345678A");
        String result = instance.getDNI();

        //Fijamos el DNI correcto:
        String expResult = "12345678A";
        assertEquals(expResult, result);
        System.out.println("DNI de Jefe: " + expResult);

    }

}
