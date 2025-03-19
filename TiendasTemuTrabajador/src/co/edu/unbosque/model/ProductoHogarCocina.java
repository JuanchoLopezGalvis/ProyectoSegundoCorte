package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

/**
 * La clase ProductoHogarCocina es una clase hija de la clase ProductoHogar
 * y representa los productos de hogar que se utilizan en la cocina.
 */
public class ProductoHogarCocina extends ProductoHogar implements Serializable{
	
	/**
	 * la funcion del producto
	 */	
	private String Funcionalidad;
	
	/**
	 * Constructor vacio de la clase Cocina
	 */
	public ProductoHogarCocina() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor propio de la clase Cocina
	 * @param funcionalidad es la funcion del producto en la preparacion de comida 
	 */
	public ProductoHogarCocina(String procedencia) {
		super();
		this.Funcionalidad = procedencia;
	}

	/**
	 * Constructor de la clase Cocina que recibe los atributos de la clase padre Hogar
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param material es el material del producto
	 * @param color es el color del producto
	 * @param funcionalidad es la funcion del producto
	 */
	public ProductoHogarCocina(String nombre, double precio, int cantidad, String marca, Image imagen, String material, String color,
			String Funcionalidad) {
		super(nombre, precio, cantidad, marca, imagen, material, color);
		this.Funcionalidad = Funcionalidad;
	}
	
	/**
	 * Constructor de la clase Cocina desde la clase padre Hogar
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param material es el material del producto
	 * @param funcionalidad es la funcion del producto
	 */
	public ProductoHogarCocina(String nombre, double precio, int cantidad, String marca, Image imagen, String material,
			String color) {
		super(nombre, precio, cantidad, marca, imagen, material, color);
		// TODO Auto-generated constructor stub
	}


	/**
	 * Metodo que retorna la funcion del producto 
	 * @return funcionalidad
	 */

	public String getFuncionalidad() {
		return Funcionalidad;
	}

	/**
	 * Metodo que modifica la funcion del producto
	 * @param funcionalidad
	 */
	public void setFuncionalidad(String funcionalidad) {
		Funcionalidad = funcionalidad;
	}

	@Override
	public String toString() {
		return super.toString()+ " Cocina [Funcionalidad=" + Funcionalidad + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

