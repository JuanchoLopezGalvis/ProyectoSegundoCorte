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

	private ArrayList<ProductoOficinaPapeleria> listaProductosOficinaPapeleria;
	private final String TEXT_FILE_NAME = "productoOficinaPapeleria.csv";
	private final String SERIAL_FILE_NAME = "productoOficinaPapeleria.dat";
	
	public ProductoOficinaPapeleriaDAO() {
		listaProductosOficinaPapeleria = new ArrayList<ProductoOficinaPapeleria>();
		leerArchivoSerializado();
	}
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

	@Override
	public void actualizar(ProductoOficinaPapeleria c) {
		escribirArchivo();
		escribirArchivoSerializado();
		// TODO Auto-generated method stub
		
	}

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
	

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosOficinaPapeleria);

	}
	
	public void leerArchivoSerializado() {
		
		listaProductosOficinaPapeleria = (ArrayList<ProductoOficinaPapeleria>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		
		if (listaProductosOficinaPapeleria == null ) {
			listaProductosOficinaPapeleria = new ArrayList<>();			
		}
		
		
	}
	public ArrayList<ProductoOficinaPapeleria> getListaProductosOficinaPapeleria() {
		return listaProductosOficinaPapeleria;
	}
	public void setListaProductosOficinaPapeleria(ArrayList<ProductoOficinaPapeleria> listaProductosOficinaPapeleria) {
		this.listaProductosOficinaPapeleria = listaProductosOficinaPapeleria;
	}

}
