/*
 Haz una versión del programa anterior, pero en la que se le indique al fichero que está con
 codificación ISO-8859-1. Obtiene un fichero llamado fich03.txt
 */
package dam107t7e3;

import dam107t7e2.*;
import java.io.*;

public class Main {
    public static void main(String [] args){
        String separador = System.getProperty("file.separator");
        String ruta ="."+separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich03.txt";
        try{       
            FileOutputStream fos = new FileOutputStream(ruta,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"ISO-8859-1");
            BufferedWriter bfw = new BufferedWriter(osw);
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
