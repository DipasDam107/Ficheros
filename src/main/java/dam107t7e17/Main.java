/*
 Realizar un programa que cree un ArrayList de 5 Trabajadores (pueden ser Asalariados o
ConsultoresExternos). Inserta objetos de ambas clases con unos valores cualesquiera “a mano”. A
continuación, guarda los objetos serializados en un archivo llamado fich17.dat. Copia ambas clases de
ejercicios anteriores y su superclase (añadiendo _v2 a su nombre) para adaptarlas a este ejercicio. Pista: La
superclase debe implementar Serializable
 */
package dam107t7e17;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static ArrayList<Trabajador> trabajadores;
    static String separador = System.getProperty("file.separator");
    static String ruta = "." + separador + "src" + separador + "main" + separador + "java" + separador + "archivos" + separador + "fich17.dat";

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        trabajadores = new ArrayList<>();
        trabajadores.add(new Asalariado(1, "Juan", LocalDate.parse("2000-01-01"), 1000d));
        trabajadores.add(new Asalariado(2, "Jose", LocalDate.parse("2002-01-01"), 1006d));
        trabajadores.add(new ConsultorExterno(3, "Ana", LocalDate.parse("1990-01-01")));
        trabajadores.add(new ConsultorExterno(4, "Daniel", LocalDate.parse("1991-01-01")));
        trabajadores.add(new ConsultorExterno(5, "Abel", LocalDate.parse("1991-01-01")));
        
        escribirDatos();
    }

    public static void escribirDatos() {
        try (FileOutputStream fos = new FileOutputStream(ruta, false);
                // No podemos añadir, siempre vacia contenido previo si lo hubiese
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            for(Trabajador x : trabajadores)
                oos.writeObject(x);
            
            System.out.println("Guardado exitoso");
        } catch (IOException ex) {
            System.out.println("Se ha producido un error");
            System.err.println("Error:" + ex.getMessage());
        }
    }
}
