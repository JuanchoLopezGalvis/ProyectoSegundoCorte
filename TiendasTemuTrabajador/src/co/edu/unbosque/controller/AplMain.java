package co.edu.unbosque.controller;
/**
 * El {@link AplMain} contendra la fución main que ejecutara el aplicativo.
 */
public class AplMain {
	
	/**
	 * Main del aplicativo TiendasTemuTrabajador/ con una intaciación 
	 * intantaneamente inicializada para llamar la funcion run.
	 * @param args
	 */
	public static void main(String[] args) {
		//Prueba de edición
		Controller controller = new Controller();
		controller.run();
	}

}
