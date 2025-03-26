package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoHogarCocina;
import co.edu.unbosque.model.ProductoOcioJuguete;

public class ProductoOcioJugueteDAO implements OperacionDAO<ProductoOcioJuguete> {

	private ArrayList<ProductoOcioJuguete> listaProductosOcioJuguete;
	private final String TEXT_FILE_NAME = "productoOcioJuguete.csv";
	private final String SERIAL_FILE_NAME = "productoOcioJuguete.dat";

	public ProductoOcioJugueteDAO() {
		listaProductosOcioJuguete = new ArrayList<ProductoOcioJuguete>();
		leerArchivoSerializado();
	}

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

	@Override
	public void eliminar() {
		escribirArchivo();
		escribirArchivoSerializado();

		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(ProductoOcioJuguete c) {
		escribirArchivo();
		escribirArchivoSerializado();
		// TODO Auto-generated method stub

	}

	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla

		comboBox.removeAllItems();
		for (ProductoOcioJuguete p : listaProductosOcioJuguete) {
			comboBox.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelCalidad(), p.getEdadRecomendada(), imagen});
		}

	}
	
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
	
	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosOcioJuguete);

	}
	
	public void leerArchivoSerializado() {
		
		listaProductosOcioJuguete = (ArrayList<ProductoOcioJuguete>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		
		if (listaProductosOcioJuguete == null ) {
			listaProductosOcioJuguete = new ArrayList<>();			
		}
		
		
	}

	public ArrayList<ProductoOcioJuguete> getListaProductosOcioJuguete() {
		return listaProductosOcioJuguete;
	}

	public void setListaProductosOcioJuguete(ArrayList<ProductoOcioJuguete> listaProductosOcioJuguete) {
		this.listaProductosOcioJuguete = listaProductosOcioJuguete;
	}

}

