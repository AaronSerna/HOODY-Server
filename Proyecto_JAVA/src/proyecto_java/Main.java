package proyecto_java;

/**
 * *************************************************************
 * Autor: Aarón Serna
 * Nombre: Main.java
 * Descripción: clase Main del proyecto HOODY Server de 1ºDAW.
 * ************************************************************
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Main: Clase donde se almacenan los ID de los empleados,
 * se ejecuta la interfaz del programa para el inicio de sesión y la llamada de los menus pertinentes.
 * @author Aarón Serna
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        Menus menu = new Menus();

        Jefe jefe1 = new Jefe("98765432B");
        Dependiente dependiente1 = new Dependiente("12345678A");
        Cocinero cocinero1 = new Cocinero("03155839D");

        ArrayList<Jefe> jefes_array = new ArrayList<Jefe>();
        ArrayList<Dependiente> dependientes_array = new ArrayList<Dependiente>();
        ArrayList<Cocinero> cocineros_array = new ArrayList<Cocinero>();

        jefes_array.add(jefe1);
        dependientes_array.add(dependiente1);
        cocineros_array.add(cocinero1);

        int n;
        String jefeID, dependienteID, cocineroID;
        boolean isJefe = false, isDependiente = false, isCocinero = false;

        System.out.println("Bienvenido a HOODY Server");

        do {
            System.out.println("Por favor identifiquese");
            System.out.println("1. Jefe \n2.Dependiente \n3.Cocinero");
            n = tec.nextInt();
            tec.nextLine();

            switch (n) {
                case 1:
                    System.out.println("Introduzca su ID de jefe:");
                    jefeID = tec.nextLine();

                    for (Jefe jef : jefes_array) {//Jefe-> objeto,  jef-> la variable que almacena al jefe en cada iteracion/vuelta,  jefes_array-> el array a recorrer.
                        if (jef.getDNI().equals(jefeID)) {
                            isJefe = true;
                            menu.menu1();
                        }/* No se usa else aquí, ya que si no encuentra lo que buscamos en la primera iteración, se saldrá del bucle, y lo que queremos es que si no encuentra
                        lo que busca en una iteración, vaya a la otra y etc.*/
                    }

                    if (isJefe == false) {
                        System.out.println("Acceso incorrecto, intente de nuevo.");
                        n = -1;
                    }
                    break;
                case 2:
                    System.out.println("Introduzca su ID de dependiente: ");
                    dependienteID = tec.nextLine();

                    for (Dependiente dep : dependientes_array) {
                        if (dep.getDNI().equals(dependienteID)) {
                            isDependiente = true;
                            menu.menu2();
                        }
                    }

                    if (isDependiente == false) {
                        System.out.println("Acceso incorrecto, intente de nuevo.");
                        n = -1;
                    }
                    break;
                case 3:
                    System.out.println("Introduzca su ID de cocinero");
                    cocineroID = tec.nextLine();

                    for (Cocinero coc : cocineros_array) {
                        if (coc.getDNI().equals(cocineroID)) {
                            isCocinero = true;
                            menu.menu3();
                        }
                    }

                    if (isCocinero == false) {
                        System.out.println("Acceso incorrecto, intente de nuevo.");
                        n = -1;
                    }
                    break;
            }
        } while (n < 0 || n > 3);
        System.out.println("Hasta luego!");
    }
}
