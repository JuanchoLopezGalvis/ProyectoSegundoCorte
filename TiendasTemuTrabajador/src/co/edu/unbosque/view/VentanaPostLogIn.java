package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import co.edu.unbosque.model.ProductoHogarBanio;

/**
 * La clase {@link VentanaPostLogIn} se encargara de mostrar la ventana principal
 * del aplicativo despues de que el usuario se haya logeado.
 */
public class VentanaPostLogIn extends JFrame{


	/**
	 * barraMenu es la barra de menu que contendra las opciones de la ventana	
	 */
	private JMenuBar barraMenu;
	/**
	 * pructoHogarBanio es el menu que contendra las opciones de los productos de hogar baño
	 * productoHogarCocina es el menu que contendra las opciones de los productos de hogar cocina
	 * productoOcioJuguete es el menu que contendra las opciones de los productos de ocio jug
	 * productoOcioRopa es el menu que contendra las opciones de los productos de ocio ropa
	 * productoOficinaElectrodomestico es el menu que contendra las opciones de los productos de oficina electrodomestico
	 */
	private JMenu menu, productoHogarBanio, productoHogarCocina, productoOcioJuguete, productoOcioRopa, productoOficinaElectrodomestico, productoOficianPapeleria;
	private JMenuItem regresarAlInicio;
	/**
	 * agregarPhb es la opcion de agregar un producto de hogar baño
	 * listarPhb es la opcion de listar un producto de hogar baño
	 * eliminarPhb es la opcion de eliminar un producto de hogar baño
	 * actualizarPhb es la opcion de actualizar un producto de hogar baño
	 */
	private JMenuItem agregarPhb, listarPhb, eliminarPhb, actualizarPhb;
	/**
	 * agregarPhc es la opcion de agregar un producto de hogar cocina
	 * listarPhc es la opcion de listar un producto de hogar cocina
	 * eliminarPhc es la opcion de eliminar un producto de hogar cocina
	 * actualizarPhc es la opcion de actualizar un producto de hogar cocina
	 */
	private JMenuItem agregarPhc, listarPhc, eliminarPhc, actualizarPhc;
	/**
	 * agregarPoj es la opcion de agregar un producto de ocio juguete
	 * listarPoj es la opcion de listar un producto de ocio juguete
	 * eliminarPoj es la opcion de eliminar un producto de ocio juguete
	 * actualizarPoj es la opcion de actualizar un producto de ocio
	 */
	private JMenuItem agregarPoj, listarPoj, eliminarPoj, actualizarPoj;
	/**
	 * agregarPor es la opcion de agregar un producto de ocio ropa
	 * listarPor es la opcion de listar un producto de ocio ropa
	 * eliminarPor es la opcion de eliminar un producto de ocio ropa
	 * actualizarPor es la opcion de actualizar un producto de ocio ropa
	 */
	private JMenuItem agregarPor, listarPor, eliminarPor, actualizarPor;
	/**
	 * agregarPoe es la opcion de agregar un producto de oficina electrodomestico
	 * listarPoe es la opcion de listar un producto de oficina electrodomestico
	 * eliminarPoe es la opcion de eliminar un producto de oficina electrodomestico
	 * actualizarPoe es la opcion de actualizar un producto de oficina electrodomestico
	 */
	private JMenuItem agregarPoe, listarPoe, eliminarPoe, actualizarPoe;
	/**
	 * agregarPop es la opcion de agregar un producto de oficina papeleria
	 * listarPop es la opcion de listar un producto de oficina papeleria
	 * eliminarPop es la opcion de eliminar un producto de oficina papeleria
	 * actualizarPop es la opcion de actualizar un producto de oficina papeleria
	 */
	private JMenuItem agregarPop, listarPop, eliminarPop, actualizarPop;

	/**
	 * panelCardLayout es el panel que contendra los paneles de las operaciones de CRUD
	 */
	private PanelCardLayout panelCardLayout;

