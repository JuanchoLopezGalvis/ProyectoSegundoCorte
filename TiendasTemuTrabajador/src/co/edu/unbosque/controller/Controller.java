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
import co.edu.unbosque.view.ViewFacade;

/**
 * El {@link Controller} tendra la resposabilidad de darle la visibilidad 
 * a cada una de las ventanas del aplicativo y agregarle eventos a todos los elementos que
 * lo requieren:
 * Botones, etiquetas, comboBox, etc.
 */

public class Controller implements ActionListener{

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
	}
	/**
	 * La funcion run permite el inicio de la ejecución
	 * del aplicativo dandole visibilidad a la venta principal.
	 */
	public void run() {

		prop = new Properties();
		vf.getVli().setVisible(true);
		vf.getVpli().setVisible(false);
		asignarLectores();

	}


	public void cargarProductosHogarBanioEnTabla() {
		DefaultTableModel modelo = (DefaultTableModel) vf.getVpli().getPanelCardLayout().getPlphb().getTabla().getModel();
		modelo.setRowCount(0);  // Limpiar la tabla antes de actualizarla


		for (ProductoHogarBanio p : mf.getProductoHogarBanioDAO().getListaProductosHogarBanio()) {
			Image imagenEscalada = p.getImagen().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			ImageIcon imagen = new ImageIcon(imagenEscalada);

			modelo.addRow(new Object[]{p.getNombre(), p.getPrecio(), p.getCantidad(), p.getMarca(),  p.getMaterial(), p.getColor(), p.getZona(), imagen});
		}
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
			cargarProductosHogarBanioEnTabla();
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
			String usuario = vf.getVli().getPli().getDatoUsuario().getText();
			String password = vf.getVli().getPli().getDatoContraseña().getText();
			if(!usuario.isEmpty()) {
				vf.getVpli().setVisible(true);
				vf.getVli().setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "El campo usuario esta vacio");
			}
			if(!password.isEmpty() || password.length() > 3) {
				vf.getVpli().setVisible(true);
				vf.getVli().setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "El campo contraseña debe ser valido");
			}

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
