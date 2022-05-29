package proyecto_java;

/**
 * *************************************************************************************************************
 * Autor: Aarón Serna Nombre: Ficheros.java Descripción: En esta clase se
 * realizan todas las funciones relacionadas con lectura y escritura de
 * ficheros.
 * **************************************************************************************************************
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase Ficheros, Clase donde se encuentran los métodos de lectura y escritura de ficheros.
 * @author Aarón Serna
 */
public class Ficheros {

    FileInputStream fi = null;
    FileOutputStream f = null;
    ObjectInputStream objectRead = null;
    ObjectOutputStream objectWrite = null;
    FileOutputStream fs = null;
    BufferedReader br = null;
    FileReader fr = null;

    /**
     * El método leerArchivo leerá los ficheros de texto de
     * proveedores y recetas.
     *
     * @param fileName
     * @param tipo
     */
    public void leerArchivo(String fileName, String tipo) {
        String cadena = new String("");
        char caracter;

        try {
            fi = new FileInputStream(fileName);

            int tamanyo = (int) fi.available();

            for (int i = 0; i < tamanyo; i++) {
                caracter = (char) fi.read();
                cadena = cadena + caracter;

            }
            System.out.println(tipo + " :\n" + cadena);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fi != null) {
                    fi.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * El método leerPedidos leerá lo pedidos que previamente hemos escrito.
     * @param fileName
     * @param tipo
     */
    public void leerPedidos(String fileName, String tipo) {
        File file = new File(fileName);

        String cadena = new String("");
        char caracter;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            int contador = 1;
            System.out.println("\n****** Leyendo Pedidos ******");
            while ((cadena = br.readLine()) != null) {
                System.out.println(contador + ". " + cadena);
                contador++;
            }
            System.out.println("****** Fin Pedidos ****** \n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null) {
                    //fi.close();
                    fr.close();
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * El método escribirPedido se encarga de redactar una cadena en un fichero de texto.
     * @param fileName
     * @param escritura
     */
    public void escribirPedido(String fileName, String escritura) {

        try {

            File file = new File(fileName);
            FileWriter fw = new FileWriter(file, true);

            fw.write(escritura, 0, escritura.length()); //escribimos una línea y marcamos que inicie en la posición 0 hasta la posición final de la cadena, y seguidamente escrribimos un salto de línea.
            fw.write("\r\n");

            if (fw != null) {
                fw.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * El método actualizarPedidos borra la cadena seleccionada del fichero pedidos.txt y la escribe en el fichero pedidosHechos.txt
     * @param fileLectura
     * @param fileEscritura
     * @param numPedido
     */
    public void actualizarPedidos(String fileLectura, String fileEscritura, int numPedido) {
        File file = new File(fileLectura);
        File f2 = new File(fileEscritura);

        String cadena = "", pedidoActualizado = "";
        String[] pedidosConservados = new String[50];

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            if (numPedido != 0) {
                numPedido--;

                int contador = 0;
                while ((cadena = br.readLine()) != null) {
                    //System.out.println(contador + ". " + cadena);
                    if (numPedido == contador) {
                        pedidoActualizado = cadena;
                    } else {
                        pedidosConservados[contador] = cadena;
                    }
                    contador++;
                }

                //Eliminamos el pedido pendiente
                try {
                    file = new File(fileLectura);
                    FileWriter fw = new FileWriter(file);

                    for (int i = 0; i < pedidosConservados.length; i++) {
                        if (pedidosConservados[i] != null) {
                            fw.write(pedidosConservados[i], 0, pedidosConservados[i].length()); //escribimos una línea y marcamos que inicie en la posición 0 hasta la posición final de la cadena, y seguidamente escrribimos un salto de línea.
                            fw.write("\r\n");
                        }
                    }
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //Lo escribimos como realizado
                try {
                    f2 = new File(fileEscritura);
                    FileWriter fw2 = new FileWriter(f2, true);

                    if (pedidoActualizado != null) {
                        fw2.write(pedidoActualizado, 0, pedidoActualizado.length()); //escribimos una línea y marcamos que inicie en la posición 0 hasta la posición final de la cadena, y seguidamente escrribimos un salto de línea.
                        fw2.write("\r\n");
                    }
                    if (fw2 != null) {
                        fw2.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
