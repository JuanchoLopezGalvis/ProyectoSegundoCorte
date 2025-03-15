package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
	private JMenu pructoHogarBanio, productoHogarCocina, productoOcioJuguete, productoOcioRopa, productoOficinaElectrodomestico, productoOficianPapeleria;
	/**
	 * agregarPhb es la opcion de agregar un producto de hogar baño
	 * listarPhb es la opcion de listar un producto de hogar baño
	 * buscarPhb es la opcion de buscar un producto de hogar baño
	 * eliminarPhb es la opcion de eliminar un producto de hogar baño
	 * actualizarPhb es la opcion de actualizar un producto de hogar baño
	 */
	private JMenuItem agregarPhb, listarPhb, buscarPhb, eliminarPhb, actualizarPhb;
	/**
	 * agregarPhc es la opcion de agregar un producto de hogar cocina
	 * listarPhc es la opcion de listar un producto de hogar cocina
	 * buscarPhc es la opcion de buscar un producto de hogar cocina
	 * eliminarPhc es la opcion de eliminar un producto de hogar cocina
	 * actualizarPhc es la opcion de actualizar un producto de hogar cocina
	 */
	private JMenuItem agregarPhc, listarPhc, buscarPhc, eliminarPhc, actualizarPhc;
	/**
	 * agregarPoj es la opcion de agregar un producto de ocio juguete
	 * listarPoj es la opcion de listar un producto de ocio juguete
	 * buscarPoj es la opcion de buscar un producto de ocio juguete
	 * eliminarPoj es la opcion de eliminar un producto de ocio juguete
	 * actualizarPoj es la opcion de actualizar un producto de ocio
	 */
	private JMenuItem agregarPoj, listarPoj, buscarPoj, eliminarPoj, actualizarPoj;
	/**
	 * agregarPor es la opcion de agregar un producto de ocio ropa
	 * listarPor es la opcion de listar un producto de ocio ropa
	 * buscarPor es la opcion de buscar un producto de ocio ropa
	 * eliminarPor es la opcion de eliminar un producto de ocio ropa
	 * actualizarPor es la opcion de actualizar un producto de ocio ropa
	 */
	private JMenuItem agregarPor, listarPor, buscarPor, eliminarPor, actualizarPor;
	/**
	 * agregarPoe es la opcion de agregar un producto de oficina electrodomestico
	 * listarPoe es la opcion de listar un producto de oficina electrodomestico
	 * buscarPoe es la opcion de buscar un producto de oficina electrodomestico
	 * eliminarPoe es la opcion de eliminar un producto de oficina electrodomestico
	 * actualizarPoe es la opcion de actualizar un producto de oficina electrodomestico
	 */
	private JMenuItem agregarPoe, listarPoe, buscarPoe, eliminarPoe, actualizarPoe;
	/**
	 * agregarPop es la opcion de agregar un producto de oficina papeleria
	 * listarPop es la opcion de listar un producto de oficina papeleria
	 * buscarPop es la opcion de buscar un producto de oficina papeleria
	 * eliminarPop es la opcion de eliminar un producto de oficina papeleria
	 * actualizarPop es la opcion de actualizar un producto de oficina papeleria
	 */
	private JMenuItem agregarPop, listarPop, buscarPop, eliminarPop, actualizarPop;


	/**
	 * Constructor de la clase {@link VentanaPostLogIn} que inicializa los atributos de la clase
	 */
	public VentanaPostLogIn() {
		setSize(1250, 650);
		setTitle("Administracion de productos");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(new BorderLayout());

		barraMenu = new JMenuBar();

		pructoHogarBanio = new JMenu("Producto Hogar Baño");
		productoHogarCocina = new JMenu("Producto Hogar Cocina");
		productoOcioJuguete = new JMenu("Producto Ocio Juguete");
		productoOcioRopa = new JMenu("Producto Ocio Ropa");
		productoOficinaElectrodomestico = new JMenu("Producto Oficina Electrodomestico");
		productoOficianPapeleria = new JMenu("Producto Oficina Papeleria");

		agregarPhb = new JMenuItem("Agregar");
		listarPhb = new JMenuItem("Listar");
		buscarPhb = new JMenuItem("Buscar");
		eliminarPhb = new JMenuItem("Eliminar");
		actualizarPhb = new JMenuItem("Actualizar");

		agregarPhc = new JMenuItem("Agregar");
		listarPhc = new JMenuItem("Listar");
		buscarPhc = new JMenuItem("Buscar");
		eliminarPhc = new JMenuItem("Eliminar");
		actualizarPhc = new JMenuItem("Actualizar");

		agregarPoj = new JMenuItem("Agregar");
		listarPoj = new JMenuItem("Listar");
		buscarPoj = new JMenuItem("Buscar");
		eliminarPoj = new JMenuItem("Eliminar");
		actualizarPoj = new JMenuItem("Actualizar");

		agregarPor = new JMenuItem("Agregar");
		listarPor = new JMenuItem("Listar");
		buscarPor = new JMenuItem("Buscar");
		eliminarPor = new JMenuItem("Eliminar");
		actualizarPor = new JMenuItem("Actualizar");

		agregarPoe = new JMenuItem("Agregar");
		listarPoe = new JMenuItem("Listar");
		buscarPoe = new JMenuItem("Buscar");
		eliminarPoe = new JMenuItem("Eliminar");
		actualizarPoe = new JMenuItem("Actualizar");

		agregarPop = new JMenuItem("Agregar");
		listarPop = new JMenuItem("Listar");
		buscarPop = new JMenuItem("Buscar");
		eliminarPop = new JMenuItem("Eliminar");
		actualizarPop = new JMenuItem("Actualizar");

		pructoHogarBanio.add(agregarPhb);
		pructoHogarBanio.add(listarPhb);
		pructoHogarBanio.add(buscarPhb);
		pructoHogarBanio.add(eliminarPhb);
		pructoHogarBanio.add(actualizarPhb);

		productoHogarCocina.add(agregarPhc);
		productoHogarCocina.add(listarPhc);
		productoHogarCocina.add(buscarPhc);
		productoHogarCocina.add(eliminarPhc);
		productoHogarCocina.add(actualizarPhc);

		productoOcioJuguete.add(agregarPoj);
		productoOcioJuguete.add(listarPoj);
		productoOcioJuguete.add(buscarPoj);
		productoOcioJuguete.add(eliminarPoj);
		productoOcioJuguete.add(actualizarPoj);

		productoOcioRopa.add(agregarPor);
		productoOcioRopa.add(listarPor);
		productoOcioRopa.add(buscarPor);
		productoOcioRopa.add(eliminarPor);
		productoOcioRopa.add(actualizarPor);

		productoOficinaElectrodomestico.add(agregarPoe);
		productoOficinaElectrodomestico.add(listarPoe);
		productoOficinaElectrodomestico.add(buscarPoe);
		productoOficinaElectrodomestico.add(eliminarPoe);
		productoOficinaElectrodomestico.add(actualizarPoe);

		productoOficianPapeleria.add(agregarPop);
		productoOficianPapeleria.add(listarPop);
		productoOficianPapeleria.add(buscarPop);
		productoOficianPapeleria.add(eliminarPop);
		productoOficianPapeleria.add(actualizarPop);

		barraMenu.add(pructoHogarBanio);
		barraMenu.add(productoHogarCocina);
		barraMenu.add(productoOcioJuguete);
		barraMenu.add(productoOcioRopa);
		barraMenu.add(productoOficinaElectrodomestico);
		barraMenu.add(productoOficianPapeleria);

		setJMenuBar(barraMenu);




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
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getAgregarPhb() {
		return agregarPhb;
	}

	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */

	public void setAgregarPhb(JMenuItem agregarPhb) {
		this.agregarPhb = agregarPhb;
	}

	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */

	public JMenuItem getListarPhb() {
		return listarPhb;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setListarPhb(JMenuItem listarPhb) {
		this.listarPhb = listarPhb;
	}
	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */

	public JMenuItem getBuscarPhb() {
		return buscarPhb;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setBuscarPhb(JMenuItem buscarPhb) {
		this.buscarPhb = buscarPhb;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getEliminarPhb() {
		return eliminarPhb;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setEliminarPhb(JMenuItem eliminarPhb) {
		this.eliminarPhb = eliminarPhb;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getActualizarPhb() {
		return actualizarPhb;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setActualizarPhb(JMenuItem actualizarPhb) {
		this.actualizarPhb = actualizarPhb;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getAgregarPhc() {
		return agregarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setAgregarPhc(JMenuItem agregarPhc) {
		this.agregarPhc = agregarPhc;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getListarPhc() {
		return listarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setListarPhc(JMenuItem listarPhc) {
		this.listarPhc = listarPhc;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getBuscarPhc() {
		return buscarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setBuscarPhc(JMenuItem buscarPhc) {
		this.buscarPhc = buscarPhc;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getEliminarPhc() {
		return eliminarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setEliminarPhc(JMenuItem eliminarPhc) {
		this.eliminarPhc = eliminarPhc;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getActualizarPhc() {
		return actualizarPhc;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setActualizarPhc(JMenuItem actualizarPhc) {
		this.actualizarPhc = actualizarPhc;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getAgregarPoj() {
		return agregarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setAgregarPoj(JMenuItem agregarPoj) {
		this.agregarPoj = agregarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getListarPoj() {
		return listarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setListarPoj(JMenuItem listarPoj) {
		this.listarPoj = listarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getBuscarPoj() {
		return buscarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setBuscarPoj(JMenuItem buscarPoj) {
		this.buscarPoj = buscarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getEliminarPoj() {
		return eliminarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setEliminarPoj(JMenuItem eliminarPoj) {
		this.eliminarPoj = eliminarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getActualizarPoj() {
		return actualizarPoj;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setActualizarPoj(JMenuItem actualizarPoj) {
		this.actualizarPoj = actualizarPoj;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getAgregarPor() {
		return agregarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setAgregarPor(JMenuItem agregarPor) {
		this.agregarPor = agregarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getListarPor() {
		return listarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setListarPor(JMenuItem listarPor) {
		this.listarPor = listarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getBuscarPor() {
		return buscarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setBuscarPor(JMenuItem buscarPor) {
		this.buscarPor = buscarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getEliminarPor() {
		return eliminarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setEliminarPor(JMenuItem eliminarPor) {
		this.eliminarPor = eliminarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getActualizarPor() {
		return actualizarPor;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setActualizarPor(JMenuItem actualizarPor) {
		this.actualizarPor = actualizarPor;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getAgregarPoe() {
		return agregarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setAgregarPoe(JMenuItem agregarPoe) {
		this.agregarPoe = agregarPoe;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getListarPoe() {
		return listarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setListarPoe(JMenuItem listarPoe) {
		this.listarPoe = listarPoe;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getBuscarPoe() {
		return buscarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setBuscarPoe(JMenuItem buscarPoe) {
		this.buscarPoe = buscarPoe;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getEliminarPoe() {
		return eliminarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setEliminarPoe(JMenuItem eliminarPoe) {
		this.eliminarPoe = eliminarPoe;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getActualizarPoe() {
		return actualizarPoe;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setActualizarPoe(JMenuItem actualizarPoe) {
		this.actualizarPoe = actualizarPoe;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getAgregarPop() {
		return agregarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setAgregarPop(JMenuItem agregarPop) {
		this.agregarPop = agregarPop;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getListarPop() {
		return listarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setListarPop(JMenuItem listarPop) {
		this.listarPop = listarPop;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getBuscarPop() {
		return buscarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setBuscarPop(JMenuItem buscarPop) {
		this.buscarPop = buscarPop;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getEliminarPop() {
		return eliminarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setEliminarPop(JMenuItem eliminarPop) {
		this.eliminarPop = eliminarPop;
	}


	/**
	 * Este metodo retorna el valor del atributo pructoHogarBanio
	 * @return pructoHogarBanio
	 */
	public JMenuItem getActualizarPop() {
		return actualizarPop;
	}


	/**
	 * Este metodo modifica el valor del atributo pructoHogarBanio
	 * @param pructoHogarBanio
	 */
	public void setActualizarPop(JMenuItem actualizarPop) {
		this.actualizarPop = actualizarPop;
	}


}
