package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * {@link VentanaLogIn} contendra el {@link PanelLogIn} donde se hace el proceso
 * de inicio de sesión.
 */

public class VentanaLogIn extends JFrame {

	private PanelLogIn pli;
	private PanelPrueb pb;

	/**
	 * Este es el contructor de la clase {@link VentanaLogIn}, la cual tiene un
	 * tamaño de 1250*650 pixeles, y su ubicación es relativa a nada por lo que
	 * aparecera en el centro de cualquier monitor.
	 */

	public VentanaLogIn() {

		setSize(1250, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Tiendas Temu trabajadores");
		setLayout(null);
		pli = new PanelLogIn();
		pb = new PanelPrueb();

		add(pli);
//		add(pb);

	}

}
