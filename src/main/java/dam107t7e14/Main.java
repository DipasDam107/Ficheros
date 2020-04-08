/*
 Realizar una nueva versión del programa anterior que solicite al usuario una fecha inicial y una
fecha final, y calcule la temperatura media entre esas fechas, a partir de las temperaturas guardadas en el
fichero anterior
 */
package dam107t7e14;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    static Scanner teclado;
    static String separador;
    static String ruta;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        separador = System.getProperty("file.separator");
        ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich12.dat";

        LocalDate fecha1 = dimeFecha();
        LocalDate fecha2 = dimeFecha();
        if (fecha1.isEqual(fecha2)) {
             System.out.println("Media: " + leeIgual(fecha1));
        } else {
            if (fecha1.isBefore(fecha2)) {
                System.out.println("Media: " + leeDistinto(fecha1, fecha2));
            } else {
                 System.out.println("Media: " + leeDistinto(fecha2, fecha1));
            }
        }

    }

    public static LocalDate dimeFecha() {
        System.out.println("Dime fecha (aaaa-mm-dd): ");
        return LocalDate.parse(teclado.nextLine());
    }

    public static float leeIgual(LocalDate fecha) {
        boolean eof = false;
        float total=0;
        int contador=0;
        
        try (FileInputStream fis = new FileInputStream(ruta);
                BufferedInputStream bfis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bfis)) {
            while (!eof) {
                float val = dis.readFloat();
                String txt = dis.readUTF();
                LocalDate fecGuardada = LocalDateTime.parse(txt, DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss")).toLocalDate();
                if(fecha.equals(fecGuardada)){
                    contador++;
                    total+=val;
                } 
            }
            
            
        } catch (EOFException e) {
            eof = true;
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        } catch (Exception ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }
        
        if(contador==0) return 0;
        else return total/contador;
    }

    public static float leeDistinto(LocalDate fechaIni, LocalDate fechaFin) {
        boolean eof = false;
        float total=0;
        int contador=0;
        
        try (FileInputStream fis = new FileInputStream(ruta);
                BufferedInputStream bfis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bfis)) {
            while (!eof) {
               float val = dis.readFloat();
                String txt = dis.readUTF();
                LocalDate fecGuardada = LocalDateTime.parse(txt, DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss")).toLocalDate();
                if(fecGuardada.isAfter(fechaIni) && fecGuardada.isBefore(fechaFin)){
                    contador++;
                    total+=val;
                } 
            }
        } catch (EOFException e) {
            eof = true;
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        } catch (Exception ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }
        if(contador==0) return 0;
        else return total/contador;
    }
}
