package co.edu.unbosque.model;

import java.awt.Image;

public class ProductoOficina extends Producto{

	/**
	 * El uso del producto en la oficina
	 */	
	private String uso;
	/**
	 * Constructor vacio de la clase ProductoOficina
	 */
	public ProductoOficina() {
	}
	/**
	 * Constructor propio de la clase ProductoOficina
	 * @param uso es el uso del producto en la oficina
	 */

	public ProductoOficina(String uso) {
		super();
		this.uso = uso;
	}
	/**
	 * Constructor de la clase ProductoOficina que recibe los atributos de la clase padre
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param tipo es el tipo de producto
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param uso es el uso del producto en la oficina
	 */
	public ProductoOficina(String nombre, double precio, int cantidad, String tipo, String marca, Image imagen,
			String uso) {
		super(nombre, precio, cantidad, tipo, marca, imagen);
		this.uso = uso;
	}
	/**
	 * Constructor de la clase ProductoOficina desde la clase padre Producto
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param tipo es el tipo de producto
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 */

	public ProductoOficina(String nombre, double precio, int cantidad, String tipo, String marca, Image imagen) {
		super(nombre, precio, cantidad, tipo, marca, imagen);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que retorna el uso del producto en la oficina
	 * @return uso
	 */
	public String getUso() {
		return uso;
	}

	/**
	 * Metodo que modifica el uso del producto en la oficina
	 * @param uso
	 */
	public void setUso(String uso) {
		this.uso = uso;
	}
	
	
}
