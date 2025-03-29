package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoHogarBanio;
import co.edu.unbosque.model.ProductoHogarCocina;

/**
 * Clase que se encarga de la persistencia de los productos de hogar y cocina
 */
public class ProductoHogarCocinaDAO implements OperacionDAO<ProductoHogarCocina>{

	/**
	 * Atributo que representa una lista de productos de hogar y cocina
	 */
	private ArrayList<ProductoHogarCocina> listaProductosHogarCocina;
	/**
	 * Atributo que representa el nombre del archivo de texto
	 */
	private final String TEXT_FILE_NAME = "productoHogarCocina.csv";
	/**
	 * Atributo que representa el nombre del archivo serializado
	 */
	private final String SERIAL_FILE_NAME = "productoHogarCocina.dat";
	
	/**
	 * Constructor que se encarga de inicializar la lista de productos de hogar y cocina
	 * y de leer el archivo serializado
	 */
	public ProductoHogarCocinaDAO() {
		listaProductosHogarCocina = new ArrayList<ProductoHogarCocina>();
		leerArchivoSerializado();
	}
	
	/**
	 * Método que se encarga de guardar un producto de hogar y cocina
	 * en la lista de productos de hogar y cocina y de escribir en el archivo de texto y serializado.
	 * @param nuevoProducto es el producto de hogar y cocina que se va a guardar
	 */
	@Override
	public void guardar(ProductoHogarCocina nuevoProducto) {
		listaProductosHogarCocina.add(nuevoProducto);
		escribirArchivo();
		escribirArchivoSerializado();
	}

	
	@Override
	public ProductoHogarCocina buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Método que se encarga de eliminar un producto de hogar y cocina
	 * de la lista de productos de hogar y cocina y de escribir en el archivo de texto y serializado.
	 * @param comboBox es el comboBox que contiene los productos de hogar y cocina
	 */
	@Override
	public void eliminar(JComboBox<String> comboBox) {
		String seleccion = (String) comboBox.getSelectedItem();
		if (!listaProductosHogarCocina.isEmpty()) {
			for (int i = 0; i < listaProductosHogarCocina.size(); i++) {
				if (listaProductosHogarCocina.get(i).getNombre().equals(seleccion)){
					int index = i;
					listaProductosHogarCocina.remove(index);
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
	 * Método que se encarga de actualizar un producto de hogar y cocina
	 * en la lista de productos de hogar y cocina y de escribir en el archivo de texto y serializado.
	 * @param c es el producto de hogar y cocina que se va a actualizar
	 */
	@Override
	public void actualizar(ProductoHogarCocina c) {
		escribirArchivo();
		escribirArchivoSerializado();
	}

	
	/**
	 * Método que se encarga de listar los productos de hogar y cocina
	 * en la tabla de productos de hogar y cocina y en los comboBox de productos de hogar y cocina
	 * @param tabla es la tabla donde se van a listar los productos de hogar y cocina
	 * @param comboBox es el comboBox donde se van a listar los productos de hogar y cocina
	 * @param comboBox2 es el comboBox donde se van a listar los productos de hogar y cocina
	 */
	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox, JComboBox<String> comboBox2) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla
		comboBox.removeAllItems();
		comboBox2.removeAllItems();
		for (ProductoHogarCocina p : listaProductosHogarCocina) {
			comboBox.addItem(p.getNombre());
			comboBox2.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);

			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(),  p.getMaterial(), p.getColor(), p.getFuncionalidad(), imagen});
		}
	}

	/**
	 * Método que se encarga de escribir en el archivo de texto
	 */
	public void escribirArchivo() {
	    StringBuilder contenido = new StringBuilder();
	    for (ProductoHogarCocina producto : listaProductosHogarCocina) {
	        String imagenBase64 = producto.getImagenBase64().replace("\n", "").replace("\r", "");

	        contenido.append(producto.getNombre()).append(";");
	        contenido.append(producto.getPrecio()).append(";");
	        contenido.append(producto.getCantidad()).append(";");
	        contenido.append(producto.getMarca()).append(";");
	        contenido.append(producto.getMaterial()).append(";");
	        contenido.append(producto.getColor()).append(";");
	        contenido.append(producto.getFuncionalidad()).append(";");
	        contenido.append(imagenBase64).append("\n"); 
	    }
	    FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}
	
	/**
	 * Método que se encarga de escribir en el archivo serializado
	 */
	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosHogarCocina);

	}
	/**
	 * Método que se encarga de leer el archivo serializado
	 */
	public void leerArchivoSerializado() {
		
		listaProductosHogarCocina = (ArrayList<ProductoHogarCocina>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		
		if (listaProductosHogarCocina == null ) {
			listaProductosHogarCocina = new ArrayList<>();			
		}
		
		
		
	}
	/**
	 * Método que retorna la lista de productos de hogar y cocina
	 * @return listaProductosHogarCocina es la lista de productos de hogar y cocina
	 */
	public ArrayList<ProductoHogarCocina> getListaProductosHogarCocina() {
		return listaProductosHogarCocina;
	}
	/**
	 * Método que modifica la lista de productos de hogar y cocina
	 * @param listaProductosHogarCocina es la lista de productos de hogar y cocina
	 */
	public void setListaProductosHogarCocina(ArrayList<ProductoHogarCocina> listaProductosHogarCocina) {
		this.listaProductosHogarCocina = listaProductosHogarCocina;
	}
	
	
	
	
}
