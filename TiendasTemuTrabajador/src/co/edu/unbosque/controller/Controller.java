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
		case "btnActualizarPhb": {
			String nombre = vf.getVpli().getPanelCardLayout().getPacphb().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacphb().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacphb().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacphb().getDatoMarca().getText();
			String material = vf.getVpli().getPanelCardLayout().getPacphb().getDatoMaterial().getText();
			String color = vf.getVpli().getPanelCardLayout().getPacphb().getDatoColor().getText();
			String zona = vf.getVpli().getPanelCardLayout().getPacphb().getDatoZona().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacphb().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || material.isEmpty() || color.isEmpty() || zona.isEmpty()) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoHogarBanioDAO().actualizar(
					new ProductoHogarBanio(nombre, precio, cantidad, marca, imagen, material, color, zona),
					vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes(), prop.getProperty("archivosdepropiedades.panelactualizarpro.show7"),
					prop.getProperty("archivosdepropiedades.panelactualizarpro.show8"));
			mf.getProductoHogarBanioDAO().listar(vf.getVpli().getPanelCardLayout().getPlphb().getTabla(),
					vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes());
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
		case "btnActualizarPhc": {
			String nombre = vf.getVpli().getPanelCardLayout().getPacphc().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacphc().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacphc().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacphc().getDatoMarca().getText();
			String material = vf.getVpli().getPanelCardLayout().getPacphc().getDatoMaterial().getText();
			String color = vf.getVpli().getPanelCardLayout().getPacphc().getDatoColor().getText();
			String funcionalidad = vf.getVpli().getPanelCardLayout().getPacphc().getDatoFuncionalidad().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacphc().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || material.isEmpty() || color.isEmpty()
					|| funcionalidad.isEmpty()) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoHogarCocinaDAO().actualizar(
					new ProductoHogarCocina(nombre, precio, cantidad, marca, imagen, material, color, funcionalidad),
					vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes(), prop.getProperty("archivosdepropiedades.panelactualizarpro.show7"),
					prop.getProperty("archivosdepropiedades.panelactualizarpro.show8"));
			mf.getProductoHogarCocinaDAO().listar(vf.getVpli().getPanelCardLayout().getPlphc().getTabla(),
					vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes());
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
		case "btnActualizarPoj": {
			String nombre = vf.getVpli().getPanelCardLayout().getPacpoj().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoj().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoj().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacpoj().getDatoMarca().getText();
			String nivelDeCalidad = vf.getVpli().getPanelCardLayout().getPacpoj().getDatoNivelCalidad()
					.getSelectedItem().toString();
			Number edadRecomendadaObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoj().getDatoEdadRecomendada()
					.getValue();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacpoj().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeCalidad.equals("")) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null || edadRecomendadaObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();
			int edadRecomendada = edadRecomendadaObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null,  prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoOcioJugueteDAO().actualizar(
					new ProductoOcioJuguete(nombre, precio, cantidad, marca, imagen, nivelDeCalidad, edadRecomendada),
					vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes(), prop.getProperty("archivosdepropiedades.panelactualizarpro.show7"),
					prop.getProperty("archivosdepropiedades.panelactualizarpro.show8"));
			mf.getProductoOcioJugueteDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoj().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoNivelCalidad().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpoj().getDatoEdadRecomendada().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoj().setImagenProducto(null);
		}
			break;
		case "btnActualizarPor": {
			String nombre = vf.getVpli().getPanelCardLayout().getPacpor().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacpor().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacpor().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacpor().getDatoMarca().getText();
			String nivelDeCalidad = vf.getVpli().getPanelCardLayout().getPacpor().getDatoNivelCalidad()
					.getSelectedItem().toString();
			String talla = vf.getVpli().getPanelCardLayout().getPacpor().getDatoTalla().getSelectedItem().toString();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacpor().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeCalidad.equals("") || talla.equals("")) {
				JOptionPane.showMessageDialog(null,prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoOcioRopaDAO().actualizar(
					new ProductoOcioRopa(nombre, precio, cantidad, marca, imagen, nivelDeCalidad, talla),
					vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes(), prop.getProperty("archivosdepropiedades.panelactualizarpro.show7"),
					prop.getProperty("archivosdepropiedades.panelactualizarpro.show8"));
			mf.getProductoOcioRopaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpor().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoNivelCalidad().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpor().getDatoTalla().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpor().setImagenProducto(null);
		}
			break;
		case "btnActualizarPoe": {
			String nombre = vf.getVpli().getPanelCardLayout().getPacpoe().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoe().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacpoe().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacpoe().getDatoMarca().getText();
			String nivelDeRuido = vf.getVpli().getPanelCardLayout().getPacpoe().getDatoNivelRuido().getSelectedItem()
					.toString();
			String consumoEnergetico = vf.getVpli().getPanelCardLayout().getPacpoe().getDatoConsumoEnergetico()
					.getSelectedItem().toString();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacpoe().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeRuido.equals("") || consumoEnergetico.equals("")) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoOficinaElectrodomesticoDAO().actualizar(
					new ProductoOficinaElectrodomestico(nombre, precio, cantidad, marca, imagen, nivelDeRuido,
							consumoEnergetico),
					vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes(),  prop.getProperty("archivosdepropiedades.panelactualizarpro.show7"),
					 prop.getProperty("archivosdepropiedades.panelactualizarpro.show8"));
			mf.getProductoOficinaElectrodomesticoDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoe().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoNivelRuido().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpoe().getDatoConsumoEnergetico().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpoe().setImagenProducto(null);
		}
			break;
		case "btnActualizarPop": {
			String nombre = vf.getVpli().getPanelCardLayout().getPacpop().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPacpop().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPacpop().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPacpop().getDatoMarca().getText();
			String nivelDeRuido = vf.getVpli().getPanelCardLayout().getPacpop().getDatoNivelRuido().getSelectedItem()
					.toString();
			String funcion = vf.getVpli().getPanelCardLayout().getPacpop().getDatoFuncion().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPacpop().getImagenProducto();
			
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeRuido.equals("") || funcion.isEmpty()) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoOficinaPapeleriaDAO().actualizar(
					new ProductoOficinaPapeleria(nombre, precio, cantidad, marca, imagen, nivelDeRuido, funcion),
					vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes(),  prop.getProperty("archivosdepropiedades.panelactualizarpro.show7"),
					prop.getProperty("archivosdepropiedades.panelactualizarpro.show8"));
			mf.getProductoOficinaPapeleriaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpop().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoNivelRuido().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPacpop().getDatoFuncion().setText("");
			vf.getVpli().getPanelCardLayout().getPacpop().setImagenProducto(null);
		}
			break;
		case "btnEliminarPhb": {
			mf.getProductoHogarBanioDAO()
					.eliminar(vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes());
			mf.getProductoHogarBanioDAO().listar(vf.getVpli().getPanelCardLayout().getPlphb().getTabla(),
					vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes());
		}
			break;
		case "btnEliminarPhc": {
			mf.getProductoHogarCocinaDAO()
					.eliminar(vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes());
			mf.getProductoHogarCocinaDAO().listar(vf.getVpli().getPanelCardLayout().getPlphc().getTabla(),
					vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes());
		}
			break;
		case "btnEliminarPoj": {
			mf.getProductoOcioJugueteDAO()
					.eliminar(vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes());
			mf.getProductoOcioJugueteDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoj().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes());
		}
			break;
		case "btnEliminarPor": {
			mf.getProductoOcioRopaDAO().eliminar(vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes());
			mf.getProductoOcioRopaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpor().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes());
		}
			break;
		case "btnEliminarPoe": {
			mf.getProductoOficinaElectrodomesticoDAO()
					.eliminar(vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes());
			mf.getProductoOficinaElectrodomesticoDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoe().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes());
		}
			break;
		case "btnEliminarPop": {
			mf.getProductoOficinaPapeleriaDAO()
					.eliminar(vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes());
			mf.getProductoOficinaPapeleriaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpop().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes());
		}
			break;
		case "volverAlInicio": {
			vf.getVpli().setVisible(false);
			vf.getVli().setVisible(true);
		}
			break;
		case "btnAgregarTrabajador": {
			String usuario = vf.getVsu().getPanelSignUp().getDatoUsuario().getText();
			String contraseña = new String(vf.getVsu().getPanelSignUp().getDatoContraseña().getPassword());
			String contraseñaConfirmacion = new String(
					vf.getVsu().getPanelSignUp().getDatoContraseñaConfirmacion().getPassword());
			Image imagen = vf.getVsu().getPanelSignUp().getImagenTrabajador();
			// Verificar si los campos de texto están vacíos

			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			if (usuario.isEmpty() || contraseña.isEmpty() || contraseñaConfirmacion.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si las contraseñas coinciden
			if (!contraseña.equals(contraseñaConfirmacion)) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show2"));
				return;
			}

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getTrabajadorDAO().guardar(new Trabajador(usuario, contraseña, imagen));
			JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show4"));
			vf.getVsu().getPanelSignUp().getDatoUsuario().setText("");
			vf.getVsu().getPanelSignUp().getDatoContraseña().setText("");
			vf.getVsu().getPanelSignUp().getDatoContraseñaConfirmacion().setText("");
			vf.getVsu().getPanelSignUp().setImagenTrabajador(null);
				if (!usuario.isEmpty() || !contraseña.isEmpty()||contraseñaConfirmacion.isEmpty()||imagen != null) {
				vf.getVsu().dispose();
			}
		}
			break;
		case "btnAgregarPhb": {
			String nombre = vf.getVpli().getPanelCardLayout().getPagphb().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagphb().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagphb().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagphb().getDatoMarca().getText();
			String material = vf.getVpli().getPanelCardLayout().getPagphb().getDatoMaterial().getText();
			String color = vf.getVpli().getPanelCardLayout().getPagphb().getDatoColor().getText();
			String zona = vf.getVpli().getPanelCardLayout().getPagphb().getDatoZona().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagphb().getImagenProducto();
			// Verificar si los campos de texto están vacíos
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			if (nombre.isEmpty() || marca.isEmpty() || material.isEmpty() || color.isEmpty() || zona.isEmpty()) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoHogarBanioDAO()
					.guardar(new ProductoHogarBanio(nombre, precio, cantidad, marca, imagen, material, color, zona));
			mf.getProductoHogarBanioDAO().listar(vf.getVpli().getPanelCardLayout().getPlphb().getTabla(),
					vf.getVpli().getPanelCardLayout().getPephb().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacphb().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoMaterial().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoColor().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().getDatoZona().setText("");
			vf.getVpli().getPanelCardLayout().getPagphb().setImagenProducto(null);
			JOptionPane.showMessageDialog(null,  prop.getProperty("archivosdepropiedades.panelagregarproducto.show6"));

		}
			break;
		case "btnAgregarPhc": {
			String nombre = vf.getVpli().getPanelCardLayout().getPagphc().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagphc().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagphc().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagphc().getDatoMarca().getText();
			String material = vf.getVpli().getPanelCardLayout().getPagphc().getDatoMaterial().getText();
			String color = vf.getVpli().getPanelCardLayout().getPagphc().getDatoColor().getText();
			String funcionalidad = vf.getVpli().getPanelCardLayout().getPagphc().getDatoFuncionalidad().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagphc().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || material.isEmpty() || color.isEmpty()
					|| funcionalidad.isEmpty()) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoHogarCocinaDAO().guardar(
					new ProductoHogarCocina(nombre, precio, cantidad, marca, imagen, material, color, funcionalidad));
			mf.getProductoHogarCocinaDAO().listar(vf.getVpli().getPanelCardLayout().getPlphc().getTabla(),
					vf.getVpli().getPanelCardLayout().getPephc().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacphc().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoMaterial().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoColor().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().getDatoFuncionalidad().setText("");
			vf.getVpli().getPanelCardLayout().getPagphc().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show6"));
		}
			break;
		case "btnAgregarPoj": {
			String nombre = vf.getVpli().getPanelCardLayout().getPagpoj().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoj().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoj().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagpoj().getDatoMarca().getText();
			String nivelDeCalidad = vf.getVpli().getPanelCardLayout().getPagpoj().getDatoNivelCalidad()
					.getSelectedItem().toString();
			Number edadRecomendadaObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoj().getDatoEdadRecomendada()
					.getValue();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagpoj().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeCalidad.equals("")) {
				JOptionPane.showMessageDialog(null,  prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null || edadRecomendadaObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();
			int edadRecomendada = edadRecomendadaObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoOcioJugueteDAO().guardar(
					new ProductoOcioJuguete(nombre, precio, cantidad, marca, imagen, nivelDeCalidad, edadRecomendada));
			mf.getProductoOcioJugueteDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoj().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepoj().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpoj().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoNivelCalidad().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpoj().getDatoEdadRecomendada().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoj().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show6"));
		}
			break;
		case "btnAgregarPor": {
			String nombre = vf.getVpli().getPanelCardLayout().getPagpor().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagpor().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagpor().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagpor().getDatoMarca().getText();
			String nivelDeCalidad = vf.getVpli().getPanelCardLayout().getPagpor().getDatoNivelCalidad()
					.getSelectedItem().toString();
			String talla = vf.getVpli().getPanelCardLayout().getPagpor().getDatoTalla().getSelectedItem().toString();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagpor().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeCalidad.equals("") || talla.equals("")) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoOcioRopaDAO()
					.guardar(new ProductoOcioRopa(nombre, precio, cantidad, marca, imagen, nivelDeCalidad, talla));
			mf.getProductoOcioRopaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpor().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepor().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpor().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoNivelCalidad().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpor().getDatoTalla().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpor().setImagenProducto(null);
			JOptionPane.showMessageDialog(null,  prop.getProperty("archivosdepropiedades.panelagregarproducto.show6"));
		}
			break;
		case "btnAgregarPoe": {
			String nombre = vf.getVpli().getPanelCardLayout().getPagpoe().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoe().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagpoe().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagpoe().getDatoMarca().getText();
			String nivelDeRuido = vf.getVpli().getPanelCardLayout().getPagpoe().getDatoNivelRuido().getSelectedItem()
					.toString();
			String consumoEnergetico = vf.getVpli().getPanelCardLayout().getPagpoe().getDatoConsumoEnergetico()
					.getSelectedItem().toString();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagpoe().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeRuido.equals("") || consumoEnergetico.equals("")) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoOficinaElectrodomesticoDAO().guardar(new ProductoOficinaElectrodomestico(nombre, precio,
					cantidad, marca, imagen, nivelDeRuido, consumoEnergetico));
			mf.getProductoOficinaElectrodomesticoDAO().listar(vf.getVpli().getPanelCardLayout().getPlpoe().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepoe().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpoe().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoNivelRuido().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpoe().getDatoConsumoEnergetico().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpoe().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show6"));
		}
			break;
		case "btnAgregarPop": {
			String nombre = vf.getVpli().getPanelCardLayout().getPagpop().getDatoNombre().getText();
			Number precioObj = (Number) vf.getVpli().getPanelCardLayout().getPagpop().getDatoPrecio().getValue();
			Number cantidadObj = (Number) vf.getVpli().getPanelCardLayout().getPagpop().getDatoCantidad().getValue();
			String marca = vf.getVpli().getPanelCardLayout().getPagpop().getDatoMarca().getText();
			String nivelDeRuido = vf.getVpli().getPanelCardLayout().getPagpop().getDatoNivelRuido().getSelectedItem()
					.toString();
			String funcion = vf.getVpli().getPanelCardLayout().getPagpop().getDatoFuncion().getText();
			Image imagen = vf.getVpli().getPanelCardLayout().getPagpop().getImagenProducto();
			try {
				if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));

				} else {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
				}
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			// Verificar si los campos de texto están vacíos
			if (nombre.isEmpty() || marca.isEmpty() || nivelDeRuido.equals("") || funcion.isEmpty()) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregartrabajador.show1"));
				return;
			}

			// Verificar si los valores de los JSpinner son nulos
			if (precioObj == null || cantidadObj == null) {
				JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show5"));
				return;
			}

			double precio = precioObj.doubleValue();
			int cantidad = cantidadObj.intValue();

			// Verificar que la imagen no sea nula
			if (imagen == null) {
				JOptionPane.showMessageDialog(null,  prop.getProperty("archivosdepropiedades.panelagregartrabajador.show3"));
				return;
			}

			mf.getProductoOficinaPapeleriaDAO().guardar(
					new ProductoOficinaPapeleria(nombre, precio, cantidad, marca, imagen, nivelDeRuido, funcion));
			mf.getProductoOficinaPapeleriaDAO().listar(vf.getVpli().getPanelCardLayout().getPlpop().getTabla(),
					vf.getVpli().getPanelCardLayout().getPepop().getProductosExistentes(),
					vf.getVpli().getPanelCardLayout().getPacpop().getProductosExistentes());
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoNombre().setText("");
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoPrecio().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoCantidad().setValue(0);
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoMarca().setText("");
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoNivelRuido().setSelectedIndex(0);
			vf.getVpli().getPanelCardLayout().getPagpop().getDatoFuncion().setText("");
			vf.getVpli().getPanelCardLayout().getPagpop().setImagenProducto(null);
			JOptionPane.showMessageDialog(null, prop.getProperty("archivosdepropiedades.panelagregarproducto.show6"));
		}
			break;
		case "btnRegistrarse": {
			vf.getVsu().setVisible(true);
		}
			break;
		case "checkEspañol": {
			if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
				try {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosespañol.properties")));
					vf.getVli().getPli().getSeleccioneIdioma()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.contenidoetiquetaidioma"));
					vf.getVli().getPli().getBtnIngresar()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.contenidobtningresar"));
					vf.getVli().getPli().getBtnRegistrarse()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.contenidobtnregistrarse"));
					vf.getVli().getPli().getEtiqueta1()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.textousuario"));
					vf.getVli().getPli().getSaludo()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.textobienvenida"));
					vf.getVli().getPli().getEtiqueta2()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.textocontraseña"));
					vf.getVli().getPli().getEtiqueta0()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.textoetiqueta0"));

					
					
					
					
					vf.getVsu().getPanelSignUp().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.panelsignup.seleccionarimagentrabajador"));
					vf.getVsu().getPanelSignUp().getBotonAgregarTrabajador()
							.setText(prop.getProperty("archivosdepropiedades.panelsignup.btnagregartrabajador"));

					
					vf.getVpli().getProductoHogarBanio().setText(prop.getProperty("archivosdepropiedades.menu.banio"));
					vf.getVpli().getProductoHogarCocina().setText(prop.getProperty("archivosdepropiedades.menu.cocina"));
					vf.getVpli().getProductoOcioJuguete().setText(prop.getProperty("archivosdepropiedades.menu.juguete"));
					vf.getVpli().getProductoOcioRopa().setText(prop.getProperty("archivosdepropiedades.menu.ropa"));
					vf.getVpli().getProductoOficianPapeleria().setText(prop.getProperty("archivosdepropiedades.menu.papeleria"));
					vf.getVpli().getProductoOficinaElectrodomestico().setText(prop.getProperty("archivosdepropiedades.menu.electrodomestico"));
					
					vf.getVpli().getAgregarPhb().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPhc().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPoe().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPoj().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPop().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPor().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					
					vf.getVpli().getEliminarPhb().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPhc().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPoe().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPoj().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPop().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPor().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					
					vf.getVpli().getActualizarPhb().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPhc().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPoe().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPoj().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPop().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPor().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
				
					vf.getVpli().getListarPhb().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPhc().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPoe().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPoj().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPop().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPor().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					
					
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaMaterial()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.etimaterial"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaColor()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.eticolor"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaZona()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarbanio.etizona"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagphb().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagphb().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaMaterial()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.etimaterial"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaColor()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.eticolor"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaZona()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarbanio.etizona"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacphb().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacphb().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaMaterial()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.etimaterial"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaColor()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.eticolor"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaFuncionalidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarcocina.etifuncionalidad"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagphc().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagphc().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaMaterial()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.etimaterial"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaColor()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.eticolor"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaFuncionalidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarcocina.etifuncionalidad"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacphc().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacphc().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaNivelRuido()
							.setText(prop.getProperty("archivosdepropiedades.panelagregaroficina.nivelderuido"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaConsumoEnergetico()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarelectrodomestico.consumo"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaNivelRuido()
							.setText(prop.getProperty("archivosdepropiedades.panelagregaroficina.nivelderuido"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaConsumoEnergetico()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarelectrodomestico.consumo"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaNivelRuido()
							.setText(prop.getProperty("archivosdepropiedades.panelagregaroficina.nivelderuido"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaFuncion()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarelectrodomestico.funcion"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagpop().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagpop().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaNivelRuido()
							.setText(prop.getProperty("archivosdepropiedades.panelagregaroficina.nivelderuido"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaFuncion()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarelectrodomestico.funcion"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacpop().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacpop().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaNivelCalidad()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarocio.nivelcalidad"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaEdadRecomendada()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarjuguete.edad"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaNivelCalidad()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarocio.nivelcalidad"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaEdadRecomendada()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarjuguete.edad"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaNivelCalidad()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarocio.nivelcalidad"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaTalla()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarjuguete.talla"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagpor().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagpor().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaNivelCalidad()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarocio.nivelcalidad"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaTalla()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarjuguete.talla"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacpor().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacpor().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));
					
					vf.getVpli().getPanelCardLayout().getPephb().getEtiqueta1()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
			vf.getVpli().getPanelCardLayout().getPephc().getEtiqueta1()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
			vf.getVpli().getPanelCardLayout().getPepoe().getEtiqueta1()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
			vf.getVpli().getPanelCardLayout().getPepop().getEtiqueta1()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
			vf.getVpli().getPanelCardLayout().getPepoj().getEtiqueta1()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
			vf.getVpli().getPanelCardLayout().getPepor().getEtiqueta1()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));

			vf.getVpli().getPanelCardLayout().getPephb().getBotonEliminar()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
			vf.getVpli().getPanelCardLayout().getPephc().getBotonEliminar()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
			vf.getVpli().getPanelCardLayout().getPepoe().getBotonEliminar()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
			vf.getVpli().getPanelCardLayout().getPepop().getBotonEliminar()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
			vf.getVpli().getPanelCardLayout().getPepoj().getBotonEliminar()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
			vf.getVpli().getPanelCardLayout().getPepor().getBotonEliminar()
					.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				vf.getVli().getPli().getCheckIngles().setSelected(false);
			}
		}
			break;
		case "checkIngles": {
			if (vf.getVli().getPli().getCheckIngles().isSelected()) {
				try {
					prop.load(new FileInputStream(new File("src/co/edu/unbosque/controller/textosingles.properties")));
					vf.getVli().getPli().getSeleccioneIdioma()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.contenidoetiquetaidioma"));
					vf.getVli().getPli().getBtnIngresar()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.contenidobtningresar"));
					vf.getVli().getPli().getBtnRegistrarse()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.contenidobtnregistrarse"));
					vf.getVli().getPli().getEtiqueta1()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.textousuario"));
					vf.getVli().getPli().getSaludo()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.textobienvenida"));
					vf.getVli().getPli().getEtiqueta2()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.textocontraseña"));
					vf.getVli().getPli().getEtiqueta0()
							.setText(prop.getProperty("archivosdepropiedades.panellogin.textoetiqueta0"));

					vf.getVsu().getPanelSignUp().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.panelsignup.seleccionarimagentrabajador"));
					vf.getVsu().getPanelSignUp().getBotonAgregarTrabajador()
							.setText(prop.getProperty("archivosdepropiedades.panelsignup.btnagregartrabajador"));

					
					vf.getVpli().getProductoHogarBanio().setText(prop.getProperty("archivosdepropiedades.menu.banio"));
					vf.getVpli().getProductoHogarCocina().setText(prop.getProperty("archivosdepropiedades.menu.cocina"));
					vf.getVpli().getProductoOcioJuguete().setText(prop.getProperty("archivosdepropiedades.menu.juguete"));
					vf.getVpli().getProductoOcioRopa().setText(prop.getProperty("archivosdepropiedades.menu.ropa"));
					vf.getVpli().getProductoOficianPapeleria().setText(prop.getProperty("archivosdepropiedades.menu.papeleria"));
					vf.getVpli().getProductoOficinaElectrodomestico().setText(prop.getProperty("archivosdepropiedades.menu.electrodomestico"));
					
					vf.getVpli().getAgregarPhb().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPhc().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPoe().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPoj().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPop().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					vf.getVpli().getAgregarPor().setText(prop.getProperty("archivosdepropiedades.menu.agregar"));
					
					vf.getVpli().getEliminarPhb().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPhc().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPoe().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPoj().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPop().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					vf.getVpli().getEliminarPor().setText(prop.getProperty("archivosdepropiedades.menu.eliminar"));
					
					vf.getVpli().getActualizarPhb().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPhc().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPoe().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPoj().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPop().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
					vf.getVpli().getActualizarPor().setText(prop.getProperty("archivosdepropiedades.menu.actualizar"));
				
					vf.getVpli().getListarPhb().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPhc().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPoe().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPoj().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPop().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					vf.getVpli().getListarPor().setText(prop.getProperty("archivosdepropiedades.menu.listar"));
					
					
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaMaterial()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.etimaterial"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaColor()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.eticolor"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaZona()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarbanio.etizona"));
					vf.getVpli().getPanelCardLayout().getPagphb().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagphb().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagphb().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaProductosExistentes()
							.setText(prop.getProperty("archivosdepropiedades.panelactualizar.etiopciones"));

					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaMaterial()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.etimaterial"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaColor()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.eticolor"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaZona()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarbanio.etizona"));
					vf.getVpli().getPanelCardLayout().getPacphb().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacphb().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacphb().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaMaterial()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.etimaterial"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaColor()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.eticolor"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaFuncionalidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarcocina.etifuncionalidad"));
					vf.getVpli().getPanelCardLayout().getPagphc().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagphc().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagphc().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaMaterial()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.etimaterial"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaColor()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarhogar.eticolor"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaFuncionalidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregarcocina.etifuncionalidad"));
					vf.getVpli().getPanelCardLayout().getPacphc().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacphc().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacphc().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaNivelRuido()
							.setText(prop.getProperty("archivosdepropiedades.panelagregaroficina.nivelderuido"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaConsumoEnergetico()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarelectrodomestico.consumo"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagpoe().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaNivelRuido()
							.setText(prop.getProperty("archivosdepropiedades.panelagregaroficina.nivelderuido"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaConsumoEnergetico()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarelectrodomestico.consumo"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacpoe().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaNivelRuido()
							.setText(prop.getProperty("archivosdepropiedades.panelagregaroficina.nivelderuido"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaFuncion()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarelectrodomestico.funcion"));
					vf.getVpli().getPanelCardLayout().getPagpop().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagpop().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagpop().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaNivelRuido()
							.setText(prop.getProperty("archivosdepropiedades.panelagregaroficina.nivelderuido"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaFuncion()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarelectrodomestico.funcion"));
					vf.getVpli().getPanelCardLayout().getPacpop().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacpop().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacpop().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaNivelCalidad()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarocio.nivelcalidad"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaEdadRecomendada()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarjuguete.edad"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagpoj().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaNivelCalidad()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarocio.nivelcalidad"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaEdadRecomendada()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarjuguete.edad"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacpoj().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaNivelCalidad()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarocio.nivelcalidad"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaTalla()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarjuguete.talla"));
					vf.getVpli().getPanelCardLayout().getPagpor().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPagpor().getBotonAgregar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPagpor().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaNombre()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etinombre"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaPrecio()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiprecio"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaCantidad()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.eticantidad"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaMarca()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etimarca"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaNivelCalidad()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarocio.nivelcalidad"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaTalla()
							.setText(prop.getProperty("archivosdepropiedades.panelagregarjuguete.talla"));
					vf.getVpli().getPanelCardLayout().getPacpor().getEtiquetaImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.etiimagen"));
					vf.getVpli().getPanelCardLayout().getPacpor().getBotonActualizar()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnagregar"));
					vf.getVpli().getPanelCardLayout().getPacpor().getSeleccionImagen()
							.setText(prop.getProperty("archivosdepropiedades.paneagregar.btnseleccionarim"));

					vf.getVpli().getPanelCardLayout().getPephb().getEtiqueta1()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
					vf.getVpli().getPanelCardLayout().getPephc().getEtiqueta1()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
					vf.getVpli().getPanelCardLayout().getPepoe().getEtiqueta1()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
					vf.getVpli().getPanelCardLayout().getPepop().getEtiqueta1()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
					vf.getVpli().getPanelCardLayout().getPepoj().getEtiqueta1()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));
					vf.getVpli().getPanelCardLayout().getPepor().getEtiqueta1()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.etiqueta"));

					vf.getVpli().getPanelCardLayout().getPephb().getBotonEliminar()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
					vf.getVpli().getPanelCardLayout().getPephc().getBotonEliminar()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
					vf.getVpli().getPanelCardLayout().getPepoe().getBotonEliminar()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
					vf.getVpli().getPanelCardLayout().getPepop().getBotonEliminar()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
					vf.getVpli().getPanelCardLayout().getPepoj().getBotonEliminar()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));
					vf.getVpli().getPanelCardLayout().getPepor().getBotonEliminar()
							.setText(prop.getProperty("archivosdepropiedades.paneleliminar.botoneliminar"));

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				vf.getVli().getPli().getCheckEspañol().setSelected(false);
			}
		}
			break;
		case "btnIngresar": {
			String usuario = vf.getVli().getPli().getDatoUsuario().getText();
			String password = vf.getVli().getPli().getDatoContraseña().getText();
			if (mf.getTrabajadorDAO().verificarExistencia(usuario, password)) {
				vf.getVpli().setVisible(true);
				vf.getVli().setVisible(false);
			} else {

				try {
					if (vf.getVli().getPli().getCheckEspañol().isSelected()) {
						prop.load(new FileInputStream(
								new File("src/co/edu/unbosque/controller/textosespañol.properties")));

					} else {
						prop.load(new FileInputStream(
								new File("src/co/edu/unbosque/controller/textosingles.properties")));
					}
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,
						prop.getProperty("archivosdepropiedades.mensejeusuarioincorrecto.show"));
			}

		}
			break;
		case "actualizarPhb": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacphb");
		}
			break;
		case "actualizarPhc": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacphc");
		}
			break;
		case "actualizarPoj": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacpoj");
		}
			break;
		case "actualizarPor": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacpor");
		}
			break;
		case "actualizarPoe": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacpoe");
		}
			break;
		case "actualizarPop": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pacpop");
		}
			break;
		case "agregarPhb": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagphb");
		}
			break;
		case "agregarPhc": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagphc");
		}
			break;
		case "agregarPoj": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagpoj");
		}
			break;
		case "agregarPor": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagpor");
		}
			break;
		case "agregarPoe": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagpoe");
		}
			break;
		case "agregarPop": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pagpop");
		}
			break;
		case "eliminarPhb": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pephb");
		}
			break;
		case "eliminarPhc": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pephc");
		}
			break;
		case "eliminarPoj": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pepoj");
		}
			break;
		case "eliminarPor": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pepor");
		}
			break;
		case "eliminarPoe": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pepoe");
		}
			break;
		case "eliminarPop": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("pepop");
		}
			break;
		case "listarPhb": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("plphb");
		}
			break;
		case "listarPhc": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("plphc");
		}
			break;
		case "listarPoj": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("plpoj");
		}
			break;
		case "listarPor": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("plpor");
		}
			break;
		case "listarPoe": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("plpoe");
		}
			break;
		case "listarPop": {
			vf.getVpli().getPanelCardLayout().mostrarPanel("plpop");
		}
			break;

		}

	}
}

