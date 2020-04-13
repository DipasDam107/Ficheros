/*
 Realizar un programa que guarde un fichero similar al de las temperaturas del ejercicio 7.12 con las
temperaturas de todo un año (generar valores al azar para la temperatura, una temperatura por día, con
valores entre 0 y 40 y la fecha en formato YYYYMMDD). El año puede ser una constante con valor 2020. A
continuación, se solicitará un día y mes del año al usuario y se obtendrá con acceso aleatorio (no
secuencial) la temperatura de ese día. Pista: Recordar que las cadenas guardan su longitud en 2 Bytes antes
de los caracteres
 */
package dam107t7e16;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.Scanner;

public class Main {

    static String separador = System.getProperty("file.separator");
    static String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "temps.dat";
    static final int anio = 2020;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LocalDate fecha = LocalDate.of(anio, 1, 1);
        escribirTemp(fecha);
        
        
        System.out.println("Dime mes: ");
        int mes = teclado.nextInt();
        
        System.out.println("Dime dia: ");
        int dia = teclado.nextInt();
       
        teclado.nextLine();
        leerTemp(LocalDate.of(anio, mes, dia));
    }

    public static void escribirTemp(LocalDate fecha) {
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "rw");) {
            do {
                if (fecha.getYear() == anio) {
                    raf.seek(raf.length());
                    String fechaS = fecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                    raf.write(String.format("%8s",fechaS).substring(0,8).getBytes()); 
                    //raf.writeUTF(fechaS);
                    raf.writeInt((int) (Math.random() * 41));
                    fecha = fecha.plusDays(1);
                }
            } while (fecha.getYear() == anio);
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }
    }

    public static void leerTemp(LocalDate fecha) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        int pos = (int)ChronoUnit.DAYS.between(LocalDate.of(anio, 1, 1), fecha);
        int TAM_REGISTRO = 12;
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r");) {
            raf.seek(pos * TAM_REGISTRO);
            byte[] modeloArray = new byte[8];
            raf.read(modeloArray);
            String nombre = new String(modeloArray);
            System.out.println("Dia: " +  LocalDate.parse(nombre.trim(), DateTimeFormatter.ofPattern("yyyyMMdd")));
            System.out.println("Temperatura: " + raf.readInt() + " ºC");
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }
    }

}
