/*
Haz una versión del programa anterior, que compruebe previamente si el fichero fich04.txt existe o
no. En caso afirmativo hará una copia del archivo como fich04.bak y seguirá añadiendo las líneas sobre
fich04.txt . 
*/
package dam107t7e5;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in, "ISO-8859-1");
        String palabra;
        String separador = System.getProperty("file.separator");
        String ruta ="."+separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich04.txt";
        String rutaCopia ="."+separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich04.bak";  
        File fichero = new File(ruta);
        File ficheroCopia = new File(rutaCopia);
        try{
            if(fichero.exists()){
                Files.copy(fichero.toPath(), ficheroCopia.toPath());
            }
            FileOutputStream fos = new FileOutputStream(ruta,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"ISO-8859-1");
            BufferedWriter bfw = new BufferedWriter(osw);
            do{
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Introduce Palabra: ");
                palabra = teclado.nextLine();
                if(!palabra.toLowerCase().equals("fin")){ 
                    bfw.write(palabra);
                    bfw.newLine();
                }
            }while(!palabra.toLowerCase().equals("fin"));
            bfw.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
