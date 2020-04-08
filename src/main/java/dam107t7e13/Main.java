/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t7e13;

import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String separador = System.getProperty("file.separator");
        String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich12.dat";
        boolean eof=false;
        try (FileInputStream fis = new FileInputStream(ruta);
                BufferedInputStream bfis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bfis)) {
            while (!eof) {
                float val = dis.readFloat();
                String txt = dis.readUTF();
                System.out.printf("Fecha: %s Temperatura: %f\n", txt, val);
            }
        } catch (EOFException e) {
            eof = true;
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        } catch (Exception ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }

    }
}