	/**
	 * Constructor de la clase {@link VentanaPostLogIn} que inicializa los atributos de la clase
	 */
	public VentanaPostLogIn() {
		setSize(1250, 650);
		setTitle("Administracion de productos");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelCardLayout = new PanelCardLayout();
		barraMenu = new JMenuBar();

		menu = new JMenu("Menu");
		productoHogarBanio = new JMenu("Producto Hogar Baño");
		productoHogarCocina = new JMenu("Producto Hogar Cocina");
		productoOcioJuguete = new JMenu("Producto Ocio Juguete");
		productoOcioRopa = new JMenu("Producto Ocio Ropa");
		productoOficinaElectrodomestico = new JMenu("Producto Oficina Electrodomestico");
		productoOficianPapeleria = new JMenu("Producto Oficina Papeleria");

		regresarAlInicio = new JMenuItem("Regresar al inicio");
		
		agregarPhb = new JMenuItem("Agregar");
		listarPhb = new JMenuItem("Listar");
		eliminarPhb = new JMenuItem("Eliminar");
		actualizarPhb = new JMenuItem("Actualizar");

		agregarPhc = new JMenuItem("Agregar");
		listarPhc = new JMenuItem("Listar");
		eliminarPhc = new JMenuItem("Eliminar");
		actualizarPhc = new JMenuItem("Actualizar");

		agregarPoj = new JMenuItem("Agregar");
		listarPoj = new JMenuItem("Listar");
		eliminarPoj = new JMenuItem("Eliminar");
		actualizarPoj = new JMenuItem("Actualizar");

		agregarPor = new JMenuItem("Agregar");
		listarPor = new JMenuItem("Listar");
		eliminarPor = new JMenuItem("Eliminar");
		actualizarPor = new JMenuItem("Actualizar");

		agregarPoe = new JMenuItem("Agregar");
		listarPoe = new JMenuItem("Listar");
		eliminarPoe = new JMenuItem("Eliminar");
		actualizarPoe = new JMenuItem("Actualizar");

		agregarPop = new JMenuItem("Agregar");
		listarPop = new JMenuItem("Listar");
		eliminarPop = new JMenuItem("Eliminar");
		actualizarPop = new JMenuItem("Actualizar");

		productoHogarBanio.add(agregarPhb);
		productoHogarBanio.add(listarPhb);
		productoHogarBanio.add(eliminarPhb);
		productoHogarBanio.add(actualizarPhb);

		productoHogarCocina.add(agregarPhc);
		productoHogarCocina.add(listarPhc);
		productoHogarCocina.add(eliminarPhc);
		productoHogarCocina.add(actualizarPhc);

		productoOcioJuguete.add(agregarPoj);
		productoOcioJuguete.add(listarPoj);
		productoOcioJuguete.add(eliminarPoj);
		productoOcioJuguete.add(actualizarPoj);

		productoOcioRopa.add(agregarPor);
		productoOcioRopa.add(listarPor);
		productoOcioRopa.add(eliminarPor);
		productoOcioRopa.add(actualizarPor);

		productoOficinaElectrodomestico.add(agregarPoe);
		productoOficinaElectrodomestico.add(listarPoe);
		productoOficinaElectrodomestico.add(eliminarPoe);
		productoOficinaElectrodomestico.add(actualizarPoe);

		productoOficianPapeleria.add(agregarPop);
		productoOficianPapeleria.add(listarPop);
		productoOficianPapeleria.add(eliminarPop);
		productoOficianPapeleria.add(actualizarPop);
		
		menu.add(regresarAlInicio);

		barraMenu.add(menu);
		barraMenu.add(productoHogarBanio);
		barraMenu.add(productoHogarCocina);
		barraMenu.add(productoOcioJuguete);
		barraMenu.add(productoOcioRopa);
		barraMenu.add(productoOficinaElectrodomestico);
		barraMenu.add(productoOficianPapeleria);

		barraMenu.setBackground(Color.DARK_GRAY);
		menu.setForeground(Color.white);
		productoHogarCocina.setForeground(Color.white);
		productoHogarBanio.setForeground(Color.white);
		productoOcioJuguete.setForeground(Color.white);
		productoOcioRopa.setForeground(Color.white);
		productoOficianPapeleria.setForeground(Color.white);
		productoOficinaElectrodomestico.setForeground(Color.white);
		setJMenuBar(barraMenu);
		add(panelCardLayout);




	}


	/**
	 * Este metodo retorna el valor del atributo panelCardLayout
	 * @return panelCardLayout
	 */
	public PanelCardLayout getPanelCardLayout() {
		return panelCardLayout;
	}


	/**
	 * Este metodo modifica el valor del atributo panelCardLayout
	 * @param panelCardLayout
	 */
	public void setPanelCardLayout(PanelCardLayout panelCardLayout) {
		this.panelCardLayout = panelCardLayout;
	}


	/**
	 * Este metodo retorna el valor del atributo barraMenu
	 * @return barraMenu
	 */
	public JMenuBar getBarraMenu() {
		return barraMenu;
	}

	/**
	 * Este metodo modifica el valor del atributo barraMenu
	 * @param barraMenu
	 */

	public void setBarraMenu(JMenuBar barraMenu) {
		this.barraMenu = barraMenu;
	}


	/**
	 * Este metodo retorna el valor del atributo agregarPhb
	 * @return agregarPhb
	 */
	public JMenuItem getAgregarPhb() {
		return agregarPhb;
	}


  
	/**
	 * Este metodo modifica el valor del atributo agregarPhb
	 * @param agregarPhb
	 */
	public void setAgregarPhb(JMenuItem agregarPhb) {
		this.agregarPhb = agregarPhb;
	}

