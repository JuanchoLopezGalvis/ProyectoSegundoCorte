package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class ProductoOcioRopaDAO implements OperacionDAO<ProductoOcioRopaDAO>{
	
	private ArrayList<ProductoOcioRopaDAO>listaProductosRopa;
	
	public ProductoOcioRopaDAO() {
		listaProductosRopa = new ArrayList<>();
	}

	@Override
	public void guardar(ProductoOcioRopaDAO newData) {
		listaProductosRopa.add(newData);
		
	}

	@Override
	public int eliminar(int index) {
		if (index <0 || index >= listaProductosRopa.size()) {
			return 1; 
		}else {
			listaProductosRopa.remove(index);
			return 0;  
		}
	}

	@Override
	public int actualizar(int index, ProductoOcioRopaDAO newData) {
		if (index <0 || index >= listaProductosRopa.size()) {
			return 1; 
		}else {
			listaProductosRopa.set(index, newData);
			return 0; 

		 }	
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (ProductoOcioRopaDAO productoOcioRopaDAO : listaProductosRopa) {
			salida += productoOcioRopaDAO.toString();
		}
		return salida;
	}

	@Override
	public int contarCantidad() {
		int cant = listaProductosRopa.size();
		return cant;
	}

	@Override
	public ProductoOcioRopaDAO buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ProductoOcioRopaDAO> getListaProductosRopa() {
		return listaProductosRopa;
	}

	public void setListaProductosRopa(ArrayList<ProductoOcioRopaDAO> listaProductosRopa) {
		this.listaProductosRopa = listaProductosRopa;
	}
	
	
	

}
