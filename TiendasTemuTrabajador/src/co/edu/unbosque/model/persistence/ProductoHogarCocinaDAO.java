package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoHogarBanio;
import co.edu.unbosque.model.ProductoHogarCocina;

public class ProductoHogarCocinaDAO implements OperacionDAO<ProductoHogarCocina>{

	private ArrayList<ProductoHogarCocina> listaProductosHogarCocina;
	private final String TEXT_FILE_NAME = "productoHogarCocina.csv";
	private final String SERIAL_FILE_NAME = "productoHogarCocina.dat";
	
	public ProductoHogarCocinaDAO() {
		listaProductosHogarCocina = new ArrayList<ProductoHogarCocina>();
		leerArchivoSerializado();
	}
	
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

	@Override
	public void eliminar() {
		escribirArchivo();
		escribirArchivoSerializado();
	}

	@Override
	public void actualizar(ProductoHogarCocina c) {
		escribirArchivo();
		escribirArchivoSerializado();
	}

	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla


		comboBox.removeAllItems();
		for (ProductoHogarCocina p : listaProductosHogarCocina) {
			comboBox.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);

			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(),  p.getMaterial(), p.getColor(), p.getFuncionalidad(), imagen});
		}
	}

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
	
	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosHogarCocina);

	}
	
	public void leerArchivoSerializado() {
		
		listaProductosHogarCocina = (ArrayList<ProductoHogarCocina>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		
		if (listaProductosHogarCocina == null ) {
			listaProductosHogarCocina = new ArrayList<>();			
		}
		
		
		
	}

	public ArrayList<ProductoHogarCocina> getListaProductosHogarCocina() {
		return listaProductosHogarCocina;
	}
	
	public void setListaProductosHogarCocina(ArrayList<ProductoHogarCocina> listaProductosHogarCocina) {
		this.listaProductosHogarCocina = listaProductosHogarCocina;
	}
	
	
	
	
}
