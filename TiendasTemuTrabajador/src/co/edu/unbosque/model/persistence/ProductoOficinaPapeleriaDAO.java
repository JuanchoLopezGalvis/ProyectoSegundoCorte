package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoOficinaElectrodomestico;
import co.edu.unbosque.model.ProductoOficinaPapeleria;

public class ProductoOficinaPapeleriaDAO implements OperacionDAO<ProductoOficinaPapeleria> {

	/**
	 * Este atributo representa una lista de productos de oficina y papeleria
	 */
	private ArrayList<ProductoOficinaPapeleria> listaProductosOficinaPapeleria;
	/**
	 * Este atributo representa el nombre del archivo de texto
	 */
	private final String TEXT_FILE_NAME = "productoOficinaPapeleria.csv";
	/**
	 * Este atributo representa el nombre del archivo serializado
	 */
	private final String SERIAL_FILE_NAME = "productoOficinaPapeleria.dat";
	
	/**
	 * Este constructor se encarga de inicializar la lista de productos de oficina y papeleria
	 * y de leer el archivo serializado.
	 */
	public ProductoOficinaPapeleriaDAO() {
		listaProductosOficinaPapeleria = new ArrayList<ProductoOficinaPapeleria>();
		leerArchivoSerializado();
	}
	/**
	 * Este método se encarga de guardar un producto de oficina y papeleria
	 * en la lista de productos de oficina y papeleria y de escribir en el archivo de texto y serializado.
	 * @param nuevoProducto es el producto de oficina y papeleria que se va a guardar
	 */
	@Override
	public void guardar(ProductoOficinaPapeleria nuevoProducto) {
		listaProductosOficinaPapeleria.add(nuevoProducto);	
		escribirArchivo();
		escribirArchivoSerializado();
	}

	
	@Override
	public ProductoOficinaPapeleria buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Este método se encarga de eliminar un producto de oficina y papeleria
	 * @param comboBox es el comboBox que contiene los productos de oficina y papeleria
	 */
	@Override
	public void eliminar(JComboBox<String> comboBox) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosOficinaPapeleria.isEmpty()) {
			for (int i = 0; i < listaProductosOficinaPapeleria.size(); i++) {
				if (listaProductosOficinaPapeleria.get(i).getNombre().equals(seleccion)){
					int index = i;
					listaProductosOficinaPapeleria.remove(index);
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
	 * Este método se encarga de actualizar un producto de oficina y electrodomestico
	 * @param c es el producto de oficina y electrodomestico que se va a actualizar
	 * @param comboBox es el comboBox que contiene los productos de oficina y electrodomestico
	 * @param confirmacion es el mensaje de confirmación
	 * @param denegacion es el mensaje de denegación
	 */
	@Override
	public void actualizar(ProductoOficinaPapeleria c, JComboBox<String> comboBox, String confirmacion, String denegacion) {		
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosOficinaPapeleria.isEmpty()) {
			for (int i = 0; i < listaProductosOficinaPapeleria.size(); i++) {
				if (listaProductosOficinaPapeleria.get(i).getNombre().equals(seleccion)){
					listaProductosOficinaPapeleria.set(i, c);
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
	 * Este método se encarga de listar los productos de oficina y papeleria
	 * @param tabla es la tabla donde se van a listar los productos
	 * @param comboBox es el comboBox que contiene los productos de oficina y papeleria
	 * @param comboBox2 es el comboBox que contiene los productos de oficina y papeleria
	 */
	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox, JComboBox<String> comboBox2) {
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		model.setRowCount(0);
		comboBox.removeAllItems();
		comboBox2.removeAllItems();
		for (ProductoOficinaPapeleria p : listaProductosOficinaPapeleria) {
			comboBox.addItem(p.getNombre());
			comboBox2.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			model.addRow(new Object[] {p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelRuido(), p.getFuncion(), imagen});
		}
	}
	
	/**
	 * Este método se encarga de escribir en el archivo de texto
	 */
	public void escribirArchivo() {
	    StringBuilder contenido = new StringBuilder();
	    for (ProductoOficinaPapeleria producto : listaProductosOficinaPapeleria) {
	        String imagenBase64 = producto.getImagenBase64().replace("\n", "").replace("\r", "");

	        contenido.append(producto.getNombre()).append(";");
	        contenido.append(producto.getPrecio()).append(";");
	        contenido.append(producto.getCantidad()).append(";");
	        contenido.append(producto.getMarca()).append(";");
	        contenido.append(producto.getNivelRuido()).append(";");
	        contenido.append(producto.getFuncion()).append(";");
	        contenido.append(imagenBase64).append("\n"); 
	    }
	    FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	

	/**
	 * Este método se encarga de escribir en el archivo serializado
	 */
	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosOficinaPapeleria);

	}
	
	/**
	 * Este método se encarga de leer el archivo serializado
	 */
	public void leerArchivoSerializado() {
		
		listaProductosOficinaPapeleria = (ArrayList<ProductoOficinaPapeleria>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		
		if (listaProductosOficinaPapeleria == null ) {
			listaProductosOficinaPapeleria = new ArrayList<>();			
		}
		
		
	}
	/**
	 * Este método se encarga de retornar la lista de productos de oficina y papeleria
	 * @return listaProductosOficinaPapeleria
	 */
	public ArrayList<ProductoOficinaPapeleria> getListaProductosOficinaPapeleria() {
		return listaProductosOficinaPapeleria;
	}
	/**
	 * Este método se encarga de modificar la lista de productos de oficina y papeleria
	 * @param listaProductosOficinaPapeleria
	 */
	public void setListaProductosOficinaPapeleria(ArrayList<ProductoOficinaPapeleria> listaProductosOficinaPapeleria) {
		this.listaProductosOficinaPapeleria = listaProductosOficinaPapeleria;
	}

}
