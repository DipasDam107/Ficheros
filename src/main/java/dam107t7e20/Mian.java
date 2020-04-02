/*
 Realizar un programa que inserte en un ArrayList 5 elementos de tipo _MovilPrepago pero solo
solicitando al usuario el número de móvil, ya que el resto de parámetros los tomará del fichero obtenido
en el ejercicio anterior, valores iguales para todos los móviles. Finalmente mostrará la suma del saldo de
los 5 móviles. 
 */
package dam107t7e20;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class Mian {
    static float estllamada, costeMb,costeMin,saldoIni;
    static Properties config;
    static String separador = System.getProperty("file.separator");
    static String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "movil.config";
    static Scanner teclado;  
    static ArrayList <cMovilPrepago> moviles;
    
    public static void main(String[] args) {
       
        moviles=new ArrayList<>();
        teclado = new Scanner(System.in);
        config = new Properties(); //(import.java.util.*)
        boolean encontrado=leerProp();
        menu(encontrado);
        
        aniadirTelefonos();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("El saldo total es: " + sumarSaldos());
        
    }

    public static void aniadirTelefonos(){
         int telefono;
    for (int i = 0; i < 5; i++) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Dime Telefono "+ (i+1) +": ");
            telefono=teclado.nextInt();
            teclado.nextLine();
            moviles.add(new cMovilPrepago(telefono,estllamada, costeMin, costeMb,saldoIni));
        }
    }
    public static float sumarSaldos(){
        float total=0;
        for(cMovilPrepago movil : moviles)
            total+=movil.consultarSaldo();
        return total;
    }
    public static void pedirDatos(boolean encontrado){
    float costeEstablecLlamada;
    float costeMinutoLlamada ;
    float costeConsumoMB;
    float saldoInicial;
    
        if(encontrado){
            System.out.println("Dime Coste de establecimiento de Llamada (Anterior: " +estllamada +"): ");
            costeEstablecLlamada=teclado.nextFloat();
            System.out.println("Dime Coste de Minuto de Llamada (Anterior: " +costeMin +"): ");
            costeMinutoLlamada=teclado.nextFloat();
            System.out.println("Dime Coste por MB (Anterior: " +costeMb +"): ");
            costeConsumoMB = teclado.nextFloat();
            System.out.println("Dime Saldo Inicial (Anterior: " +saldoIni +"): ");
            saldoInicial = teclado.nextFloat();
        }
        else{
            System.out.println("Dime Coste de establecimiento de Llamada: ");
            costeEstablecLlamada=teclado.nextFloat();
            System.out.println("Dime Coste de Minuto de Llamada: ");
            costeMinutoLlamada=teclado.nextFloat();
            System.out.println("Dime Coste por MB: ");
            costeConsumoMB = teclado.nextFloat();
            System.out.println("Dime Saldo Inicial: ");
            saldoInicial = teclado.nextFloat();
        }
        escribirProp(costeEstablecLlamada,costeMinutoLlamada,costeConsumoMB, saldoInicial);
    }
    public static void escribirProp(float costeEst, float costeMin, float consumoMB, float saldoInicial){
        
        config.setProperty("establecimientoLlamada", String.valueOf(costeEst));
        config.setProperty("costeMinuto", String.valueOf(costeMin));
        config.setProperty("consumoMB", String.valueOf(consumoMB));
        config.setProperty("saldo", String.valueOf(saldoInicial));
        try {
            config.store(new FileOutputStream(ruta), "Fichero de config. de Moviles");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Archivo properties creado");
    }
    public static boolean leerProp() {
        try {
            config.load(new FileInputStream(ruta));
            estllamada = Float.valueOf(config.getProperty("establecimientoLlamada"));
            costeMin = Float.valueOf(config.getProperty("costeMinuto"));
            costeMb = Float.valueOf(config.getProperty("consumoMB"));
            saldoIni = Float.valueOf(config.getProperty("saldo"));

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            return false;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return true;

    }
    
    public static void imprimir(){
        System.out.println("Coste de estabecimiento de llamada: " +estllamada);
        System.out.println("Coste de minuto: " + costeMin);
        System.out.println("Coste de MB: " + costeMb);
        System.out.println("Saldo: " + saldoIni);
    }
    
    public static void menu(boolean encontrado){
        int opcion;
        if(encontrado){
            System.out.println("El archivo de configuracion ya existe: ");
            imprimir();
            do{
                System.out.println("Quieres editarlo? (1 - Si 2- No): ");
                opcion=teclado.nextInt();
                teclado.nextLine();
            }while(opcion!=1 & opcion!=2);
            if(opcion==1) pedirDatos(encontrado);
        }
        else{
            System.out.println("El archivo de configuracion no existe. Vamos a crearlo.");
            pedirDatos(encontrado);
        }
    }
}
