package co.edu.unbosque.model.persistence;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ProductoOficinaElectrodomestico;

public class ProductoOficinaElectrodomesticoDAO implements OperacionDAO<ProductoOficinaElectrodomestico>{

	
	private ArrayList<ProductoOficinaElectrodomestico> listaProductosOficinaElectrodomestico;

	public ProductoOficinaElectrodomesticoDAO() {
		listaProductosOficinaElectrodomestico = new ArrayList<ProductoOficinaElectrodomestico>();
	}
	@Override
	public void guardar(ProductoOficinaElectrodomestico c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoOficinaElectrodomestico buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(ProductoOficinaElectrodomestico c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(JTable tabla) {
		
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		model.setRowCount(0);
		
		for (ProductoOficinaElectrodomestico p : listaProductosOficinaElectrodomestico) {
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);
			model.addRow(new Object[] {p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(), p.getNivelRuido() , p.getConsumoEnergetico(), imagen});
		}
		
	}
	

	
	
}
