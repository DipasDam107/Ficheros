/*
 Busca por Internet que valores deben de tener los primeros bytes (cabecera) de los archivos BMP
y JPG para ser identificados como tal. Implementa un método con nombre comprobarTipoArchivo () que
devuelva un booleano y al que se le pasará como parámetro un nombre de fichero con ruta y el tipo a
comprobar (jpg ó bmp). El método deberá comprobar si el valor del campo de la cabecera que identifica
al tipo de archivo coincide con el del archivo. Si es así devolverá true, en caso contrario devolverá false.
Pista: Para comparar valores hexadecimales, hacer casting. Ej: if ( varByte1 ==(byte)0x42) …
 */
package dam107t7e15;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        byte [] numeros = new byte[30];
        String separador = System.getProperty("file.separator");
        String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "bandera.jpg";
        String rutaBmp = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "land.bmp";
       
        if (esPng(ruta)) System.out.println("El archivo '"+ ruta +"' es un png");
        else System.out.println("El archivo '"+ ruta +"' no es un png");

        if (esBmp(rutaBmp)) System.out.println("El archivo '"+ rutaBmp +"' es un bmp");
        else System.out.println("El archivo '"+ rutaBmp +"' no es un bmp");
    }
    
    public static boolean esPng(String ruta){
        boolean eof=false;
        final int png[] = new int[] {0xff, 0xd8, 0xff};
        try (FileInputStream fis = new FileInputStream(ruta);
                BufferedInputStream bfis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bfis)) {
            
                for(int i = 0; i < png.length; ++i) {
                    if(png[i] != fis.read()) return false;
                }
            
        } catch (EOFException e) {
            eof = true;
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        } catch (Exception ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }
        
        return true;
    }
    
     public static boolean esBmp(String ruta){
        boolean eof=false;
        final int png[] = new int[] {0x42, 0x4d};
        try (FileInputStream fis = new FileInputStream(ruta);
                BufferedInputStream bfis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bfis)) {
            
                for(int i = 0; i < png.length; ++i) {
                    if(png[i] != fis.read()) return false;
        
                }
            
        } catch (EOFException e) {
            eof = true;
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        } catch (Exception ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }
        
        return true;
    }
}