	/**
	 * Este metodo retorna el valor del atributo listarPhb
	 * @return listarPhb
	 */
	public JMenuItem getListarPhb() {
		return listarPhb;
	}


	/**
	 * Este metodo modifica el valor del atributo listarPhb
	 * @param listarPhb
	 */
	public void setListarPhb(JMenuItem listarPhb) {
		this.listarPhb = listarPhb;
	}

	/**
	 * Este metodo retorna el valor del atributo eliminarPhb
	 * @return eliminarPhb
	 */
	public JMenuItem getEliminarPhb() {
		return eliminarPhb;
	}


	/**
	 * Este metodo modifica el valor del atributo eliminarPhb
	 * @param eliminarPhb
	 */
	public void setEliminarPhb(JMenuItem eliminarPhb) {
		this.eliminarPhb = eliminarPhb;
	}


	/**
	 * Este metodo retorna el valor del atributo actualizarPhb
	 * @return actualizarPhb
	 */
	public JMenuItem getActualizarPhb() {
		return actualizarPhb;
	}


	/**
	 * Este metodo modifica el valor del atributo actualizarPhb
	 * @param actualizarPhb
	 */
	public void setActualizarPhb(JMenuItem actualizarPhb) {
		this.actualizarPhb = actualizarPhb;
	}


