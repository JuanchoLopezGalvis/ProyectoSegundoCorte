package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoOcioRopa;

public class ProductoOcioRopaDAO implements OperacionDAO<ProductoOcioRopa> {

	private ArrayList<ProductoOcioRopa> listaProductosOcioRopa;
	
	public ProductoOcioRopaDAO() {
		listaProductosOcioRopa = new ArrayList<ProductoOcioRopa>();
	}
	
	@Override
	public void guardar(ProductoOcioRopa nuevoProducto) {
		listaProductosOcioRopa.add(nuevoProducto);
	}

	@Override
	public ProductoOcioRopa buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(ProductoOcioRopa c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox) {

		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla
		
		for (ProductoOcioRopa p : listaProductosOcioRopa) {
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelCalidad(), p.getTalla(), imagen});
		}
		
	}

	public ArrayList<ProductoOcioRopa> getListaProductosOcioRopa() {
		return listaProductosOcioRopa;
	}

	public void setListaProductosOcioRopa(ArrayList<ProductoOcioRopa> listaProductosOcioRopa) {
		this.listaProductosOcioRopa = listaProductosOcioRopa;
	}

	

}
