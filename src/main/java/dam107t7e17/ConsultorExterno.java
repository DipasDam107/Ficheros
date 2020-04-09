/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam107t7e17;


import java.time.LocalDate;

public class ConsultorExterno extends Trabajador{
	private int horasTabajadas;
	private double salarioFinal;
	private static double valorHora=10;
	
	ConsultorExterno(int id, String nombre, LocalDate fecNac){
		super(id,nombre,fecNac);
		this.horasTabajadas=0;
		this.salarioFinal=0;
	}
	
	public static void setValorHora(double valor) {
		valorHora=valor;
	}
	
	public static double getValorHora() {
		return valorHora;
	}

	public int getHorasTabajadas() {
		return horasTabajadas;
	}

	public void setHorasTabajadas(int horasTabajadas) {
		this.horasTabajadas = horasTabajadas;
		calcularSalarioFinal();
	}

	public void calcularSalarioFinal() {
		this.salarioFinal=this.horasTabajadas*valorHora;
		
	}

	public double getSalarioFinal() {
		return salarioFinal;
	}
	
}