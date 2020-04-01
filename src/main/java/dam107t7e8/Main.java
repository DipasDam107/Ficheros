/*
 Realizar un programa que escriba distintas líneas de texto en un fichero llamado alumnos.csv, que
contenga en cada línea: nombre del alumno, fecha de nacimiento, y notas de las tres evaluaciones (con
dos decimales). Cada uno de los campos estará separado por un punto y coma. El programa finalizará
cuando se introduzca ‘Z’ como nombre de alumno. 

 */
package dam107t7e8;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        final char SEPARADOR = ';';
        String separador = System.getProperty("file.separator");
        String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "alumnos.csv";
        String nombre;
        LocalDate fecNac;
        float nota1, nota2, nota3;
        try (FileWriter fw = new FileWriter(new File(ruta), true);
                BufferedWriter bfw = new BufferedWriter(fw)) {
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
                    nota1=(float)Math.round(nota1*100)/100f;
                    nota2=(float)Math.round(nota2*100)/100f;
                    nota3=(float)Math.round(nota3*100)/100f;

                    bfw.write(nombre + SEPARADOR);
                    bfw.write(fecNac + "" + SEPARADOR);
                    bfw.write(nota1 + "" + SEPARADOR);
                    bfw.write(nota2 + "" + SEPARADOR);
                    bfw.write(nota3 + "" + SEPARADOR);
                    bfw.newLine();

                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Datos introducidos");
            } while (!nombre.toUpperCase().equals("Z"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}
