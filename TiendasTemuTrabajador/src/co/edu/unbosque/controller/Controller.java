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
		vf.getVpli().getAgregarPhc().addActionListener(this);
		vf.getVpli().getAgregarPoj().addActionListener(this);
		vf.getVpli().getAgregarPor().addActionListener(this);
		vf.getVpli().getAgregarPoe().addActionListener(this);
		vf.getVpli().getAgregarPop().addActionListener(this);
		
		vf.getVpli().getActualizarPhb().addActionListener(this);
		vf.getVpli().getActualizarPhc().addActionListener(this);
		vf.getVpli().getActualizarPoj().addActionListener(this);
		vf.getVpli().getActualizarPor().addActionListener(this);
		vf.getVpli().getActualizarPoe().addActionListener(this);
		vf.getVpli().getActualizarPop().addActionListener(this);
		
		vf.getVpli().getBuscarPhb().addActionListener(this);
		vf.getVpli().getBuscarPhc().addActionListener(this);
		vf.getVpli().getBuscarPoj().addActionListener(this);
		vf.getVpli().getBuscarPor().addActionListener(this);
		vf.getVpli().getBuscarPoe().addActionListener(this);
		vf.getVpli().getBuscarPop().addActionListener(this);
		
		vf.getVpli().getEliminarPhb().addActionListener(this);
		vf.getVpli().getEliminarPhc().addActionListener(this);
		vf.getVpli().getEliminarPoj().addActionListener(this);
		vf.getVpli().getEliminarPor().addActionListener(this);
		vf.getVpli().getEliminarPoe().addActionListener(this);
		vf.getVpli().getEliminarPop().addActionListener(this);
		
		vf.getVpli().getListarPhb().addActionListener(this);
		vf.getVpli().getListarPhc().addActionListener(this);
		vf.getVpli().getListarPoj().addActionListener(this);
		vf.getVpli().getListarPor().addActionListener(this);
		vf.getVpli().getListarPoe().addActionListener(this);
		vf.getVpli().getListarPop().addActionListener(this);
		
		
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
		case "btnIngresar":
			vf.getVpli().setVisible(true);
			vf.getVli().setVisible(false);
			break;
		}
		
	}

}
