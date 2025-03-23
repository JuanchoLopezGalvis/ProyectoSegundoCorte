package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoOficinaPapeleria;

public class ProductoOficinaPapeleriaDAO implements OperacionDAO<ProductoOficinaPapeleria> {

	private ArrayList<ProductoOficinaPapeleria> listaProductosOficinaPapeleria;
	
	public ProductoOficinaPapeleriaDAO() {
		listaProductosOficinaPapeleria = new ArrayList<ProductoOficinaPapeleria>();
	}
	@Override
	public void guardar(ProductoOficinaPapeleria nuevoProducto) {
		listaProductosOficinaPapeleria.add(nuevoProducto);	
	}

	@Override
	public ProductoOficinaPapeleria buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(ProductoOficinaPapeleria c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(JTable tabla) {
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		model.setRowCount(0);
		for (ProductoOficinaPapeleria p : listaProductosOficinaPapeleria) {
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			model.addRow(new Object[] {p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelRuido(), p.getFuncion(), imagen});
		}
	}
	public ArrayList<ProductoOficinaPapeleria> getListaProductosOficinaPapeleria() {
		return listaProductosOficinaPapeleria;
	}
	public void setListaProductosOficinaPapeleria(ArrayList<ProductoOficinaPapeleria> listaProductosOficinaPapeleria) {
		this.listaProductosOficinaPapeleria = listaProductosOficinaPapeleria;
	}

}
