package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoOcioRopa;
import co.edu.unbosque.model.ProductoOficinaElectrodomestico;

public class ProductoOficinaElectrodomesticoDAO implements OperacionDAO<ProductoOficinaElectrodomestico>{

	/**
	 * Este atributo representa una lista de productos de oficina y electrodomestico
	 */
	private ArrayList<ProductoOficinaElectrodomestico> listaProductosOficinaElectrodomestico;
	/**
	 * Este atributo representa el nombre del archivo de texto
	 */
	private final String TEXT_FILE_NAME = "productoOficinaElectrodomestico.csv";
	/**
	 * Este atributo representa el nombre del archivo serializado
	 */
	private final String SERIAL_FILE_NAME = "productoOficinaElectrodomestico.dat";

	/**
	 * Este constructor se encarga de inicializar la lista de productos de oficina y electrodomestico
	 * y de leer el archivo serializado.
	 */
	public ProductoOficinaElectrodomesticoDAO() {
		listaProductosOficinaElectrodomestico = new ArrayList<ProductoOficinaElectrodomestico>();
		leerArchivoSerializado();
	}
	/**
	 * Este método se encarga de guardar un producto de oficina y electrodomestico
	 * en la lista de productos de oficina y electrodomestico y de escribir en el archivo de texto y serializado.
	 * @param nuevoProducto es el producto de oficina y electrodomestico que se va a guardar
	 */
	@Override
	public void guardar(ProductoOficinaElectrodomestico nuevoProducto) {
		listaProductosOficinaElectrodomestico.add(nuevoProducto);
		escribirArchivo();
		escribirArchivoSerializado();
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoOficinaElectrodomestico buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Este método se encarga de eliminar un producto de oficina y electrodomestico
	 * @param comboBox es el comboBox que contiene los productos de oficina y electrodomestico
	 */
	@Override
	public void eliminar(JComboBox<String> comboBox) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosOficinaElectrodomestico.isEmpty()) {
			for (int i = 0; i < listaProductosOficinaElectrodomestico.size(); i++) {
				if (listaProductosOficinaElectrodomestico.get(i).getNombre().equals(seleccion)){
					int index = i;
					listaProductosOficinaElectrodomestico.remove(index);
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
	public void actualizar(ProductoOficinaElectrodomestico c, JComboBox<String> comboBox, String confirmacion, String denegacion) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosOficinaElectrodomestico.isEmpty()) {
			for (int i = 0; i < listaProductosOficinaElectrodomestico.size(); i++) {
				if (listaProductosOficinaElectrodomestico.get(i).getNombre().equals(seleccion)){
					listaProductosOficinaElectrodomestico.set(i, c);
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
	 * Este método se encarga de listar los productos de oficina y electrodomestico
	 * @param tabla es la tabla donde se van a listar los productos
	 * @param comboBox es el comboBox que contiene los productos
	 * @param comboBox2 es el comboBox que contiene los productos
	 */
	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox, JComboBox<String> comboBox2) {
		
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		model.setRowCount(0);
		comboBox.removeAllItems();
		comboBox2.removeAllItems();
		for (ProductoOficinaElectrodomestico p : listaProductosOficinaElectrodomestico) {
			comboBox.addItem(p.getNombre());
			comboBox2.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			model.addRow(new Object[] {p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelRuido() , p.getConsumoEnergetico(), imagen});
		}
		
	}
	
	/**
	 * Este método se encarga de escribir en el archivo de texto
	 */
	public void escribirArchivo() {
	    StringBuilder contenido = new StringBuilder();
	    for (ProductoOficinaElectrodomestico producto : listaProductosOficinaElectrodomestico) {
	        String imagenBase64 = producto.getImagenBase64().replace("\n", "").replace("\r", "");

	        contenido.append(producto.getNombre()).append(";");
	        contenido.append(producto.getPrecio()).append(";");
	        contenido.append(producto.getCantidad()).append(";");
	        contenido.append(producto.getMarca()).append(";");
	        contenido.append(producto.getNivelRuido()).append(";");
	        contenido.append(producto.getConsumoEnergetico()).append(";");
	        contenido.append(imagenBase64).append("\n"); 
	    }
	    FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	

	/**
	 * Este método se encarga de escribir en el archivo serializado
	 */
	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosOficinaElectrodomestico);

	}
	
	/**
	 * Este método se encarga de leer el archivo serializado
	 */
	public void leerArchivoSerializado() {
		
		listaProductosOficinaElectrodomestico = (ArrayList<ProductoOficinaElectrodomestico>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		
		if (listaProductosOficinaElectrodomestico == null ) {
			listaProductosOficinaElectrodomestico = new ArrayList<>();			
		}
		
		
	}
	
	/**
	 * Este método se encarga de obtener la lista de productos de oficina y electrodomestico
	 * @return la lista de productos de oficina y electrodomestico
	 */
	public ArrayList<ProductoOficinaElectrodomestico> getListaProductosOficinaElectrodomestico() {
		return listaProductosOficinaElectrodomestico;
	}
	/**
	 * Este método se encarga de modificar la lista de productos de oficina y electrodomestico
	 * @param listaProductosOficinaElectrodomestico es la nueva lista de productos de oficina y electrodomestico
	 */
	public void setListaProductosOficinaElectrodomestico(
			ArrayList<ProductoOficinaElectrodomestico> listaProductosOficinaElectrodomestico) {
		this.listaProductosOficinaElectrodomestico = listaProductosOficinaElectrodomestico;
	}
	

	
	
}
