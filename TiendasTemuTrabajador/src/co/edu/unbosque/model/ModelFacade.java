package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ProductoHogarBanioDAO;

public class ModelFacade {
	
	private ProductoHogarBanioDAO productoHogarBanioDAO;
	
	public ModelFacade() {
		productoHogarBanioDAO  = new ProductoHogarBanioDAO();
	}

	public ProductoHogarBanioDAO getProductoHogarBanioDAO() {
		return productoHogarBanioDAO;
	}

	public void setProductoHogarBanioDAO(ProductoHogarBanioDAO productoHogarBanioDAO) {
		this.productoHogarBanioDAO = productoHogarBanioDAO;
	}
	
	

}
