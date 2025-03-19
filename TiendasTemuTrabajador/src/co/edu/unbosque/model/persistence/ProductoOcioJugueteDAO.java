package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProductoOcioJuguete;

public class ProductoOcioJugueteDAO implements OperacionDAO<ProductoOcioJuguete>{
	
	private ArrayList<ProductoOcioJuguete>listaProductosJuguetes;
	
	public ProductoOcioJugueteDAO() {
		listaProductosJuguetes = new ArrayList<>();
	}

	@Override
	public void guardar(ProductoOcioJuguete newData) {
		listaProductosJuguetes.add(newData);
		
	}

	@Override
	public int eliminar(int index) {
		if (index <0 || index >= listaProductosJuguetes.size()) {
			return 1; 
		}else {
			listaProductosJuguetes.remove(index);
			return 0;  
		}
	}

	@Override
	public int actualizar(int index, ProductoOcioJuguete newData) {
		if (index <0 || index >= listaProductosJuguetes.size()) {
			return 1; 
		}else {
			listaProductosJuguetes.set(index, newData);
			return 0; 

		 }	
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (ProductoOcioJuguete productoOcioJuguete : listaProductosJuguetes) {
			salida += productoOcioJuguete.toString();
		}
		return salida;
	}

	@Override
	public int contarCantidad() {
		int cant = listaProductosJuguetes.size();
		return cant;
	}

	@Override
	public ProductoOcioJuguete buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ProductoOcioJuguete> getListaProductosJuguetes() {
		return listaProductosJuguetes;
	}

	public void setListaProductosJuguetes(ArrayList<ProductoOcioJuguete> listaProductosJuguetes) {
		this.listaProductosJuguetes = listaProductosJuguetes;
	}
	
	
	

}
