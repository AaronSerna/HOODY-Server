package proyecto_java;

/**
 * *************************************************************
 * Autor: Aarón Serna Nombre: Menus.java Descripción: en esta clase se realizan
 * todas las funciones relacionadas con el acceso al sistema y lectura y
 * escritura de ficheros.
 * ************************************************************
 */
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

/**
 * Clase Menú: Cada método menu hace determina las funciones que cada usuario
 * puede realizar, Esta clase llama a los métodos de la clase Ficheros, usa
 * rutas relativas y abre el archivo HTML.
 *
 * @author Aarón Serna
 */
public class Menus {

    Scanner tec = new Scanner(System.in);
    Scanner tec2 = new Scanner(System.in);
    Ficheros ficheros = new Ficheros();

    /**
     * Menú de Jefe
     */
    public void menu1() {

        System.out.println("Bienvenido Jefe \nElige una opción");

        byte n;

        do {
            System.out.println("0. Salir");
            System.out.println("1. Leer recetas");
            System.out.println("2. Leer proveedores");
            System.out.println("3. Abrir web HOODY");
            n = tec.nextByte();

            //Se lee el archivo de las recetas.
            switch (n) {
                case 1:
                    ficheros.leerArchivo("RECETAS.txt", "Recetas disponibles");
                    break;

                case 2:
                    ficheros.leerArchivo("proveedores.txt", "Proveedores disponibles");
                    break;

                case 3:
                    System.out.println("\n **** Abriendo navegador ****\n");
                    abrirWebHOODY();
                    break;
                default:
                    System.out.println("Saliendo del Sistema...");
            }

        } while (n != 0 || (n < 0 && n > 2));
    }

    /**
     * Menú de Dependiente
     */
    public void menu2() {

        System.out.println("Bienvenido Dependiente \nElige una opción");

        byte n;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Leer pedidos");
            System.out.println("2. Añadir pedido");
            n = tec.nextByte();

            //Se lee el archivo de las recetas.
            switch (n) {
                case 1:
                    ficheros.leerArchivo("pedidos.txt", "Pedidos a realizar");
                    break;

                case 2:
                    System.out.println("Escriba pedido a agregar: ");
                    String pedido = tec2.nextLine();
                    ficheros.escribirPedido("pedidos.txt", pedido);
                    System.out.println("Pedido agregado satisfactoriamente");
                    break;
                default:
                    System.out.println("Saliendo del Sistema...");
            }
        } while (n != 0 || (n < 0 && n > 2));

    }

    /**
     * Menú de Cocinero
     */
    public void menu3() {

        System.out.println("Bienvenido Cocinero \nElige una opción");

        byte n;

        do {
            System.out.println("0. Salir");
            System.out.println("1. Leer recetas");
            System.out.println("2. Leer pedidos pendientes");
            System.out.println("3. Hacer pedido");
            System.out.println("4. Revisar pedido realizado");

            n = tec.nextByte();

            switch (n) {
                case 1:
                    ficheros.leerArchivo("RECETAS.txt", "Recetas disponibles");
                    break;
                case 2:
                    ficheros.leerPedidos("pedidos.txt", "Pedidos a realizar");
                    break;
                case 3:
                    int numPedido;

                    do {
                        ficheros.leerPedidos("pedidos.txt", "**** Pedidos a realizar: ****");

                        System.out.println("¿Qué pedido ha realizado?");

                        numPedido = tec.nextByte();
                        ficheros.actualizarPedidos("pedidos.txt", "pedidosHechos.txt", numPedido);

                    } while (numPedido != 0);

                    break;

                case 4:
                    ficheros.leerPedidos("pedidosHechos.txt", "Pedido realizado");
                    break;
                default:
                    System.out.println("Saliendo del Sistema...");
            }
        } while (n != 0 || (n < 0 && n > 2));
    }

    public static void abrirWebHOODY() {

        try {
            File objectfile = new File("./LdM_PROYECTO/bootstrap_ej3.html");
            Desktop.getDesktop().open(objectfile);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
