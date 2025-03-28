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

public class ProductoOcioRopaDAO implements OperacionDAO<ProductoOcioRopa> {

	private ArrayList<ProductoOcioRopa> listaProductosOcioRopa;
	private final String TEXT_FILE_NAME = "productoOcioRopa.csv";
	private final String SERIAL_FILE_NAME = "productoOcioRopa.dat";

	public ProductoOcioRopaDAO() {
		listaProductosOcioRopa = new ArrayList<ProductoOcioRopa>();
		leerArchivoSerializado();
	}

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

	@Override
	public void actualizar(ProductoOcioRopa c) {
		escribirArchivo();
		escribirArchivoSerializado();
		// TODO Auto-generated method stub

	}

	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox) {

		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla

		comboBox.removeAllItems();
		for (ProductoOcioRopa p : listaProductosOcioRopa) {
			comboBox.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelCalidad(), p.getTalla(), imagen});
		}

	}

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

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosOcioRopa);

	}

	public void leerArchivoSerializado() {

		listaProductosOcioRopa = (ArrayList<ProductoOcioRopa>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaProductosOcioRopa == null ) {
			listaProductosOcioRopa = new ArrayList<>();			
		}


	}

	public ArrayList<ProductoOcioRopa> getListaProductosOcioRopa() {
		return listaProductosOcioRopa;
	}

	public void setListaProductosOcioRopa(ArrayList<ProductoOcioRopa> listaProductosOcioRopa) {
		this.listaProductosOcioRopa = listaProductosOcioRopa;
	}



}
