/*
 Realizar un programa que lea un archivo como el del ejercicio anterior y muestre por pantalla su
contenido. Además, introducirá los objetos leídos en un ArrayList de tipo Trabajadores_v2
 */
package dam107t7e18;

import dam107t7e17.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static ArrayList<Trabajador> trabajadores;
    static String separador = System.getProperty("file.separator");
    static String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich17.dat";

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        trabajadores = new ArrayList<>();
        leerDatos();
        imprimirDatos();
      
    }

    public static void leerDatos() {
        boolean eof = false;
        File fichero = new File(ruta);
        try (FileInputStream fis = new FileInputStream(fichero);
                BufferedInputStream bufis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bufis)) {

            while (!eof) { //while(bufis.available()>0
                Object x = ois.readObject();
                System.out.println(x.getClass());
                if(x instanceof Asalariado)
                    trabajadores.add((Asalariado)x );
                else 
                    trabajadores.add((ConsultorExterno)x );
            }
        } catch (EOFException e) {
            eof = true;
        } catch (IOException ex) {
            System.err.println("Error:" + ex.getMessage());
        }catch (ClassNotFoundException ex) {
            System.err.println("Error:" + ex.getMessage());
        }
    }

    public static void escribirDatos() {
        try (FileOutputStream fos = new FileOutputStream(ruta, false);
                // No podemos añadir, siempre vacia contenido previo si lo hubiese
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            for (Trabajador x : trabajadores) {
                oos.writeObject(x);
            }
        } catch (IOException ex) {
            System.err.println("Error:" + ex.getMessage());
        }
    }
    public static void imprimirDatos(){
        for (Trabajador x:trabajadores) {
                System.out.println(x.toString());
        }
    }
}
