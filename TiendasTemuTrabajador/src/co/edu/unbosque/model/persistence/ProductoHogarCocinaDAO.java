package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoHogarBanio;
import co.edu.unbosque.model.ProductoHogarCocina;

public class ProductoHogarCocinaDAO implements OperacionDAO<ProductoHogarCocina>{

	private ArrayList<ProductoHogarCocina> listaProductosHogarCocina;
	
	public ProductoHogarCocinaDAO() {
		listaProductosHogarCocina = new ArrayList<ProductoHogarCocina>();
	}
	
	@Override
	public void guardar(ProductoHogarCocina nuevoProducto) {
		listaProductosHogarCocina.add(nuevoProducto);
	}

	@Override
	public ProductoHogarCocina buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(ProductoHogarCocina c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(JTable tabla) {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla


		for (ProductoHogarCocina p : listaProductosHogarCocina) {
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);

			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(),  p.getMaterial(), p.getColor(), p.getFuncionalidad(), imagen});
		}
	}

	public ArrayList<ProductoHogarCocina> getListaProductosHogarCocina() {
		return listaProductosHogarCocina;
	}

	public void setListaProductosHogarCocina(ArrayList<ProductoHogarCocina> listaProductosHogarCocina) {
		this.listaProductosHogarCocina = listaProductosHogarCocina;
	}

	
	
	
}
