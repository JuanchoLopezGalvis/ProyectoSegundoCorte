package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

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
	public void listar() {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<ProductoHogarBanio> getListaProductosHogarBanio() {
		return listaProductosHogarBanio;
	}
	public void setListaProductosHogarBanio(ArrayList<ProductoHogarBanio> listaProductosHogarBanio) {
		this.listaProductosHogarBanio = listaProductosHogarBanio;
	}

}
