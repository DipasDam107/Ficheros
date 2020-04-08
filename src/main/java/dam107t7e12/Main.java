/*
 Realizar un programa que escriba en un archivo de datos llamado fich12.dat (no de texto) las
temperaturas que se van registrando mediante un sensor. El programa solicita al usuario la temperatura y
la almacena (puede tener decimales). A continuación, almacenará la fecha/hora del sistema con precisión
de segundos y volverá a solicitar otra temperatura. Si se teclea la temperatura -999 indicará fin de
programa. Pista: DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss")
 */
package dam107t7e12;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String separador = System.getProperty("file.separator");
        String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich12.dat";
        float temp;
        try (FileOutputStream fis = new FileOutputStream(ruta,true);
                BufferedOutputStream bfos = new BufferedOutputStream(fis);
                DataOutputStream dos = new DataOutputStream(fis);){
            do{
                System.out.println("Dime temperatura: ");
                temp=teclado.nextFloat();
                if(temp!=-999){
                    String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss"));
                    
                    dos.writeFloat(temp);
                    dos.writeUTF(fecha);
             
                }
            }while(temp!=-999);
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
        }

    }
}
