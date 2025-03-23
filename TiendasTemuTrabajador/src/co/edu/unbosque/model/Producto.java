package co.edu.unbosque.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * La clase Producto es la clase padre de la jerarquía de clases {@link ProductoOcio}, {@link ProductoHogar} 
 * y {@link ProductoOficina}. 
 * Esta clase contiene los atributos comunes de los productos.
 */
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L; 

	/**
	 * El atributo imagenBytes almacena la imagen en formato de bytes para permitir la serialización.
	 */
	private byte[] imagenBytes;  

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
	 * El atributo marca es la marca del producto.
	 */
	private String marca;

	/**
	 * Constructor vacío de la clase Producto.
	 */
	public Producto() {
	}

	/**
	 * Constructor de la clase Producto.
	 * @param nombre Nombre del producto.
	 * @param precio Precio del producto.
	 * @param cantidad Cantidad de productos.
	 * @param marca Marca del producto.
	 * @param imagen Imagen del producto.
	 */
	public Producto(String nombre, double precio, int cantidad, String marca, Image imagen) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.marca = marca;
		setImagen(imagen); // Convierte la imagen en bytes
	}

	// Métodos Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Método que devuelve la imagen como un objeto `Image` si existe.
	 * @return Objeto Image o `null` si no hay imagen.
	 */
	public Image getImagen() {
		if (imagenBytes == null) {
			return null;
		}
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(imagenBytes);
			return new ImageIcon(ImageIO.read(bais)).getImage();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Método que almacena la imagen en formato de bytes para permitir la serialización.
	 * @param imagen Objeto Image a convertir y guardar.
	 */
	public void setImagen(Image imagen) {
		if (imagen == null) {
			this.imagenBytes = null;
			return;
		}
		try {
			BufferedImage bufferedImage = new BufferedImage(
					imagen.getWidth(null), 
					imagen.getHeight(null), 
					BufferedImage.TYPE_INT_ARGB
					);
			bufferedImage.getGraphics().drawImage(imagen, 0, 0, null);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", baos);
			this.imagenBytes = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para obtener la imagen en formato Base64.
	 * @return Cadena Base64 de la imagen o `""` si no hay imagen.
	 */
	public String getImagenBase64() {
		if (imagenBytes == null) {
			return "";
		}
		return "png;" + Base64.getEncoder().encodeToString(imagenBytes);
	}

	@Override
	public String toString() {
		return String.format(
				"Producto [nombre=%s, precio=%.2f, cantidad=%d, marca=%s, imagen=%s]", 
				nombre, precio, cantidad, marca, (imagenBytes != null ? "Sí" : "No")
				);
	}


}

