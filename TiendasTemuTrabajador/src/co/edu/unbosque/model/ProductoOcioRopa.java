package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

/**
 * La clase ProductoOcioRopa es una clase hija de la clase ProductoOcio
 * y representa los productos de ocio que son prendas de vestir.
 */
public class ProductoOcioRopa extends ProductoOcio implements Serializable{

	/**
	 * Talla de la prenda (ej. "S", "M", "L").
	 */
	private String talla;
	
	/**
	 * Constructor vacio de la clase ProductoOcioRopa
	 */
	public ProductoOcioRopa() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor propio de la clase ProductoOcioRopa
	 * @param talla es la talla de la prenda
	 */
	public ProductoOcioRopa(String talla) {
		super();
		this.talla = talla;
	}

	/**
	 * Constructor de la clase ProductoOcioJuguete que recibe los atributos de la clase padre
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelCalidad es el nivel de calidad del producto en el Ocio
	 * @param talla es 
	 */
	public ProductoOcioRopa(String nombre, double precio, int cantidad, String marca, Image imagen, String nivelCalidad,
			String talla) {
		super(nombre, precio, cantidad, marca, imagen, nivelCalidad);
		this.talla = talla;
	}

	/**la talla de la prenda
	 * Constructor de la clase ProductoOficinaPapeleria desde la clase padre ProductoOficina
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelCalidad el nivel de calidad del producto para el uso
	 */
	public ProductoOcioRopa(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelCalidad) {
		super(nombre, precio, cantidad, marca, imagen, nivelCalidad);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que retorna la talla de la prenda
	 * @return talla
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * Metodo que modifica la talla de la prenda
	 * @param talla
	 */
	public void setTalla(String talla) {
		this.talla = talla;
	}

	@Override
	public String toString() {
		return super.toString()+ " ProductoOcioRopa [talla=" + talla + "]";
	}
	
	
	
	
	
	
	
	
	
	
}

