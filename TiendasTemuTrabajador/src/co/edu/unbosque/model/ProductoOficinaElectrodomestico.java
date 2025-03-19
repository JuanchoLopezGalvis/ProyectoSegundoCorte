package co.edu.unbosque.model;

import java.awt.Image;
import java.io.Serializable;

/**
 * La clase ProductoOficinaElectrodomestico es una clase hija de la clase ProductoOficina
 * y representa los productos de oficina que son electrodomesticos.
 */
public class ProductoOficinaElectrodomestico extends ProductoOficina implements Serializable{
	
	/**
	 * el consumo energetico que genera
	 */
	private String consumoEnergetico;
	
	/**
	 * Constructor vacio de la clase ProductoOficinaElectrodomestico
	 */
	public ProductoOficinaElectrodomestico() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor propio de la clase ProductoOficinaElectrodomestico
	 * @param consumoEnergetico es el consumo que genera
	 */
	public ProductoOficinaElectrodomestico(String consumoEnergetico) {
		super();
		this.consumoEnergetico = consumoEnergetico;
	}

	/**
	 * Constructor de la clase ProductoOficinaElectrodomestico que recibe los atributos de la clase padre ProductoOficina
	 * @param nombre es el nombre del producto
	 * @param precio es el precio del producto
	 * @param cantidad es la cantidad de productos
	 * @param marca es la marca del producto
	 * @param imagen es la imagen del producto
	 * @param nivelRuido el nivel de ruido que genera
	 * @param consumoEnergetico es el consumo que genera
	*/
	public ProductoOficinaElectrodomestico(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelRuido, String consumoEnergetico) {
		super(nombre, precio, cantidad, marca, imagen, nivelRuido);
		this.consumoEnergetico = consumoEnergetico;
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
	public ProductoOficinaElectrodomestico(String nombre, double precio, int cantidad, String marca, Image imagen,
			String nivelRuido) {
		super(nombre, precio, cantidad, marca, imagen, nivelRuido);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que retorna el consumo energetico
	 * @return consumoEnergetico
	 */
	public String getConsumoEnergetico() {
		return consumoEnergetico;
	}

	/**
	 * Metodo que modifica el consumo energetico
	 * @param consumoEnergetico
	 */
	public void setConsumoEnergetico(String consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}

	@Override
	public String toString() {
		return super.toString() + " ProductoOficinaElectrodomestico [consumoEnergetico=" + consumoEnergetico + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
