package main.models;

import java.util.Comparator;

public class Profesor extends Persona implements Comparator<Profesor>, Comparable<Profesor>{

	private int legajo;
    private String titulo;
    
	public Profesor(Integer id, String apellido, String nombre, Integer edad, Integer dni, int legajo, String titulo) {
		super(id, apellido, nombre, edad, dni);
		this.legajo = legajo;
		this.titulo = titulo;
	}

//region Getters and Setters
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
//endregion

	@Override
	public String toString() {
		return this.legajo + " - " + this.getApellido() + ", " + this.getNombre() + ". Titulo: "+ this.titulo;
	}

	@Override
	public int compareTo(Profesor p) {
		return Integer.compare(this.legajo, p.legajo);
	}

	@Override
	public int compare(Profesor p1, Profesor p2) {
		return p2.getEdad() - p1.getEdad();
	}
}
