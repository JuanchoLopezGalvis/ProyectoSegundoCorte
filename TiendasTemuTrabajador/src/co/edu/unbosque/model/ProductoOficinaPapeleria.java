package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

/**
 * La clase ProductoOficinaPapeleria es una clase hija de la clase ProductoOficina
 * y representa los productos de oficina de papeleria.
 */
public class ProductoOficinaPapeleria extends ProductoOficina implements Serializable{
	
	/**
	 * el color de la tinta que maneja
	 */
	private String funcion;
	
	/**
	 * Constructor vacio de la clase ProductoOficinaPapeleria
	 */
	public ProductoOficinaPapeleria() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor propio de la clase ProductoOficinaPapeleria
	 * @param colorTinta es el color de la tinta que usa
	 */
	public ProductoOficinaPapeleria(String funcion) {
		super();
		this.funcion = funcion;
	}


	
	/**
	 * Constructor de la clase ProductoOficinaPapeleria que recibe los atributos de la clase padre ProductoOficina
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelRuido el nivel de ruido que genera
	 * @param funcion para que se usa
	*/
	public ProductoOficinaPapeleria(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelRuido, String funcion) {
		super(nombre, precio, cantidad, marca, imagen, nivelRuido);
		this.funcion = funcion;
	}

	/**
	 * Constructor de la clase ProductoOficinaPapeleria desde la clase padre ProductoOficina
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelRuido el nivel de ruido que genera
	 */
	public ProductoOficinaPapeleria(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelRuido) {
		super(nombre, precio, cantidad, marca, imagen, nivelRuido);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que retorna la funcion
	 * @return funcion
	 */
	public String getFuncion() {
		return funcion;
	}

	/**
	 * Metodo que modifica la funcion
	 * @param funcion
	 */
	public void setFuncion(String colorTinta) {
		this.funcion = colorTinta;
	}

	@Override
	public String toString() {
		return super.toString() +" ProductoOficinaPapeleria [colorTinta=" + funcion + "]";
	}
	
	
	
	
	
	
	
	
	
	

}

