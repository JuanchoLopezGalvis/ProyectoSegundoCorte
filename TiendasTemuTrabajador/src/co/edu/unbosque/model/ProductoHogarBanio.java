package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

/**
 * La clase ProductoHogarBanio es una clase hija de la clase ProductoHogar
 * y representa los productos de hogar que se utilizan en el baño.
 */
public class ProductoHogarBanio extends ProductoHogar implements Serializable {

	/**
	 * la zona en la que se utiliza el producto ejemplo:(Ducha, lavamanos, inodoro
	 */
	private String zona;

	/**
	 * Constructor vacio de la clase ProductoHogarBanio
	 */
	public ProductoHogarBanio() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor propio de la clase ProductoHogarBanio
	 * @param Zona es la zona en la que se usara el producto
	 */
	public ProductoHogarBanio(String zona) {
		super();
		this.zona = zona;
	}
	/**
	 * Constructor de la clase ProductoHogarBanio que recibe los atributos de la clase padre Hogar
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param material es el material del producto
	 * @param color es el color del producto
	 * @param Zona es la zona en la que se usara el producto
	 */
	public ProductoHogarBanio(String nombre, double precio, int cantidad, String marca, Image imagen, String material, String color,
			String zona) {
		super(nombre, precio, cantidad, marca, imagen, material, color);
		this.zona = zona;
	}

	
	/**
	 * Constructor de la clase ProductoHogarBanio desde la clase padre Hogar
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param material es el material del producto
	 * @param color es el color del producto
	 */
	public ProductoHogarBanio(String nombre, double precio, int cantidad, String marca, Image imagen, String material,
			String color) {
		super(nombre, precio, cantidad, marca, imagen, material, color);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que retorna la zona del producto 
	 * @return zona
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * Metodo que modifica la zona del producto
	 * @param zona
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return super.toString()+ " Banio [zona=" + zona + "]";
	}
	
	
	
	
	
	

	

	
	
	

}
