package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoHogarCocina;
import co.edu.unbosque.model.ProductoOcioJuguete;

/**
 * Clase que se encarga de la persistencia de los productos de ocio y juguete
 */
public class ProductoOcioJugueteDAO implements OperacionDAO<ProductoOcioJuguete> {

	/**
	 * Este atributo representa una lista de productos de ocio y juguete
	 */
	private ArrayList<ProductoOcioJuguete> listaProductosOcioJuguete;
	/**
	 * Este atributo representa el nombre del archivo de texto
	 */
	private final String TEXT_FILE_NAME = "productoOcioJuguete.csv";
	/**
	 * Este atributo representa el nombre del archivo serializado
	 */
	private final String SERIAL_FILE_NAME = "productoOcioJuguete.dat";

	/**
	 * Este constructor se encarga de inicializar la lista de productos de ocio y juguete
	 * y de leer el archivo serializado.
	 */
	public ProductoOcioJugueteDAO() {
		listaProductosOcioJuguete = new ArrayList<ProductoOcioJuguete>();
		leerArchivoSerializado();
	}

	/**
	 * Este método se encarga de guardar un producto de ocio y juguete
	 * en la lista de productos de ocio y juguete y de escribir en el archivo de texto y serializado.
	 * @param nuevoProducto es el producto de ocio y juguete que se va a guardar
	 */
	@Override
	public void guardar(ProductoOcioJuguete nuevoProducto) {
		listaProductosOcioJuguete.add(nuevoProducto);
		escribirArchivo();
		escribirArchivoSerializado();
	}

	@Override
	public ProductoOcioJuguete buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Este método se encarga de eliminar un producto de ocio y juguete
	 * de la lista de productos de ocio y juguete y de escribir en el archivo de texto y serializado.
	 * @param comboBox es el comboBox que contiene los productos de ocio y juguete
	 */
	@Override
	public void eliminar(JComboBox<String> comboBox) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosOcioJuguete.isEmpty()) {
			for (int i = 0; i < listaProductosOcioJuguete.size(); i++) {
				if (listaProductosOcioJuguete.get(i).getNombre().equals(seleccion)){
					int index = i;
					listaProductosOcioJuguete.remove(index);
					escribirArchivo();
					escribirArchivoSerializado();
					JOptionPane.showMessageDialog(null, "Producto eliminado");
					break;
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "No hay productos para eliminar");
		}
	}

	/**
	 * Este método se encarga de actualizar un producto de ocio y juguete
	 * en la lista de productos de ocio y juguete y de escribir en el archivo de texto y serializado.
	 * @param c es el producto de ocio y juguete que se va a actualizar
	 * @param comboBox es el comboBox que contiene los productos de ocio y juguete
	 * @param confirmacion es el mensaje de confirmación
	 * @param denegacion es el mensaje de denegación
	 */
	@Override
	public void actualizar(ProductoOcioJuguete c, JComboBox<String> comboBox, String confirmacion, String denegacion) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosOcioJuguete.isEmpty()) {
			for (int i = 0; i < listaProductosOcioJuguete.size(); i++) {
				if (listaProductosOcioJuguete.get(i).getNombre().equals(seleccion)){
					listaProductosOcioJuguete.set(i, c);
					escribirArchivo();
					escribirArchivoSerializado();
					JOptionPane.showMessageDialog(null, confirmacion);
					break;
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, denegacion);
		}
	}

	/**
	 * Este método se encarga de listar los productos de ocio y juguete
	 * en la tabla y comboBoxes
	 * @param tabla es la tabla donde se van a listar los productos de ocio y juguete
	 * @param comboBox es el comboBox que contiene los productos de ocio y juguete
	 * @param comboBox2 es el comboBox que contiene los productos de ocio y juguete
	 */
	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox, JComboBox<String> comboBox2) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla
		comboBox.removeAllItems();
		comboBox2.removeAllItems();
		for (ProductoOcioJuguete p : listaProductosOcioJuguete) {
			comboBox.addItem(p.getNombre());
			comboBox2.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelCalidad(), p.getEdadRecomendada(), imagen});
		}

	}

	/**
	 * Este método se encarga de escribir en el archivo de texto
	 */
	public void escribirArchivo() {
		StringBuilder contenido = new StringBuilder();
		for (ProductoOcioJuguete producto : listaProductosOcioJuguete) {
			String imagenBase64 = producto.getImagenBase64().replace("\n", "").replace("\r", "");

			contenido.append(producto.getNombre()).append(";");
			contenido.append(producto.getPrecio()).append(";");
			contenido.append(producto.getCantidad()).append(";");
			contenido.append(producto.getMarca()).append(";");
			contenido.append(producto.getNivelCalidad()).append(";");
			contenido.append(producto.getEdadRecomendada()).append(";");
			contenido.append(imagenBase64).append("\n"); 
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}

	/**
	 * Este método se encarga de escribir en el archivo serializado
	 */
	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosOcioJuguete);

	}

	/**
	 * Este método se encarga de leer el archivo serializado
	 */
	public void leerArchivoSerializado() {

		listaProductosOcioJuguete = (ArrayList<ProductoOcioJuguete>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaProductosOcioJuguete == null ) {
			listaProductosOcioJuguete = new ArrayList<>();			
		}


	}

	/**
	 * Este método se encarga de obtener la lista de productos de ocio y juguete
	 * @return la lista de productos de ocio y juguete
	 */
	public ArrayList<ProductoOcioJuguete> getListaProductosOcioJuguete() {
		return listaProductosOcioJuguete;
	}
	/**
	 * Este método se encarga de modificar la lista de productos de ocio y juguete
	 * @param listaProductosOcioJuguete
	 */
	public void setListaProductosOcioJuguete(ArrayList<ProductoOcioJuguete> listaProductosOcioJuguete) {
		this.listaProductosOcioJuguete = listaProductosOcioJuguete;
	}

}

