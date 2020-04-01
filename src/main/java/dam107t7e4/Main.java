/*
Basándote en el ejercicio 7.2., hay un programa en el usuario introduzca palabras o frases y se vayan
escribiendo como líneas separadas en un fichero llamado fich04.txt. El programa finaliza cuando el usuario
teclee “fin”. Para definir el objeto teclado para introducir texto especifica la codificación de la consola
mediante: Scanner teclado = new Scanner(System.in, "ISO-8859-1");
*/
package dam107t7e4;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in, "ISO-8859-1");
        String palabra;
        String separador = System.getProperty("file.separator");
        String ruta ="."+separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich04.txt";
        try{
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
