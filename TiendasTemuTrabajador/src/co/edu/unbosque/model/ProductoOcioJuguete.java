package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

public class ProductoOcioJuguete extends ProductoOcio implements Serializable{
	
	/**
	 * Edad minima recomendada para usar el juguete
	 */
	private int edadRecomendada;
	
	/**
	 * Constructor vacio de la clase ProductoOcioJuguete
	 */
	public ProductoOcioJuguete() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor propio de la clase ProductoOcioJuguete
	 * @param edadRecomendada es la edad minima recomendada para usar el juguete
	 */
	public ProductoOcioJuguete(int edadRecomendada) {
		super();
		this.edadRecomendada = edadRecomendada;
	}

	/**
	 * Constructor de la clase ProductoOcioJuguete que recibe los atributos de la clase padre
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelCalidad es el nivel de calidad del producto en el Ocio
	 * @param edadRecomendada es la edad minima recomendada para usar el juguete
	 */
	public ProductoOcioJuguete(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelCalidad, int edadRecomendada) {
		super(nombre, precio, cantidad, marca, imagen, nivelCalidad);
		this.edadRecomendada = edadRecomendada;
	}

	/**
	 * Constructor de la clase ProductoOficinaPapeleria desde la clase padre ProductoOficina
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelCalidad el nivel de calidad del producto para el uso
	 */
	public ProductoOcioJuguete(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelCalidad) {
		super(nombre, precio, cantidad, marca, imagen, nivelCalidad);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que retorna la edad recomendada para su uso
	 * @return edadRecomendada
	 */
	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	/**
	 * Metodo que modifica la edad recomendada para su uso
	 * @param edadRecomendada
	 */
	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	@Override
	public String toString() {
		return super.toString() + " ProductoOcioJuguete [edadRecomendada=" + edadRecomendada + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

