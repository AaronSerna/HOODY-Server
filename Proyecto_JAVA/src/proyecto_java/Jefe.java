package proyecto_java;

/**
 * *************************************************************
 * Autor: Aarón Serna Nombre: Jefe.java Descripción: clase Jefe, hereda de la
 * clase Empleado y hereda el ID(DNI) necesario para acceder al sistema.
 * ************************************************************
 */

/**
 * Clase Jefe que hereda de Empleado
 * @author Aarón Serna
 */

public class Jefe extends Empleado {

    /**
     * Método constructor que hereda el DNI de la clase padre Empleado.
     * @param DNI
     */
    public Jefe(String DNI) {

        super(DNI);
    }

}
