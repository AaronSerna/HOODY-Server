package proyecto_java;
/**************************************************************************************
 * Autor: Aarón Serna
 * Nombre: Cocinero.java
 * Descripción: clase Cocinero, clase que hereda de la clase Empleado 
 * y que hereda el ID(DNI) necesario para acceder al sistema.
 * ************************************************************************************/

/**
 * Clase Cocinero que hereda de Empleado
 * @author Aarón Serna
 */
public class Cocinero extends Empleado  {
	
    /**
     * Método constructor que hereda el DNI de la clase padre Empleado.
     * @param DNI
     */
    public Cocinero (String DNI) {
		
		super(DNI);
        }
        
       
}