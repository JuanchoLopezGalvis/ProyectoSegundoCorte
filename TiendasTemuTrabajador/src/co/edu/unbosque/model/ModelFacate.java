package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ProductoHogarBanioDAO;
import co.edu.unbosque.model.persistence.ProductoHogarCocinaDAO;
import co.edu.unbosque.model.persistence.ProductoOcioJugueteDAO;
import co.edu.unbosque.model.persistence.ProductoOcioRopaDAO;
import co.edu.unbosque.model.persistence.ProductoOficinaElectrodomesticoDAO;
import co.edu.unbosque.model.persistence.ProductoOficinaPapeleriaDAO;

public class ModelFacate {
	private ArrayList<ProductoHogar>listaProductosHogar;
	private ArrayList<ProductoOcio>listaProductosOcio;
	private ArrayList<ProductoOficina>listaProductosOficina;
	private ArrayList<Producto>listaProductos;
	
	private ProductoHogarBanioDAO productohogarbaniodao;
	private ProductoHogarCocinaDAO productohogarcocinadao;
	private ProductoOficinaElectrodomesticoDAO productooficinaelectrodomesticodao;
	private ProductoOficinaPapeleriaDAO productooficinapapeleriadao;
	private ProductoOcioJugueteDAO productoociojuguetedao;
	private ProductoOcioRopaDAO productoocioropadao;
	
	public ModelFacate() {
		listaProductos = new ArrayList<>();
		listaProductosHogar = new ArrayList<>();
		listaProductosOcio = new  ArrayList<>();
		listaProductosOficina = new ArrayList<>();
		
		productohogarbaniodao = new ProductoHogarBanioDAO();
		productohogarcocinadao = new ProductoHogarCocinaDAO();
		productoociojuguetedao = new ProductoOcioJugueteDAO();
		productoocioropadao = new ProductoOcioRopaDAO();
		productooficinaelectrodomesticodao = new ProductoOficinaElectrodomesticoDAO();
		productooficinapapeleriadao = new ProductoOficinaPapeleriaDAO();
		
	}

}
