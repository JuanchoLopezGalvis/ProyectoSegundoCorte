package co.edu.unbosque.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * La clase Trabajador es una clase que representa a los trabajadores de la empresa.
 * Esta clase contiene los atributos comunes de los trabajadores.
 *
 */
public class Trabajador implements Serializable {
	private String usuario;
	private String contraseña;
	/**
	 * El atributo imagenBytes almacena la imagen en formato de bytes para permitir la serialización.
	 */
	private byte[] imagenBytes;  

	public Trabajador() {
		// TODO Auto-generated constructor stub
	}

	public Trabajador(String usuario, String contraseña, Image imagen) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		setImagen(imagen);
	}
	//Pasar Metodos al modelFacade/Dao pq es manejo de datos

	public void guardar() throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/camposTexto/usuarios.txt" , true))) {
			writer.write(usuario + "," + contraseña);
			writer.newLine();
		}
	}
	public static boolean verificar(String nombre, String contraseña) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader("src/camposTexto/usuarios.txt"))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos[0].equals(nombre) && datos[1].equals(contraseña)) {
					return true;
				}
			}
		}
		return false; 
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public byte[] getImagenBytes() {
		return imagenBytes;
	}

	public void setImagenBytes(byte[] imagenBytes) {
		this.imagenBytes = imagenBytes;
	}


}
