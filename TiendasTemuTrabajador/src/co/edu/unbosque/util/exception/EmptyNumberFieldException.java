package co.edu.unbosque.util.exception;

import javax.swing.JOptionPane;

public class EmptyNumberFieldException extends Exception{
	
	public EmptyNumberFieldException() {
		JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válidos");

		}

}
