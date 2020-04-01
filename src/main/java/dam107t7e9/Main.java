/*
 Haz una versión del programa anterior, pero creando un fichero alumnos.txt que, en vez de estar
separado por punto y coma, cada columna ocupa un ancho ficho. El nombre ocupará 100 caracteres
(alineado a la derecha, con espacios en blanco a la derecha hasta completar los 100 caracteres, la fecha de
nacimiento tendrá formato AAAAMMDD y las notas ocuparán 2 posiciones enteras, coma y dos posiciones
decimales. Este puede ser un caso donde puede ser muy cómodo usar la clase PrintWriter
 */
package dam107t7e9;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static final int ESPACIO_NOMBRE=100;
     public static void main(String[] args) {
         
         LocalDate fecNac;
         String nombre;
         float nota1, nota2, nota3;
         Scanner teclado = new Scanner(System.in);
         String separador = System.getProperty("file.separator");
         String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "alumnos.txt";
          try (FileWriter fw = new FileWriter(new File(ruta), true);
                BufferedWriter bfw = new BufferedWriter(fw);
                  PrintWriter pw = new PrintWriter(bfw, true)) {
               do {

                System.out.println("Dime Nombre: ");
                nombre = teclado.nextLine();
                if (!nombre.toUpperCase().equals("Z")) {
                    System.out.println("Dime Fecha de Nacimiento(aaaa-mm-dd): ");
                    fecNac = LocalDate.parse(teclado.nextLine());
                    System.out.println("Dime Nota Eval 1: ");
                    nota1 = teclado.nextFloat();
                    System.out.println("Dime Nota Eval 2: ");
                    nota2 = teclado.nextFloat();
                    System.out.println("Dime Nota Eval 3: ");
                    nota3 = teclado.nextFloat();
                    teclado.nextLine();
                 

                    while(nombre.length()<100)
                        nombre+=' ';
                   
                    pw.printf("%s%d%d%d %05.2f %05.2f %05.2f",nombre, fecNac.getYear(), fecNac.getMonthValue(), fecNac.getDayOfMonth(),nota1,nota2,nota3);                    
                    pw.println();
                   

                }
                   System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                   System.out.println("Datos introducidos");
            } while (!nombre.toUpperCase().equals("Z"));
          }
          catch(Exception e){
          
          }
     }
}
