package main.principal;

import java.util.ArrayList;
import main.models.*;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import javax.swing.JOptionPane;
import com.github.javafaker.Faker;

public class Implementacion {
	
	private static String[] titulos = { "Licenciado en Matemáticas", "Doctor en Física", "Ingeniero en Sistemas", "Maestro en Literatura", "Licenciado en Historia", "Doctor en Biología", "Ingeniero en Electrónica", "Maestro en Psicología",
    	    "Licenciado en Economía", "Doctor en Química", "Ingeniero en Telecomunicaciones", "Maestro en Arquitectura", "Licenciado en Filosofía", "Doctor en Medicina", "Ingeniero en Mecánica"
    	};
	
	private static ArrayList<Alumno> listaAlumnos;
	private static ArrayList<Profesor> listaProfesores;
	private static ArrayList<Alumno> alumnosMayorA7;
	
	private static Random rand = new Random();
	
	@SuppressWarnings("deprecation")
	private static final Faker faker = new Faker(new Locale("es", "AR"));
	
	public static void main(String[] args) {

		mostarMenu();
		
	}

	private static void mostarMenu() {
		int opcion;
        do {
            String menu = JOptionPane.showInputDialog("Menú Principal:\n1 - Generar Alumnos y Profesores\n2 - Ordenar listas\n3 - MAyor y menor promedio\n4 - Mejores alumnos\n5 - Profesores graduados en\n6 - Profesores por edad\n7 - Sumatoria de edad\n8 - Calculo de promedios\n9 - Salir");
        	
            if (menu == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                return;
            }

            if (menu.isBlank()) {
                opcion = 0;
            } else {
                opcion = Integer.parseInt(menu);
            }
        	
            try {
                switch(opcion) {
                	case 1:
                		generarAlumnos();
                		generarProfesores();
                		mostrarListaProfesores();
                		mostrarListaAlumnos();
                		break;
                	case 2:
                		if(listaAlumnos == null || listaProfesores == null) {
                			JOptionPane.showMessageDialog(null, "Genere los alumnos y profesores primero");
                			continue;
                		} else {
	                		Collections.sort(listaAlumnos);
	                		Collections.sort(listaProfesores);
	                		mostrarListaProfesores();
	                		mostrarListaAlumnos();
                		}
                		break;
                	case 3:
                		if(listaAlumnos == null || listaProfesores == null) {
                			JOptionPane.showMessageDialog(null, "Genere los alumnos y profesores primero");
                			continue;
                		} else {
                			identificarMayorMenorPromedio();
                		}
                		break;
                	case 4:
                		if(listaAlumnos == null || listaProfesores == null) {
                			JOptionPane.showMessageDialog(null, "Genere los alumnos y profesores primero");
                			continue;
                		} else {
                			identificarAlumnosMayorA7();
                		}
                		break;
                	case 5:
                		if(listaAlumnos == null || listaProfesores == null) {
                			JOptionPane.showMessageDialog(null, "Genere los alumnos y profesores primero");
                			continue;
                		} else {
                			identificarTitulo();
                		}
                		break;
                	case 6:
                		if(listaAlumnos == null || listaProfesores == null) {
                			JOptionPane.showMessageDialog(null, "Genere los alumnos y profesores primero");
                			continue;
                		} else {
                			ordenarProfesoresPorEdad();
                		}
                		break;
                	case 7:
                		if(listaAlumnos == null || listaProfesores == null) {
                			JOptionPane.showMessageDialog(null, "Genere los alumnos y profesores primero");
                			continue;
                		} else {
                			sumatoriaEdadesProfesores();
                		}
                		break;
                	case 8:
                		if(listaAlumnos == null || listaProfesores == null) {
                			JOptionPane.showMessageDialog(null, "Genere los alumnos y profesores primero");
                			continue;
                		} else {
	                		calcularPromediosGenerales();
	                		calcularPromedioMejores();
                		}
                		break;
                	case 9:
                		JOptionPane.showMessageDialog(null, "Gracias");
                		return;
            		default:
            			JOptionPane.showMessageDialog(null, "Opción inválida");		
                }
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cancelado");
                return;
            }
        } while (opcion != 9);
    }		

	private static void generarProfesores() {
		listaProfesores = new ArrayList<Profesor>();
		
		for (int i = 0; i < 20; i++) {
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            int edad = rand.nextInt(45) + 25;
            int dni = faker.number().numberBetween(1000000, 50000000);
            int legajo = faker.number().numberBetween(1000, 9999);
            String titulo =  titulos[rand.nextInt(titulos.length)];
            Profesor profesor = new Profesor(i + 1, apellido, nombre, edad, dni, legajo, titulo);
            listaProfesores.add(profesor);
        }
	}

	private static void generarAlumnos() {
		listaAlumnos = new ArrayList<Alumno>();
		
		for (int i = 0; i < 40; i++) {
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            int edad = rand.nextInt(20) + 18;
            int dni = faker.number().numberBetween(1000000, 80000000);
            int nroLE = faker.number().numberBetween(1000, 99999);
            int materiasAprobadas = rand.nextInt(20);
            double promedio = faker.number().numberBetween(2, 10);
            Alumno alumno = new Alumno(i + 1, apellido, nombre, edad, dni, nroLE, materiasAprobadas, promedio);
            listaAlumnos.add(alumno);
        }
	}
	
