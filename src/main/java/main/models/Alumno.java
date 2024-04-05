package main.models;

import java.util.Comparator;

public class Alumno extends Persona implements Comparator<Alumno>, Comparable<Alumno>{
	
	private int nroLE;
    private int materiasAprobadas;
    private double promedio;
    
	public Alumno(Integer id, String apellido, String nombre, Integer edad, Integer dni, Integer nroLE, int materiasAprobadas, double promedio) {
		super(id, apellido, nombre, edad, dni);
		this.nroLE = nroLE;
		this.materiasAprobadas = materiasAprobadas;
		this.promedio = promedio;
	}

//region Getters and Setters 
	public int getNroLE() {
		return nroLE;
	}
	public void setNroLE(int nroLE) {
		this.nroLE = nroLE;
	}
	public int getMateriasAprobadas() {
		return materiasAprobadas;
	}
	public void setMateriasAprobadas(int materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
//endregion

	@Override
	public String toString() {
		return this.nroLE + " - " + this.getApellido() + ", " + this.getNombre() + " - Promedio: " + String.format("%.2f", this.promedio);
	}

	@Override
	public int compareTo(Alumno a) {
		if(this.getApellido().equals(a.getApellido()))
			return this.getNombre().compareTo(a.getNombre());
		return this.getApellido().compareTo(a.getApellido());
	}

	@Override
	public int compare(Alumno a1, Alumno a2) {
		return Double.compare(a2.promedio, a1.promedio);
	}
}
