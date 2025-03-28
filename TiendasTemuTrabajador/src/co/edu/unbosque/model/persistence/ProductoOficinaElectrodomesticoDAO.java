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

	
	private ArrayList<ProductoOficinaElectrodomestico> listaProductosOficinaElectrodomestico;
	private final String TEXT_FILE_NAME = "productoOficinaElectrodomestico.csv";
	private final String SERIAL_FILE_NAME = "productoOficinaElectrodomestico.dat";

	public ProductoOficinaElectrodomesticoDAO() {
		listaProductosOficinaElectrodomestico = new ArrayList<ProductoOficinaElectrodomestico>();
		leerArchivoSerializado();
	}
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

	@Override
	public void actualizar(ProductoOficinaElectrodomestico c) {
		escribirArchivo();
		escribirArchivoSerializado();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox) {
		
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		model.setRowCount(0);
		
		comboBox.removeAllItems();
		for (ProductoOficinaElectrodomestico p : listaProductosOficinaElectrodomestico) {
			comboBox.addItem(p.getNombre());
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			model.addRow(new Object[] {p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelRuido() , p.getConsumoEnergetico(), imagen});
		}
		
	}
	
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
	

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaProductosOficinaElectrodomestico);

	}
	
	public void leerArchivoSerializado() {
		
		listaProductosOficinaElectrodomestico = (ArrayList<ProductoOficinaElectrodomestico>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		
		if (listaProductosOficinaElectrodomestico == null ) {
			listaProductosOficinaElectrodomestico = new ArrayList<>();			
		}
		
		
	}
	
	public ArrayList<ProductoOficinaElectrodomestico> getListaProductosOficinaElectrodomestico() {
		return listaProductosOficinaElectrodomestico;
	}
	public void setListaProductosOficinaElectrodomestico(
			ArrayList<ProductoOficinaElectrodomestico> listaProductosOficinaElectrodomestico) {
		this.listaProductosOficinaElectrodomestico = listaProductosOficinaElectrodomestico;
	}
	

	
	
}
