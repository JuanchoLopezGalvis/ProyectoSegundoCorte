package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProductoHogarBanio;

public class ProductoHogarBanioDAO implements OperacionDAO<ProductoHogarBanio>{
	private ArrayList<ProductoHogarBanio>listaProductosBanio;
	
	public ProductoHogarBanioDAO() {
		listaProductosBanio = new ArrayList<>();
	}

	@Override
	public void guardar(ProductoHogarBanio newData) {
		listaProductosBanio.add(newData);
		
	}

	@Override
	public int eliminar(int index) {
		if (index <0 || index >= listaProductosBanio.size()) {
			return 1; 
		}else {
			listaProductosBanio.remove(index);
			return 0;  
		}
	}

	@Override
	public int actualizar(int index, ProductoHogarBanio newData) {
		if (index <0 || index >= listaProductosBanio.size()) {
			return 1; 
		}else {
			listaProductosBanio.set(index, newData);
			return 0; 

		 }	
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (ProductoHogarBanio productoHogarBanio : listaProductosBanio) {
			salida += productoHogarBanio.toString();
		}
		return salida;
	}

	@Override
	public int contarCantidad() {
		int cant = listaProductosBanio.size();
		return cant;
	}

	@Override
	public ProductoHogarBanio buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ProductoHogarBanio> getListaProductosBanio() {
		return listaProductosBanio;
	}

	public void setListaProductosBanio(ArrayList<ProductoHogarBanio> listaProductosBanio) {
		this.listaProductosBanio = listaProductosBanio;
	}
	
	

	
	
	

}
