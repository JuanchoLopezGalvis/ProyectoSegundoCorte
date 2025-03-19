<<<<<<< HEAD
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.ViewFacade;

/**
 * El {@link Controller} tendra la resposabilidad de darle la visibilidad 
 * a cada una de las ventanas del aplicativo y agregarle eventos a todos los elementos que
 * lo requieren:
 * Botones, etiquetas, comboBox, etc.
 */

public class Controller implements ActionListener{

	/**
	 * Instacia de la {@link ViewFacade} para acceder a todas las
	 * ventanas del aplicativo.
	 */
	private ViewFacade vf; 
	/**
	 * Constructor vacio del {@link Controller}.
	 */
	public Controller() {
		vf = new ViewFacade();
	}
	/**
	 * La funcion run permite el inicio de la ejecución
	 * del aplicativo dandole visibilidad a la venta principal.
	 */
	public void run() {

		vf.getVli().setVisible(true);
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
		case "btnIngresar":{
			String usuario = vf.getVli().getPli().getDatoUsuario().getText();
			if(usuario.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error llene los campos");
			}else {
				vf.getVpli().setVisible(true);
				vf.getVli().setVisible(false);
				
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
			vf.getVpli().getPanelCardLayout().mostrarPanel("pcphb");
		}
		break;
		case "agregarPhc":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pcphc");
		}
		break;
		case "agregarPoj":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pcpoj");
		}
		break;
		case "agregarPor":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pcpor");
		}
		break;
		case "agregarPoe":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pcpoe");
		}
		break;
		case "agregarPop":{
			vf.getVpli().getPanelCardLayout().mostrarPanel("pcpop");
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
=======
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import co.edu.unbosque.view.ViewFacade;

/**
 * El {@link Controller} tendra la resposabilidad de darle la visibilidad 
 * a cada una de las ventanas del aplicativo y agregarle eventos a todos los elementos que
 * lo requieren:
 * Botones, etiquetas, comboBox, etc.
 */

public class Controller implements ActionListener{

	/**
	 * Instacia de la {@link ViewFacade} para acceder a todas las
	 * ventanas del aplicativo.
	 */
	private ViewFacade vf; 
	/**
	 * Constructor vacio del {@link Controller}.
	 */
	public Controller() {
		vf = new ViewFacade();
	}
	/**
	 * La funcion run permite el inicio de la ejecución
	 * del aplicativo dandole visibilidad a la venta principal.
	 */
	public void run() {

		vf.getVli().setVisible(true);
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
		case "btnIngresar":{
			vf.getVpli().setVisible(true);
			vf.getVli().setVisible(false);

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
>>>>>>> branch 'master' of git@github.com:JuanchoLopezGalvis/ProyectoSegundoCorte.git
