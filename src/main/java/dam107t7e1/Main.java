/*
 Realizar un programa que escriba distintas líneas con un texto cualquiera (con eñes y acentos) en
un fichero llamado fich01.txt, usando la clase FileWriter y buffers. El fichero estará almacenado en la carpeta
archivos creada previamente. No emplees la estructura try-with-resources por lo que deberás hacer close()
explícito del BufferedWriter dentro un try-catch.

 */
package dam107t7e1;

import java.io.*;

public class Main {
    public static void main(String [] args){
        BufferedWriter bfw=null;
        try{
            File f = new File(".//src//main//java//archivos//fich01.txt");
            FileWriter fw = new FileWriter(f);
            bfw = new BufferedWriter(fw);
            bfw.write("Esto es un texto con eñes");
            bfw.newLine();
            bfw.write("Río, esdrújula, todavía");
            bfw.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            
        }
    }
}