	/**
	 * Este metodo retorna el valor del atributo agregarPhc
	 * @return agregarPhc
	 */
	public JMenuItem getAgregarPhc() {
		return agregarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo agregarPhc
	 * @param agregarPhc
	 */
	public void setAgregarPhc(JMenuItem agregarPhc) {
		this.agregarPhc = agregarPhc;
	}


	/**
	 * Este metodo retorna el valor del atributo listarPhc
	 * @return listarPhc
	 */
	public JMenuItem getListarPhc() {
		return listarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo listarPhc
	 * @param listarPhc
	 */
	public void setListarPhc(JMenuItem listarPhc) {
		this.listarPhc = listarPhc;
	}



	/**
	 * Este metodo retorna el valor del atributo eliminarPhc
	 * @return eliminarPhc
	 */
	public JMenuItem getEliminarPhc() {
		return eliminarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo eliminarPhc
	 * @param eliminarPhc
	 */
	public void setEliminarPhc(JMenuItem eliminarPhc) {
		this.eliminarPhc = eliminarPhc;
	}


	/**
	 * Este metodo retorna el valor del atributo actualizarPhc
	 * @return actualizarPhc
	 */
	public JMenuItem getActualizarPhc() {
		return actualizarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo actualizarPhc
	 * @param actualizarPhc
	 */
	public void setActualizarPhc(JMenuItem actualizarPhc) {
		this.actualizarPhc = actualizarPhc;
	}


	/**
	 * Este metodo retorna el valor del atributo agregarPoj
	 * @return agregarPoj
	 */
	public JMenuItem getAgregarPoj() {
		return agregarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo agregarPoj
	 * @param agregarPoj
	 */
	public void setAgregarPoj(JMenuItem agregarPoj) {
		this.agregarPoj = agregarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo listarPoj
	 * @return listarPoj
	 */
	public JMenuItem getListarPoj() {
		return listarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo listarPoj
	 * @param listarPoj
	 */
	public void setListarPoj(JMenuItem listarPoj) {
		this.listarPoj = listarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo eliminarPoj
	 * @return eliminarPoj
	 */
	public JMenuItem getEliminarPoj() {
		return eliminarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo eliminarPoj
	 * @param eliminarPoj
	 */
	public void setEliminarPoj(JMenuItem eliminarPoj) {
		this.eliminarPoj = eliminarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo actualizarPoj
	 * @return actualizarPoj
	 */
	public JMenuItem getActualizarPoj() {
		return actualizarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo actualizarPoj
	 * @param actualizarPoj
	 */
	public void setActualizarPoj(JMenuItem actualizarPoj) {
		this.actualizarPoj = actualizarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo agregarPor
	 * @return agregarPor
	 */
	public JMenuItem getAgregarPor() {
		return agregarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo agregarPor
	 * @param agregarPor
	 */
	public void setAgregarPor(JMenuItem agregarPor) {
		this.agregarPor = agregarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo listarPor
	 * @return listarPor
	 */
	public JMenuItem getListarPor() {
		return listarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo listarPor
	 * @param listarPor
	 */
	public void setListarPor(JMenuItem listarPor) {
		this.listarPor = listarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo eliminarPor
	 * @return eliminarPor
	 */
	public JMenuItem getEliminarPor() {
		return eliminarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo eliminarPor
	 * @param eliminarPor
	 */
	public void setEliminarPor(JMenuItem eliminarPor) {
		this.eliminarPor = eliminarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo actualizarPor
	 * @return actualizarPor
	 */
	public JMenuItem getActualizarPor() {
		return actualizarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo actualizarPor
	 * @param actualizarPor
	 */
	public void setActualizarPor(JMenuItem actualizarPor) {
		this.actualizarPor = actualizarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo agregarPoe
	 * @return agregarPoe
	 */
	public JMenuItem getAgregarPoe() {
		return agregarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo agregarPoe
	 * @param agregarPoe
	 */
	public void setAgregarPoe(JMenuItem agregarPoe) {
		this.agregarPoe = agregarPoe;
	}


	/**
	 * Este metodo retorna el valor del atributo listarPoe
	 * @return listarPoe
	 */
	public JMenuItem getListarPoe() {
		return listarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo listarPoe
	 * @param listarPoe
	 */
	public void setListarPoe(JMenuItem listarPoe) {
		this.listarPoe = listarPoe;
	}





	/**
	 * Este metodo retorna el valor del atributo eliminarPoe
	 * @return eliminarPoe
	 */
	public JMenuItem getEliminarPoe() {
		return eliminarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo eliminarPoe
	 * @param eliminarPoe
	 */
	public void setEliminarPoe(JMenuItem eliminarPoe) {
		this.eliminarPoe = eliminarPoe;
	}


	/**
	 * Este metodo retorna el valor del atributo actualizarPoe
	 * @return actualizarPoe
	 */
	public JMenuItem getActualizarPoe() {
		return actualizarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo actualizarPoe
	 * @param actualizarPoe
	 */
	public void setActualizarPoe(JMenuItem actualizarPoe) {
		this.actualizarPoe = actualizarPoe;
	}


	/**
	 * Este metodo retorna el valor del atributo agregarPop
	 * @return agregarPop
	 */
	public JMenuItem getAgregarPop() {
		return agregarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo agregarPop
	 * @param agregarPop
	 */
	public void setAgregarPop(JMenuItem agregarPop) {
		this.agregarPop = agregarPop;
	}


	/**
	 * Este metodo retorna el valor del atributo listarPop
	 * @return listarPop
	 */
	public JMenuItem getListarPop() {
		return listarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo listarPop
	 * @param listarPop
	 */
	public void setListarPop(JMenuItem listarPop) {
		this.listarPop = listarPop;
	}


	/**
	 * Este metodo retorna el valor del atributo eliminarPop
	 * @return eliminarPop
	 */
	public JMenuItem getEliminarPop() {
		return eliminarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo eliminarPop
	 * @param eliminarPop
	 */
	public void setEliminarPop(JMenuItem eliminarPop) {
		this.eliminarPop = eliminarPop;
	}


	/**
	 * Este metodo retorna el valor del atributo actualizarPop
	 * @return actualizarPop
	 */
	public JMenuItem getActualizarPop() {
		return actualizarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo actualizarPop
	 * @param actualizarPop
	 */
	public void setActualizarPop(JMenuItem actualizarPop) {
		this.actualizarPop = actualizarPop;
	}


	public JMenuItem getRegresarAlInicio() {
		return regresarAlInicio;
	}


	public void setRegresarAlInicio(JMenuItem regresarAlInicio) {
		this.regresarAlInicio = regresarAlInicio;
	}


	public JMenu getMenu() {
		return menu;
	}


	public void setMenu(JMenu menu) {
		this.menu = menu;
	}


	public JMenu getProductoHogarBanio() {
		return productoHogarBanio;
	}


	public void setProductoHogarBanio(JMenu productoHogarBanio) {
		this.productoHogarBanio = productoHogarBanio;
	}


	public JMenu getProductoHogarCocina() {
		return productoHogarCocina;
	}


	public void setProductoHogarCocina(JMenu productoHogarCocina) {
		this.productoHogarCocina = productoHogarCocina;
	}


	public JMenu getProductoOcioJuguete() {
		return productoOcioJuguete;
	}


	public void setProductoOcioJuguete(JMenu productoOcioJuguete) {
		this.productoOcioJuguete = productoOcioJuguete;
	}


	public JMenu getProductoOcioRopa() {
		return productoOcioRopa;
	}


	public void setProductoOcioRopa(JMenu productoOcioRopa) {
		this.productoOcioRopa = productoOcioRopa;
	}


	public JMenu getProductoOficinaElectrodomestico() {
		return productoOficinaElectrodomestico;
	}


	public void setProductoOficinaElectrodomestico(JMenu productoOficinaElectrodomestico) {
		this.productoOficinaElectrodomestico = productoOficinaElectrodomestico;
	}


	public JMenu getProductoOficianPapeleria() {
		return productoOficianPapeleria;
	}


	public void setProductoOficianPapeleria(JMenu productoOficianPapeleria) {
		this.productoOficianPapeleria = productoOficianPapeleria;
	}


}
