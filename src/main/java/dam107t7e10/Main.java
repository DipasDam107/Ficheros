/*
 Realizar un programa que lea el fichero del ejercicio anterior línea a línea y finalmente muestre la
cantidad de alumnos que tienen una nota final >=5 y el nombre del alumno con mejor nota. (La nota 
final no tiene decimales y se calcula redondeando un 20% de la primera evaluación más un 30% de la
segunda más 50% de la tercera). 

 */
package dam107t7e10;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String []args){
        String separador = System.getProperty("file.separator");
        String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "alumnos.txt";
        String cadena;
        String nombreNota="Ninguno";
        int mediaAlta=0, aprobados=0;
         try(FileReader fr = new FileReader(ruta); BufferedReader bfr = new BufferedReader(fr)){
                while((cadena=bfr.readLine()) != null){
                    float nota1, nota2, nota3;
                    int media;
                    String nombre = cadena.substring(0, 100).trim();
                    nota1 = Float.valueOf(cadena.substring(108, 114).replace(',', '.'));
                    nota2= Float.valueOf(cadena.substring(115, 120).replace(',', '.'));
                    nota3= Float.valueOf(cadena.substring(121, 126).replace(',', '.'));
                    media = (int) Math.round((nota1*0.2+nota2*0.3+nota3*0.5));
                    System.out.println("--------------------------------------------");
                    System.out.println("Alumno: " + nombre);
                    System.out.println("--------------------------------------------");
                    System.out.println("Fecha de Nacimiento: " + LocalDate.of(Integer.valueOf(cadena.substring(100, 104)), Integer.valueOf(cadena.substring(104, 106)), Integer.valueOf(cadena.substring(106, 108))));
                    System.out.println("Nota Primer Trimestre: " + nota1);
                    System.out.println("Nota Segundo Trimestre: " + nota2);
                    System.out.println("Nota Tercer Trimestre: " + nota3);
                    System.out.println("Media = " + media);
                    if(media>mediaAlta)
                        nombreNota=nombre;
                    if(media>=5)
                        aprobados++;
                }
                System.out.println("--------------------------------------------");
                System.out.println("La nota media mas alta es la de " + nombreNota);
                System.out.println("Aprobados: " + aprobados);
         }catch(Exception e){
             e.printStackTrace();
             System.out.println(e.getMessage());
         }
    }
}
