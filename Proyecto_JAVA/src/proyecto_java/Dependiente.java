package proyecto_java;

/**
 * ***************************************************************************************
 * Autor: Aarón Serna Nombre: Dependiente.java Descripción: clase Dependiente,
 * clase que hereda de la clase Empleado y que hereda el ID(DNI) necesario para
 * acceder al sistema.
 * *************************************************************************************
 */
/**
 * Clase Dependiente que hereda de Empleado
 * @author Aarón Serna
 */
public class Dependiente extends Empleado {

    /**
     * Método constructor que hereda el DNI de la clase padre Empleado.     *
     * @param DNI
     */
    public Dependiente(String DNI) {

        super(DNI);
    }

}
