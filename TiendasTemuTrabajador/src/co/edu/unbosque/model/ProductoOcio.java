<<<<<<< HEAD
package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

/**
 * La clase ProductoOcio es una clase hija de la clase Producto
 * y representa los productos de ocio.
 */
public class ProductoOcio extends Producto implements Serializable{
	
	/**
	 * El nivel de calidad del producto para el uso
	 */	
	private String nivelCalidad;
	
	/**
	 * Constructor vacio de la clase ProductoOcio
	 */
	public ProductoOcio() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor propio de la clase ProductoOcio
	 * @param nivelCalidad es el nivel de calidad producto en la oficina
	 */
	public ProductoOcio(String nivelCalidad) {
		super();
		this.nivelCalidad = nivelCalidad;
	}
	/**
	 * Constructor de la clase ProductoOcio que recibe los atributos de la clase padre
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelCalidad es el nivel de calidad del producto en el Ocio
	 */


	public ProductoOcio(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelCalidad) {
		super(nombre, precio, cantidad, marca, imagen);
		this.nivelCalidad = nivelCalidad;
	}

	/**
	 * Constructor de la clase ProductoOcio desde la clase padre Producto
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 */
	public ProductoOcio(String nombre, double precio, int cantidad, String marca, Image imagen) {
		super(nombre, precio, cantidad, marca, imagen);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que retorna el nivel de calidad del producto en el ocio
	 * @return nivelCalidad
	 */
	public String getNivelCalidad() {
		return nivelCalidad;
	}

	/**
	 * Metodo que modifica el nivel de calidad del producto en el ocio
	 * @param nivelCaliad
	 */
	public void setNivelCalidad(String nivelCalidad) {
		this.nivelCalidad = nivelCalidad;
	}

	@Override
	public String toString() {
		return super.toString() + " Ocio [nivelCalidad=" + nivelCalidad + "]";
	}
	
	
	
	
	
	
	
	

}
=======
package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

/**
 * La clase ProductoOcio es una clase hija de la clase Producto
 * y representa los productos de ocio.
 */
public class ProductoOcio extends Producto implements Serializable{
	
	/**
	 * El nivel de calidad del producto para el uso
	 */	
	private String nivelCalidad;
	
	/**
	 * Constructor vacio de la clase ProductoOcio
	 */
	public ProductoOcio() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor propio de la clase ProductoOcio
	 * @param nivelCalidad es el nivel de calidad producto en la oficina
	 */
	public ProductoOcio(String nivelCalidad) {
		super();
		this.nivelCalidad = nivelCalidad;
	}
	/**
	 * Constructor de la clase ProductoOcio que recibe los atributos de la clase padre
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelCalidad es el nivel de calidad del producto en el Ocio
	 */


	public ProductoOcio(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelCalidad) {
		super(nombre, precio, cantidad, marca, imagen);
		this.nivelCalidad = nivelCalidad;
	}

	/**
	 * Constructor de la clase ProductoOcio desde la clase padre Producto
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 */
	public ProductoOcio(String nombre, double precio, int cantidad, String marca, Image imagen) {
		super(nombre, precio, cantidad, marca, imagen);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que retorna el nivel de calidad del producto en el ocio
	 * @return nivelCalidad
	 */
	public String getNivelCalidad() {
		return nivelCalidad;
	}

	/**
	 * Metodo que modifica el nivel de calidad del producto en el ocio
	 * @param nivelCaliad
	 */
	public void setNivelCalidad(String nivelCalidad) {
		this.nivelCalidad = nivelCalidad;
	}

	@Override
	public String toString() {
		return super.toString() + " Ocio [nivelCalidad=" + nivelCalidad + "]";
	}
	
	
	
	
	
	
	
	

}
>>>>>>> branch 'master' of git@github.com:JuanchoLopezGalvis/ProyectoSegundoCorte.git
