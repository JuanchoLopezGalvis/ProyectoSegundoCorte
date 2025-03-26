package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ProductoHogarBanioDAO;
import co.edu.unbosque.model.persistence.ProductoHogarCocinaDAO;
import co.edu.unbosque.model.persistence.ProductoOcioJugueteDAO;
import co.edu.unbosque.model.persistence.ProductoOcioRopaDAO;
import co.edu.unbosque.model.persistence.ProductoOficinaElectrodomesticoDAO;
import co.edu.unbosque.model.persistence.ProductoOficinaPapeleriaDAO;
import co.edu.unbosque.model.persistence.TrabajadorDAO;

public class ModelFacade {
	
	private ProductoHogarBanioDAO productoHogarBanioDAO;
	private ProductoHogarCocinaDAO productoHogarCocinaDAO;
	private ProductoOcioJugueteDAO productoOcioJugueteDAO;
	private ProductoOcioRopaDAO productoOcioRopaDAO;
	private ProductoOficinaPapeleriaDAO productoOficinaPapeleriaDAO;
	private ProductoOficinaElectrodomesticoDAO productoOficinaElectrodomesticoDAO;
	private TrabajadorDAO trabajadorDAO;
	
	public ModelFacade() {
		productoHogarBanioDAO  = new ProductoHogarBanioDAO();
		productoHogarCocinaDAO = new ProductoHogarCocinaDAO();
		productoOcioJugueteDAO = new ProductoOcioJugueteDAO();
		productoOcioRopaDAO    = new ProductoOcioRopaDAO();
		productoOficinaPapeleriaDAO = new ProductoOficinaPapeleriaDAO();
		productoOficinaElectrodomesticoDAO = new ProductoOficinaElectrodomesticoDAO();
		trabajadorDAO = new TrabajadorDAO();
	}

	public ProductoHogarBanioDAO getProductoHogarBanioDAO() {
		return productoHogarBanioDAO;
	}

	public void setProductoHogarBanioDAO(ProductoHogarBanioDAO productoHogarBanioDAO) {
		this.productoHogarBanioDAO = productoHogarBanioDAO;
	}

	public ProductoHogarCocinaDAO getProductoHogarCocinaDAO() {
		return productoHogarCocinaDAO;
	}

	public void setProductoHogarCocinaDAO(ProductoHogarCocinaDAO productoHogarCocinaDAO) {
		this.productoHogarCocinaDAO = productoHogarCocinaDAO;
	}

	public ProductoOcioJugueteDAO getProductoOcioJugueteDAO() {
		return productoOcioJugueteDAO;
	}

	public void setProductoOcioJugueteDAO(ProductoOcioJugueteDAO productoOcioJugueteDAO) {
		this.productoOcioJugueteDAO = productoOcioJugueteDAO;
	}

	public ProductoOcioRopaDAO getProductoOcioRopaDAO() {
		return productoOcioRopaDAO;
	}

	public void setProductoOcioRopaDAO(ProductoOcioRopaDAO productoOcioRopaDAO) {
		this.productoOcioRopaDAO = productoOcioRopaDAO;
	}

	public ProductoOficinaPapeleriaDAO getProductoOficinaPapeleriaDAO() {
		return productoOficinaPapeleriaDAO;
	}

	public TrabajadorDAO getTrabajadorDAO() {
		return trabajadorDAO;
	}

	public void setTrabajadorDAO(TrabajadorDAO trabajadorDAO) {
		this.trabajadorDAO = trabajadorDAO;
	}

	public void setProductoOficinaPapeleriaDAO(ProductoOficinaPapeleriaDAO productoOficinaPapeleriaDAO) {
		this.productoOficinaPapeleriaDAO = productoOficinaPapeleriaDAO;
	}

	public ProductoOficinaElectrodomesticoDAO getProductoOficinaElectrodomesticoDAO() {
		return productoOficinaElectrodomesticoDAO;
	}

	public void setProductoOficinaElectrodomesticoDAO(
			ProductoOficinaElectrodomesticoDAO productoOficinaElectrodomesticoDAO) {
		this.productoOficinaElectrodomesticoDAO = productoOficinaElectrodomesticoDAO;
	}
	
	

}
