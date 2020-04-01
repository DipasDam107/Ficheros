/*
 Realizar un programa que lea el fichero fich04.txt línea a línea y lo muestre por pantalla, con el texto
en mayúscula. Usar FileReader, try-with-resources y buffers. 
 */
package dam107t7e6;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args){
        String separador = System.getProperty("file.separator");
        String ruta ="."+separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich04.txt";
        String cadena;
        
        try(FileReader fr = new FileReader(ruta); BufferedReader bfr = new BufferedReader(fr)){
            while((cadena=bfr.readLine()) != null)
                System.out.printf("%s\n",cadena);
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
