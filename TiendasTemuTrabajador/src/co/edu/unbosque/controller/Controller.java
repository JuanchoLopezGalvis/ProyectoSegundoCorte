package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.ProductoHogarBanio;
import co.edu.unbosque.model.ProductoHogarCocina;
import co.edu.unbosque.model.ProductoOcioJuguete;
import co.edu.unbosque.model.ProductoOcioRopa;
import co.edu.unbosque.model.ProductoOficinaElectrodomestico;
import co.edu.unbosque.model.ProductoOficinaPapeleria;
import co.edu.unbosque.model.Trabajador;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.view.ViewFacade;

/**
 * El {@link Controller} tendra la resposabilidad de darle la visibilidad 
 * a cada una de las ventanas del aplicativo y agregarle eventos a todos los elementos que
 * lo requieren:
 * Botones, etiquetas, comboBox, etc.
 */

public class Controller implements ActionListener{

	/**
	 * Instancia de la {@link ModelFacade} para acceder a los metodos de la logica de los productos.
	 */
	private ModelFacade mf;
	/**
	 * Instacia de la {@link ViewFacade} para acceder a todas las
	 * ventanas del aplicativo.
	 */
	private ViewFacade vf; 
	/**
	 * Instancia de la clase {@link Properties} para acceder a los archivos de propiedades.
	 */
	private Properties prop;
	/**
	 * Constructor vacio del {@link Controller}.
	 */
	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		mf.getProductoHogarBanioDAO().listar(vf.getVpli().getPanelCardLayout().getPlphb().getTabla(), vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes());
		mf.getProductoHogarCocinaDAO().listar(vf.getVpli().getPanelCardLayout().getPlphc().getTabla(), vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes());
		mf.getProductoOcioJugueteDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoj().getTabla(), vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes());
		mf.getProductoOcioRopaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpor().getTabla(), vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes());
		mf.getProductoOficinaElectrodomesticoDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoe().getTabla(), vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes());
		mf.getProductoOficinaPapeleriaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpop().getTabla(), vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes());
	}
	/**
	 * La funcion run permite el inicio de la ejecución
	 * del aplicativo dandole visibilidad a la venta principal.
	 */
	public void run() {

		FileManager.crearCarpeta();
		prop = new Properties();
		vf.getVli().setVisible(true);
		vf.getVpli().setVisible(false);
		asignarLectores();

	}

	/**
	 * La funcion asignarLectores se encargara de asignarle
	 * a cada uno de los botones de las ventanas del aplicativo
	 * un evento y un comando de accion.
	 */
	public void asignarLectores() {

		vf.getVli().getPli().getBtnIngresar().addActionListener(this);
		vf.getVli().getPli().getBtnIngresar().setActionCommand("btnIngresar");
		vf.getVli().getPli().getBtnRegistrarse().addActionListener(this);
		vf.getVli().getPli().getBtnRegistrarse().setActionCommand("btnRegistrarse");


		vf.getVpli().getPanelCardLayout().getPagphb().getBotonAgregar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPagphb().getBotonAgregar().setActionCommand("btnAgregarPhb");
		vf.getVpli().getPanelCardLayout().getPagphc().getBotonAgregar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPagphc().getBotonAgregar().setActionCommand("btnAgregarPhc");
		vf.getVpli().getPanelCardLayout().getPagpoj().getBotonAgregar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPagpoj().getBotonAgregar().setActionCommand("btnAgregarPoj");
		vf.getVpli().getPanelCardLayout().getPagpor().getBotonAgregar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPagpor().getBotonAgregar().setActionCommand("btnAgregarPor");
		vf.getVpli().getPanelCardLayout().getPagpoe().getBotonAgregar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPagpoe().getBotonAgregar().setActionCommand("btnAgregarPoe");
		vf.getVpli().getPanelCardLayout().getPagpop().getBotonAgregar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPagpop().getBotonAgregar().setActionCommand("btnAgregarPop");
		vf.getVsu().getPanelSignUp().getBotonAgregarTrabajador().addActionListener(this);
		vf.getVsu().getPanelSignUp().getBotonAgregarTrabajador().setActionCommand("btnAgregarTrabajador");
		
		vf.getVpli().getPanelCardLayout().getPephb().getBotonEliminar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPephb().getBotonEliminar().setActionCommand("btnEliminarPhb");
		vf.getVpli().getPanelCardLayout().getPephc().getBotonEliminar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPephc().getBotonEliminar().setActionCommand("btnEliminarPhc");
		vf.getVpli().getPanelCardLayout().getPepoj().getBotonEliminar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPepoj().getBotonEliminar().setActionCommand("btnEliminarPoj");
		vf.getVpli().getPanelCardLayout().getPepor().getBotonEliminar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPepor().getBotonEliminar().setActionCommand("btnEliminarPor");
		vf.getVpli().getPanelCardLayout().getPepoe().getBotonEliminar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPepoe().getBotonEliminar().setActionCommand("btnEliminarPoe");
		vf.getVpli().getPanelCardLayout().getPepop().getBotonEliminar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPepop().getBotonEliminar().setActionCommand("btnEliminarPop");
		
		vf.getVpli().getPanelCardLayout().getPacphb().getBotonActualizar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPacphb().getBotonActualizar().setActionCommand("btnActualizarPhb");
		vf.getVpli().getPanelCardLayout().getPacphc().getBotonActualizar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPacphc().getBotonActualizar().setActionCommand("btnActualizarPhc");
		vf.getVpli().getPanelCardLayout().getPacpoj().getBotonActualizar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPacpoj().getBotonActualizar().setActionCommand("btnActualizarPoj");
		vf.getVpli().getPanelCardLayout().getPacpor().getBotonActualizar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPacpor().getBotonActualizar().setActionCommand("btnActualizarPor");
		vf.getVpli().getPanelCardLayout().getPacpoe().getBotonActualizar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPacpoe().getBotonActualizar().setActionCommand("btnActualizarPoe");
		vf.getVpli().getPanelCardLayout().getPacpop().getBotonActualizar().addActionListener(this);
		vf.getVpli().getPanelCardLayout().getPacpop().getBotonActualizar().setActionCommand("btnActualizarPop");
		
		vf.getVpli().getRegresarAlInicio().addActionListener(this);
		vf.getVpli().getRegresarAlInicio().setActionCommand("volverAlInicio");

		vf.getVpli().getAgregarPhb().addActionListener(this);
		vf.getVpli().getAgregarPhb().setActionCommand("agregarPhb");
		vf.getVpli().getAgregarPhc().addActionListener(this);
		vf.getVpli().getAgregarPhc().setActionCommand("agregarPhc");
		vf.getVpli().getAgregarPoj().addActionListener(this);
		vf.getVpli().getAgregarPoj().setActionCommand("agregarPoj");
		vf.getVpli().getAgregarPor().addActionListener(this);
		vf.getVpli().getAgregarPor().setActionCommand("agregarPor");
		vf.getVpli().getAgregarPoe().addActionListener(this);
		vf.getVpli().getAgregarPoe().setActionCommand("agregarPoe");
		vf.getVpli().getAgregarPop().addActionListener(this);
		vf.getVpli().getAgregarPop().setActionCommand("agregarPop");

		vf.getVpli().getActualizarPhb().addActionListener(this);
		vf.getVpli().getActualizarPhb().setActionCommand("actualizarPhb");
		vf.getVpli().getActualizarPhc().addActionListener(this);
		vf.getVpli().getActualizarPhc().setActionCommand("actualizarPhc");
		vf.getVpli().getActualizarPoj().addActionListener(this);
		vf.getVpli().getActualizarPoj().setActionCommand("actualizarPoj");
		vf.getVpli().getActualizarPor().addActionListener(this);
		vf.getVpli().getActualizarPor().setActionCommand("actualizarPor");
		vf.getVpli().getActualizarPoe().addActionListener(this);
		vf.getVpli().getActualizarPoe().setActionCommand("actualizarPoe");
		vf.getVpli().getActualizarPop().addActionListener(this);
		vf.getVpli().getActualizarPop().setActionCommand("actualizarPop");

		vf.getVpli().getAgregarPhb().addActionListener(this);
		vf.getVpli().getAgregarPhb().setActionCommand("agregarPhb");
		vf.getVpli().getAgregarPhc().addActionListener(this);
		vf.getVpli().getAgregarPhc().setActionCommand("agregarPhc");
		vf.getVpli().getAgregarPoj().addActionListener(this);
		vf.getVpli().getAgregarPoj().setActionCommand("agregarPoj");
		vf.getVpli().getAgregarPor().addActionListener(this);
		vf.getVpli().getAgregarPor().setActionCommand("agregarPor");
		vf.getVpli().getAgregarPoe().addActionListener(this);
		vf.getVpli().getAgregarPoe().setActionCommand("agregarPoe");
		vf.getVpli().getAgregarPop().addActionListener(this);
		vf.getVpli().getAgregarPop().setActionCommand("agregarPop");

		vf.getVpli().getActualizarPhb().addActionListener(this);
		vf.getVpli().getActualizarPhb().setActionCommand("actualizarPhb");
		vf.getVpli().getActualizarPhc().addActionListener(this);
		vf.getVpli().getActualizarPhc().setActionCommand("actualizarPhc");
		vf.getVpli().getActualizarPoj().addActionListener(this);
		vf.getVpli().getActualizarPoj().setActionCommand("actualizarPoj");
		vf.getVpli().getActualizarPor().addActionListener(this);
		vf.getVpli().getActualizarPor().setActionCommand("actualizarPor");
		vf.getVpli().getActualizarPoe().addActionListener(this);
		vf.getVpli().getActualizarPoe().setActionCommand("actualizarPoe");
		vf.getVpli().getActualizarPop().addActionListener(this);
		vf.getVpli().getActualizarPop().setActionCommand("actualizarPop");


		vf.getVpli().getEliminarPhb().addActionListener(this);
		vf.getVpli().getEliminarPhb().setActionCommand("eliminarPhb");
		vf.getVpli().getEliminarPhc().addActionListener(this);
		vf.getVpli().getEliminarPhc().setActionCommand("eliminarPhc");
		vf.getVpli().getEliminarPoj().addActionListener(this);
		vf.getVpli().getEliminarPoj().setActionCommand("eliminarPoj");
		vf.getVpli().getEliminarPor().addActionListener(this);
		vf.getVpli().getEliminarPor().setActionCommand("eliminarPor");
		vf.getVpli().getEliminarPoe().addActionListener(this);
		vf.getVpli().getEliminarPoe().setActionCommand("eliminarPoe");
		vf.getVpli().getEliminarPop().addActionListener(this);
		vf.getVpli().getEliminarPop().setActionCommand("eliminarPop");

		vf.getVpli().getListarPhb().addActionListener(this);
		vf.getVpli().getListarPhb().setActionCommand("listarPhb");
		vf.getVpli().getListarPhc().addActionListener(this);
		vf.getVpli().getListarPhc().setActionCommand("listarPhc");
		vf.getVpli().getListarPoj().addActionListener(this);
		vf.getVpli().getListarPoj().setActionCommand("listarPoj");
		vf.getVpli().getListarPor().addActionListener(this);
		vf.getVpli().getListarPor().setActionCommand("listarPor");
		vf.getVpli().getListarPoe().addActionListener(this);
		vf.getVpli().getListarPoe().setActionCommand("listarPoe");
		vf.getVpli().getListarPop().addActionListener(this);
		vf.getVpli().getListarPop().setActionCommand("listarPop");

		vf.getVli().getPli().getCheckEspañol().addActionListener(this);
		vf.getVli().getPli().getCheckEspañol().setActionCommand("checkEspañol");
		vf.getVli().getPli().getCheckIngles().addActionListener(this);
		vf.getVli().getPli().getCheckIngles().setActionCommand("checkIngles");

	}
	/**
	 * La funcion actionPerformed se encargara de asignarle
	 * a cada uno de los botones de las ventanas del aplicativo
	 * un evento y un comando de accion.
	 * @param e es el evento que se le asignara a cada uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "btnActualizarPhb":{
			String nombre = vf.getVpli().getPanelCardLayout().getPacphb().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacphb().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacphb().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacphb().getDatoMarca().getText();
			String material = vf.getVpli().getPanelCardLayout().getPacphb().getDatoMaterial().getText();
			String color = vf.getVpli().getPanelCardLayout().getPacphb().getDatoColor().getText();
			String zona = vf.getVpli().getPanelCardLayout().getPacphb().getDatoZona().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacphb().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || material.isEmpty() || color.isEmpty() || zona.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoHogarBanioDAO().actualizar(new ProductoHogarBanio(nombre, precio, cantidad, marca, imagen, material, color, zona), vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes(),  "Producto actualizado", "No hay productos para actualizar");
			mf.getProductoHogarBanioDAO().listar(vf.getVpli().getPanelCardLayout().getPlphb().getTabla(),vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes(),vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacphb().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacphb().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacphb().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacphb().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacphb().getDatoMaterial().setText("");
			vf.getVpli().getPanelCardLayout().getPacphb().getDatoColor().setText("");
			vf.getVpli().getPanelCardLayout().getPacphb().getDatoZona().setText("");
			vf.getVpli().getPanelCardLayout().getPacphb().setImagenProducto(null);		

		}
		break;
		case "btnActualizarPhc":{
			String nombre = vf.getVpli().getPanelCardLayout().getPacphc().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacphc().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacphc().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacphc().getDatoMarca().getText();
			String material = vf.getVpli().getPanelCardLayout().getPacphc().getDatoMaterial().getText();
			String color = vf.getVpli().getPanelCardLayout().getPacphc().getDatoColor().getText();
			String funcionalidad = vf.getVpli().getPanelCardLayout().getPacphc().getDatoFuncionalidad().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacphc().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || material.isEmpty() || color.isEmpty() || funcionalidad.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}


			mf.getProductoHogarCocinaDAO().actualizar(new ProductoHogarCocina(nombre, precio, cantidad, marca, imagen, material, color, funcionalidad), vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes(), "Producto actualizado", "No hay productos para actualizar");
			mf.getProductoHogarCocinaDAO().listar(vf.getVpli().getPanelCardLayout().getPlphc().getTabla(), vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacphc().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacphc().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacphc().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacphc().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacphc().getDatoMaterial().setText("");
			vf.getVpli().getPanelCardLayout().getPacphc().getDatoColor().setText("");
			vf.getVpli().getPanelCardLayout().getPacphc().getDatoFuncionalidad().setText("");
			vf.getVpli().getPanelCardLayout().getPacphc().setImagenProducto(null);
		}
		break;
		case "btnActualizarPoj":{
			String nombre = vf.getVpli().getPanelCardLayout().getPacpoj().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoj().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoj().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacpoj().getDatoMarca().getText();
			String nivelDeCalidad = vf.getVpli().getPanelCardLayout().getPacpoj().getDatoNivelCalidad().getSelectedItem().toString();
			Number edadRecomendadaObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoj().getDatoEdadRecomendada().getValue();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacpoj().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeCalidad.equals("")  ) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null || edadRecomendadaObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();
			int edadRecomendada = edadRecomendadaObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoOcioJugueteDAO().actualizar(new ProductoOcioJuguete(nombre, precio, cantidad, marca, imagen, nivelDeCalidad, edadRecomendada), vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes(), "Producto actualizado", "No hay productos para actualizar");
			mf.getProductoOcioJugueteDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoj().getTabla(), vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoNivelCalidad().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoEdadRecomendada().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoj().setImagenProducto(null);
		}
		break;
		case "btnActualizarPor":{
			String nombre = vf.getVpli().getPanelCardLayout().getPacpor().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacpor().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacpor().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacpor().getDatoMarca().getText();
			String nivelDeCalidad = vf.getVpli().getPanelCardLayout().getPacpor().getDatoNivelCalidad().getSelectedItem().toString();
			String talla = vf.getVpli().getPanelCardLayout().getPacpor().getDatoTalla().getSelectedItem().toString();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacpor().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeCalidad.equals("") || talla.equals("")) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoOcioRopaDAO().actualizar(new ProductoOcioRopa(nombre, precio, cantidad, marca, imagen, nivelDeCalidad, talla), vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes(), "Producto actualizado", "No hay productos para actualizar");
			mf.getProductoOcioRopaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpor().getTabla(), vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoNivelCalidad().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoTalla().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpor().setImagenProducto(null);
		}
		break;
		case "btnActualizarPoe":{
			String nombre = vf.getVpli().getPanelCardLayout().getPacpoe().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoe().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoe().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacpoe().getDatoMarca().getText();
			String nivelDeRuido = vf.getVpli().getPanelCardLayout().getPacpoe().getDatoNivelRuido().getSelectedItem().toString();
			String consumoEnergetico = vf.getVpli().getPanelCardLayout().getPacpoe().getDatoConsumoEnergetico().getSelectedItem().toString();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacpoe().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeRuido.equals("") || consumoEnergetico.equals("") ) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoOficinaElectrodomesticoDAO().actualizar(new ProductoOficinaElectrodomestico(nombre, precio, cantidad, marca, imagen, nivelDeRuido, consumoEnergetico), vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes(), "Producto actualizado", "No hay productos para actualizar");
			mf.getProductoOficinaElectrodomesticoDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoe().getTabla(), vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoNivelRuido().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoConsumoEnergetico().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpoe().setImagenProducto(null);
			}
		break;			
		case "btnActualizarPop":{
			String nombre = vf.getVpli().getPanelCardLayout().getPacpop().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacpop().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacpop().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacpop().getDatoMarca().getText();
			String nivelDeRuido = vf.getVpli().getPanelCardLayout().getPacpop().getDatoNivelRuido().getSelectedItem().toString();
			String funcion = vf.getVpli().getPanelCardLayout().getPacpop().getDatoFuncion().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacpop().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeRuido.equals("") || funcion.isEmpty() ) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoOficinaPapeleriaDAO().actualizar(new ProductoOficinaPapeleria(nombre, precio, cantidad, marca, imagen, nivelDeRuido, funcion), vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes(), "Producto actualizado", "No hay productos para actualizar");
			mf.getProductoOficinaPapeleriaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpop().getTabla(), vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoNivelRuido().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoFuncion().setText("");
			vf.getVpli().getPanelCardLayout().getPacpop().setImagenProducto(null);
			}
		break;
		case "btnEliminarPhb":{
			mf.getProductoHogarBanioDAO().eliminar(vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes());
			mf.getProductoHogarBanioDAO().listar(vf.getVpli().getPanelCardLayout().getPlphb().getTabla(), vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes(),vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes());		
		}
		break;
		case "btnEliminarPhc":{
			mf.getProductoHogarCocinaDAO().eliminar(vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes());
			mf.getProductoHogarCocinaDAO().listar(vf.getVpli().getPanelCardLayout().getPlphc().getTabla(), vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes(),vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes());
		}
		break;
		case "btnEliminarPoj":{
			mf.getProductoOcioJugueteDAO().eliminar(vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes());
			mf.getProductoOcioJugueteDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoj().getTabla(), vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes(),vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes());
		}
		break;
		case "btnEliminarPor":{
			mf.getProductoOcioRopaDAO().eliminar(vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes());
			mf.getProductoOcioRopaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpor().getTabla(), vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes(),vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes());
		}
		break;
		case "btnEliminarPoe":{
			mf.getProductoOficinaElectrodomesticoDAO().eliminar(vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes());
			mf.getProductoOficinaElectrodomesticoDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoe().getTabla(), vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes(),vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes());
		}
		break;
		case "btnEliminarPop":{
			mf.getProductoOficinaPapeleriaDAO().eliminar(vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes());
			mf.getProductoOficinaPapeleriaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpop().getTabla(), vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes(),vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes());
		}
		break;
		case "volverAlInicio":{
			vf.getVpli().setVisible(false);
			vf.getVli().setVisible(true);
		}
		break;
		case "btnAgregarTrabajador":{
			String usuario = vf.getVsu().getPanelSignUp().getDatoUsuario().getText();
			String contraseña = new String(vf.getVsu().getPanelSignUp().getDatoContraseña().getPassword());
			String contraseñaConfirmacion = new String(vf.getVsu().getPanelSignUp().getDatoContraseñaConfirmacion().getPassword());
			Image imagen = vf.getVsu().getPanelSignUp().getImagenTrabajador();
			// Verificar si los campos de texto están vacíos
			if (usuario.isEmpty() || contraseña.isEmpty() || contraseñaConfirmacion.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si las contraseñas coinciden
			if (!contraseña.equals(contraseñaConfirmacion)) {
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
				return;
			}

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}
			

			mf.getTrabajadorDAO().guardar(new Trabajador(usuario, contraseña, imagen));
			JOptionPane.showMessageDialog(null, "Trabajador agregado correctamente");
			vf.getVsu().getPanelSignUp().getDatoUsuario().setText("");
			vf.getVsu().getPanelSignUp().getDatoContraseña().setText("");
			vf.getVsu().getPanelSignUp().getDatoContraseñaConfirmacion().setText("");
			vf.getVsu().getPanelSignUp().setImagenTrabajador(null);
		}
		break;		
		case "btnAgregarPhb":{
			String nombre = vf.getVpli().getPanelCardLayout().getPagphb().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagphb().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagphb().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagphb().getDatoMarca().getText();
			String material = vf.getVpli().getPanelCardLayout().getPagphb().getDatoMaterial().getText();
			String color = vf.getVpli().getPanelCardLayout().getPagphb().getDatoColor().getText();
			String zona = vf.getVpli().getPanelCardLayout().getPagphb().getDatoZona().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagphb().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || material.isEmpty() || color.isEmpty() || zona.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoHogarBanioDAO().guardar(new ProductoHogarBanio(nombre, precio, cantidad, marca, imagen, material, color, zona));
			mf.getProductoHogarBanioDAO().listar(vf.getVpli().getPanelCardLayout().getPlphb().getTabla(),vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes(),vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoMaterial().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoColor().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoZona().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().setImagenProducto(null);		
			JOptionPane.showMessageDialog(null, "Producto agregado correctamente");

		}
		break;
		case "btnAgregarPhc":{
			String nombre = vf.getVpli().getPanelCardLayout().getPagphc().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagphc().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagphc().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagphc().getDatoMarca().getText();
			String material = vf.getVpli().getPanelCardLayout().getPagphc().getDatoMaterial().getText();
			String color = vf.getVpli().getPanelCardLayout().getPagphc().getDatoColor().getText();
			String funcionalidad = vf.getVpli().getPanelCardLayout().getPagphc().getDatoFuncionalidad().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagphc().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || material.isEmpty() || color.isEmpty() || funcionalidad.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}


			mf.getProductoHogarCocinaDAO().guardar(new ProductoHogarCocina(nombre, precio, cantidad, marca, imagen, material, color, funcionalidad));
			mf.getProductoHogarCocinaDAO().listar(vf.getVpli().getPanelCardLayout().getPlphc().getTabla(), vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoMaterial().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoColor().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoFuncionalidad().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
		}
		break;
		case "btnAgregarPoj":{
			String nombre = vf.getVpli().getPanelCardLayout().getPagpoj().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoj().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoj().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagpoj().getDatoMarca().getText();
			String nivelDeCalidad = vf.getVpli().getPanelCardLayout().getPagpoj().getDatoNivelCalidad().getSelectedItem().toString();
			Number edadRecomendadaObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoj().getDatoEdadRecomendada().getValue();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagpoj().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeCalidad.equals("")  ) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null || edadRecomendadaObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();
			int edadRecomendada = edadRecomendadaObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoOcioJugueteDAO().guardar(new ProductoOcioJuguete(nombre, precio, cantidad, marca, imagen, nivelDeCalidad, edadRecomendada));
			mf.getProductoOcioJugueteDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoj().getTabla(), vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoNivelCalidad().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoEdadRecomendada().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoj().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
		}
		break;
		case "btnAgregarPor":{
			String nombre = vf.getVpli().getPanelCardLayout().getPagpor().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagpor().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagpor().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagpor().getDatoMarca().getText();
			String nivelDeCalidad = vf.getVpli().getPanelCardLayout().getPagpor().getDatoNivelCalidad().getSelectedItem().toString();
			String talla = vf.getVpli().getPanelCardLayout().getPagpor().getDatoTalla().getSelectedItem().toString();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagpor().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeCalidad.equals("") || talla.equals("")) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoOcioRopaDAO().guardar(new ProductoOcioRopa(nombre, precio, cantidad, marca, imagen, nivelDeCalidad, talla));
			mf.getProductoOcioRopaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpor().getTabla(), vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoNivelCalidad().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoTalla().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpor().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
		}
		break;
		case "btnAgregarPoe":{
			String nombre = vf.getVpli().getPanelCardLayout().getPagpoe().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoe().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoe().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagpoe().getDatoMarca().getText();
			String nivelDeRuido = vf.getVpli().getPanelCardLayout().getPagpoe().getDatoNivelRuido().getSelectedItem().toString();
			String consumoEnergetico = vf.getVpli().getPanelCardLayout().getPagpoe().getDatoConsumoEnergetico().getSelectedItem().toString();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagpoe().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeRuido.equals("") || consumoEnergetico.equals("") ) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoOficinaElectrodomesticoDAO().guardar(new ProductoOficinaElectrodomestico(nombre, precio, cantidad, marca, imagen, nivelDeRuido, consumoEnergetico));
			mf.getProductoOficinaElectrodomesticoDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoe().getTabla(), vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoNivelRuido().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoConsumoEnergetico().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpoe().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
			}
		break;			
		case "btnAgregarPop":{
			String nombre = vf.getVpli().getPanelCardLayout().getPagpop().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagpop().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagpop().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagpop().getDatoMarca().getText();
			String nivelDeRuido = vf.getVpli().getPanelCardLayout().getPagpop().getDatoNivelRuido().getSelectedItem().toString();
			String funcion = vf.getVpli().getPanelCardLayout().getPagpop().getDatoFuncion().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagpop().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeRuido.equals("") || funcion.isEmpty() ) {
				JOptionPane.showMessageDialog(null, "Todos los campos de texto son obligatorios");
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un precio y una cantidad válidos");
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen");
				return;
			}

			mf.getProductoOficinaPapeleriaDAO().guardar(new ProductoOficinaPapeleria(nombre, precio, cantidad, marca, imagen, nivelDeRuido, funcion));
			mf.getProductoOficinaPapeleriaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpop().getTabla(), vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes(), vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoNivelRuido().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoFuncion().setText("");
			vf.getVpli().getPanelCardLayout().getPagpop().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
			}
		break;
		case "btnRegistrarse":{
			vf.getVsu().setVisible(true);
		}
		break;
		case "checkEspañol":{
			if(vf.getVli().getPli().getCheckEspañol().isSelected()) {
				try {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));
					vf.getVli().getPli().getSeleccioneIdioma().setText(prop.getProperty("archivosdepropiedades.panellogin.contenidoetiquetaidioma"));
					vf.getVli().getPli().getBtnIngresar().setText(prop.getProperty("archivosdepropiedades.panellogin.contenidobtningresar"));
					vf.getVli().getPli().getBtnRegistrarse().setText(prop.getProperty("archivosdepropiedades.panellogin.contenidobtnregistrarse"));
					vf.getVli().getPli().getEtiqueta1().setText(prop.getProperty("archivosdepropiedades.panellogin.textousuario"));
					vf.getVli().getPli().getSaludo().setText(prop.getProperty("archivosdepropiedades.panellogin.textobienvenida"));
					vf.getVli().getPli().getEtiqueta2().setText(prop.getProperty("archivosdepropiedades.panellogin.textocontraseña"));
					vf.getVli().getPli().getEtiqueta0().setText(prop.getProperty("archivosdepropiedades.panellogin.textoetiqueta0"));
					vf.getVli().getPli().revalidate();
					vf.getVli().getPli().repaint();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				vf.getVli().getPli().getCheckIngles().setSelected(false);
			}
		}
		break;
		case "checkIngles":{
			if(vf.getVli().getPli().getCheckIngles().isSelected()) {
				try {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
					vf.getVli().getPli().getSeleccioneIdioma().setText(prop.getProperty("archivosdepropiedades.panellogin.contenidoetiquetaidioma"));
					vf.getVli().getPli().getBtnIngresar().setText(prop.getProperty("archivosdepropiedades.panellogin.contenidobtningresar"));
					vf.getVli().getPli().getBtnRegistrarse().setText(prop.getProperty("archivosdepropiedades.panellogin.contenidobtnregistrarse"));
					vf.getVli().getPli().getEtiqueta1().setText(prop.getProperty("archivosdepropiedades.panellogin.textousuario"));
					vf.getVli().getPli().getSaludo().setText(prop.getProperty("archivosdepropiedades.panellogin.textobienvenida"));
					vf.getVli().getPli().getEtiqueta2().setText(prop.getProperty("archivosdepropiedades.panellogin.textocontraseña"));
					vf.getVli().getPli().getEtiqueta0().setText(prop.getProperty("archivosdepropiedades.panellogin.textoetiqueta0"));

					vf.getVli().getPli().revalidate();
					vf.getVli().getPli().repaint();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				vf.getVli().getPli().getCheckEspañol().setSelected(false);
			}
		}
		break;
		case "btnIngresar":{
//			String usuario = vf.getVli().getPli().getDatoUsuario().getText();
//			String password = vf.getVli().getPli().getDatoContraseña().getText();
//			if(mf.getTrabajadorDAO().verificarExistencia(usuario, password)) {
				vf.getVpli().setVisible(true);
				vf.getVli().setVisible(false);
//			}else {
//				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
//			}
//			if(!password.isEmpty() || password.length() > 3) {
//				vf.getVpli().setVisible(true);
//				vf.getVli().setVisible(false);
//			}else {
//				JOptionPane.showMessageDialog(null, "El campo contraseña debe ser valido");
//			}

		}
		break;
		case "actualizarPhb":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacphb");
		}
		break;
		case "actualizarPhc":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacphc");
		}
		break;
		case "actualizarPoj":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacpoj");
		}
		break;
		case "actualizarPor":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacpor");
		}
		break;
		case "actualizarPoe":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacpoe");
		}
		break;
		case "actualizarPop":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacpop");
		}
		break;
		case "agregarPhb":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagphb");
		}
		break;
		case "agregarPhc":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagphc");
		}
		break;
		case "agregarPoj":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagpoj");
		}
		break;
		case "agregarPor":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagpor");
		}
		break;
		case "agregarPoe":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagpoe");
		}
		break;
		case "agregarPop":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagpop");
		}
		break;
		case "eliminarPhb":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pephb");
		}
		break;
		case "eliminarPhc":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pephc");
		}
		break;
		case "eliminarPoj":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pepoj");
		}
		break;
		case "eliminarPor":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pepor");
		}
		break;
		case "eliminarPoe":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pepoe");
		}
		break;
		case "eliminarPop":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pepop");
		}
		break;
		case "listarPhb":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("plphb");
		}
		break;
		case "listarPhc":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("plphc");
		}
		break;
		case "listarPoj":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("plpoj");
		}
		break;
		case "listarPor":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("plpor");
		}
		break;
		case "listarPoe":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("plpoe");
		}
		break;
		case "listarPop":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("plpop");
		}
		break;

		}

	}
}

