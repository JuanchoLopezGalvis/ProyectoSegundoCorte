package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoOcioJuguete;
import co.edu.unbosque.model.ProductoOcioRopa;

/**
 * Clase que se encarga de la persistencia de los productos de ocio y ropa
 */
public class ProductoOcioRopaDAO implements OperacionDAO<ProductoOcioRopa> {

	/**
	 * Este atributo representa una lista de productos de ocio y ropa
	 */
	private ArrayList<ProductoOcioRopa> listaProductosOcioRopa;
	/**
	 * Este atributo representa el nombre del archivo de texto
	 */
	private final String TEXT_FILE_NAME = "productoOcioRopa.csv";
	/**
	 * Este atributo representa el nombre del archivo serializado
	 */
	private final String SERIAL_FILE_NAME = "productoOcioRopa.dat";

	/**
	 * Este constructor se encarga de inicializar la lista de productos de ocio y ropa
	 * y de leer el archivo serializado.
	 */
	public ProductoOcioRopaDAO() {
		listaProductosOcioRopa = new ArrayList<ProductoOcioRopa>();
		leerArchivoSerializado();
	}

	/**
	 * Este método se encarga de guardar un producto de ocio y ropa
	 * en la lista de productos de ocio y ropa y de escribir en el archivo de texto y serializado.
	 * @param nuevoProducto es el producto de ocio y ropa que se va a guardar
	 */
	@Override
	public void guardar(ProductoOcioRopa nuevoProducto) {
		listaProductosOcioRopa.add(nuevoProducto);
		escribirArchivo();
		escribirArchivoSerializado();
	}

	@Override
	public ProductoOcioRopa buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Este método se encarga de eliminar un producto de ocio y ropa
	 * de la lista de productos de ocio y ropa y de escribir en el archivo de texto y serializado.
	 * @param comboBox es el comboBox que contiene los productos de ocio y ropa
	 */
	@Override
	public void eliminar(JComboBox<String> comboBox) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosOcioRopa.isEmpty()) {
			for (int i = 0; i < listaProductosOcioRopa.size(); i++) {
				if (listaProductosOcioRopa.get(i).getNombre().equals(seleccion)){
					int index = i;
					listaProductosOcioRopa.remove(index);
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
	 * Este método se encarga de actualizar un producto de ocio y ropa
	 * en la lista de productos de ocio y ropa y de escribir en el archivo de texto y serializado.
	 * @param c es el producto de ocio y ropa que se va a actualizar
	 * @param comboBox es el comboBox que contiene los productos de ocio y ropa
	 * @param confirmacion es el mensaje de confirmación
	 * @param denegacion es el mensaje de denegación
	 */
	@Override
	public void actualizar(ProductoOcioRopa c, JComboBox<String> comboBox, String confirmacion, String denegacion) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosOcioRopa.isEmpty()) {
			for (int i = 0; i < listaProductosOcioRopa.size(); i++) {
				if (listaProductosOcioRopa.get(i).getNombre().equals(seleccion)){
					listaProductosOcioRopa.set(i, c);
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
	 * Este método se encarga de listar los productos de ocio y ropa
	 * en la tabla de productos de ocio y ropa y de llenar los comboBox con los productos de ocio y ropa.
	 * @param tabla es la tabla donde se van a listar los productos de ocio y ropa
	 * @param comboBox es el comboBox que contiene los productos de ocio y ropa
	 * @param comboBox2 es el comboBox que contiene los productos de ocio y ropa
	 */
	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox, JComboBox<String> comboBox2) {

		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla
		comboBox.removeAllItems();
		comboBox2.removeAllItems();
		for (ProductoOcioRopa p : listaProductosOcioRopa) {
			comboBox.addItem(p.getNombre());
			comboBox2.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelCalidad(), p.getTalla(), imagen});
		}

	}
	/**
	 * Este método se encarga de escribir en el archivo de texto
	 */
	public void escribirArchivo() {
		StringBuilder contenido = new StringBuilder();
		for (ProductoOcioRopa producto : listaProductosOcioRopa) {
			String imagenBase64 = producto.getImagenBase64().replace("\n", "").replace("\r", "");

			contenido.append(producto.getNombre()).append(";");
			contenido.append(producto.getPrecio()).append(";");
			contenido.append(producto.getCantidad()).append(";");
			contenido.append(producto.getMarca()).append(";");
			contenido.append(producto.getNivelCalidad()).append(";");
			contenido.append(producto.getTalla()).append(";");
			contenido.append(imagenBase64).append("\n"); 
		}
		FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}

	/**
	 * Este método se encarga de escribir en el archivo serializado
	 */
	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosOcioRopa);

	}

	/**
	 * Este método se encarga de leer el archivo serializado
	 */
	public void leerArchivoSerializado() {

		listaProductosOcioRopa = (ArrayList<ProductoOcioRopa>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaProductosOcioRopa == null ) {
			listaProductosOcioRopa = new ArrayList<>();			
		}


	}

	/**
	 * Este método se encarga de retornar la lista de productos de ocio y ropa
	 * @return la lista de productos de ocio y ropa
	 */
	public ArrayList<ProductoOcioRopa> getListaProductosOcioRopa() {
		return listaProductosOcioRopa;
	}

	/**
	 * Este método se encarga de modificar la lista de productos de ocio y ropa
	 * @param listaProductosOcioRopa es la lista de productos de ocio y ropa
	 */
	public void setListaProductosOcioRopa(ArrayList<ProductoOcioRopa> listaProductosOcioRopa) {
		this.listaProductosOcioRopa = listaProductosOcioRopa;
	}



}
