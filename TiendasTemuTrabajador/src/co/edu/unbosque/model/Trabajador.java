package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La clase Trabajador es una clase que representa a los trabajadores de la empresa.
 * Esta clase contiene los atributos comunes de los trabajadores.
 *
 */
public class Trabajador {
	 private String nombre;
	    private String contraseña;

	    public Trabajador(String nombre, String contraseña) {
	        this.nombre = nombre;
	        this.contraseña = contraseña;
	    }
	//Pasar Metodos al modelFacade/Dao pq es manejo de datos
	 
	    public void guardar() throws IOException {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/camposTexto/usuarios.txt" , true))) {
	            writer.write(nombre + "," + contraseña);
	            writer.newLine();
	        }
	    }
	    public static boolean verificar(String nombre, String contraseña) throws IOException {
	        try (BufferedReader reader = new BufferedReader(new FileReader("src/camposTexto/usuarios.txt"))) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                String[] datos = linea.split(",");
	                if (datos[0].equals(nombre) && datos[1].equals(contraseña)) {
	                    return true;
	                }
	            }
	        }
	        return false; 
	    }
	}
