package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoOcioJuguete;

public class ProductoOcioJugueteDAO implements OperacionDAO<ProductoOcioJuguete> {

	private ArrayList<ProductoOcioJuguete> listaProductosOcioJuguete;

	public ProductoOcioJugueteDAO() {
		listaProductosOcioJuguete = new ArrayList<ProductoOcioJuguete>();
	}

	@Override
	public void guardar(ProductoOcioJuguete nuevoProducto) {
		listaProductosOcioJuguete.add(nuevoProducto);
	}

	@Override
	public ProductoOcioJuguete buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(ProductoOcioJuguete c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listar(JTable tabla) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla

		for (ProductoOcioJuguete p : listaProductosOcioJuguete) {
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelCalidad(), p.getEdadRecomendada(), imagen});
		}

	}

	public ArrayList<ProductoOcioJuguete> getListaProductosOcioJuguete() {
		return listaProductosOcioJuguete;
	}

	public void setListaProductosOcioJuguete(ArrayList<ProductoOcioJuguete> listaProductosOcioJuguete) {
		this.listaProductosOcioJuguete = listaProductosOcioJuguete;
	}

}

