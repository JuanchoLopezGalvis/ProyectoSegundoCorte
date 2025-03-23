package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoHogarBanio;

public class ProductoHogarBanioDAO implements OperacionDAO<ProductoHogarBanio>{

	private ArrayList<ProductoHogarBanio> listaProductosHogarBanio;
	
	public ProductoHogarBanioDAO() {
		listaProductosHogarBanio = new ArrayList<ProductoHogarBanio>();
	}
	@Override
	public void guardar(ProductoHogarBanio nuevoProducto) {
		listaProductosHogarBanio.add(nuevoProducto);
		
	}

	@Override
	public ProductoHogarBanio buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(ProductoHogarBanio c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(JTable tabla) {
			DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
			modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla


			for (ProductoHogarBanio p : listaProductosHogarBanio) {
				Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
				ImageIcon imagen = new ImageIcon(imagenEscalada);

				modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(),  p.getMaterial(), p.getColor(), p.getZona(), imagen});
			}
		}
		
	public ArrayList<ProductoHogarBanio> getListaProductosHogarBanio() {
		return listaProductosHogarBanio;
	}
	public void setListaProductosHogarBanio(ArrayList<ProductoHogarBanio> listaProductosHogarBanio) {
		this.listaProductosHogarBanio = listaProductosHogarBanio;
	}

}
