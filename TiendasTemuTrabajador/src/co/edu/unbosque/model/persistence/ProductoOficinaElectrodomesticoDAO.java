package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProductoOficinaElectrodomestico;

public class ProductoOficinaElectrodomesticoDAO implements OperacionDAO<ProductoOficinaElectrodomestico>{
	private ArrayList<ProductoOficinaElectrodomestico>listaProductosElectrodomesticos;
	
	public ProductoOficinaElectrodomesticoDAO() {
		listaProductosElectrodomesticos = new ArrayList<>();
	}

	@Override
	public void guardar(ProductoOficinaElectrodomestico newData) {
		listaProductosElectrodomesticos.add(newData);
		
	}

	@Override
	public int eliminar(int index) {
		if (index <0 || index >= listaProductosElectrodomesticos.size()) {
			return 1; 
		}else {
			listaProductosElectrodomesticos.remove(index);
			return 0;  
		}
	}

	@Override
	public int actualizar(int index, ProductoOficinaElectrodomestico newData) {
		if (index <0 || index >= listaProductosElectrodomesticos.size()) {
			return 1; 
		}else {
			listaProductosElectrodomesticos.set(index, newData);
			return 0; 

		 }	
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (ProductoOficinaElectrodomestico productoOficinaElectrodomestico : listaProductosElectrodomesticos) {
			salida += productoOficinaElectrodomestico.toString();
		}
		return salida;
	}

	@Override
	public int contarCantidad() {
		int cant = listaProductosElectrodomesticos.size();
		return cant;
	}

	@Override
	public ProductoOficinaElectrodomestico buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ProductoOficinaElectrodomestico> getListaProductosElectrodomesticos() {
		return listaProductosElectrodomesticos;
	}

	public void setListaProductosElectrodomesticos(
			ArrayList<ProductoOficinaElectrodomestico> listaProductosElectrodomesticos) {
		this.listaProductosElectrodomesticos = listaProductosElectrodomesticos;
	}
	
	

}
