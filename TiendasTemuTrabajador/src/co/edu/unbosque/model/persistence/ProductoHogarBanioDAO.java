package co.edu.unbosque.model.persistence;

import java.awt.Image;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoHogarBanio;

public class ProductoHogarBanioDAO implements OperacionDAO<ProductoHogarBanio>{

	private ArrayList<ProductoHogarBanio> listaProductosHogarBanio;
	private final String TEXT_FILE_NAME = "productoHogarBanio.csv";
	private final String SERIAL_FILE_NAME = "productoHogarBanio.dat";

	public ProductoHogarBanioDAO() {
		listaProductosHogarBanio = new ArrayList<ProductoHogarBanio>();
		leerArchivoSerializado();
	}
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

	@Override
	public void actualizar(ProductoHogarBanio c) {
		escribirArchivo();
		escribirArchivoSerializado();
		// TODO Auto-generated method stub

	}


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

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosHogarBanio);

	}

	public void leerArchivoSerializado() {

		listaProductosHogarBanio = (ArrayList<ProductoHogarBanio>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);

		if (listaProductosHogarBanio == null ) {
			listaProductosHogarBanio = new ArrayList<>();			
		}


	}
	public ArrayList<ProductoHogarBanio> getListaProductosHogarBanio() {
		return listaProductosHogarBanio;
	}
	public void setListaProductosHogarBanio(ArrayList<ProductoHogarBanio> listaProductosHogarBanio) {
		this.listaProductosHogarBanio = listaProductosHogarBanio;
	}

}
