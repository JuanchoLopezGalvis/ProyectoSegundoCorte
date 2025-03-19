package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La clase Trabajador es una clase que representa a los trabajadores de la
 * empresa. Esta clase contiene los atributos comunes de los trabajadores.
 *
 */
public class Trabajador {
	private String nombre;
	private String contraseña;
	
	public Trabajador() {
		// TODO Auto-generated constructor stub
	}

	public Trabajador(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", contraseña=" + contraseña + "]";
	}
	
	
	// Pasar Metodos al modelFacade/Dao pq es manejo de datos

}
