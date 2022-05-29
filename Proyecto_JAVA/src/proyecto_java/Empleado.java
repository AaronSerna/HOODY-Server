
package proyecto_java;

/*****************************************************************************************
 * Autor: Aarón Serna
 * Nombre: Empleado.java
 * Descripción: clase Empleado, clase padre de las clases Dependiente,Jefe y Cocinero 
 * y que almacena el ID(DNI) necesario para acceder al sistema.
 * **************************************************************************************/

/**
 * Clase padre Empleado, de la cual descienden tres subclases, Cocinero, Jefe y Dependiente.
 * En esta clase se programan los métodos constructores necesarios para acceder al Sistema y ser heredados.
 * @author Aarón Serna
 */

public class Empleado {

    private String DNI;
    
    /**
     * Método constructor
     */
    public Empleado() {}

    /**
     * Indicamos que el DNI del constructor es el mismo que el del atributo.
     * @param DNI
     */
    public Empleado(String DNI) {

        this.DNI = DNI;
    }

    public String toString() {
        return "Dni: " + this.DNI;
    }

    /**
     * Indicamos que el dni es el DNI del método anterior
     * @param dni
     */
    public void setDNI(String dni) {
        this.DNI = dni;
    }

    /**
     * Devolvemos DNI
     * @return 
     */
    public String getDNI() {
        return this.DNI;
    }

}
