package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

public class ProductoHogar extends Producto implements Serializable{
	
	/**
	 * El atributo material es de tipo String y representa el material del producto
	 */
	private String material;
	/**
	 * El atributo color es de tipo String y representa el color del producto
	 */
	private String color;
	
	/**
	 * Constructor vacio de la clase ProductoHogar
	 */
	public ProductoHogar() {
	}
	/**
	 * Constructor propio de la clase ProductoHogar
	 * @param material es el material del producto
	 * @param color es el color del producto
	 */
	public ProductoHogar(String material, String color) {
		super();
		this.material = material;
		this.color = color;
	}
	/**
	 * Constructor de la clase ProductoHogar que recibe los atributos de la clase padre
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param material es el material del producto
	 * @param color es el color del producto
	 */
	public ProductoHogar(String nombre, double precio, int cantidad, String marca, Image imagen, String material,
			String color) {
		super(nombre, precio, cantidad, marca, imagen);
		this.material = material;
		this.color = color;
	}
 
	/**
	 * Constructor de la clase ProductoHogar desde la clase padre Producto
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 */
	public ProductoHogar(String nombre, double precio, int cantidad, String marca, Image imagen) {
		super(nombre, precio, cantidad, marca, imagen);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que retorna el material del producto
	 * @return material
	 */
	public String getMaterial() {
		return material;
	}
	
	/**
	 * Metodo que modifica el material del producto
	 * @param material es el material del producto
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * Metodo que retorna el color del producto
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Metodo que modifica el color del producto
	 * @param color es el color del producto
	 */
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return super.toString() + "Hogar [material=" + material + ", color=" + color + "]";
	}
	
	

}
