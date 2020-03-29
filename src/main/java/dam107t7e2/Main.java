/*
 Haz una versión del programa anterior empleando ahora la estructura try-with-resources. Usa
 también File.separator para componer la ruta del archivo que se llamará fich02.txt
 */
package dam107t7e2;

import java.io.*;

public class Main {
    public static void main(String [] args){
        String separador = System.getProperty("file.separator");
        File f = new File("."+separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich02.txt" );
        try( FileWriter fw = new FileWriter(f);
             BufferedWriter bfw = new BufferedWriter(fw)){       
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
