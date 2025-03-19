package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProductoOficinaPapeleria;

public class ProductoOficinaPapeleriaDAO implements OperacionDAO<ProductoOficinaPapeleria>{
	private ArrayList<ProductoOficinaPapeleria>listaProductosPapeleria;
	
	public ProductoOficinaPapeleriaDAO() {
		listaProductosPapeleria = new ArrayList<>();
	}

	@Override
	public void guardar(ProductoOficinaPapeleria newData) {
		listaProductosPapeleria.add(newData);
		
	}

	@Override
	public int eliminar(int index) {
		if (index <0 || index >= listaProductosPapeleria.size()) {
			return 1; 
		}else {
			listaProductosPapeleria.remove(index);
			return 0;  
		}
	}

	@Override
	public int actualizar(int index, ProductoOficinaPapeleria newData) {
		if (index <0 || index >= listaProductosPapeleria.size()) {
			return 1; 
		}else {
			listaProductosPapeleria.set(index, newData);
			return 0; 

		 }
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (ProductoOficinaPapeleria productoOficinaPapeleria : listaProductosPapeleria) {
			salida += productoOficinaPapeleria.toString();
		}
		return salida;
	}

	@Override
	public int contarCantidad() {
		int cant = listaProductosPapeleria.size();
		return cant;
	}

	@Override
	public ProductoOficinaPapeleria buscar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
