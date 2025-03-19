package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

/**
 * La clase ProductoOficina es una clase hija de la clase Producto
 * y representa los productos de oficina.
 */
public class ProductoOficina extends Producto implements Serializable{
	
	/**
	 * El uso del producto en la oficina
	 */	
	private String nivelRuido;
	/**
	 * Constructor vacio de la clase ProductoOficina
	 */
	public ProductoOficina() {
	}
	/**
	 * Constructor propio de la clase ProductoOficina
	 * @param uso es el uso del producto en la oficina
	 */

	public ProductoOficina(String nivelRuido) {
		super();
		this.nivelRuido = nivelRuido;
	}
	/**
	 * Constructor de la clase ProductoOficina que recibe los atributos de la clase padre
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelRuido es la cantidad de ruido que genera
	 */
	public ProductoOficina(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelRuido) {
		super(nombre, precio, cantidad, marca, imagen);
		this.nivelRuido = nivelRuido;
	}
	/**
	 * Constructor de la clase ProductoOficina desde la clase padre Producto
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 */

	public ProductoOficina(String nombre, double precio, int cantidad, String marca, Image imagen) {
		super(nombre, precio, cantidad,marca, imagen);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que retorna el uso del producto en la oficina
	 * @return uso
	 */
	public String getNivelRuido() {
		return nivelRuido;
	}

	/**
	 * Metodo que modifica el uso del producto en la oficina
	 * @param uso
	 */
	public void setNivelRuido(String nivelRuido) {
		this.nivelRuido = nivelRuido;
	}
	@Override
	public String toString() {
		return super.toString() + " Oficina [nivel de Ruido=" + nivelRuido + "]";
	}
	
	

}
