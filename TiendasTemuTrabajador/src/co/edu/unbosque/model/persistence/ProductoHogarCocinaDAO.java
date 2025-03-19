package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProductoHogarCocina;

public class ProductoHogarCocinaDAO implements OperacionDAO<ProductoHogarCocina>{
	private ArrayList<ProductoHogarCocina>listaProductosCocina;
	
	public ProductoHogarCocinaDAO() {
		listaProductosCocina = new ArrayList<>();
	}

	@Override
	public void guardar(ProductoHogarCocina newData) {
		listaProductosCocina.add(newData);
		
	}

	@Override
	public int eliminar(int index) {
		if (index <0 || index >= listaProductosCocina.size()) {
			return 1; 
		}else {
			listaProductosCocina.remove(index);
			return 0;  
		}
	}

	@Override
	public int actualizar(int index, ProductoHogarCocina newData) {
		if (index <0 || index >= listaProductosCocina.size()) {
			return 1; 
		}else {
			listaProductosCocina.set(index, newData);
			return 0; 

		 }	
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (ProductoHogarCocina productoHogarCocina : listaProductosCocina) {
			salida += productoHogarCocina.toString();
		}
		return salida;
	}

	@Override
	public int contarCantidad() {
		int cant = listaProductosCocina.size();
		return cant;
	}

	@Override
	public ProductoHogarCocina buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ProductoHogarCocina> getListaProductosCocina() {
		return listaProductosCocina;
	}

	public void setListaProductosCocina(ArrayList<ProductoHogarCocina> listaProductosCocina) {
		this.listaProductosCocina = listaProductosCocina;
	}
	
	
	

}
