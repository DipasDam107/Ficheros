/*
 Realizar un programa con un método al que se le pase una cadena con la ruta y nombre de un
fichero. El método lo leerá y devolverá un array cuyo primer elemento contendrá el número de caracteres
del fichero. El segundo elemento del array debe contar el número de palabras del fichero y el tercer
elemento del array debe contar el número de líneas del fichero. El método devolverá null si no existe el
fichero. El programa puede tener un main que llame al método creado pasándole como parámetro
fich04.txt.
 */
package dam107t7e7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args){
        String separador = System.getProperty("file.separator");
        String ruta ="."+separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich04.txt";
        int [] array=metodo(ruta);
        if(array!=null){
            System.out.println("\n");
            System.out.println("----------------------");
            System.out.println("DATOS");
            System.out.println("----------------------");
            System.out.println("Lineas: " + array[2]);
            System.out.println("Caracteres: " + array[0]);
            System.out.println("Palabras: " + array[1]);
        }
        else System.out.println("El fichero no existe");
    }
    public static int[] metodo(String ruta){
        int linea=0, palabras=0, caracteres=0;
        String cadena;
        File archivo = new File(ruta);
        if(!archivo.exists()) return null;
        else {
            System.out.println("----------------------");
            System.out.println("FICHERO");
            System.out.println("----------------------");
            try(FileReader fr = new FileReader(ruta); BufferedReader bfr = new BufferedReader(fr)){
                while((cadena=bfr.readLine()) != null){
                    System.out.printf("%s\n",cadena);
                    linea++;
                    caracteres += cadena.length();
                    for (int i = 0; i < cadena.length(); i++) {
                        if(i!=0 && ((cadena.charAt(i) == ' ' && cadena.charAt(i-1)!= ' ')||(i==cadena.length()-1 && cadena.charAt(i)!=' ')))
                           palabras++;
                    }
                }
                
                
            }catch(Exception e){}
            int[] valores={caracteres, palabras,linea};
            return valores;
        }        
        
    }
}
