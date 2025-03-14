package co.edu.unbosque.model;

import java.awt.Image;

/**
 * La clase Producto es la clase padre de la jerarquia de clases {@link ProductoOseo}, {@link ProductoHogar} 
 * y {@link ProductoOficina}. 
 * Esta clase contiene los atributos comunes de los productos.
 *
 */
public class Producto {

	/**
	 * El atributo imagen es la imagen del producto.
	 */
	private Image imagen;
	/**
	 * El atributo nombre es el nombre del producto.
	 */
	private String nombre;
	/**
	 * El atributo precio es el precio del producto.
	 */
	private double precio;
	/**
	 * El atributo cantidad es la cantidad de productos.
	 */
	private int cantidad;
	/**
	 * El atributo tipo es el tipo de producto.
	 */
	private String tipo;
	/**
	 * El atributo marca es la marca del producto.
	 */
	private String marca;

	/**
	 * Constructor vacio de la clase Producto.
	 */
	public Producto() {

	}
	/**
	 * Constructor de la clase Producto.
	 * @param nombre es el nombre del producto.
	 * @param precio es el precio del producto.
	 * @param cantidad es la cantidad de productos.
	 * @param tipo es el tipo de producto.
	 * @param marca es la marca del producto.
	 */
	public Producto(String nombre, double precio, int cantidad, String tipo, String marca, Image imagen) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.marca = marca;
		this.imagen = imagen;

	}
	/**
	 * Metodo que retorna el nombre del producto.
	 * @return nombre es el nombre del producto.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que retorna el precio del producto.
	 * @return precio es el precio del producto.
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * Metodo que retorna la cantidad de productos.
	 * @return cantidad es la cantidad de productos.
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * Metodo que retorna el tipo de producto.
	 * @return tipo es el tipo de producto.
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Metodo que retorna la marca del producto.
	 * @return marca es la marca del producto.
	 */

	public String getMarca() {
		return marca;
	}
	/**
	 * Metodo que modifica el nombre del producto.
	 * @param nombre es el nombre del producto.
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que modifica el precio del producto.
	 * @param precio es el precio del producto.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * Metodo que modifica la cantidad de productos.
	 * @param cantidad es la cantidad de productos.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Metodo que modifica el tipo de producto.
	 * @param tipo es el tipo de producto.
	 */


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Metodo que modifica la marca del producto.
	 * @param marca es la marca del producto.
	 */

	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * Metodo que retorna la imagen del producto.
	 * @return imagen es la imagen del producto.
	 */
	public Image getImagen() {
		return imagen;
	}
	/**
	 * Metodo que modifica la imagen del producto.
	 * @param imagen es la imagen del producto.
	 */
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

}
