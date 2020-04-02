package dam107t7e17;

import java.io.Serializable;
import java.time.LocalDate;


public abstract class Trabajador implements Serializable{
	private int id;
	private String nombre;
	private LocalDate fecNac;
	private double sueldo;
	
	
	Trabajador(int id, String nombre, LocalDate fecNac, double sueldo){
		this.id=id;
		this.nombre=nombre;
		this.fecNac=fecNac;
		this.sueldo=sueldo;
		
	}
	
	Trabajador(int id, String nombre, LocalDate fecNac){
		this.id=id;
		this.nombre=nombre;
		this.fecNac=fecNac;
		this.sueldo=0;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecNac() {
		return fecNac;
	}

	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
    public boolean equals(Object tra){
		if(tra instanceof Trabajador) {
			if(((Trabajador)tra).id==this.id) return true;
			else return false;
		}
		else return false;
    }
	
	@Override
    public String toString(){
        return "ID: " + this.id +"\n Nombre: " + this.nombre +"\n Fecha Nacimiento: "+ this.fecNac +"\n Sueldo: " + this.sueldo;
    }
	
	
}
