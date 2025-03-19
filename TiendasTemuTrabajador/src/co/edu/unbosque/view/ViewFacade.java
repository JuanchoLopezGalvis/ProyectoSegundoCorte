
package co.edu.unbosque.view;

/**
 * La {@link ViewFacade} tendra la responsabilidad de instanciar
 * cada una de las ventanas del aplicativo.
 */
public class ViewFacade {

	/**
	 * Instancia de la {@link VentanaPostLogIn}
	 */
	private VentanaPostLogIn vpli;

	/** 
	 * Instacia de la {@link VentanaLogIn}
	 */
	private VentanaLogIn vli;

	/**
	 * Constructor vacio de la {@link ViewFacade} donde inicializaremos cada 
	 * una de las ventanas del aplicatico.
	 */
	public ViewFacade() {

		vli = new VentanaLogIn(); 
		vpli = new VentanaPostLogIn();

	}

	/**
	 * Get de la {@link VentanaLogIn}
	 * @return vli
	 */
	public VentanaLogIn getVli() {
		return vli;
	}

	/**
	 * Set de la {@link VentanaLogIn}.
	 * @param vli
	 */
	public void setVli(VentanaLogIn vli) {
		this.vli = vli;
	}

	/**
	 * Get de la {@link VentanaPostLogIn}
	 * @return vpli
	 */
	public VentanaPostLogIn getVpli() {
		return vpli;
	}

	/**
	 * Set de la {@link VentanaPostLogIn}
	 * @param vpli
	 */
	public void setVpli(VentanaPostLogIn vpli) {
		this.vpli = vpli;
	}


}

