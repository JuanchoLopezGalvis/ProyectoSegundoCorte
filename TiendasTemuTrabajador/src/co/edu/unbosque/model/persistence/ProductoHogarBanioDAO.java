package co.edu.unbosque.model.persistence;

import java.awt.Image;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoHogarBanio;

/**
 * Clase que se encarga de la persistencia de los productos de hogar y baño
 */
public class ProductoHogarBanioDAO implements OperacionDAO<ProductoHogarBanio>{

	/**
	 * Atributo que representa una lista de productos de hogar y baño
	 */
	private ArrayList<ProductoHogarBanio> listaProductosHogarBanio;
	/**
	 * Atributo que representa el nombre del archivo de texto
	 */
	private final String TEXT_FILE_NAME = "productoHogarBanio.csv";
	/**
	 * Atributo que representa el nombre del archivo serializado
	 */
	private final String SERIAL_FILE_NAME = "productoHogarBanio.dat";

	/**
	 * Constructor que se encarga de inicializar la lista de productos de hogar y baño
	 * y de leer el archivo serializado
	 */
	public ProductoHogarBanioDAO() {
		listaProductosHogarBanio = new ArrayList<ProductoHogarBanio>();
		leerArchivoSerializado();
	}
	
	/**
	 * Método que se encarga de guardar un producto de hogar y baño
	 * en la lista de productos de hogar y baño y de escribir en el archivo de texto y serializado.
	 * @param nuevoProducto es el producto de hogar y baño que se va a guardar
	 */
	@Override
	public void guardar(ProductoHogarBanio nuevoProducto) {
		listaProductosHogarBanio.add(nuevoProducto);
		escribirArchivo();
		escribirArchivoSerializado();

	}
	@Override
	public ProductoHogarBanio buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Método que se encarga de eliminar un producto de hogar y baño
	 * de la lista de productos de hogar y baño y de escribir en el archivo de texto y serializado.
	 * @param comboBox es el comboBox que contiene los productos de hogar y baño
	 */
	@Override
	public void eliminar(JComboBox<String> comboBox) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosHogarBanio.isEmpty()) {
			for (int i = 0; i < listaProductosHogarBanio.size(); i++) {
				if (listaProductosHogarBanio.get(i).getNombre().equals(seleccion)){
					int index = i;
					listaProductosHogarBanio.remove(index);
					escribirArchivo();
					escribirArchivoSerializado();
					JOptionPane.showMessageDialog(null, "Producto eliminado");
					break;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay productos para eliminar");
		}
	}

	/**
	 * Método que se encarga de actualizar un producto de hogar y baño
	 * en la lista de productos de hogar y baño y de escribir en el archivo de texto y serializado.
	 * @param c es el producto de hogar y baño que se va a actualizar
	 * @param comboBox es el comboBox que contiene los productos de hogar y baño
	 * @param confirmacion es el mensaje de confirmación
	 * @param denegacion es el mensaje de denegación
	 */
	@Override
	public void actualizar(ProductoHogarBanio c, JComboBox<String> comboBox, String confirmacion, String denegacion) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosHogarBanio.isEmpty()) {
			for (int i = 0; i < listaProductosHogarBanio.size(); i++) {
				if (listaProductosHogarBanio.get(i).getNombre().equals(seleccion)){
					listaProductosHogarBanio.set(i, c);
					escribirArchivo();
					escribirArchivoSerializado();
					JOptionPane.showMessageDialog(null, confirmacion);
					break;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, denegacion);
		}
	}


	/**
	 * Método que se encarga de listar los productos de hogar y baño
	 * en la tabla de productos de hogar y baño y en los comboBox de productos de hogar y baño
	 * @param tabla es la tabla donde se van a listar los productos de hogar y baño
	 * @param comboBox es el comboBox que contiene los productos de hogar y baño
	 * @param comboBox2 es el comboBox que contiene los productos de hogar y baño
	 */
	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox, JComboBox<String> comboBox2) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla
		comboBox.removeAllItems();
		comboBox2.removeAllItems();
		for (ProductoHogarBanio p : listaProductosHogarBanio) {
			comboBox.addItem(p.getNombre());
			comboBox2.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);

			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(),  p.getMaterial(), p.getColor(), p.getZona(), imagen});
		}
	}

	/**
	 * Método que se encarga de escribir en el archivo de texto
	 */
	public void escribirArchivo() {
		StringBuilder contenido = new StringBuilder();
		for (ProductoHogarBanio producto : listaProductosHogarBanio) {
			String imagenBase64 = producto.getImagenBase64().replace("\n", "").replace("\r", "");

			contenido.append(producto.getNombre()).append(";");
			contenido.append(producto.getPrecio()).append(";");
			contenido.append(producto.getCantidad()).append(";");
			contenido.append(producto.getMarca()).append(";");
			contenido.append(producto.getMaterial()).append(";");
			contenido.append(producto.getColor()).append(";");
			contenido.append(producto.getZona()).append(";");
			contenido.append(imagenBase64).append("\n"); 
			
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}

	/**
	 * Método que se encarga de escribir en el archivo serializado
	 */
	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosHogarBanio);

	}

	/**
	 * Método que se encarga de leer el archivo serializado
	 */
	public void leerArchivoSerializado() {

		listaProductosHogarBanio = (ArrayList<ProductoHogarBanio>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaProductosHogarBanio == null ) {
			listaProductosHogarBanio = new ArrayList<>();			
		}


	}
	/**
	 * Método que retorna la lista de productos de hogar y baño
	 * @return listaProductosHogarBanio es la lista de productos de hogar y baño
	 */
	public ArrayList<ProductoHogarBanio> getListaProductosHogarBanio() {
		return listaProductosHogarBanio;
	}
	/**
	 * Método que modifica la lista de productos de hogar y baño
	 * @param listaProductosHogarBanio es la lista de productos de hogar y baño
	 */
	public void setListaProductosHogarBanio(ArrayList<ProductoHogarBanio> listaProductosHogarBanio) {
		this.listaProductosHogarBanio = listaProductosHogarBanio;
	}

}
