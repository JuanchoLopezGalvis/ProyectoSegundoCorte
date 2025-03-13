package co.edu.unbosque.view;

/**
 * La {@link ViewFacade} tendra la responsabilidad de instanciar
 * cada una de las ventanas del aplicativo.
 */
public class ViewFacade {
	
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
	

}