	private static void mostrarListaProfesores() {
        StringBuilder sbProfesores = new StringBuilder();
        for (Profesor profesor : listaProfesores) {
            sbProfesores.append(profesor).append("\n");
        }
        JOptionPane.showMessageDialog(null, sbProfesores.toString(), "Lista de profesores", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void mostrarListaAlumnos() {
		StringBuilder sbAlumnos = new StringBuilder();
        for (Alumno alumno : listaAlumnos) {
            sbAlumnos.append(alumno).append("\n");
        }
        JOptionPane.showMessageDialog(null, sbAlumnos.toString(), "Lista de alumnos", JOptionPane.INFORMATION_MESSAGE);
        
	}
	
	private static void identificarMayorMenorPromedio() {
		double mayorPromedio = 0;
		double menorPromedio = 10;
		
		Alumno alumnoMayorPromedio = null;
		Alumno alumnoMenorPromedio = null;
		
		for (Alumno alumno : listaAlumnos) {
            if (alumno.getPromedio() > mayorPromedio) {
                mayorPromedio = alumno.getPromedio();
                alumnoMayorPromedio = alumno;
            }
            if (alumno.getPromedio() < menorPromedio) {
                menorPromedio = alumno.getPromedio();
                alumnoMenorPromedio = alumno;
            }
		}
		JOptionPane.showMessageDialog(null, alumnoMayorPromedio.toString(), "Alumno con mayor promedio:", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, alumnoMenorPromedio.toString(), "Alumno con menor promedio:", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void identificarAlumnosMayorA7() {
        alumnosMayorA7 = new ArrayList<>();

        for (Alumno alumno : listaAlumnos) {
            if (alumno.getPromedio() > 7) {
                alumnosMayorA7.add(alumno);
            }
        }
        Collections.sort(alumnosMayorA7, new Alumno(null, null, null, null, null, 0, 0, 0));

        StringBuilder sb = new StringBuilder();
        for (Alumno alumno : alumnosMayorA7) {
            sb.append(alumno.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Alumnos con promedio mayor a 7", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void identificarTitulo() {
		
	    String titulo = JOptionPane.showInputDialog("Ingrese el titulo del profesor: ");
	    
	    if(titulo == null)
	    	return;
	    
	    if(titulo.isEmpty())
	    	titulo = "Ingeniero en Sistemas";

	    StringBuilder sb = new StringBuilder();
	    for (Profesor profesor : listaProfesores) {
	        if (profesor.getTitulo().equals(titulo)) {
	            sb.append(profesor).append("\n");
	        }
            if (profesor.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                sb.append(profesor).append("\n");
            }
	    }
	    
	    if (sb.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "No hay profesores graduados en: " + titulo, "Profesores con título '" + titulo + "'", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	    	JOptionPane.showMessageDialog(null, sb.toString(), "Profesores graduados en '" + titulo + "'", JOptionPane.INFORMATION_MESSAGE);
	    }
    }
	
	private static void ordenarProfesoresPorEdad() {
		Collections.sort(listaProfesores, new Profesor(null, null, null, null, null, 0, null));
		
		StringBuilder sbEdades = new StringBuilder();
        for (Profesor p : listaProfesores) {
            sbEdades.append(p).append(" - Edad: ").append(p.getEdad() + "\n");
        }
        JOptionPane.showMessageDialog(null, sbEdades.toString(), "Profesores ordenados por edad", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void sumatoriaEdadesProfesores() {
		int sumatoria = 0;
		for(Profesor p : listaProfesores) {
			sumatoria += p.getEdad();
		}
		JOptionPane.showMessageDialog(null, "La sumatoria de edad de los profesores es de: " + sumatoria, "Sumatoria de edad de los profesores", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void calcularPromediosGenerales() {
		
		int cantidadAlumnos = listaAlumnos.size();
		double sumatoriaPromedios = 0;
		for(Alumno a : listaAlumnos) {
			sumatoriaPromedios += a.getPromedio();
		}
		double promedioGeneral = sumatoriaPromedios / cantidadAlumnos;
		
		JOptionPane.showMessageDialog(null, "Promedio general: " + String.format("%.2f", promedioGeneral), "Promedio de notas generales", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void calcularPromedioMejores() {
		ArrayList<Alumno> mejoresAlumnos = new ArrayList<Alumno>();
		mejoresAlumnos.addAll(alumnosMayorA7);
		
		int cantidadAlumnos = mejoresAlumnos.size();
		double sumatoriaPromedios = 0;
		for(Alumno a : mejoresAlumnos) {
			sumatoriaPromedios += a.getPromedio();
		}
		double promedioMejores = sumatoriaPromedios / cantidadAlumnos;
		
		JOptionPane.showMessageDialog(null, "Promedio mejores alumnos: " + String.format("%.2f", promedioMejores), "Promedio de Notas de los Mejores Alumnos", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
