
package dam107t7e17;

import java.time.LocalDate;

public class Asalariado extends Trabajador{
	private double salarioFinal;
	private int horasExtra;
	private static double valorHoraExtra=5;
	
	public static double getValorHoraExtra() {
		return valorHoraExtra;
	}

	Asalariado(int id, String nombre, LocalDate fecNac, double sueldo){
		super(id,nombre,fecNac,sueldo);
		this.horasExtra=0;
		this.salarioFinal=sueldo; 
	}

	public int getHorasExtra() {
		return horasExtra;
	}

	public static void setvalorHorasExtra(double valor) {
		valorHoraExtra=valor;
	}
	
	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
		this.calcularSalarioFinal();
	}
	
	public void calcularSalarioFinal() {
		this.salarioFinal=this.getSueldo()+(this.horasExtra*valorHoraExtra);
		
	}

	public double getSalarioFinal() {
		return salarioFinal;
	}
	
}